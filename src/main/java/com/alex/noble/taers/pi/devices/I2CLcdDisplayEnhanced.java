package com.alex.noble.taers.pi.devices;


import com.pi4j.component.lcd.impl.I2CLcdDisplay;

/**
 * @author Alex Noble
 */
public class I2CLcdDisplayEnhanced extends I2CLcdDisplay {
    /**
     * Constructs ...
     *
     * @param rows
     * @param columns
     * @param i2cBus
     * @param i2cAddress
     * @param backlightBit
     * @param rsBit
     * @param rwBit
     * @param eBit
     * @param d7
     * @param d6
     * @param d5
     * @param d4
     * @throws Exception
     */
    public I2CLcdDisplayEnhanced(int rows, int columns, int i2cBus, int i2cAddress, int backlightBit, int rsBit, int rwBit, int eBit, int d7, int d6, int d5, int d4) throws Exception {
        super(rows, columns, i2cBus, i2cAddress, backlightBit, rsBit, rwBit, eBit, d7, d6, d5, d4);
    }

    public void cursor(boolean enable) throws Exception {
        if(enable){
            lcd_byte(0x0E, false);
        } else {
            lcd_byte(0x0C, false);
        }
    }

    public void blink(boolean enable) throws Exception {
        if(enable){
            lcd_byte(0x0F, false);
        } else {
            lcd_byte(0x0C, false);
        }
    }

}
