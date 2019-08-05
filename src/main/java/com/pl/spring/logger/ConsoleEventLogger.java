package com.pl.spring.logger;

import com.pl.spring.entity.Event;
import org.apache.log4j.Logger;

public class ConsoleEventLogger implements EventLogger {

    private static final Logger LOGGER = Logger.getLogger(ConsoleEventLogger.class);

    public void logEvent(Event msg) {
        LOGGER.info(msg);
    }
}
