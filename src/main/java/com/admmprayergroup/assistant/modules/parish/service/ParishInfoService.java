package com.admmprayergroup.assistant.modules.parish.service;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;

import java.util.List;

public interface ParishInfoService {

    List<Parish> getAllParishDetails();

    PrayerInfoResponse getOneParish(Long parishID) throws Exception;

    void saveParishDetails(Parish parish);

    void updateParishDetails(Parish parish);

    void deleteParishDetails(Long parishID);

}
