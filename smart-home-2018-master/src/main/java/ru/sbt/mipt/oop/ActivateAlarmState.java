package ru.sbt.mipt.oop;


public class ActivateAlarmState implements AlarmState {

    private final AlarmSystem alarmSystem;

    public ActivateAlarmState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }
    @Override
    public void activate() {
        this.alarmSystem.changeState(AlarmSystemState.ON);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void setAlarm() {

    }
}
