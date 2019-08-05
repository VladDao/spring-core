package com.pl.spring.logger;

import com.pl.spring.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() >= cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
