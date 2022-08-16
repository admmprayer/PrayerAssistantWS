package com.admmprayergroup.assistant.unit.parish.models;

import com.admmprayergroup.assistant.unit.Unit;
import com.admmprayergroup.assistant.unit.vicariate.models.Vicariate;
import com.admmprayergroup.assistant.unit.parish.dto.ParishLevel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parish extends Unit {

    @Column(nullable = false, unique = true)
    private String registeredId;

    @Column(nullable = false)
    private ParishLevel parishLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vicariate_id", nullable = false)
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
