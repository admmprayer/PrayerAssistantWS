package com.admmprayergroup.assistant.unit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UnitDTO {

    private Long id;
    private String name;
    private String inChargePriest;
    private String presidentName;
    private String presidentContactNumber;

}
