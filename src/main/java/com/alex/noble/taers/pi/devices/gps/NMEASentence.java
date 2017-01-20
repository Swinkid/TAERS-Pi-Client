package com.alex.noble.taers.pi.devices.gps;

/**
 * NMEASentence
 *
 * This class represents a NMEASentence. Specifically for GPGGA sentence type.
 *
 * TODO: Add additional extensions of this class to generalize for multiple types of NMEA Sentence.
 *
 * @author Alex Noble
 */
public class NMEASentence {

    private String[] sentence;
    private String unparsedSentence;

    public NMEASentence(String sentence){
        this.unparsedSentence = sentence;
        this.sentence = sentence.split(",");
    }

    /**
     * Returns Timestamp of Fix.
     *
     * @return String timestamp of fix.
     */
    public String getTimestamp(){
        return this.sentence[1];
    }

    /**
     * Returns Latitude String
     *
     * @return String latitude
     */
    public String getLatitudeString(){
        return this.sentence[2];
    }

    /**
     * Returns Longitude String
     *
     * @return String longitude
     */
    public String getLongitudeString(){
        return this.sentence[4];
    }


    /**
     * Calculates the Decimal Degrees from NMEA Format.
     *
     * TODO: Make function more robust, accepting direction instead of boolean.
     *
     * @param coordinate NMEA Coordinates (DMS)
     * @param negative Direction of co ordinate (N / S, E / W)
     * @return float Decimal Degrees
     */
    public static float getDecimalDegrees(String coordinate, boolean negative){
        int decimal = coordinate.indexOf(".");

        float degrees = Float.parseFloat(coordinate.substring(0, decimal - 2));
        float minutes = Float.parseFloat(coordinate.substring(decimal - 2, coordinate.length()));


        if(negative){
            return (degrees + (minutes / 60)) * - 1;
        } else {
            return degrees + (minutes / 60);
        }
    }

    /**
     * Returns unparsed NMEA Sentence string.
     *
     * @return String unparsed NMEA String
     */
    public String getUnparsedSentence(){
        return this.unparsedSentence;
    }

}
