package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import com.admmprayergroup.assistant.dto.models.PrayerSlot;
import com.admmprayergroup.assistant.modules.prayer.service.PrayerService;
import com.admmprayergroup.assistant.vo.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prayer")
public class PrayerController {

    @Autowired
    private PrayerService prayerService;

    @Autowired
    private AppUtils appUtils;

    @PostMapping
    public ResponseEntity<HttpStatus> savePrayerMetadata(@RequestParam(value = "entity", required = false) PrayerEntityType prayerEntityType, @RequestBody PrayerSlot prayerSlot) throws Exception {
        prayerSlot.setCelebrationID(appUtils.overwriteCelebrationIDValue(prayerSlot.getCelebrationID(), prayerEntityType));
        prayerService.savePrayerSlotInformation(prayerSlot);
        return AppUtils.ACCEPTED;
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updatePrayerMetadata(@RequestParam(value = "entity", required = false) PrayerEntityType prayerEntityType, @RequestBody PrayerSlot prayerSlot) throws Exception {
        prayerSlot.setCelebrationID(appUtils.overwriteCelebrationIDValue(prayerSlot.getCelebrationID(), prayerEntityType));
        prayerService.updatePrayerSlotInformation(prayerSlot);
        return AppUtils.ACCEPTED;
    }

}
