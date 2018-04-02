package javase05.t02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceManager {
    private ResourceBundle resourceBundle;
    private Properties properties = new Properties();

    public ResourceManager(String path) {
        try {
            resourceBundle = ResourceBundle.getBundle(path);
        } catch (MissingResourceException e) {
            System.out.println("File does not exist");
        }
    }

    public String getValue(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (NullPointerException e) {
            System.out.println("File does not exist");
        } catch (MissingResourceException e) {
            System.out.println("Key does not exist");
        }
        return null;
    }

    public void loadExtendedPropertyFile(String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    public String getValueFromExtendedPropertyFile(String key) {
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
