package com.admmprayergroup.assistant.modules.parish.service;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;

import java.util.List;

public interface ParishInfoService {

    PrayerInfoResponse getOneParish(Long parishID) throws Exception;

    Parish saveParishDetails(Parish parish);

    void deleteParishDetails(Long parishID);

}
