package com.pl.spring;

import org.apache.log4j.Logger;

public class ConsoleEventLogger implements EventLogger {

    public static final Logger LOGGER = Logger.getLogger(ConsoleEventLogger.class);

    public void logEvent(Event msg) {
        LOGGER.info(msg);
    }
}
