package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.service.GroupInfoService;
import com.admmprayergroup.assistant.vo.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
public class GroupsController {

    @Autowired
    private GroupInfoService groupInfoService;

    @GetMapping
    public ResponseEntity<List<ArchdiocesanGroup>> getAllGroupInfo() {
        return ResponseEntity.ok(groupInfoService.getAllGroupDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchdiocesanGroup> getOneGroupInfo(@PathVariable("id") Long groupID) {
        return ResponseEntity.ok(groupInfoService.getOneGroup(groupID));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveGroupInfo(@RequestBody ArchdiocesanGroup archdiocesanGroup) {
        groupInfoService.saveGroupDetails(archdiocesanGroup);
        return Constants.CREATED;
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> updateGroupInfo(@RequestBody ArchdiocesanGroup archdiocesanGroup) {
        groupInfoService.updateGroupDetails(archdiocesanGroup);
        return Constants.CREATED;
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneGroupInfo(@RequestHeader("group-id") Long groupID) {
        groupInfoService.deleteGroupDetails(groupID);
        return Constants.CREATED;
    }

}
