package com.admmprayergroup.assistant.unit.models;

import com.admmprayergroup.assistant.prayerslots.models.PrayerSlot;
import com.admmprayergroup.assistant.unit.dto.UnitType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String registeredId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UnitType type;
    @Column(nullable = false)
    private String inChargePriest;
    @Column(nullable = false)
    private String presidentName;
    @Column(nullable = false, length = 10)
    private String presidentContactNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<PrayerSlot> prayerSlots = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(String registeredId) {
        this.registeredId = registeredId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public String getInChargePriest() {
        return inChargePriest;
    }

    public void setInChargePriest(String inChargePriest) {
        this.inChargePriest = inChargePriest;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getPresidentContactNumber() {
        return presidentContactNumber;
    }

    public void setPresidentContactNumber(String presidentContactNumber) {
        this.presidentContactNumber = presidentContactNumber;
    }

    public Set<PrayerSlot> getPrayerSlots() {
        return prayerSlots;
    }

    public void setPrayerSlots(Set<PrayerSlot> prayerSlots) {
        this.prayerSlots = prayerSlots;
    }
}
