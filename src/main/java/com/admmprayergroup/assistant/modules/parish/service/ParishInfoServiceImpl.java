package com.admmprayergroup.assistant.modules.parish.service;

import com.admmprayergroup.assistant.modules.parish.ParishRepository;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;
import com.admmprayergroup.assistant.vo.FirestoreDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ParishInfoServiceImpl implements ParishInfoService {

    @Autowired
    private ParishRepository parishRepository;

    @Autowired
    private FirestoreDocument document;

    @Override
    public List<Parish> getAllParishDetails() {
        Iterable<Parish> parishes = parishRepository.findAll();
        List<Parish> parishList = new LinkedList<>();
        parishes.forEach(parishList::add);
        return parishList;
    }

    @Override
    public PrayerInfoResponse getOneParish(Long parishID) throws Exception {
        Optional<Parish> parishPack = parishRepository.findById(parishID);
        if (parishPack.isEmpty())
            throw new Exception("Parish Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setParishInfo(parishPack.get());
        return prayerInfoResponse;
    }

    @Override
    public void saveParishDetails(Parish parish) {
        parishRepository.save(parish);
    }

    @Override
    public void updateParishDetails(Parish parish) {
        parishRepository.save(parish);
    }

    @Override
    public void deleteParishDetails(Long parishID) {
        parishRepository.deleteById(parishID);
    }
}
