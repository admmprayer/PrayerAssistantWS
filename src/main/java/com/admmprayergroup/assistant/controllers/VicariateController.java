package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;
import com.admmprayergroup.assistant.modules.vicariate.service.VicariateInfoService;
import com.admmprayergroup.assistant.vo.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vicariate")
public class VicariateController {

    @Autowired
    private VicariateInfoService vicariateInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<PrayerInfoResponse> getOneVicariateInfo(@PathVariable("id") Long vicariateID) throws Exception {
        return ResponseEntity.ok(vicariateInfoService.getOneVicariate(vicariateID));
    }

    @PutMapping
    public ResponseEntity<Vicariate> saveOrUpdateVicariateInfo(@RequestBody Vicariate vicariate) {
        Vicariate vicariateInfo = vicariateInfoService.saveVicariateDetails(vicariate);
        return ResponseEntity.ok(vicariateInfo);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneVicariateInfo(@RequestHeader("vicariate-id") Long vicariateID) {
        vicariateInfoService.deleteVicariateDetails(vicariateID);
        return AppUtils.ACCEPTED;
    }

}
