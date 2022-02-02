package com.admmprayergroup.assistant.modules.group.service;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.GroupRepository;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.prayer.service.PrayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupInfoServiceImpl implements GroupInfoService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PrayerService prayerService;

    @Override
    public PrayerInfoResponse getOneGroup(Long groupID) throws Exception {
        Optional<ArchdiocesanGroup> groupPack = groupRepository.findById(groupID);
        if (groupPack.isEmpty())
            throw new Exception("Group Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setGroupInfo(groupPack.get());
        prayerInfoResponse.setPrayerSlotsCompleted(prayerService.getCompletedPrayerSlots(String.valueOf(groupID), PrayerEntityType.GROUP));
        prayerInfoResponse.setPrayerSlotsDue(prayerService.getDuePrayerSlots(String.valueOf(groupID), PrayerEntityType.GROUP));
        return prayerInfoResponse;
    }

    @Override
    public ArchdiocesanGroup saveGroupDetails(ArchdiocesanGroup archdiocesanGroup) {
        return groupRepository.save(archdiocesanGroup);
    }

    @Override
    public void deleteGroupDetails(Long groupID) {
        groupRepository.deleteById(groupID);
    }
}
