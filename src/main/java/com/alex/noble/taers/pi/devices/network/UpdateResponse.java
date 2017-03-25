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

    /**
     * getUpdateCount
     *
     * returns number of updates in pojo.
     *
     * @return int number of updates
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * setUpdateCount
     *
     * Sets the number of updates in the Pojo
     *
     * @param updateCount int number of updates
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * getStatus
     *
     * Gets the HTTP response from the request.
     *
     * @return String HTTP response
     */
    public String getStatus() {
        return status;
    }

    /**
     * setStatus
     *
     * Sets the HTTP response
     *
     * @param error
     */
    public void setStatus(String error) {
        this.status = error;
    }

    /**
     * getMessage
     *
     * Gets message recieved from backend API
     *
     * @return String message recieved from backend API.
     */
    public String getMessage() {
        return message;
    }

    /**
     * setMessage
     *
     * Sets the message from the HTTP response.
     *
     * @param message Message recieved from backend API.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
