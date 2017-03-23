package com.alex.noble.taers.pi.devices;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Alex on 02/02/2017.
 */
public class TestDeviceManager {

    private float TEST_LAT = 51.572f;
    private float TEST_LNG = -1.7583534f;
    private DeviceManager deviceManager;

    @Before
    public void initialize() throws InterruptedException {
        deviceManager = DeviceManager.getInstance();
    }

    @Test
    public void testGetSetLatitude(){
        deviceManager.setLatestLat(TEST_LAT);
        assertEquals(TEST_LAT, deviceManager.getLatestLat());
    }

    @Test
    public void testGetSetLongitude(){
        deviceManager.setLatestLong(TEST_LNG);
        assertEquals(TEST_LAT, deviceManager.getLatestLong());
    }


}
