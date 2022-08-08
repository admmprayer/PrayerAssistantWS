package com.admmprayergroup.assistant.unit.service;

import com.admmprayergroup.assistant.unit.dto.UnitDTO;

public interface UnitService {

    UnitDTO getUnit(String unitRegisteredId);

    UnitDTO createUnit(UnitDTO unitDTO);

}
