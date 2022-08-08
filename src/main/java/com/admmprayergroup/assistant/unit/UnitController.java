package com.admmprayergroup.assistant.unit;

import com.admmprayergroup.assistant.unit.dto.UnitDTO;
import com.admmprayergroup.assistant.unit.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/api/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/{unitId}")
    public ResponseEntity<UnitDTO> getUnit(@PathVariable("unitId") String unitRegisteredId) {
        UnitDTO unit = unitService.getUnit(unitRegisteredId);
        return ResponseEntity.ok(unit);
    }

    @PostMapping
    public ResponseEntity<UnitDTO> createUnit(@RequestBody UnitDTO unitDTO) {
        UnitDTO newUnit = unitService.createUnit(unitDTO);
        return ResponseEntity.ok(newUnit);
    }

}
