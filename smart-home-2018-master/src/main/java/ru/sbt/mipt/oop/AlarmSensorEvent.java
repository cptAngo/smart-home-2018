package ru.sbt.mipt.oop;

public class AlarmSensorEvent extends SensorEvent{
    private String code;

    public AlarmSensorEvent(SensorEventType type, String code) {
        super(type, "alarm");
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
