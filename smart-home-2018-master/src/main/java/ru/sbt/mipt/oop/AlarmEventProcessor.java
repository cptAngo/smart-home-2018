package ru.sbt.mipt.oop;

import java.lang.reflect.Field;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if(this.isAlarmEvent(sensorEvent)) {
            AlarmSensorEvent event = (AlarmSensorEvent) sensorEvent;
            try {
                Field field = smartHome.getAlarmSystem().getClass().getDeclaredField("pass");
                field.setAccessible(true);
                if (event.getCode().equals(field.get(smartHome.getAlarmSystem()))) {
                    if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
                        ActivateAlarmState activate = new ActivateAlarmState(smartHome.getAlarmSystem());
                        activate.activate();
                    }
                    else if(sensorEvent.getType() == SensorEventType.ALARM_DEACTIVATE) {
                        DeactivateAlarmState deactivate = new DeactivateAlarmState(smartHome.getAlarmSystem());
                        deactivate.deactivate();
                    }
                }
                else {
                    SetAlarmState setAlarmState = new SetAlarmState(smartHome.getAlarmSystem());
                    setAlarmState.setAlarm();
                    System.out.println("Sending sms");
                    }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isAlarmEvent(SensorEvent sensorEvent) {
        return sensorEvent instanceof AlarmSensorEvent;
    }
}
