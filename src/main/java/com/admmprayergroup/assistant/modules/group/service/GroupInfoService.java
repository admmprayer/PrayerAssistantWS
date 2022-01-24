package com.admmprayergroup.assistant.modules.group.service;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;

import java.util.List;

public interface GroupInfoService {

    List<ArchdiocesanGroup> getAllGroupDetails();

    ArchdiocesanGroup getOneGroup(Long groupID);

    void saveGroupDetails(ArchdiocesanGroup archdiocesanGroup);

    void updateGroupDetails(ArchdiocesanGroup archdiocesanGroup);

    void deleteGroupDetails(Long groupID);

}
