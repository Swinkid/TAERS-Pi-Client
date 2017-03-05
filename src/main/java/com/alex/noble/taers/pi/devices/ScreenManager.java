package com.alex.noble.taers.pi.devices;

/**
 * ScreenManager
 *
 * Singleton class that manages what is displayed on the LCD.
 *
 * @author Alex Noble
 */
public class ScreenManager {

    private static ScreenManager instance = null;
    private String state = "";

    private ScreenManager(){}

    public static ScreenManager getInstance(){
        if(instance == null){
            instance = new ScreenManager();
        }

        return instance;
    }

}
