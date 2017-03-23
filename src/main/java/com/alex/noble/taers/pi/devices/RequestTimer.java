package com.alex.noble.taers.pi.devices;

import com.alex.noble.taers.pi.devices.network.NetworkManager;
import com.alex.noble.taers.pi.devices.network.UpdateResponse;

import java.util.TimerTask;

/**
 * Created by Alex on 14/02/2017.
 */
public class RequestTimer extends TimerTask {
    public void run(){
        NetworkManager.updateLocation("+447456421341", DeviceManager.getLatestLat(), DeviceManager.getLatestLong());
        UpdateResponse updates = NetworkManager.getUpdates("+447456421341");

        if(updates.getStatus().equals("OK")){
            String messages = updates.getMessage();

            String[] display = messages.split(",");

            for(int i = 0; i < 2; i++){
                DeviceManager.setDisplayText(display[i], i);
            }

        }
    }
}
