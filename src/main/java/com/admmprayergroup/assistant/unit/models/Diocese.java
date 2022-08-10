package com.admmprayergroup.assistant.unit.models;

import com.admmprayergroup.assistant.unit.dto.DioceseLevel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Diocese extends Unit {

    @Column(nullable = false)
    private DioceseLevel dioceseLevel;

    public DioceseLevel getDioceseLevel() {
        return dioceseLevel;
    }

    public void setDioceseLevel(DioceseLevel dioceseLevel) {
        this.dioceseLevel = dioceseLevel;
    }
}
