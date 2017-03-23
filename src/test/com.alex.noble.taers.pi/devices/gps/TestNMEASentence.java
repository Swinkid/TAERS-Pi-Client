package com.alex.noble.taers.pi.devices.gps;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Junit Test Class to test NMEASentence.
 *
 * @author Alex Noble
 */
public class TestNMEASentence {

    private static final String TEST_NMEA_STRING = "$GPGGA,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47";

    private static final String ACTUAL_SENTENCE_TYPE = "$GPGGA";

    private static NMEASentence nmeaSentence;

    @Before
    public void initialize(){
        nmeaSentence = new NMEASentence(TEST_NMEA_STRING) {
            @Override
            public String getTimestamp() {
                return null;
            }

            @Override
            public String getLatitudeDirection() {
                return null;
            }

            @Override
            public String getLongitudeDirection() {
                return null;
            }

            @Override
            public String getLatitudeString() {
                return null;
            }

            @Override
            public String getLongitudeString() {
                return null;
            }
        };
    }


    @Test
    public void testGetUnparsedSentence(){
        assertEquals(TEST_NMEA_STRING, nmeaSentence.getUnparsedSentence());
    }

    @Test
    public void testGetSentenceType(){
        assertEquals(ACTUAL_SENTENCE_TYPE, nmeaSentence.getSentenceType());
    }

}
