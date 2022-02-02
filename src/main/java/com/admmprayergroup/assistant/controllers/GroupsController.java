package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.service.GroupInfoService;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.vo.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/group")
public class GroupsController {

    @Autowired
    private GroupInfoService groupInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<PrayerInfoResponse> getOneGroupInfo(@PathVariable("id") Long groupID) throws Exception {
        return ResponseEntity.ok(groupInfoService.getOneGroup(groupID));
    }

    @PutMapping
    public ResponseEntity<ArchdiocesanGroup> saveOrUpdateGroupInfo(@RequestBody ArchdiocesanGroup archdiocesanGroup) {
        ArchdiocesanGroup group = groupInfoService.saveGroupDetails(archdiocesanGroup);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneGroupInfo(@RequestHeader("group-id") Long groupID) {
        groupInfoService.deleteGroupDetails(groupID);
        return AppUtils.ACCEPTED;
    }

}
