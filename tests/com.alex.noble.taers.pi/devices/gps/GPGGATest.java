package com.alex.noble.taers.pi.devices.gps;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Alex on 02/02/2017.
 */
public class GPGGATest {

    public static final String TEST_NMEA_STRING = "$GPGGATest,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47";

    @Test
    public void testObjectInstantiation() {
        GPGGA gpgga = new GPGGA(TEST_NMEA_STRING);
        assertNotNull(gpgga);
    }

    @Test
    public void testGetTimestamp(){
        GPGGA gpgga = new GPGGA(TEST_NMEA_STRING);
        assertEquals("123519", gpgga.getTimestamp());
    }

}
