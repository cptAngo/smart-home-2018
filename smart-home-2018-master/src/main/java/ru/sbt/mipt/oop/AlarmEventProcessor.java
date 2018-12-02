package ru.sbt.mipt.oop;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if(this.isAlarmEvent(sensorEvent)) {
            AlarmSensorEvent event = (AlarmSensorEvent) sensorEvent;
            if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
                smartHome.getAlarmSystem().activate(event.getCode());
            }
            else {
                smartHome.getAlarmSystem().deactivate(event.getCode());
            }
        }
        else {
            if (smartHome.getAlarmSystem().getState().equals(AlarmSystemState.ON)) {
                smartHome.getAlarmSystem().setAlarm();
                System.out.println("Sending sms");
            }
        }
    }

    private boolean isAlarmEvent(SensorEvent sensorEvent) {
        return sensorEvent instanceof AlarmSensorEvent;
    }
}
