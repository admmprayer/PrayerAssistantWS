package com.admmprayergroup.assistant.prayerslots.dto;

import com.admmprayergroup.assistant.prayerslots.models.PrayerSlot;
import com.admmprayergroup.assistant.prayerslots.vo.DateUtils;
import com.admmprayergroup.assistant.prayerslots.vo.ValidatorUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrayerSlotDTO {

    private LocalDate date;
    private Long dayCount;
    private String saintSpeech;
    private String generalSpeech;
    private String celebratorId;
    private String gospel;

    public PrayerSlotDTO() {
    }

    public PrayerSlotDTO(LocalDate date) {
        assignDate(date);
    }

    public PrayerSlotDTO fromEntity(PrayerSlot prayerSlot) {
        this.setDate(prayerSlot.getDate());
        this.setDayCount(prayerSlot.getDayCount());
        this.setSaintSpeech(prayerSlot.getSaintSpeech());
        this.setGeneralSpeech(prayerSlot.getGeneralSpeech());
        this.setCelebratorId(prayerSlot.getCelebratorId());
        this.setGospel(prayerSlot.getGospel());
        return this;
    }

    public PrayerSlot toEntity(LocalDate date) {
        PrayerSlot entity = new PrayerSlot();
        if (ValidatorUtils.isAnyNull(this.getDate(), this.getDayCount())) {
            assignDate(date);
        }
        entity.setDate(this.getDate());
        entity.setDayCount(this.getDayCount());
        entity.setSaintSpeech(this.getSaintSpeech());
        entity.setGeneralSpeech(this.getGeneralSpeech());
        entity.setGospel(this.getGospel());
        entity.setCelebratorId(this.getCelebratorId());
        return entity;
    }

    private void assignDate(LocalDate date) {
        this.setDate(date);
        this.setDayCount(DateUtils.getDayCount(date));
    }

}
