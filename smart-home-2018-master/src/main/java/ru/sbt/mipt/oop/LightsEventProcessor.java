package ru.sbt.mipt.oop;

public class LightsEventProcessor implements EventProcessor {

    private boolean isLightEvent(SensorEvent sensorEvent) {
        return sensorEvent.getType() == SensorEventType.LIGHT_OFF || sensorEvent.getType() == SensorEventType.LIGHT_ON;
    }

    private void changeLightState(Light light, SensorEvent sensorEvent) {
        if (sensorEvent.getType() == SensorEventType.LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light" + light.getId());
        }
        else {
            light.setOn(false);
            System.out.println("Light" + light.getId());
        }
    }



    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if (this.isLightEvent(sensorEvent)) {
            smartHome.executeAction((object) -> {
                if (object instanceof Light) {
                    Light light = (Light) object;
                    if (light.getId().equals(sensorEvent.getObjectId())) {
                        this.changeLightState(light, sensorEvent);
                    }
                }
            });
        }

    }
}
