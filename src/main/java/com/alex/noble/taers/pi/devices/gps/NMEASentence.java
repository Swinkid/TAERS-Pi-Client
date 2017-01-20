package com.alex.noble.taers.pi.devices.gps;

/**
 * Created by Alex on 20/01/2017.
 */
public class NMEASentence {

    private String[] sentence;
    private String unparsedSentence;

    public NMEASentence(String sentence){
        this.unparsedSentence = sentence;
        this.sentence = sentence.split(",");
    }

    public String getTimestamp(){
        return this.sentence[1];
    }

    public String getLatitudeString(){
        return this.sentence[2];
    }

    public String getLongitudeString(){
        return this.sentence[4];
    }

    public String getUnparsedSentence(){
        return this.unparsedSentence;
    }

}
