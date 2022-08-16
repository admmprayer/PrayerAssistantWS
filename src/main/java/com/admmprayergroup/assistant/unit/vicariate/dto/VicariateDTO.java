package com.admmprayergroup.assistant.unit.vicariate.dto;

import com.admmprayergroup.assistant.unit.diocese.dto.DioceseDTO;
import com.admmprayergroup.assistant.unit.UnitDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VicariateDTO extends UnitDTO {

    private DioceseDTO affiliatedDioceseDTO;

}
