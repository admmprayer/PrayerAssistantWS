package com.admmprayergroup.assistant.modules.parish.service;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import com.admmprayergroup.assistant.modules.parish.ParishRepository;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;
import com.admmprayergroup.assistant.modules.prayer.service.PrayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParishInfoServiceImpl implements ParishInfoService {

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private PrayerService prayerService;

    @Override
    public PrayerInfoResponse getOneParish(Long parishID) throws Exception {
        Optional<Parish> parishPack = parishRepository.findById(parishID);
        if (parishPack.isEmpty())
            throw new Exception("Parish Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setParishInfo(parishPack.get());
        prayerInfoResponse.setPrayerSlotsCompleted(prayerService.getCompletedPrayerSlots(String.valueOf(parishID), PrayerEntityType.PARISH));
        prayerInfoResponse.setPrayerSlotsDue(prayerService.getDuePrayerSlots(String.valueOf(parishID), PrayerEntityType.PARISH));
        return prayerInfoResponse;
    }

    @Override
    public Parish saveParishDetails(Parish parish) {
        return parishRepository.save(parish);
    }

    @Override
    public void deleteParishDetails(Long parishID) {
        parishRepository.deleteById(parishID);
    }
}
