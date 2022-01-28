package com.admmprayergroup.assistant.modules.group.service;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.GroupRepository;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupInfoServiceImpl implements GroupInfoService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<ArchdiocesanGroup> getAllGroupDetails() {
        Iterable<ArchdiocesanGroup> groups = groupRepository.findAll();
        List<ArchdiocesanGroup> archdiocesanGroupList = new LinkedList<>();
        groups.forEach(archdiocesanGroupList::add);
        return archdiocesanGroupList;
    }

    @Override
    public PrayerInfoResponse getOneGroup(Long groupID) throws Exception {
        Optional<ArchdiocesanGroup> groupPack = groupRepository.findById(groupID);
        if (groupPack.isEmpty())
            throw new Exception("Group Not available in given ID");
        PrayerInfoResponse prayerInfoResponse = new PrayerInfoResponse();
        prayerInfoResponse.setGroupInfo(groupPack.get());
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
