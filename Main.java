package es.ulpgc.hpi.ews;

import java.util.Scanner;

/**
 * Main CLI interface for the Early-Warning System simulation.
 * 
 * Commands:
 *   add-source <name> <type>
 *   ingest <description> <severity> <sourceId>
 *   show-sources
 *   show-events
 *   exit
 */
public class Main {

    private static final SystemMonitor monitor = new SystemMonitor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Early-Warning System Simulator ===");

        String command = askCommand(scanner);

        while (!command.equals("exit")) {
            try {
                process(command);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            command = askCommand(scanner);
        }

        System.out.println("System shutting down.");
    }

    private static void process(String input) {
        String[] p = input.split(" ");

        switch (p[0]) {

            case "add-source":
                if (p.length < 3) {
                    System.out.println("Usage: add-source <name> <type>");
                    return;
                }
                monitor.addDataSource(new DataSource(p[1], p[2]));
                break;

            case "ingest":
                if (p.length < 4) {
                    System.out.println("Usage: ingest <description> <severity> <sourceId>");
                    return;
                }
                String description = p[1];
                String severity = p[2];
                int sourceId = Integer.parseInt(p[3]);
                monitor.ingest(description, severity, sourceId);
                break;

            case "show-sources":
                System.out.println("\n--- DATA SOURCES ---");
                for (DataSource s : monitor.getSources()) System.out.println(s);
                break;

            case "show-events":
                System.out.println("\n--- CRISIS EVENTS ---");
                for (CrisisEvent e : monitor.getEvents()) System.out.println(e);
                break;

            default:
                System.out.println("Unknown command.");
        }
    }

    private static String askCommand(Scanner scanner) {
        System.out.println("\nAvailable commands:\n" +
                "  add-source <name> <type>\n" +
                "  ingest <description> <severity> <sourceId>\n" +
                "  show-sources\n" +
                "  show-events\n" +
                "  exit\n");
        System.out.print("> ");
        return scanner.nextLine().trim();
    }
}
