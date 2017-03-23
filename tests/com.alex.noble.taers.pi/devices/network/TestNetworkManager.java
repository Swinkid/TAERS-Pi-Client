package com.alex.noble.taers.pi.devices.network;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Created by Alex on 23/03/2017.
 */
public class TestNetworkManager {

    private String TEST_DEVICE = "+447456421341";
    private float TEST_LAT = 51.572f;
    private float TEST_LNG = -1.7583534f;

    @Test
    public void testGetUpdates(){
        UpdateResponse updates = NetworkManager.getUpdates(TEST_DEVICE);
        assertNotNull(updates);
    }

    @Test
    public void testGetUpdatesStatus(){
        UpdateResponse updates = NetworkManager.getUpdates(TEST_DEVICE);
        assertNotNull(updates.getStatus());
    }

    @Test
    public void testUpdateLocation(){
        NetworkManager.updateLocation(TEST_DEVICE, TEST_LAT, TEST_LNG);
        assert true;
    }

}
