package com.admmprayergroup.assistant.modules.vicariate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Vicariate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vicariateNameEnglish;
    private String vicariateLocationEnglish;
    private String vicariateNameTamil;
    private String vicariateLocationTamil;
    private String vicariatePriestName;
    private String vicariatePriestPhoneNumber;
    private String vicariateYouthPriestName;
    private String vicariateYouthPriestPhoneNumber;
    private String vicariateYouthPresidentName;
    private String vicariateYouthPresidentNumber;
    private String contactPerson1Name;
    private String contactPerson1PhoneNumber;
    private String contactPerson2Name;
    private String contactPerson2PhoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVicariateNameEnglish() {
        return vicariateNameEnglish;
    }

    public void setVicariateNameEnglish(String vicariateNameEnglish) {
        this.vicariateNameEnglish = vicariateNameEnglish;
    }

    public String getVicariateLocationEnglish() {
        return vicariateLocationEnglish;
    }

    public void setVicariateLocationEnglish(String vicariateLocationEnglish) {
        this.vicariateLocationEnglish = vicariateLocationEnglish;
    }

    public String getVicariateNameTamil() {
        return vicariateNameTamil;
    }

    public void setVicariateNameTamil(String vicariateNameTamil) {
        this.vicariateNameTamil = vicariateNameTamil;
    }

    public String getVicariateLocationTamil() {
        return vicariateLocationTamil;
    }

    public void setVicariateLocationTamil(String vicariateLocationTamil) {
        this.vicariateLocationTamil = vicariateLocationTamil;
    }

    public String getVicariatePriestName() {
        return vicariatePriestName;
    }

    public void setVicariatePriestName(String vicariatePriestName) {
        this.vicariatePriestName = vicariatePriestName;
    }

    public String getVicariatePriestPhoneNumber() {
        return vicariatePriestPhoneNumber;
    }

    public void setVicariatePriestPhoneNumber(String vicariatePriestPhoneNumber) {
        this.vicariatePriestPhoneNumber = vicariatePriestPhoneNumber;
    }

    public String getVicariateYouthPriestName() {
        return vicariateYouthPriestName;
    }

    public void setVicariateYouthPriestName(String vicariateYouthPriestName) {
        this.vicariateYouthPriestName = vicariateYouthPriestName;
    }

    public String getVicariateYouthPriestPhoneNumber() {
        return vicariateYouthPriestPhoneNumber;
    }

    public void setVicariateYouthPriestPhoneNumber(String vicariateYouthPriestPhoneNumber) {
        this.vicariateYouthPriestPhoneNumber = vicariateYouthPriestPhoneNumber;
    }

    public String getVicariateYouthPresidentName() {
        return vicariateYouthPresidentName;
    }

    public void setVicariateYouthPresidentName(String vicariateYouthPresidentName) {
        this.vicariateYouthPresidentName = vicariateYouthPresidentName;
    }

    public String getVicariateYouthPresidentNumber() {
        return vicariateYouthPresidentNumber;
    }

    public void setVicariateYouthPresidentNumber(String vicariateYouthPresidentNumber) {
        this.vicariateYouthPresidentNumber = vicariateYouthPresidentNumber;
    }

    public String getContactPerson1Name() {
        return contactPerson1Name;
    }

    public void setContactPerson1Name(String contactPerson1Name) {
        this.contactPerson1Name = contactPerson1Name;
    }

    public String getContactPerson1PhoneNumber() {
        return contactPerson1PhoneNumber;
    }

    public void setContactPerson1PhoneNumber(String contactPerson1PhoneNumber) {
        this.contactPerson1PhoneNumber = contactPerson1PhoneNumber;
    }

    public String getContactPerson2Name() {
        return contactPerson2Name;
    }

    public void setContactPerson2Name(String contactPerson2Name) {
        this.contactPerson2Name = contactPerson2Name;
    }

    public String getContactPerson2PhoneNumber() {
        return contactPerson2PhoneNumber;
    }

    public void setContactPerson2PhoneNumber(String contactPerson2PhoneNumber) {
        this.contactPerson2PhoneNumber = contactPerson2PhoneNumber;
    }

}
