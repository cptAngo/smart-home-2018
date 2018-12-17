package ru.sbt.mipt.oop;

public class DeactivateAlarmState implements AlarmState {

    private final AlarmSystem alarmSystem;

    public DeactivateAlarmState(AlarmSystem alarmSystem){
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate(String pass) {
        if (pass.hashCode() == this.alarmSystem.getCode()) {
            this.alarmSystem.changeState(new ActivateAlarmState(this.alarmSystem));
        }
        else {
            this.alarmSystem.changeState(new SetAlarmState(this.alarmSystem));
        }
    }

    @Override
    public void deactivate(String pass) {
    }

    @Override
    public void setAlarm() {
        this.alarmSystem.changeState(new SetAlarmState(this.alarmSystem));
    }
}
