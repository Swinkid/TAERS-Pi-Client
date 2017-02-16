package com.alex.noble.taers.pi.devices;

import java.util.TimerTask;

/**
 * Created by Alex on 14/02/2017.
 */
public class SendRequest extends TimerTask {
    public void run(){
        NetworkManager.updateLocation("+447456421341", DeviceManager.getLatestLat(), DeviceManager.getLatestLong());
        System.out.println("Sending...");
    }
}
