package ru.sbt.mipt.oop;

public class AlarmSensorEvent extends SensorEvent{
    public String code;

    public AlarmSensorEvent(SensorEventType type, String code) {
        super(type, "alarm");
        this.code = code;
    }

    public SensorEventType getType() {
        return super.getType();
    }

    public String getCode() {
        return this.code;
    }
}
