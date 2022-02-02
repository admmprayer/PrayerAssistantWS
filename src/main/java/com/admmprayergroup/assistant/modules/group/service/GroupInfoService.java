package com.admmprayergroup.assistant.modules.group.service;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;

public interface GroupInfoService {

    PrayerInfoResponse getOneGroup(Long groupID) throws Exception;

    ArchdiocesanGroup saveGroupDetails(ArchdiocesanGroup archdiocesanGroup);

    void deleteGroupDetails(Long groupID);

}
