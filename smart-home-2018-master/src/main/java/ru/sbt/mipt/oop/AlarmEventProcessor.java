package ru.sbt.mipt.oop;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if(this.isAlarmEvent(sensorEvent)) {
            AlarmSensorEvent event = (AlarmSensorEvent) sensorEvent;
            if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
                ActivateAlarmState activate = new ActivateAlarmState(smartHome.getAlarmSystem());
                if (event.getCode().hashCode() == smartHome.getAlarmSystem().getCode()) {
                    activate.activate();
                }
            }
            else {
                DeactivateAlarmState deactivate = new DeactivateAlarmState(smartHome.getAlarmSystem());
                if (event.getCode().hashCode() == smartHome.getAlarmSystem().getCode()) {
                    deactivate.deactivate();
                }
            }
            SetAlarmState alarmState = new SetAlarmState(smartHome.getAlarmSystem());
            if (event.getCode().hashCode() != smartHome.getAlarmSystem().getCode()) {
                alarmState.setAlarm();
            }
        }
    }

    private boolean isAlarmEvent(SensorEvent sensorEvent) {
        return sensorEvent instanceof AlarmSensorEvent;
    }
}
