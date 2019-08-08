package com.pl.spring;

import com.pl.spring.entity.Event;
import com.pl.spring.enums.EventType;
import com.pl.spring.logger.EventLogger;
import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

@Data
public class App {

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggerMap;

    public App() {
    }

    public App(Client client, EventLogger eventLogger,
               Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggerMap = loggerMap;
    }

    public void logEvent(EventType type, String msg) {
        String message = msg.replaceAll(
                client.getId(), client.toString());
        Event event = (Event) ctx.getBean("event");
        event.setMsg(message);
        EventLogger logger = loggerMap.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String... args) {
        App app = (App) ctx.getBean("app");
        app.logEvent(EventType.INFO, "Some event for user 1");
        app.logEvent(EventType.ERROR, "Some event for user 2");
        ctx.close();
    }
}
