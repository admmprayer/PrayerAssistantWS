package com.admmprayergroup.assistant.config;

import com.admmprayergroup.assistant.dto.ExceptionResponse;
import com.admmprayergroup.assistant.prayerslots.exception.InsufficientParametersException;
import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InsufficientParametersException.class)
    public ResponseEntity<ExceptionResponse> handleInsufficientRequestParameters(InsufficientParametersException e) {
        return ResponseEntity.badRequest().body(ExceptionResponse.create(e.getMessage()));
    }

    @ExceptionHandler(NotFoundInDatabaseException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundInDb(NotFoundInDatabaseException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionResponse.create(e.getMessage()));
    }

}
