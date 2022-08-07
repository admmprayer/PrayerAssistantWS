package com.admmprayergroup.assistant.prayerslots.service;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;

import java.time.LocalDate;

public interface PrayerSlotService {

    PrayerSlotDTO getSlot(LocalDate date);

    PrayerSlotDTO createSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO);

    void updateSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO);
}
