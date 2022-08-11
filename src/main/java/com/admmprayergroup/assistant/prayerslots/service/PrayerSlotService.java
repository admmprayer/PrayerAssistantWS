package com.admmprayergroup.assistant.prayerslots.service;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;

import java.time.LocalDate;

public interface PrayerSlotService {

    PrayerSlotDTO getSlot(LocalDate date);

    PrayerSlotDTO createSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO);

    void updateSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO) throws NotFoundInDatabaseException;
}
