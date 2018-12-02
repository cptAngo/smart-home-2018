package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeEventsObserverTest {

    @Test
    public void test() {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new HomeEventsObserverTest.OneTimeEventProvider(sensorEvent));
        HomeEventsObserverTest.CountingEventProcessor countingEventProcessor1 = new HomeEventsObserverTest.CountingEventProcessor();
        HomeEventsObserverTest.CountingEventProcessor countingEventProcessor2 = new HomeEventsObserverTest.CountingEventProcessor();
        homeEventsObserver.registerEventProcessor(countingEventProcessor1);
        homeEventsObserver.registerEventProcessor(countingEventProcessor2);
        homeEventsObserver.runEventsCycle(new SmartHome());
        Assertions.assertEquals(1, countingEventProcessor1.getCount());
        Assertions.assertEquals((Object)null, countingEventProcessor1.getReceivedEvent());
        Assertions.assertEquals(1, countingEventProcessor2.getCount());
        Assertions.assertEquals(sensorEvent, countingEventProcessor2.getReceivedEvent());
    }

    public static class CountingEventProcessor implements EventProcessor {
        private int count = 0;
        private SensorEvent receivedEvent;

        public CountingEventProcessor() {
        }

        public void processEvent(SmartHome smartHome, SensorEvent event) {
            this.receivedEvent = event;
            ++this.count;
        }

        public SensorEvent getReceivedEvent() {
            return this.receivedEvent;
        }

        public int getCount() {
            return this.count;
        }
    }

    public static class OneTimeEventProvider implements SensorEventProvider {
        private SensorEvent event;
        private int callsCount = 0;

        public OneTimeEventProvider(SensorEvent event) {
            this.event = event;
        }

        public SensorEvent getNextSensorEvent() {
            if (this.callsCount > 0) {
                return null;
            } else {
                ++this.callsCount;
                return this.event;
            }
        }
    }
}
