package ru.sbt.mipt.oop;

public class SetAlarmState implements AlarmState {
    private final AlarmSystem alarmSystem;

    public SetAlarmState(AlarmSystem alarmSystem){
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate(String pass) {

    }

    @Override
    public void deactivate(String pass) {
    }

    @Override
    public void setAlarm() {
        this.alarmSystem.changeState(this);
    }
}
