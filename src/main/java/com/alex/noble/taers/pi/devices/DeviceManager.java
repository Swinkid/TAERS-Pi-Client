package com.alex.noble.taers.pi.devices;

import com.alex.noble.taers.pi.devices.gps.GPS;
import com.alex.noble.taers.pi.devices.lcd.I2CLcdDisplayEnhanced;

/**
 * @author Alex Noble
 */
public class DeviceManager {

    private static DeviceManager instance = null;

    private static I2CLcdDisplayEnhanced lcd = null;

    private static GPS gps = null;

    private static final int I2C_ADDRESS = 0x27;
    private static final int LCD_COL = 16, LCD_ROW = 2;

    protected DeviceManager(){

    }

    public static DeviceManager getInstance(){
        if(instance == null){
            instance = new DeviceManager();

            /* try {
                lcd = new I2CLcdDisplayEnhanced(LCD_ROW, LCD_COL,
                        I2CBus.BUS_1, I2C_ADDRESS, 3, 0, 1, 2, 7, 6, 5, 4);
            } catch (Exception e) {
                e.printStackTrace();
            }

            lcd.writeln(0, "Starting Device");
            lcd.writeln(1, "Manager....");*/

            gps = new GPS();

            gps.run();


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

}
