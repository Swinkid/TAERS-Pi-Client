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

            Timer timer = new Timer();
            timer.schedule(new RequestTimer(), 0, 2000);
            lcd.clear();
            gps.run();

        }

        return instance;
    }

    /**
     * Writes a message to LCD
     *
     * @param text text to display
     * @param displayLine line to place text on LCD
     */
    public static void setDisplayText(String text, int displayLine){
        lcd.writeln(displayLine, text);
    }

    /**
     * setLatestLat
     *
     * Set the latest latitude variable.
     *
     * @param lat latitude coordinate
     */
    public static void setLatestLat(float lat){
        latestLat = lat;
    }

    /**
     * setLatestLong
     *
     * Set the latest longitude variable.
     *
     * @param lng longitude coordinate.
     */
    public static void setLatestLong(float lng){
        latestLong = lng;
    }

    /**
     * getLatestLat
     *
     * Gets the latest latitude set.
     *
     * @return float latitude co ordinate
     */
    public static float getLatestLat() {
        return latestLat;
    }

    /**
     * getLatestLong
     *
     * Gets the latest longitude set.
     *
     * @return float longitude co ordinate.
     */
    public static float getLatestLong() {
        return latestLong;
    }
}
