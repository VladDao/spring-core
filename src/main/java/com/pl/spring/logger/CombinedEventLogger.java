package com.pl.spring.logger;

import com.pl.spring.entity.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event msg) {
        loggers.forEach(l -> l.logEvent(msg));
    }
}
