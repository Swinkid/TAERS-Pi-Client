package com.alex.noble.taers.pi.devices.gps;

import com.alex.noble.taers.pi.devices.DeviceManager;
import com.pi4j.io.serial.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * GPS
 *
 * Pojo thread that handles listening to GPS serial messages and parsing.
 *
 * @author Alex Noble
 */
public class GPS implements Runnable {

    private static String sentence = "";

    @Override
    public void run() {
            final Serial serial = SerialFactory.createInstance();


            serial.addListener((SerialDataEventListener) event -> {
                try {

                    if(event.getAsciiString().startsWith("$")){
                        sentence = "";
                        sentence += event.getAsciiString();
                    } else if (event.getAsciiString().endsWith("\r\n") || event.getAsciiString().endsWith("\n") || event.getAsciiString().endsWith("\r")){
                        sentence += event.getAsciiString().replace("\r\n", " ").replace("\n", " ").replace("\n\n", " ").replace("\r", " ");

                        String[] sentences;

                        sentences = sentence.split("\r\n");

                        ArrayList<NMEASentence> parsedSentences = new ArrayList<>();

                        for(String s : sentences){

                            // Calculate message type
                            switch (s.split(",")[0]){
                                case "$GPGGA":
                                    parsedSentences.add(new GPGGA(s));
                                    break;
                            }

                        }

                        for(NMEASentence nmea : parsedSentences){

                            switch(nmea.getSentenceType()){
                                case "$GPGGA":

                                    // Update location
                                    DeviceManager.setLatestLat(getDecimalDegrees(nmea.getLatitudeString(), nmea.getLatitudeDirection()));
                                    DeviceManager.setLatestLong(getDecimalDegrees(nmea.getLongitudeString(), nmea.getLongitudeDirection()));
                                    break;
                            }
                        }


                    } else {
                        sentence += event.getAsciiString();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            try {
                SerialConfig config = new SerialConfig();

                config.device(Serial.FIRST_USB_COM_PORT)
                        .baud(Baud._4800)
                        .dataBits(DataBits._8)
                        .parity(Parity.NONE)
                        .stopBits(StopBits._1)
                        .flowControl(FlowControl.NONE);

                serial.open(config);

                while(true){
                    // Keep serial listen open
                }

            }
            catch(Exception e) {

            }
    }

    /**
     * Calculates the Decimal Degrees from NMEA Format.
     *
     * @param coordinate NMEA Coordinates (DMS)
     * @param direction Direction of co ordinate (N / S, E / W)
     * @return float Decimal Degrees
     */
    public static float getDecimalDegrees(String coordinate, String direction){
        int decimal = coordinate.indexOf(".");
        float decimalResult = 0.0f;

        if(decimal > 0) {
            float degrees = Float.parseFloat(coordinate.substring(0, decimal - 2));
            float minutes = Float.parseFloat(coordinate.substring(decimal - 2, coordinate.length()));

            // Different calculation depending on GPS direction
            switch (direction){
                case "N":
                    decimalResult = degrees + (minutes / 60);
                    break;
                case "E":
                    decimalResult = degrees + (minutes / 60);
                    break;
                case "S":
                    decimalResult = (degrees + (minutes / 60)) * -1;
                    break;
                case "W":
                    decimalResult = (degrees + (minutes / 60)) * -1;
                    break;
            }
        }

        return decimalResult;
    }

}
