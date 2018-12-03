package ru.sbt.mipt.oop;

public class TurnOffAllLights implements RemoteCommands {
    private SmartHome smartHome;

    public TurnOffAllLights(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        this.smartHome.turnOffLights();
    }
}
