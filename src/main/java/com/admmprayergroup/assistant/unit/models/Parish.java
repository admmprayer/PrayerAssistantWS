package com.admmprayergroup.assistant.unit.models;

import com.admmprayergroup.assistant.unit.dto.ParishLevel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Parish extends Unit {

    @Column(nullable = false, unique = true)
    private String registeredId;

    @Column(nullable = false)
    private ParishLevel parishLevel;

    @Column(nullable = false)
    private Vicariate affiliatedVicariate;

    public String getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(String registeredId) {
        this.registeredId = registeredId;
    }

    public ParishLevel getLevel() {
        return parishLevel;
    }

    public void setLevel(ParishLevel parishLevel) {
        this.parishLevel = parishLevel;
    }

    public Vicariate getAffiliatedVicariate() {
        return affiliatedVicariate;
    }

    public void setAffiliatedVicariate(Vicariate affiliatedVicariate) {
        this.affiliatedVicariate = affiliatedVicariate;
    }
}
