package com.alex.noble.taers.pi.devices.gps;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * JUnit Test class to test the GPGGA NMEA Sentence Class.
 *
 * @author Alex Noble
 */
public class GPGGATest {

    private static final String TEST_NMEA_STRING = "$GPGGA,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47";

    private static final String ACTUAL_TIMESTAMP = "123519";
    private static final String ACTUAL_LATITUDE_DIRECTION = "N";
    private static final String ACTUAL_LONGITUDE_DIRECTION = "E";
    private static final String ACTUAL_LATITUDE_STRING = "4807.038";
    private static final String ACTUAL_LONGITUDE_STRING = "01131.000";

    private static GPGGA gpgga;

    @Before
    public void initialize(){
        gpgga = new GPGGA(TEST_NMEA_STRING);
    }

    @Test
    public void testObjectInstantiation() {
        assertNotNull(gpgga);
    }

    @Test
    public void testGetTimestamp(){
        assertEquals(ACTUAL_TIMESTAMP, gpgga.getTimestamp());
    }

    @Test
    public void testLatitudeDirection(){
        assertEquals(ACTUAL_LATITUDE_DIRECTION, gpgga.getLatitudeDirection());
    }

    @Test
    public void testGetLongitudeDirection(){
        assertEquals(ACTUAL_LONGITUDE_DIRECTION, gpgga.getLongitudeDirection());
    }

    @Test
    public void testGetLatitudeString(){
        assertEquals(ACTUAL_LATITUDE_STRING, gpgga.getLatitudeString());
    }

    @Test
    public void testGetLongitudeString(){
        assertEquals(ACTUAL_LONGITUDE_STRING, gpgga.getLongitudeString());
    }


}
