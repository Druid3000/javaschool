package javase10.t02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataBaseManager {

    public static final String DB_DRIVER = "db.driver";
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASSWORD = "db.password";
    private Properties properties = new Properties();

    public DataBaseManager() {
        loadPropertyFile("src/main/java/javase10/t02/dbconfig.properties");
    }

    public void loadPropertyFile(String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    public String getValue(String key) {
        try {
            if (properties.getProperty(key) == null)
                throw new IllegalArgumentException("Key does not exist");
            return properties.getProperty(key);
        } catch (NullPointerException e) {
            System.out.println("File does not exist");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

