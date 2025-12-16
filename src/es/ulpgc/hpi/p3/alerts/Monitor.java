package es.ulpgc.hpi.p3.alerts;

import java.util.ArrayList;
import java.util.List;

public class Monitor {

    private final List<Sensor> sensors = new ArrayList<>();
    private final List<Alert> alerts = new ArrayList<>();

    public void addSensor(String name, String type) {
        sensors.add(new Sensor(name, type));
    }

    public void addAlert(int sensorId, String description, String severity) {
        Sensor s = sensors.stream()
                .filter(sensor -> sensor.id() == sensorId)
                .findFirst()
                .orElse(null);

        if (s == null) {
            System.out.println("The sensor ID does not exist: " + sensorId);
            return;
        }

        alerts.add(new Alert(sensorId, description, severity));
    }

    public List<Sensor> sensors() {
        return sensors;
    }

    public List<Alert> alerts() {
        return alerts;
    }
}