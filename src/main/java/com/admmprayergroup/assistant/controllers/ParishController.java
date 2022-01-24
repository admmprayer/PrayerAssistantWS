package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.parish.Parish;
import com.admmprayergroup.assistant.modules.parish.service.ParishInfoService;
import com.admmprayergroup.assistant.vo.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parish")
public class ParishController {

    @Autowired
    private ParishInfoService parishInfoService;

    @GetMapping
    public ResponseEntity<List<Parish>> getAllParishInfo() {
        return ResponseEntity.ok(parishInfoService.getAllParishDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parish> getOneParishInfo(@PathVariable("id") Long parishID) {
        return ResponseEntity.ok(parishInfoService.getOneParish(parishID));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveParishInfo(@RequestBody Parish parish) {
        parishInfoService.saveParishDetails(parish);
        return Constants.CREATED;
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> updateParishInfo(@RequestBody Parish parish) {
        parishInfoService.updateParishDetails(parish);
        return Constants.CREATED;
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneParishInfo(@RequestHeader("parish-id") Long parishID) {
        parishInfoService.deleteParishDetails(parishID);
        return Constants.CREATED;
    }

}
