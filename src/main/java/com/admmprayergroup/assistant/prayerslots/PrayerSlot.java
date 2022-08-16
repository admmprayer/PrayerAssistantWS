package com.admmprayergroup.assistant.prayerslots;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PrayerSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private LocalDate date;
    @Column(nullable = false, unique = true)
    private Long dayCount;
    private String saintSpeech;
    private String generalSpeech;
    private String gospel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDayCount() {
        return dayCount;
    }

    public void setDayCount(Long dayCount) {
        this.dayCount = dayCount;
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

    public String getGospel() {
        return gospel;
    }

    public void setGospel(String gospel) {
        this.gospel = gospel;
    }
}
