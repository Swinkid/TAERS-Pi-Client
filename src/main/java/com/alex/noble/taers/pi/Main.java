package com.alex.noble.taers.pi;

import com.alex.noble.taers.pi.devices.DeviceManager;

public class Main {

    public static final DeviceManager deviceManager = DeviceManager.getInstance();

    public static void main(String[] args) throws Exception {

        Thread.sleep(2000);

        DeviceManager.clearDisplay();
        DeviceManager.setDisplayText("Started.", 0);

    }
}
