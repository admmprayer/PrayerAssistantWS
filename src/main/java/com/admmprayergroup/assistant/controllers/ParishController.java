package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;
import com.admmprayergroup.assistant.modules.parish.service.ParishInfoService;
import com.admmprayergroup.assistant.vo.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parish")
public class ParishController {

    @Autowired
    private ParishInfoService parishInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<PrayerInfoResponse> getOneParishInfo(@PathVariable("id") Long parishID) throws Exception {
        return ResponseEntity.ok(parishInfoService.getOneParish(parishID));
    }

    @PutMapping
    public ResponseEntity<Parish> saveOrUpdateParishInfo(@RequestBody Parish parish) {
        Parish parishInfo = parishInfoService.saveParishDetails(parish);
        return ResponseEntity.ok(parishInfo);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneParishInfo(@RequestHeader("parish-id") Long parishID) {
        parishInfoService.deleteParishDetails(parishID);
        return AppUtils.ACCEPTED;
    }

}
