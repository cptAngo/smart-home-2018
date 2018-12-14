package ru.sbt.mipt.oop;

public class AlarmSystem {

    private AlarmSystemState state;
    private int code;

    public AlarmSystem() {
        this.state = AlarmSystemState.OFF;
        this.code = "default_password".hashCode();
    }

    public void changeState(AlarmSystemState state) {
        this.state = state;
    }

    public AlarmSystemState getState() {
        return this.state;
    }

    public void setCode(String newCode) {
        this.code = newCode.hashCode();
    }

    public int getCode() {
        return this.code;
    }
}
