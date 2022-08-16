package com.admmprayergroup.assistant.unit.diocese;

import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseDTO;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseTag;
import com.admmprayergroup.assistant.unit.diocese.service.DioceseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/diocese")
public class DioceseUnitsController {

    @Autowired
    private DioceseService dioceseService;

    @GetMapping("/{id}")
    public ResponseEntity<DioceseDTO> getDiocese(@PathVariable("id") Long id) throws NotFoundInDatabaseException {
        DioceseDTO diocese = dioceseService.get(id);
        return ResponseEntity.ok(diocese);
    }

    @GetMapping
    public ResponseEntity<List<DioceseDTO>> getDioceses(@RequestParam("tag") DioceseTag dioceseTag) {
        List<DioceseDTO> dioceseUnits = dioceseService.get(dioceseTag);
        return ResponseEntity.ok(dioceseUnits);
    }

    @PostMapping
    public ResponseEntity<DioceseDTO> createDiocese(@RequestBody DioceseDTO diocese) {
        DioceseDTO savedDiocese = dioceseService.create(diocese);
        return ResponseEntity.ok(savedDiocese);
    }

}
