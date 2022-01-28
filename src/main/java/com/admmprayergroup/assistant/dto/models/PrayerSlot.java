package com.admmprayergroup.assistant.dto.models;

import com.google.cloud.firestore.annotation.PropertyName;

import java.io.Serializable;

public class PrayerSlot implements Serializable {

    private String prayerSlotID;
    private String celebrationID;
    private String saintSpeech;
    private String generalSpeech;
    private String reading;

    public PrayerSlot() {
    }

    public PrayerSlot(String prayerSlotID, String celebrationID, String saintSpeech, String generalSpeech, String reading) {
        this.prayerSlotID = prayerSlotID;
        this.celebrationID = celebrationID;
        this.saintSpeech = saintSpeech;
        this.generalSpeech = generalSpeech;
        this.reading = reading;
    }

    @PropertyName("slot_id")
    public String getPrayerSlotID() {
        return prayerSlotID;
    }

    @PropertyName("slot_id")
    public void setPrayerSlotID(String prayerSlotID) {
        this.prayerSlotID = prayerSlotID;
    }

    @PropertyName("celebrate_id")
    public String getCelebrationID() {
        return celebrationID;
    }

    @PropertyName("celebrate_id")
    public void setCelebrationID(String celebrationID) {
        this.celebrationID = celebrationID;
    }

    @PropertyName("saint_speech")
    public String getSaintSpeech() {
        return saintSpeech;
    }

    @PropertyName("saint_speech")
    public void setSaintSpeech(String saintSpeech) {
        this.saintSpeech = saintSpeech;
    }

    @PropertyName("general_speech")
    public String getGeneralSpeech() {
        return generalSpeech;
    }

    @PropertyName("general_speech")
    public void setGeneralSpeech(String generalSpeech) {
        this.generalSpeech = generalSpeech;
    }

    @PropertyName("reading")
    public String getReading() {
        return reading;
    }

    @PropertyName("reading")
    public void setReading(String reading) {
        this.reading = reading;
    }
}
