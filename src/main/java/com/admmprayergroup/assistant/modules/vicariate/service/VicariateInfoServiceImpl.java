package com.admmprayergroup.assistant.modules.vicariate.service;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;
import com.admmprayergroup.assistant.modules.vicariate.VicariateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VicariateInfoServiceImpl implements VicariateInfoService {

    @Autowired
    private VicariateRepository vicariateRepository;

    @Override
    public List<Vicariate> getAllVicariateDetails() {
        Iterable<Vicariate> vicariate = vicariateRepository.findAll();
        List<Vicariate> vicariateList = new LinkedList<>();
        vicariate.forEach(vicariateList::add);
        return vicariateList;
    }

    @Override
    public PrayerInfoResponse getOneVicariate(Long vicariateID) throws Exception {
        Optional<Vicariate> vicariatePack = vicariateRepository.findById(vicariateID);
        if (vicariatePack.isEmpty())
            throw new Exception("Vicariate Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setVicariateInfo(vicariatePack.get());
        return prayerInfoResponse;
    }

    @Override
    public void saveVicariateDetails(Vicariate vicariate) {
        vicariateRepository.save(vicariate);
    }

    @Override
    public void updateVicariateDetails(Vicariate vicariate) {
        vicariateRepository.save(vicariate);
    }

    @Override
    public void deleteVicariateDetails(Long vicariateID) {
        vicariateRepository.deleteById(vicariateID);
    }
}
