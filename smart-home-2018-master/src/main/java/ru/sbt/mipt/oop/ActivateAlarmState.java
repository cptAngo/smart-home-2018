package ru.sbt.mipt.oop;


public class ActivateAlarmState implements AlarmState {

    private final AlarmSystem alarmSystem;

    public ActivateAlarmState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void activate(String pass) {
        if (pass.hashCode() != this.alarmSystem.getCode()) {
            this.setAlarm();
        }
    }

    @Override
    public void deactivate(String  pass) {
        if (pass.hashCode() == this.alarmSystem.getCode()) {
            this.alarmSystem.changeState(new DeactivateAlarmState(this.alarmSystem));
        }
        else {
            this.setAlarm();
        }

    }

    @Override
    public void setAlarm() {
        this.alarmSystem.changeState(new SetAlarmState( this.alarmSystem));

    }
}
