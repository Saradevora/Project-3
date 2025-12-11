package es.ulpgc.hpi.p3.alerts;

public class Alert {

    private static int ID_COUNTER = 0;
    private final int id;
    private final int sensorId;
    private final String description;
    private final String severity; // green, yellow, orange, red

    public Alert(int sensorId, String description, String severity) {
        this.id = ++ID_COUNTER;
        this.sensorId = sensorId;
        this.description = description;
        this.severity = severity;
    }

    public int id() {
        return id;
    }

    public int sensorId() {
        return sensorId;
    }

    public String description() {
        return description;
    }

    public String severity() {
        return severity;
    }

    @Override
    public String toString() {
        return id + ": [" + severity.toUpperCase() + "] " + description + " | sensor=" + sensorId;
    }
}
