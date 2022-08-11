package com.admmprayergroup.assistant.unit.models;

import com.admmprayergroup.assistant.prayerslots.models.PrayerSlot;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String inChargePriest;

    @Column(nullable = false)
    private String presidentName;

    @Column(nullable = false, length = 10)
    private String presidentContactNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PrayerSlot> prayerSlots = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
