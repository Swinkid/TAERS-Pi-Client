package com.alex.noble.taers.pi.devices;

import com.alex.noble.taers.pi.devices.gps.GPS;
import com.alex.noble.taers.pi.devices.lcd.I2CLcdDisplayEnhanced;
import com.pi4j.io.i2c.I2CBus;

import java.util.Timer;

/**
 * @author Alex Noble
 */
public class DeviceManager {

    private static DeviceManager instance = null;

    private static I2CLcdDisplayEnhanced lcd = null;

    private static GPS gps = null;

    private static final int I2C_ADDRESS = 0x27;
    private static final int LCD_COL = 16, LCD_ROW = 2;

    private static float latestLat = 0.0f;
    private static float latestLong = 0.0f;

    private static boolean runUpdate = true;

    public static DeviceManager getInstance() throws InterruptedException {
        if(instance == null){
            instance = new DeviceManager();

            try {
                lcd = new I2CLcdDisplayEnhanced(LCD_ROW, LCD_COL,
                        I2CBus.BUS_1, I2C_ADDRESS, 3, 0, 1, 2, 7, 6, 5, 4);

                lcd.writeln(0, "Starting Device");
                lcd.writeln(1, "Manager....");
            } catch (Exception e) {

            }

            gps = new GPS();

            Thread.sleep(2000);


            try {
                lcd.clear();
                lcd.writeln(0, "Starting GPS");
            } catch (Exception e){

            }

            gps.run();

            Timer timer = new Timer();
            timer.schedule(new SendRequest(), 0, 10000);

        }

        return instance;
    }

    public static void setDisplayText(String text, int displayLine){
        lcd.writeln(displayLine, text);
    }

    public static void clearDisplay(){
        lcd.clear();
    }

    public static void startGPS(){
        gps.run();
    }

    public static void setLatestLat(float lat){
        latestLat = lat;
    }

    public static void setLatestLong(float lng){
        latestLong = lng;
    }

    public static float getLatestLat() {
        return latestLat;
    }

    public static float getLatestLong() {
        return latestLong;
    }
}
