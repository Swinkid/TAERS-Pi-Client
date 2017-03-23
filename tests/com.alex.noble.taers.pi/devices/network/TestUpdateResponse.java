package com.alex.noble.taers.pi.devices.network;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Alex on 23/03/2017.
 */
public class TestUpdateResponse {

    public final int TEST_UPDATE_COUNT = 10;
    public final String TEST_STATUS = "ONLINE";
    public final String TEST_MESSAGE = "TEST MESSAGE";

    @Test
    public void testGetSetUpdateCount(){

        UpdateResponse response = new UpdateResponse();

        response.setUpdateCount(TEST_UPDATE_COUNT);

        assertEquals(TEST_UPDATE_COUNT, response.getUpdateCount());
    }

    @Test
    public void testGetSetStatus(){

        UpdateResponse response = new UpdateResponse();

        response.setStatus(TEST_STATUS);

        assertEquals(TEST_STATUS, response.getStatus());
    }

    @Test
    public void testGetSetMessage(){

        UpdateResponse response = new UpdateResponse();

        response.setMessage(TEST_MESSAGE);

        assertEquals(TEST_MESSAGE, response.getMessage());
    }

}
