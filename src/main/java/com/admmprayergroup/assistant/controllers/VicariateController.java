package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.vicariate.Vicariate;
import com.admmprayergroup.assistant.modules.vicariate.service.VicariateInfoService;
import com.admmprayergroup.assistant.vo.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vicariate")
public class VicariateController {

    @Autowired
    private VicariateInfoService vicariateInfoService;

    @GetMapping
    public ResponseEntity<List<Vicariate>> getAllVicariateInfo() {
        return ResponseEntity.ok(vicariateInfoService.getAllVicariateDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vicariate> getOneVicariateInfo(@PathVariable("id") Long vicariateID) {
        return ResponseEntity.ok(vicariateInfoService.getOneVicariate(vicariateID));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveVicariateInfo(@RequestBody Vicariate vicariate) {
        vicariateInfoService.saveVicariateDetails(vicariate);
        return Constants.CREATED;
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> updateVicariateInfo(@RequestBody Vicariate vicariate) {
        vicariateInfoService.updateVicariateDetails(vicariate);
        return Constants.CREATED;
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteOneVicariateInfo(@RequestHeader("vicariate-id") Long vicariateID) {
        vicariateInfoService.deleteVicariateDetails(vicariateID);
        return Constants.CREATED;
    }

}
