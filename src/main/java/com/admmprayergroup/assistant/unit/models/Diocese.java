package com.admmprayergroup.assistant.unit.models;

import com.admmprayergroup.assistant.unit.dto.DioceseLevel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Diocese extends Unit {

    @Column(nullable = false)
    private DioceseLevel dioceseLevel;

    @OneToMany(mappedBy = "affiliatedDiocese", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vicariate> vicariates;

    public DioceseLevel getDioceseLevel() {
        return dioceseLevel;
    }

    public void setDioceseLevel(DioceseLevel dioceseLevel) {
        this.dioceseLevel = dioceseLevel;
    }

    public Set<Vicariate> getVicariates() {
        return vicariates;
    }

    public void setVicariates(Set<Vicariate> vicariates) {
        this.vicariates = vicariates;
    }
}
