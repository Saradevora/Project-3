/**
 * Represents an external data source that feeds information
 * into the Early-Warning System (e.g. hospitals, satellites, sensors).
 */

public class DataSource {

    private static int ID = 0;      // common counter 
    private final int id;           // unique ID
    private final String name;      // name
    private final String type;      // type (health, seismic, environmental, etc)

    public DataSource(String name, String type) {
        this.id = ++ID;             // every time one is created it´s added 
        this.name = name;
        this.type = type;
    }

    public int getId() { 
        return id; 
    }
    
    public String getName() { 
        return name; 
    }

    public String getType() { 
        return type; 
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + type + ")";
    }
}

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + type + ")";
    }
}
