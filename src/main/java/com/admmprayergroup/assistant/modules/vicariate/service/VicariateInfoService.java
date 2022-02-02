package com.admmprayergroup.assistant.modules.vicariate.service;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;

public interface VicariateInfoService {

    PrayerInfoResponse getOneVicariate(Long vicariateID) throws Exception;

    Vicariate saveVicariateDetails(Vicariate vicariate);

    void deleteVicariateDetails(Long vicariateID);

}
