package ru.sbt.mipt.oop;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if(this.isAlarmEvent(sensorEvent)) {
            AlarmSensorEvent event = (AlarmSensorEvent) sensorEvent;
            if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
                smartHome.getAlarmSystem().changeState(new ActivateAlarmState(smartHome.getAlarmSystem()));
                smartHome.getAlarmSystem().activate(event.getCode());
            }
            else {
                smartHome.getAlarmSystem().changeState(new DeactivateAlarmState(smartHome.getAlarmSystem()));
                smartHome.getAlarmSystem().deactivate(event.getCode());
            }
            if (event.getCode().hashCode() != smartHome.getAlarmSystem().getCode()) {
                smartHome.getAlarmSystem().changeState(new SetAlarmState(smartHome.getAlarmSystem()));
                smartHome.getAlarmSystem().setAlarm();
            }
        }
    }

    private boolean isAlarmEvent(SensorEvent sensorEvent) {
        return sensorEvent instanceof AlarmSensorEvent;
    }
}
