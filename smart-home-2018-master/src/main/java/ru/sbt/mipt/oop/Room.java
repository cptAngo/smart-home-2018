package ru.sbt.mipt.oop;

import java.util.*;

public class Room implements Actionable, Printable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        Iterator var2 = this.doors.iterator();

        while (var2.hasNext()) {
            Door door = (Door) var2.next();
            door.executeAction(action);
        }

        var2 = this.lights.iterator();

        while (var2.hasNext()) {
            Light light = (Light) var2.next();
            light.executeAction(action);
        }
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Room" + this.getName());
    }
}
