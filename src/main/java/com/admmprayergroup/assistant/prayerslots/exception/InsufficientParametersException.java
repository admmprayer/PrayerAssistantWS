package com.admmprayergroup.assistant.prayerslots.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsufficientParametersException extends Exception {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsufficientParametersException.class);

    public InsufficientParametersException() {
        logError();
    }

    private void logError() {
        LOGGER.error("Insufficient parameters provided to process further operations");
    }

}
