package com.alex.noble.taers.pi.devices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Alex on 02/02/2017.
 */
public class TestDeviceManager {

    private static final float NEW_LAT_LONG = 0.1f;

    @Test
    public void testNullObject() {
        DeviceManager deviceManager = new DeviceManager();
        assertNotNull(deviceManager);
    }

    @Test
    public void testGetSetLatestLat() {
        DeviceManager deviceManager = new DeviceManager();

        deviceManager.setLatestLat(NEW_LAT_LONG);

        assertEquals(NEW_LAT_LONG, deviceManager.getLatestLat());
    }

    @Test
    public void testSetLatestLong() {
        DeviceManager deviceManager = new DeviceManager();

        deviceManager.setLatestLong(NEW_LAT_LONG);

        assertEquals(NEW_LAT_LONG, deviceManager.getLatestLong());
    }

}
