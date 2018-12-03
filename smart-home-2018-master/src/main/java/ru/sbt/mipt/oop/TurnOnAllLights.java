package ru.sbt.mipt.oop;

public class TurnOnAllLights implements RemoteCommands {
    private SmartHome smartHome;

    public TurnOnAllLights(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void execute() {
        this.smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(true);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_ON, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        });
    }
}
