package ru.sbt.mipt.oop;

public class SetAlarmState implements AlarmState {
    private final AlarmSystem alarmSystem;

    public SetAlarmState(AlarmSystem alarmSystem){
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {
    }

    @Override
    public void setAlarm() {
        this.alarmSystem.changeState(AlarmSystemState.ALARM);
    }
}
