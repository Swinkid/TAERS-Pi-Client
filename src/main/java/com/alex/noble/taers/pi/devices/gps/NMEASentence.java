package com.alex.noble.taers.pi.devices.gps;

/**
 * NMEASentence
 *
 * This class represents a NMEASentence. Specifically for GPGGA sentence type.
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


}
