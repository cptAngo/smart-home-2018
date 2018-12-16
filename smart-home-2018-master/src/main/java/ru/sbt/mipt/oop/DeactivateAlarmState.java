package ru.sbt.mipt.oop;

public class DeactivateAlarmState implements AlarmState {

    private final AlarmSystem alarmSystem;

    public DeactivateAlarmState(AlarmSystem alarmSystem){
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate(String pass) {

    }

    @Override
    public void deactivate(String pass) {
        if (pass.hashCode() == this.alarmSystem.getCode()){
            this.alarmSystem.changeState(this);
        }
    }

    @Override
    public void setAlarm() {

    }
}
