package com.admmprayergroup.assistant.vo;

import com.admmprayergroup.assistant.dto.PrayerEntityType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

    @Autowired
    private ModelMapper modelMapper;

    // CREATED RESPONSE ENTITY
    public static final ResponseEntity<HttpStatus> ACCEPTED = new ResponseEntity<>(HttpStatus.ACCEPTED);

    public <T> T transferValues(Object sourceObject, Class<?> sourceClass, Class<T> destinationClass) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper.map(sourceClass.cast(sourceObject), destinationClass);
    }

    public String updateIDWithEntityType(String id, PrayerEntityType prayerEntityType) throws Exception {
        if (id.matches("[0-9]+")) {
            switch (prayerEntityType) {
                case PARISH:
                    return "P".concat(id);
                case VICARIATE:
                    return "V".concat(id);
                case GROUP:
                    return "G".concat(id);
                default:
                    throw new Exception("Invalid Entity type");
            }
        } else if (id.matches("(P | V | G)[0-9]+"))
            return id;
        else
            throw new Exception("Not a valid ID");
    }

    public String overwriteCelebrationIDValue(String providedCelebrationID, PrayerEntityType prayerEntityType) throws Exception {
        return prayerEntityType != null ?
                providedCelebrationID != null ?
                        this.updateIDWithEntityType(providedCelebrationID, prayerEntityType)
                        : null
                : null;
    }

}
