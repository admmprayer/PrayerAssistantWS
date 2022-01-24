package com.admmprayergroup.assistant.modules.parish;

import com.admmprayergroup.assistant.modules.vicariate.Vicariate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Parish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parishRegistrationID;
    private String parishNameEnglish;
    private String parishLocationEnglish;
    private String parishNameTamil;
    private String parishLocationTamil;
    private String parishPriestName;
    private String parishPriestPhoneNumber;
    private String parishYouthPresidentName;
    private String parishYouthPresidentPhoneNumber;
    private String contactPerson1Name;
    private String contactPerson1PhoneNumber;
    private String contactPerson2Name;
    private String contactPerson2PhoneNumber;
    private String vicariateID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParishRegistrationID() {
        return parishRegistrationID;
    }

    public void setParishRegistrationID(String parishRegistrationID) {
        this.parishRegistrationID = parishRegistrationID;
    }

    public String getParishNameEnglish() {
        return parishNameEnglish;
    }

    public void setParishNameEnglish(String parishNameEnglish) {
        this.parishNameEnglish = parishNameEnglish;
    }

    public String getParishLocationEnglish() {
        return parishLocationEnglish;
    }

    public void setParishLocationEnglish(String parishLocationEnglish) {
        this.parishLocationEnglish = parishLocationEnglish;
    }

    public String getParishNameTamil() {
        return parishNameTamil;
    }

    public void setParishNameTamil(String parishNameTamil) {
        this.parishNameTamil = parishNameTamil;
    }

    public String getParishLocationTamil() {
        return parishLocationTamil;
    }

    public void setParishLocationTamil(String parishLocationTamil) {
        this.parishLocationTamil = parishLocationTamil;
    }

    public String getParishPriestName() {
        return parishPriestName;
    }

    public void setParishPriestName(String parishPriestName) {
        this.parishPriestName = parishPriestName;
    }

    public String getParishPriestPhoneNumber() {
        return parishPriestPhoneNumber;
    }

    public void setParishPriestPhoneNumber(String parishPriestPhoneNumber) {
        this.parishPriestPhoneNumber = parishPriestPhoneNumber;
    }

    public String getParishYouthPresidentName() {
        return parishYouthPresidentName;
    }

    public void setParishYouthPresidentName(String parishYouthPresidentName) {
        this.parishYouthPresidentName = parishYouthPresidentName;
    }

    public String getParishYouthPresidentPhoneNumber() {
        return parishYouthPresidentPhoneNumber;
    }

    public void setParishYouthPresidentPhoneNumber(String parishYouthPresidentPhoneNumber) {
        this.parishYouthPresidentPhoneNumber = parishYouthPresidentPhoneNumber;
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

    public String getVicariateID() {
        return vicariateID;
    }

    public void setVicariateID(String vicariateID) {
        this.vicariateID = vicariateID;
    }
}
