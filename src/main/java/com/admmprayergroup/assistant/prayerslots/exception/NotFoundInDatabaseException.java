package com.admmprayergroup.assistant.prayerslots.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundInDatabaseException extends Exception {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotFoundInDatabaseException.class);

    public NotFoundInDatabaseException(Class<?> repositoryClass) {
        super(String.format("Requested data not found from %s", repositoryClass.toString()));
        logError();
    }

    private void logError() {
        LOGGER.error("Requested data in not found in database");
    }

}
