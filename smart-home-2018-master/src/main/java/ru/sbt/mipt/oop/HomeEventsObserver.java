package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HomeEventsObserver implements EventsManager {
    private final Collection<EventProcessor> eventProcessors = new ArrayList();
    private SensorEventProvider sensorEventProvider;

    public HomeEventsObserver(SensorEventProvider sensorEventProvider) {
        this.sensorEventProvider = sensorEventProvider;
    }

    public void registerEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public void runEventsCycle(SmartHome smartHome) {
        for (SensorEvent event = this.sensorEventProvider.getNextSensorEvent(); event != null; event = this.sensorEventProvider.getNextSensorEvent()) {
            System.out.println("Got event: " + event);
            Iterator var = this.eventProcessors.iterator();

            while (var.hasNext()) {
                EventProcessor eventProcessor = (EventProcessor) var.next();
                eventProcessor.processEvent(smartHome, event);
            }
        }
    }
}
