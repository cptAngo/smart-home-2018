package ru.sbt.mipt.oop;

public interface AlarmState {

    void activate(String pass);

    void deactivate(String pass);

    void setAlarm();

}
