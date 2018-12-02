package ru.sbt.mipt.oop;

import java.util.Iterator;

public class HallDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED) {
            Iterator var1 = smartHome.getRooms().iterator();

            while(var1.hasNext()) {
                Room room = (Room)var1.next();
                Iterator var2 = room.getDoors().iterator();

                while(var2.hasNext()) {
                    Door door = (Door)var2.next();
                    if (door.getId().equals(event.getObjectId()) && room.getName().equals("hall")) {
                        smartHome.turnOffLights();
                    }
                }
            }

        }
    }
}
