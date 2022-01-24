package com.admmprayergroup.assistant.modules.group.service;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.GroupRepository;
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
    public ArchdiocesanGroup getOneGroup(Long groupID) {
        Optional<ArchdiocesanGroup> groupPack = groupRepository.findById(groupID);
        return groupPack.orElse(null);
    }

    @Override
    public void saveGroupDetails(ArchdiocesanGroup archdiocesanGroup) {
        groupRepository.save(archdiocesanGroup);
    }

    @Override
    public void updateGroupDetails(ArchdiocesanGroup archdiocesanGroup) {
        groupRepository.save(archdiocesanGroup);
    }

    @Override
    public void deleteGroupDetails(Long groupID) {
        groupRepository.deleteById(groupID);
    }
}
