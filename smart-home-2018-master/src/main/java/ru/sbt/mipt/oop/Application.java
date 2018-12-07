package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String... args) throws IOException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EventsManager eventsManager = context.getBean(EventsManager.class);
        eventsManager.runEventsCycle(context.getBean(SmartHome.class));
    }
}
