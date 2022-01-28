package com.admmprayergroup.assistant.dto;

import java.io.Serializable;

public class PrayerResponse implements Serializable {

    private String prayerSlotID;
    private String saintSpeech;
    private String generalSpeech;
    private String reading;
    private String date;
    private String day;
    private Long prayerTotalStrength;

    public String getPrayerSlotID() {
        return prayerSlotID;
    }

    public void setPrayerSlotID(String prayerSlotID) {
        this.prayerSlotID = prayerSlotID;
    }

    public String getSaintSpeech() {
        return saintSpeech;
    }

    public void setSaintSpeech(String saintSpeech) {
        this.saintSpeech = saintSpeech;
    }

    public String getGeneralSpeech() {
        return generalSpeech;
    }

    public void setGeneralSpeech(String generalSpeech) {
        this.generalSpeech = generalSpeech;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getPrayerTotalStrength() {
        return prayerTotalStrength;
    }

    public void setPrayerTotalStrength(Long prayerTotalStrength) {
        this.prayerTotalStrength = prayerTotalStrength;
    }
}
