package com.admmprayergroup.assistant.unit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParishDTO extends UnitDTO {

    private String registeredId;
    private ParishLevel parishLevel;
    private VicariateDTO affiliatedVicariateDTO;

}
