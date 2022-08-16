package com.admmprayergroup.assistant.unit.diocese.models;

import com.admmprayergroup.assistant.unit.diocese.dto.DioceseLevel;
import com.admmprayergroup.assistant.unit.Unit;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseTag;
import com.admmprayergroup.assistant.unit.vicariate.models.Vicariate;

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

    @Column(nullable = false)
    private DioceseTag tag;

    @OneToMany(mappedBy = "affiliatedDiocese", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vicariate> vicariates;

    public DioceseLevel getDioceseLevel() {
        return dioceseLevel;
    }

    public void setDioceseLevel(DioceseLevel dioceseLevel) {
        this.dioceseLevel = dioceseLevel;
    }

    public DioceseTag getTag() {
        return tag;
    }

    public void setTag(DioceseTag tag) {
        this.tag = tag;
    }

    public Set<Vicariate> getVicariates() {
        return vicariates;
    }

    public void setVicariates(Set<Vicariate> vicariates) {
        this.vicariates = vicariates;
    }
}
