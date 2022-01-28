package com.admmprayergroup.assistant.modules.vicariate.service;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;

import java.util.List;

public interface VicariateInfoService {

    List<Vicariate> getAllVicariateDetails();

    PrayerInfoResponse getOneVicariate(Long vicariateID) throws Exception;

    void saveVicariateDetails(Vicariate vicariate);

    void updateVicariateDetails(Vicariate vicariate);

    void deleteVicariateDetails(Long vicariateID);

}
