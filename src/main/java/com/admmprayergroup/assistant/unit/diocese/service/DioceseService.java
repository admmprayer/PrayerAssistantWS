package com.admmprayergroup.assistant.unit.diocese.service;

import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseDTO;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseTag;

import java.util.List;

public interface DioceseService {

    DioceseDTO get(Long id) throws NotFoundInDatabaseException;
    List<DioceseDTO> get(DioceseTag dioceseTag);
    DioceseDTO create(DioceseDTO diocese);
}
