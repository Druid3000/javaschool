package javase06.t02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ResourceManager {
    private Map<String, String> bundleMap = new HashMap<>();

    public void loadBundleFromResources(String path) {
        ResourceBundle resourceBundle;
        try {
            resourceBundle = ResourceBundle.getBundle(path);
            Set<String> keySetOfResourceBundle  = resourceBundle.keySet();
            for (String key : keySetOfResourceBundle) {
                bundleMap.put(key, resourceBundle.getString(key));
            }
        } catch (MissingResourceException e) {
            System.out.println("File does not exist");
        }
    }

    public void loadExtendedPropertyFile(String file) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            properties.load(bufferedReader);
            for (String key : properties.stringPropertyNames()) {
                bundleMap.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    public void printBundleMap(){
        for (Map.Entry entry : bundleMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }
}