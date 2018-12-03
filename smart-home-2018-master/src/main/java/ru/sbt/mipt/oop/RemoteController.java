package ru.sbt.mipt.oop;

import java.util.Map;

public class RemoteController implements RemoteControl {
    private Map<String, RemoteCommands> buttonCommands;

    public RemoteController(Map<String,RemoteCommands> userCommands) {
        this.buttonCommands = userCommands;
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        this.buttonCommands.get(buttonCode).execute();
    }
}
