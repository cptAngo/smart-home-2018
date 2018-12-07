package ru.sbt.mipt.oop;

public class ActivateAlarm implements RemoteCommands {
    private SmartHome smartHome;

    public ActivateAlarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        SetAlarmState setAlarmState = new SetAlarmState(smartHome.getAlarmSystem());
        setAlarmState.setAlarm();
    }
}
