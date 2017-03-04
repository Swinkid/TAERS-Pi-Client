package com.alex.noble.taers.pi.devices.gps;

/**
 * NMEASentence
 *
 * This class represents a NMEASentence. Specifically for GPGGA sentence type.
 *
 * @author Alex Noble
 */
public abstract class NMEASentence {

    private String[] sentence;
    private String unparsedSentence;

    NMEASentence(String sentence){
        this.unparsedSentence = sentence;
        this.sentence = sentence.split(",");
    }

    /**
     * Returns sentence array
     * @return String[] Array of sentence elements
     */
    public String[] getSentence(){
        return this.sentence;
    }

    /**
     * Returns unparsed NMEA Sentence string.
     *
     * @return String unparsed NMEA String
     */
    public String getUnparsedSentence(){
        return this.unparsedSentence;
    }


    /**
     * Returns Sentence Type
     *
     * @return String Sentence type
     */
    public String getSentenceType(){
        return this.sentence[0];
    }

    /**
     * Returns Timestamp of Fix.
     *
     * @return String timestamp of fix.
     */
    public abstract String getTimestamp();

    /**
     * Gets direction of Latitude Co-ordinates
     *
     * @return String N / S Latitude Direction
     */
    public abstract String getLatitudeDirection();

    /**
     * Gets direction of Longitude Direction
     *
     * @return String E / W Longitude Direction
     */
    public abstract String getLongitudeDirection();


    /**
     * Returns Latitude String
     *
     * @return String latitude
     */
    public abstract String getLatitudeString();

    /**
     * Returns Longitude String
     *
     * @return String longitude
     */
    public abstract String getLongitudeString();

}
