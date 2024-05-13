package singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        System.out.println("Database URL: " + configManager.getDatabaseUrl());
        System.out.println("Username: " + configManager.getUsername());
        System.out.println("Password: " + configManager.getPassword());
    }
}
