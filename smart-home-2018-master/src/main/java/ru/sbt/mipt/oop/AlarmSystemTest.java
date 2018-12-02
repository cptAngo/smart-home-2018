package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlarmSystemTest {

    @Test
    public void testNewSystemOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemState.OFF, alarmSystem.getState());
    }

    @Test
    public void testTurnSystemOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.activate("wrong code");
        assertEquals(AlarmSystemState.ON, alarmSystem.getState());

        alarmSystem.activate("default_password");
        assertEquals(AlarmSystemState.ON, alarmSystem.getState());
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