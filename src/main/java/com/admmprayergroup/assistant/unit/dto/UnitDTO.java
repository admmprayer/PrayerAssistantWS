package com.admmprayergroup.assistant.unit.dto;

import com.admmprayergroup.assistant.unit.models.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDTO {

    private String registeredId;
    private String name;
    private UnitType type;
    private String inChargePriest;
    private String presidentName;
    private String presidentContactNumber;

    public UnitDTO fromEntity(Unit unit) {
        this.setRegisteredId(unit.getRegisteredId());
        this.setName(unit.getName());
        this.setType(unit.getType());
        this.setInChargePriest(unit.getInChargePriest());
        this.setPresidentName(unit.getPresidentName());
        this.setPresidentContactNumber(unit.getPresidentContactNumber());
        return this;
    }

    public Unit toEntity() {
        Unit entity = new Unit();
        entity.setRegisteredId(this.getRegisteredId());
        entity.setName(this.getName());
        entity.setType(this.getType());
        entity.setInChargePriest(this.getInChargePriest());
        entity.setPresidentName(this.getPresidentName());
        entity.setPresidentContactNumber(this.getPresidentContactNumber());
        return entity;
    }

}
