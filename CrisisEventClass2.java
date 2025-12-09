public class CrisisEvent {

    private static int ID = 0;
    private final int id;
    private final String description;
    private final String severity;      // green, yellow, orange, red
    private final LocalDateTime timestamp;
    private final DataSource source;

    public CrisisEvent(String description, String severity, DataSource source) {
        this.id = ++ID;                 // unique ID
        this.description = description; // short text
        this.severity = severity.toLowerCase();
        this.timestamp = LocalDateTime.now(); // moment in which it was created
        this.source = source;           // source of the signal
    }

    // getters...

    @Override
    public String toString() {
        return "Event #" + id +
                " | Severity: " + severity.toUpperCase() +
                " | Source: " + source.getName() +
                " | Description: " + description +
                " | Time: " + timestamp;
    }
}
