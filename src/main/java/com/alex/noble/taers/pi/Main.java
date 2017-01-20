package com.alex.noble.taers.pi;

import com.alex.noble.taers.pi.devices.DeviceManager;

public class Main {

    public static DeviceManager deviceManager;

    public static void main(String[] args) throws Exception {

        deviceManager = DeviceManager.getInstance();


    }
}
