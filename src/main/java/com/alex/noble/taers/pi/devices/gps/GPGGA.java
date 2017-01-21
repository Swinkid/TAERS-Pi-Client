package com.alex.noble.taers.pi.devices.gps;

/**
 * GPGGA
 *
 * Class representation of the GPGGA NMEA Sentence.
 *
 * @author Alex Noble
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
    @Override
    public String getTimestamp(){
        return this.getSentence()[1];
    }

    /**
     * Gets direction of Latitude Co-ordinates
     *
     * @return String N / S Latitude Direction
     */
    @Override
    public String getLatitudeDirection(){
        return this.getSentence()[3];
    }

    /**
     * Gets direction of Longitude Direction
     *
     * @return String E / W Longitude Direction
     */
    @Override
    public String getLongitudeDirection(){
        return this.getSentence()[5];
    }

    /**
     * Returns Latitude String
     *
     * @return String latitude
     */
    @Override
    public String getLatitudeString(){
        return this.getSentence()[2];
    }

    /**
     * Returns Longitude String
     *
     * @return String longitude
     */
    @Override
    public String getLongitudeString(){
        return this.getSentence()[4];
    }

}
