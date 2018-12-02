package ru.sbt.mipt.oop;

public class RandomSensorEventProvider implements SensorEventProvider {

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05D) {
            return null;
        } else {
            SensorEventType sensorEventType = SensorEventType.values()[(int)(4.0D * Math.random())];
            String objectId = "" + (int)(10.0D * Math.random());
            return new SensorEvent(sensorEventType, objectId);
        }
    }
}
