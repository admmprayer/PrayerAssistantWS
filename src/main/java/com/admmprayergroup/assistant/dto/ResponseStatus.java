package com.admmprayergroup.assistant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import java.io.Serializable;

public class ResponseStatus implements Serializable {
    private Status status;

    private Status getStatus() {
        return status != null ? status : new Status();
    }

    protected void successful() {
        this.getStatus().setMessage(MessageStatus.Success);
    }

    protected void failed(@NotNull String messageDesc) {
        this.getStatus().setMessage(MessageStatus.Failure);
        this.getStatus().setDescription(messageDesc);
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Status implements Serializable {
    private MessageStatus message;
    private String description;

    public MessageStatus getMessage() {
        return message;
    }

    public void setMessage(MessageStatus message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

enum MessageStatus {
    Success, Failure
}
