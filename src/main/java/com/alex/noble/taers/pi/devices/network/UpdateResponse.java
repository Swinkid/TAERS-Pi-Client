package com.alex.noble.taers.pi.devices.network;

/**
 * UpdateResource
 *
 * POJO that represents the JSON returned by getting updates.
 *
 * @author Alex Noble
 */
public class UpdateResponse {

    public int updateCount = 0;
    public String status = "NONE";
    public String message = "";

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String error) {
        this.status = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
