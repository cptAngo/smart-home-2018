package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LightEventProcessorTest {

    @Test
    public void testTurnOffLight() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            lights.add(new Light(String.valueOf(i + 1), true));
        }

        ArrayList<Door> doors = new ArrayList();

        for(int i = 0; i < 5; ++i) {
            doors.add(new Door(true, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList();

        for(int i = 0; i < 8; ++i) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        Iterator var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            Iterator var7 = room.getLights().iterator();

            while(var7.hasNext()) {
                Light light = (Light)var7.next();
                assertTrue(light.isOn());
            }
        }

        var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            smartHome.addRoom(room);
        }

        String turnedOffLightId = "2";
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, turnedOffLightId);
        LightsEventProcessor processor = new LightsEventProcessor();
        processor.processEvent(smartHome, event);
        Iterator var18 = rooms.iterator();

        while(var18.hasNext()) {
            Room room = (Room)var18.next();
            Iterator var10 = room.getLights().iterator();

            while(var10.hasNext()) {
                Light light = (Light)var10.next();
                if (light.getId().equals(turnedOffLightId)) {
                    assertFalse(light.isOn());
                } else {
                    assertTrue(light.isOn());
                }
            }
        }

    }

    @Test
    public void testTurnOnLight() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList();

        for(int i = 0; i < 5; ++i) {
            doors.add(new Door(true, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList();

        for(int i = 0; i < 8; ++i) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        Iterator var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            Iterator var7 = room.getLights().iterator();

            while(var7.hasNext()) {
                Light light = (Light)var7.next();
                assertFalse(light.isOn());
            }
        }

        var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            smartHome.addRoom(room);
        }

        String turnedOnLightId = "2";
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, turnedOnLightId);
        LightsEventProcessor processor = new LightsEventProcessor();
        processor.processEvent(smartHome, event);
        Iterator var18 = rooms.iterator();

        while(var18.hasNext()) {
            Room room = (Room)var18.next();
            Iterator var10 = room.getLights().iterator();

            while(var10.hasNext()) {
                Light light = (Light)var10.next();
                if (light.getId().equals(turnedOnLightId)) {
                    assertTrue(light.isOn());
                } else {
                    assertFalse(light.isOn());
                }
            }
        }

    }

    @Test
    public void testTurnOnNotExistedLight() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList();

        for(int i = 0; i < 5; ++i) {
            doors.add(new Door(true, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList();

        for(int i = 0; i < 8; ++i) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        Iterator var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            Iterator var7 = room.getLights().iterator();

            while(var7.hasNext()) {
                Light light = (Light)var7.next();
                assertFalse(light.isOn());
            }
        }

        var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            smartHome.addRoom(room);
        }

        String turnedOnLightId = "0";
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, turnedOnLightId);
        LightsEventProcessor processor = new LightsEventProcessor();
        processor.processEvent(smartHome, event);
        Iterator var18 = rooms.iterator();

        while(var18.hasNext()) {
            Room room = (Room)var18.next();
            Iterator var10 = room.getLights().iterator();

            while(var10.hasNext()) {
                Light light = (Light)var10.next();
                assertFalse(light.isOn());
            }
        }

    }

    @Test
    public void testCloseDoor() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList();

        for(int i = 0; i < 5; ++i) {
            doors.add(new Door(true, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList();

        for(int i = 0; i < 8; ++i) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        Iterator var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            Iterator var7 = room.getLights().iterator();

            while(var7.hasNext()) {
                Light light = (Light)var7.next();
                assertFalse(light.isOn());
            }
        }

        var14 = rooms.iterator();

        while(var14.hasNext()) {
            Room room = (Room)var14.next();
            smartHome.addRoom(room);
        }

        String openedDoor = "3";
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, openedDoor);
        LightsEventProcessor processor = new LightsEventProcessor();
        processor.processEvent(smartHome, event);
        Iterator var18 = rooms.iterator();

        while(var18.hasNext()) {
            Room room = (Room)var18.next();
            Iterator var10 = room.getLights().iterator();

            while(var10.hasNext()) {
                Light light = (Light)var10.next();
                assertFalse(light.isOn());
            }
        }

    }
}
