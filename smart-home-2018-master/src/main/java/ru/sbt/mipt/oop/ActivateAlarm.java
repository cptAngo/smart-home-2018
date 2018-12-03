package ru.sbt.mipt.oop;

public class ActivateAlarm implements RemoteCommands {
    private SmartHome smartHome;

    public ActivateAlarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        this.smartHome.getAlarmSystem().setAlarm();
    }
}
