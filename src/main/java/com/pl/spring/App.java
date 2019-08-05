package com.pl.spring;

import com.pl.spring.entity.Event;
import com.pl.spring.logger.EventLogger;
import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Data
public class App {

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private Client client;
    private EventLogger eventLogger;

    public App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(
                client.getId(), client.getFullName());
        Event event = (Event) ctx.getBean("event");
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String... args) {
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
        ctx.close();
    }
}
