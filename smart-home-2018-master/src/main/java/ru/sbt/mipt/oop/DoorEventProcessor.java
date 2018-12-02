package ru.sbt.mipt.oop;

public class DoorEventProcessor implements EventProcessor {

    private boolean isDoorEvent(SensorEvent sensorEvent) {
        return sensorEvent.getType() == SensorEventType.DOOR_CLOSED || sensorEvent.getType() == SensorEventType.DOOR_OPEN;
    }

    private void changeDoorState(Door door, boolean opened, String s) {
        door.setOpen(opened);
        System.out.println(" Door " + door.getId() + s);
    }

    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if (this.isDoorEvent(sensorEvent)) {
            smartHome.executeAction((object) -> {
                if(object instanceof Door) {
                    Door door = (Door) object;
                    if (door.getId().equals(sensorEvent.getObjectId())) {
                        if (sensorEvent.getType() == SensorEventType.DOOR_OPEN) {
                            this.changeDoorState(door, true, "was opened");
                        }
                        else {
                            this.changeDoorState(door, false, "was closed");
                        }
                    }
                }
            });
        }
    }
}
