package com.alex.noble.taers.pi;

import com.alex.noble.taers.pi.devices.I2CLcdDisplayEnhanced;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.system.NetworkInfo;

public class Main {

    private static final int I2C_ADDRESS = 0x27;
    private static final int LCD_COL = 16, LCD_ROW = 2;

    public static void main(String[] args) throws Exception {
        I2CLcdDisplayEnhanced lcd = new I2CLcdDisplayEnhanced(LCD_ROW, LCD_COL,
                I2CBus.BUS_1, I2C_ADDRESS, 3, 0, 1, 2, 7, 6, 5, 4);

        lcd.writeln(0, NetworkInfo.getHostname());

        lcd.setCursorHome();

        lcd.cursor_enable();
    }
}
