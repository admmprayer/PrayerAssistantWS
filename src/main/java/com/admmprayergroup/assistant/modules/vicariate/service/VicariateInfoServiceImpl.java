package com.admmprayergroup.assistant.modules.vicariate.service;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.prayer.service.PrayerService;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;
import com.admmprayergroup.assistant.modules.vicariate.VicariateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VicariateInfoServiceImpl implements VicariateInfoService {

    @Autowired
    private VicariateRepository vicariateRepository;

    @Autowired
    private PrayerService prayerService;

    @Override
    public PrayerInfoResponse getOneVicariate(Long vicariateID) throws Exception {
        Optional<Vicariate> vicariatePack = vicariateRepository.findById(vicariateID);
        if (vicariatePack.isEmpty())
            throw new Exception("Vicariate Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setVicariateInfo(vicariatePack.get());
        prayerInfoResponse.setPrayerSlotsCompleted(prayerService.getCompletedPrayerSlots(String.valueOf(vicariateID), PrayerEntityType.VICARIATE));
        prayerInfoResponse.setPrayerSlotsDue(prayerService.getDuePrayerSlots(String.valueOf(vicariateID), PrayerEntityType.VICARIATE));
        return prayerInfoResponse;
    }

    @Override
    public Vicariate saveVicariateDetails(Vicariate vicariate) {
        return vicariateRepository.save(vicariate);
    }

    @Override
    public void deleteVicariateDetails(Long vicariateID) {
        vicariateRepository.deleteById(vicariateID);
    }
}
