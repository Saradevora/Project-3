package es.ulpgc.hpi.p3.alerts;

public class Sensor {

    private static int ID_COUNTER = 0;
    private final int id;
    private final String name;
    private final String type; // seismic, weather, fire, ocean, etc.

    public Sensor(String name, String type) {
        this.id = ++ID_COUNTER;
        this.name = name;
        this.type = type;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + type + ")";
    }
}
