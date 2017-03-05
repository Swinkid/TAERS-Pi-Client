package com.alex.noble.taers.pi.devices.network;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private static final String GET_UPDATES_PATH = "/api/updates/get";
    private static final String UPDATE_STATUS_PATH = "/api/device/status/update";



    public static void updateLocation(String device, float lat, float lng){
        try {
            URL updateLocationURL = new URL(API_URL + UPDATE_LOCATION_PATH);

            HttpURLConnection connection = (HttpURLConnection) updateLocationURL.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            String input = "{\"device\": \"" + device + "\", \"lat\": " + lat  + ", \"long\": " + lng + " }";

            OutputStream output = connection.getOutputStream();
            output.write(input.getBytes());
            output.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UpdateResponse getUpdates(String device){
        try {
            URL getUpdatesURL = new URL(API_URL + GET_UPDATES_PATH);

            HttpURLConnection connection = (HttpURLConnection) getUpdatesURL.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            String input = "{\"device\": \"" + device + "\"}";

            OutputStream os = connection.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));


            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            Gson gson = new Gson();

            UpdateResponse update = gson.fromJson(output, UpdateResponse.class);

            connection.disconnect();

            return update;

        } catch (IOException e){

        }

        UpdateResponse update = new UpdateResponse();
        update.setStatus("Error");

        return update;
    }

}
