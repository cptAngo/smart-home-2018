package ru.sbt.mipt.oop;

public class AlarmSystem {

    private AlarmSystemState state;
    private final String pass;

    public AlarmSystem() {
        this.state = AlarmSystemState.OFF;
        this.pass = "default_password";
    }

    public void activate(String code) {
        if (code.equals(this.pass)) {
            this.state = AlarmSystemState.ON;
        }
        else {
            System.out.println("Wrong password");
        }
    }

    public void deactivate(String code) {
        if (code.equals(this.pass)) {
            this.state = AlarmSystemState.OFF;
        }
        else {
            this.state = AlarmSystemState.ALARM;
        }
    }

    public void setAlarm() {
        this.state = AlarmSystemState.ALARM;
    }

    public AlarmSystemState getState() {
        return this.state;
    }
}
