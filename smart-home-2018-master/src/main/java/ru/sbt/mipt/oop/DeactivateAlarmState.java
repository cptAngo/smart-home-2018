package ru.sbt.mipt.oop;

public class DeactivateAlarmState implements AlarmState {
    private final AlarmSystem alarmSystem;

    public DeactivateAlarmState(AlarmSystem alarmSystem){
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {
        this.alarmSystem.changeState(AlarmSystemState.OFF);
    }

    @Override
    public void setAlarm() {

    }
}
