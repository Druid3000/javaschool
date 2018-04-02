package javase06.t02;

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

    public void loadExtendedPropertyFile(String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }
}
