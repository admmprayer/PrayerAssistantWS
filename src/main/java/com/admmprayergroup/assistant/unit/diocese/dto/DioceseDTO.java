package com.admmprayergroup.assistant.unit.diocese.dto;

import com.admmprayergroup.assistant.unit.UnitDTO;
import com.admmprayergroup.assistant.unit.diocese.models.Diocese;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DioceseDTO extends UnitDTO {

    private DioceseLevel dioceseLevel;
    private DioceseTag tag;

    public DioceseDTO fromEntity(Diocese diocese) {
        super.setId(diocese.getId());
        super.setName(diocese.getName());
        super.setInChargePriest(diocese.getInChargePriest());
        super.setPresidentName(diocese.getPresidentName());
        super.setPresidentContactNumber(diocese.getPresidentContactNumber());
        this.setDioceseLevel(diocese.getDioceseLevel());
        this.setTag(diocese.getTag());
        return this;
    }

    public Diocese toEntity() {
        Diocese diocese = new Diocese();
        diocese.setName(super.getName());
        diocese.setInChargePriest(super.getInChargePriest());
        diocese.setPresidentName(super.getPresidentName());
        diocese.setPresidentContactNumber(super.getPresidentContactNumber());
        diocese.setDioceseLevel(this.getDioceseLevel());
        diocese.setTag(this.getTag());
        return diocese;
    }

}
