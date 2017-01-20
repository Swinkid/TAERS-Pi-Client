package com.alex.noble.taers.pi.devices.gps;

import com.alex.noble.taers.pi.devices.DeviceManager;
import com.pi4j.io.serial.*;

import java.io.IOException;

/**
 *
 * TODO: Generalize listener method to accept more than GPGGA NMEA Sentence
 *
 * Created by Alex on 20/01/2017.
 */
public class GPS implements Runnable {

    public static String sentence = "";

    @Override
    public void run() {
        final Serial serial = SerialFactory.createInstance();

        serial.addListener((SerialDataEventListener) event -> {
            try {

                if(event.getAsciiString().startsWith("$")){
                    sentence = "";
                    sentence += event.getAsciiString();
                } else if (event.getAsciiString().endsWith("\n")){
                    sentence += event.getAsciiString().replace("\r\n", " ").replace("\n", " ").replace("\n\n", " ").replace("\r", " ");

                    if(sentence.contains("$GPGGA")){
                        sentence = sentence.split("\r\n")[0];

                        System.out.println(sentence);

                        GPGGA parsedSentence = new GPGGA(sentence);

                        DeviceManager.setDisplayText("Lat: " + getDecimalDegrees(parsedSentence.getLatitudeString(), parsedSentence.getLatitudeDirection()),  0);
                        DeviceManager.setDisplayText("Lng: " + getDecimalDegrees(parsedSentence.getLongitudeString(), parsedSentence.getLongitudeDirection()), 1);


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

            }

        }
        catch(IOException ex) {
            return;
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
