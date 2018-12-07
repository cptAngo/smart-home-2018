package ru.sbt.mipt.oop;

public class AlarmSystem {

    private AlarmSystemState state;
    private final String pass;

    public AlarmSystem() {
        this.state = AlarmSystemState.OFF;
        this.pass = "default_password";
    }

    public void changeState(AlarmSystemState state) {
        this.state = state;
    }

    public AlarmSystemState getState() {
        return this.state;
    }
}
