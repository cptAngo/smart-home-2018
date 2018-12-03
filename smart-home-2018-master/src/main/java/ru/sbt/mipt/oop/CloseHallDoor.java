package ru.sbt.mipt.oop;

public class CloseHallDoor implements RemoteCommands {
    private SmartHome smartHome;

    public CloseHallDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        HallDoorEventProcessor processor = new HallDoorEventProcessor();
        processor.processEvent(this.smartHome, new SensorEvent(SensorEventType.DOOR_CLOSED, "HallDoor"));
    }
}
