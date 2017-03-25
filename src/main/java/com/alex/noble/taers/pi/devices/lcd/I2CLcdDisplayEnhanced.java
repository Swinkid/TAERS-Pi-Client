package com.alex.noble.taers.pi.devices.lcd;


import com.pi4j.component.lcd.impl.I2CLcdDisplay;

/**
 * I2CLcdDisplayEnhanced
 *
 * This class extends functionality of the I2CLcdDisplay class, including LCD backlight control.
 *
 * @author Alex Noble
 */
public class I2CLcdDisplayEnhanced extends I2CLcdDisplay {

    private byte backlight;

    public I2CLcdDisplayEnhanced(int rows, int columns, int i2cBus, int i2cAddress, int backlight, int rsBit, int rwBit, int eBit, int d7, int d6, int d5, int d4) throws Exception {
        super(rows, columns, i2cBus, i2cAddress, backlight, rsBit, rwBit, eBit, d7, d6, d5, d4);

        this.backlight = (byte)backlight;
    }

    /**
     * cursor
     *
     * Turns cursor on/off.
     *
     * @param state on/off cursor.
     */
    public void cursor(boolean state) {
        try {
            if(state){
                lcd_byte(0x0E, false);
            } else {
                lcd_byte(0x0C, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * cursorBLink
     *
     * Sets cursor to either blink on or off.
     *
     * @param state on/off blink
     */
    public void cursorBlink(boolean state) {
        try {
            if(state){
                    lcd_byte(0x0F, false);
            } else {
                lcd_byte(0x0C, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches the backlight of the LCD on/off
     *
     * Overrides super class to extend functionality to allow backlight state to be changed
     * without waiting for next write.
     *
     * @param backlight boolean state of backlight
     */
    public void setBacklight(boolean backlight){
        super.setBacklight(backlight);

        try {
            super.lcd_byte((byte)(backlight
                              ? 1 << this.backlight
                              : 0 << this.backlight), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
