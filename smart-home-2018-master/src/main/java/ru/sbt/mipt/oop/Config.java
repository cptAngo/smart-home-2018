package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Config {
    private SmartHome smartHome;
    private SensorEventProvider sensorEventProvider;
    private EventsManager eventsManager;
    private SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();

    public Config() throws IOException {
        smartHome = smartHomeLoader.loadSmartHome();
        sensorEventProvider = new RandomSensorEventProvider();
        eventsManager = new HomeEventsObserver(sensorEventProvider);
        //eventsManager = new EventsManagerAdapter(new SensorEventsManager());
    }


    @Bean
    SmartHome getSmartHome() {
        return smartHome;
    }

    @Bean
    EventsManager getEventsManager() {
        return eventsManager;
    }
}
