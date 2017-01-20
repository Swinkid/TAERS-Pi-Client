package com.alex.noble.taers.pi;

import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;

import java.io.IOException;

public class Main {

//    public static final DeviceManager deviceManager = DeviceManager.getInstance();

    /*public static void main(String[] args) throws Exception {

        Thread.sleep(2000);

        DeviceManager.clearDisplay();
        DeviceManager.setDisplayText("Started.", 0);

    }*/

    public static String sentence = "";

    public static void main(String[] args) throws Exception {

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

            if(args.length > 0){
                config = CommandArgumentParser.getSerialConfig(config, args);
            }

            serial.open(config);

            while(true){

            }

        }
        catch(IOException ex) {
            return;
        }

    }
}
