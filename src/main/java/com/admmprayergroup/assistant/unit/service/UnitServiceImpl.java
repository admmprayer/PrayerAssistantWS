package com.admmprayergroup.assistant.unit.service;

import com.admmprayergroup.assistant.unit.dto.UnitDTO;
import com.admmprayergroup.assistant.unit.models.Unit;
import com.admmprayergroup.assistant.unit.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public UnitDTO getUnit(String unitRegisteredId) {
        Optional<Unit> optionalUnit = unitRepository.findByRegisteredId(unitRegisteredId);
        if (optionalUnit.isPresent()) {
            Unit unit = optionalUnit.get();
            return new UnitDTO().fromEntity(unit);
        }
        return null; // TODO: Throw invalid Id error
    }

    @Override
    public UnitDTO createUnit(UnitDTO unitDTO) {
        Unit savedUnit = unitRepository.save(unitDTO.toEntity());
        return unitDTO.fromEntity(savedUnit);
    }

}
