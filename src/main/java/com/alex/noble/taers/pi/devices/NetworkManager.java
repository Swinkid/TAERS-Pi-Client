package com.alex.noble.taers.pi.devices;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Network Manager
 *
 * Manages REST (GET / POST) calls to the API server.
 */
public class NetworkManager {

    private static final String API_URL = "http://frontend.alexnoble.co.uk:3001";

    private static final String UPDATE_LOCATION_PATH = "/api/location/update";
    private static final String UPDATE_STATUS_PATH = "/api/device/status/update";



    public static void updateLocation(String device, float lat, float lng){
        try {
            URL updateLocationURL = new URL(API_URL + UPDATE_LOCATION_PATH);

            HttpURLConnection connection = (HttpURLConnection) updateLocationURL.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"device\": \"" + device + "\", \"lat\": " + lat  + ", \"long\": " + lng + " }";

            OutputStream output = connection.getOutputStream();
            output.write(input.getBytes());
            output.flush();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                throw new RuntimeException("Connection Failed. " + connection.getResponseCode());
            }

            //TODO: Would parse response here..

            System.out.println("Sent Update..");

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
