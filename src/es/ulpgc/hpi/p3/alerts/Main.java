// Command-line interface for the Natural Disaster Early Warning System

package es.ulpgc.hpi.p3.alerts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Natural Disaster Early Warning System ===");

        String commandInput;

        do {
            System.out.print("\nCommand > ");
            commandInput = scanner.nextLine();
            String[] parts = commandInput.split(" ");

            switch (parts[0]) {
                case "add-sensor":
                    if (parts.length < 3) {
                        System.out.println("Uso: add-sensor <name> <type>");
                    } else {
                        monitor.addSensor(parts[1], parts[2]);
                        System.out.println("Added Sensor.");
                    }
                    break;

                case "add-alert":
                    if (parts.length < 4) {
                        System.out.println("Use: add-alert <sensorId> <description> <severity>");
                    } else {
                        int sensorId = Integer.parseInt(parts[1]);
                        monitor.addAlert(sensorId, parts[2], parts[3]);
                        System.out.println("Alert created.");
                    }
                    break;

                case "show-sensors":
                    monitor.sensors().forEach(System.out::println);
                    break;

                case "show-alerts":
                    monitor.alerts().forEach(System.out::println);
                    break;

                case "exit":
                    System.out.println("Closing system...");
                    break;

                default:
                    System.out.println("Command not recognised.");
            }

        } while (!commandInput.equals("exit"));

        scanner.close();
    }

    System.out.println("Alerta finalizada");
}
