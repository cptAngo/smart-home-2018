package ru.sbt.mipt.oop;


import java.util.*;

public class SmartHome {
    Collection<Room> rooms;
    private AlarmSystem alarmSystem;

    public SmartHome() {
        this.rooms = new ArrayList<>();
        this.alarmSystem = new AlarmSystem();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public AlarmSystem getAlarmSystem() {
        return this.alarmSystem;
    }

    public void executeAction(Action action) {
        action.execute(this);
        Iterator var2 = this.rooms.iterator();

        while(var2.hasNext()) {
            Room room = (Room) var2.next();
            room.executeAction(action);
        }
    }

    public void turnOffLights() {
        this.executeAction((object) -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        });
    }

    public void printToSystemOut() {
        System.out.println("Smart home consist of:");
        Iterator var1 = this.rooms.iterator();

        while(var1.hasNext()) {
            Room room = (Room) var1.next();
            room.printToSystemOut();
        }
    }
}
