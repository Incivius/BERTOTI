package singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String databaseUrl;
    private String username;
    private String password;

    private ConfigurationManager() {
        this.loadConfigurations();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    private void loadConfigurations() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        this.username = "admin";
        this.password = "admin123";
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
