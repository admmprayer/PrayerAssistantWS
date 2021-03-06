package com.admmprayergroup.assistant.modules.prayer.service;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import com.admmprayergroup.assistant.dto.PrayerResponse;
import com.admmprayergroup.assistant.dto.models.PrayerSlot;

import java.util.List;

public interface PrayerService {

    List<PrayerResponse> getCompletedPrayerSlots(String id, PrayerEntityType prayerEntityType) throws Exception;

    List<PrayerResponse> getDuePrayerSlots(String id, PrayerEntityType prayerEntityType) throws Exception;

    void savePrayerSlotInformation(PrayerSlot prayerSlot) throws Exception;

    void updatePrayerSlotInformation(PrayerSlot prayerSlot) throws Exception;
}
