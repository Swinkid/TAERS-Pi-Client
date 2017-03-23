package com.alex.noble.taers.pi.devices;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by alex on 16/03/2017.
 */
public class TestScreenManager {

    @Test
    public void testNullObject(){
        ScreenManager screenManager = ScreenManager.getInstance();
        assertNotNull(screenManager);
    }

}
