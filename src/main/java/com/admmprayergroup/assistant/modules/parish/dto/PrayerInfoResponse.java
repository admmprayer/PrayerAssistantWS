package com.admmprayergroup.assistant.modules.parish.dto;

import com.admmprayergroup.assistant.dto.PrayerResponse;
import com.admmprayergroup.assistant.dto.ResponseStatus;
import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;
import com.admmprayergroup.assistant.modules.vicariate.Vicariate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrayerInfoResponse extends ResponseStatus implements Serializable {

    private ArchdiocesanGroup groupInfo;
    private Parish parishInfo;
    private Vicariate vicariateInfo;
    @NotNull
    private List<PrayerResponse> prayerSlotsCompleted;
    @NotNull
    private List<PrayerResponse> prayerSlotsDue;

    public ArchdiocesanGroup getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(ArchdiocesanGroup groupInfo) {
        this.groupInfo = groupInfo;
    }

    public Parish getParishInfo() {
        return parishInfo;
    }

    public void setParishInfo(Parish parishInfo) {
        this.parishInfo = parishInfo;
    }

    public Vicariate getVicariateInfo() {
        return vicariateInfo;
    }

    public void setVicariateInfo(Vicariate vicariateInfo) {
        this.vicariateInfo = vicariateInfo;
    }

    public List<PrayerResponse> getPrayerSlotsCompleted() {
        return prayerSlotsCompleted;
    }

    public void setPrayerSlotsCompleted(List<PrayerResponse> prayerSlotsCompleted) {
        this.prayerSlotsCompleted = prayerSlotsCompleted;
    }

    public List<PrayerResponse> getPrayerSlotsDue() {
        return prayerSlotsDue;
    }

    public void setPrayerSlotsDue(List<PrayerResponse> prayerSlotsDue) {
        this.prayerSlotsDue = prayerSlotsDue;
    }
}
