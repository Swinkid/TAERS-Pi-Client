package com.alex.noble.taers.pi.devices.gps;

/**
 * Created by Alex on 20/01/2017.
 */
public class GPGGA extends NMEASentence {
    public GPGGA(String sentence) {
        super(sentence);
    }

    /**
     * Returns Timestamp of Fix.
     *
     * @return String timestamp of fix.
     */
    public String getTimestamp(){
        return this.getSentence()[1];
    }

    public String getLatitudeDirection(){
        return this.getSentence()[3];
    }

    public String getLongitudeDirection(){
        return this.getSentence()[5];
    }

    /**
     * Returns Latitude String
     *
     * @return String latitude
     */
    public String getLatitudeString(){
        return this.getSentence()[2];
    }

    /**
     * Returns Longitude String
     *
     * @return String longitude
     */
    public String getLongitudeString(){
        return this.getSentence()[4];
    }

}
