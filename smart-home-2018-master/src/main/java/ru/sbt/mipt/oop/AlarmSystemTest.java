package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlarmSystemTest {

    @Test
    public void testNewSystemOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemState.OFF, alarmSystem.getType());
    }

    @Test
    public void testTurnSystemOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.activate("wrong code");
        assertEquals(AlarmSystemState.ON, alarmSystem.getType());

        alarmSystem.activate("default_password");
        assertEquals(true, alarmSystem.isActivated());
    }

    @Test
    public void test2() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.activate("default_password");
        AlarmEventProcessor processor = new AlarmEventProcessor();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        processor.processEvent(new SmartHome(), event);
    }
}
