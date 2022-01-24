package com.admmprayergroup.assistant.modules.parish.service;

import com.admmprayergroup.assistant.modules.parish.Parish;

import java.util.List;

public interface ParishInfoService {

    List<Parish> getAllParishDetails();

    Parish getOneParish(Long parishID);

    void saveParishDetails(Parish parish);

    void updateParishDetails(Parish parish);

    void deleteParishDetails(Long parishID);

}
