package ru.sbt.mipt.oop;

public class AlarmSystem {

    private AlarmState state;
    private int code;
    private AlarmSystemState type = AlarmSystemState.OFF;

    public AlarmSystem() {
        this.state = new DeactivateAlarmState(this);
        this.code = "default_password".hashCode();
    }

    public void changeState(AlarmState state) {

        this.state = state;

        if (state instanceof ActivateAlarmState) {
            this.type = AlarmSystemState.ON;
        }
        if (state instanceof DeactivateAlarmState) {
            this.type = AlarmSystemState.OFF;
        }
        else {
            this.type = AlarmSystemState.ALARM;
        }
    }

    public AlarmState getState() {
        return this.state;
    }

    public AlarmSystemState getType() {
        return this.type;
    }

    public void activate(String pass) {
        this.state.activate(pass);
    }

    public void deactivate(String pass) {
        this.state.deactivate(pass);
    }

    public void setAlarm() {
        this.state.setAlarm();
    }

    public void setCode(String newCode) {
        this.code = newCode.hashCode();
    }

    public int getCode() {
        return this.code;
    }

    public boolean isActivated() {
        return this.type == AlarmSystemState.ON;
    }
}
