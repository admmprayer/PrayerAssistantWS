package com.admmprayergroup.assistant.modules.vicariate.service;

import com.admmprayergroup.assistant.modules.vicariate.Vicariate;

import java.util.List;

public interface VicariateInfoService {

    List<Vicariate> getAllVicariateDetails();

    Vicariate getOneVicariate(Long vicariateID);

    void saveVicariateDetails(Vicariate vicariate);

    void updateVicariateDetails(Vicariate vicariate);

    void deleteVicariateDetails(Long vicariateID);

}
