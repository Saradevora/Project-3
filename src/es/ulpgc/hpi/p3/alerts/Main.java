package es.ulpgc.hpi.p3.alerts;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Natural Disaster Early Warning System ===");

        String command;

        
        do {
            System.out.print("\nComando > ");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "add-sensor":
                    if (parts.length < 3) {
                        System.out.println("Uso: add-sensor <nombre> <tipo>");
                    } else {
                        monitor.addSensor(parts[1], parts[2]);
                        System.out.println("Sensor añadido.");
                    }
                    break;
                    
                case "add-alert":
                    if (parts.length < 4) {
                        System.out.println("Uso: add-alert <sensorId> <descripcion> <severidad>");

                    } else {
                        int sensorId = Integer.parseInt(parts[1]);
                        monitor.addAlert(sensorId, parts[2], parts[3]);
                        System.out.println("Alerta creada.");
                    }
                    break;

                case "show-sensors":
                    monitor.sensors().forEach(System.out::println);
                    break;

                case "show-alerts":
                    monitor.alerts().forEach(System.out::println);
                    break;

                case "exit":
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Comando no reconocido.");
            }
            

        } while (!command.equals("exit"));
        
    }
    
}
