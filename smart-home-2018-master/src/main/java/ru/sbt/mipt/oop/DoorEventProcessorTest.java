package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DoorEventProcessorTest {

    @Test
    public void testCloseDoor() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lights.add(new Light(String.valueOf(i + 1), true));
        }

        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            doors.add(new Door(true, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertTrue(door.isOpen());
            }
        }

        for (Room room : rooms) {
            smartHome.addRoom(room);
        }

        String closedDoorId = "2";

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, closedDoorId);
        DoorEventProcessor processor = new DoorEventProcessor();
        processor.processEvent(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(closedDoorId)) {
                    assertFalse(door.isOpen());
                } else {
                    assertTrue(door.isOpen());
                }
            }
        }
    }

    @Test
    public void testOpenDoor() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            doors.add(new Door(false, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }

        for (Room room : rooms) {
            smartHome.addRoom(room);
        }

        String openedDoorId = "2";

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, openedDoorId);
        DoorEventProcessor processor = new DoorEventProcessor();
        processor.processEvent(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(openedDoorId)) {
                    assertTrue(door.isOpen());
                } else {
                    assertFalse(door.isOpen());
                }
            }
        }
    }

    @Test
    public void testOpenNotExistedDoor() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            doors.add(new Door(false, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }

        for (Room room : rooms) {
            smartHome.addRoom(room);
        }

        String openedDoorId = "0";

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, openedDoorId);
        DoorEventProcessor processor = new DoorEventProcessor();
        processor.processEvent(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }
    }

    @Test
    public void testTurnOnLight() {
        SmartHome smartHome = new SmartHome();
        ArrayList<Light> lights = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lights.add(new Light(String.valueOf(i + 1), false));
        }

        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            doors.add(new Door(false, String.valueOf(i + 1)));
        }

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room(lights, doors, "Room #" + String.valueOf(i + 1)));
        }

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }

        for (Room room : rooms) {
            smartHome.addRoom(room);
        }

        String turnedOnLightId = "3";

        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, turnedOnLightId);
        DoorEventProcessor processor = new DoorEventProcessor();
        processor.processEvent(smartHome, event);

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }
    }
}