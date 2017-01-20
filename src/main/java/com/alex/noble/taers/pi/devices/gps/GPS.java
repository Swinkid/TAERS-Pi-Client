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

                        NMEASentence parsedSentence = new NMEASentence(sentence);

                        DeviceManager.setDisplayText("Lat: " + NMEASentence.getDecimalDegrees(parsedSentence.getLatitudeString(), false),  0);
                        DeviceManager.setDisplayText("Lng: " + NMEASentence.getDecimalDegrees(parsedSentence.getLongitudeString(), true), 1);


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
}
