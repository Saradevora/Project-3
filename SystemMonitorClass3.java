public class SystemMonitor {

    private final List<DataSource> sources = new ArrayList<>();
    private final List<CrisisEvent> events = new ArrayList<>();

    public void addDataSource(DataSource ds) {
        sources.add(ds);
        System.out.println("Added data source: " + ds);
    }

    public void ingest(String description, String severity, int sourceId) {
        DataSource ds = sources.stream()
                .filter(s -> s.getId() == sourceId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Source ID not found"));

        CrisisEvent event = new CrisisEvent(description, severity, ds);
        events.add(event);

        System.out.println("Crisis event generated:\n" + event);
    }

    public List<DataSource> getSources() { return new ArrayList<>(sources); }
    public List<CrisisEvent> getEvents() { return new ArrayList<>(events); }
}
