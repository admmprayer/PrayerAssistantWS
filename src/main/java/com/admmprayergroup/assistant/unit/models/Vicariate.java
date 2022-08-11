package com.admmprayergroup.assistant.unit.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Vicariate extends Unit {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diocese_id", nullable = false)
    private Diocese affiliatedDiocese;

    @OneToMany(mappedBy = "affiliatedVicariate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Parish> parishes;

    public Diocese getAffiliatedDiocese() {
        return affiliatedDiocese;
    }

    public void setAffiliatedDiocese(Diocese affiliatedDiocese) {
        this.affiliatedDiocese = affiliatedDiocese;
    }

    public Set<Parish> getParishes() {
        return parishes;
    }

    public void setParishes(Set<Parish> parishes) {
        this.parishes = parishes;
    }
}
