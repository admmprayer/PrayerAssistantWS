package com.admmprayergroup.assistant.vo;

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

}
