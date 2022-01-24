package com.admmprayergroup.assistant.modules.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ArchdiocesanGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupNameEnglish;
    private String groupNameTamil;
    private String groupHeadName;
    private String groupHeadPhoneNumber;
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

    public String getGroupNameEnglish() {
        return groupNameEnglish;
    }

    public void setGroupNameEnglish(String groupNameEnglish) {
        this.groupNameEnglish = groupNameEnglish;
    }

    public String getGroupNameTamil() {
        return groupNameTamil;
    }

    public void setGroupNameTamil(String groupNameTamil) {
        this.groupNameTamil = groupNameTamil;
    }

    public String getGroupHeadName() {
        return groupHeadName;
    }

    public void setGroupHeadName(String groupHeadName) {
        this.groupHeadName = groupHeadName;
    }

    public String getGroupHeadPhoneNumber() {
        return groupHeadPhoneNumber;
    }

    public void setGroupHeadPhoneNumber(String groupHeadPhoneNumber) {
        this.groupHeadPhoneNumber = groupHeadPhoneNumber;
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
