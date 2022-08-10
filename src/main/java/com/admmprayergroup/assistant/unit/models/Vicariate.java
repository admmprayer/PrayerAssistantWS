package com.admmprayergroup.assistant.unit.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vicariate extends Unit {

    @Column(nullable = false)
    private Diocese affiliatedDiocese;

}
