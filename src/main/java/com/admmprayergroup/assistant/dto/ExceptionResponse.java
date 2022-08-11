package com.admmprayergroup.assistant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionResponse {

    @JsonIgnore
    private static ExceptionResponse exceptionResponse;
    private String message;

    private ExceptionResponse(String message) {
        this.message = message;
    }

    public static ExceptionResponse create(String message) {
        if (exceptionResponse == null) {
            return new ExceptionResponse(message);
        }
        exceptionResponse.setMessage(message);
        return exceptionResponse;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
