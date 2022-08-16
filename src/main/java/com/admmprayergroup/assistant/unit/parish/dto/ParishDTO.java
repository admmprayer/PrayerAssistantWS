package com.admmprayergroup.assistant.unit.parish.dto;

import com.admmprayergroup.assistant.unit.UnitDTO;
import com.admmprayergroup.assistant.unit.vicariate.dto.VicariateDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParishDTO extends UnitDTO {

    private String registeredId;
    private ParishLevel parishLevel;
    private VicariateDTO affiliatedVicariateDTO;

}
