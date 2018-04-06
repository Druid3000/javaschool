package javase07.t02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ResourceManager extends Thread {
    private Properties properties = new Properties();
    private String pathToFile;
    private String key;

    public ResourceManager(String threadName, String pathToFile, String key) {
        super(threadName);
        this.pathToFile = pathToFile;
        this.key = key;
        this.start();
    }

    private synchronized void loadPropertyFile(String pathToFile) {
        try (FileReader fileReader = new FileReader(pathToFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    private String getValue(String key) {
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

    @Override
    public void run() {
        this.loadPropertyFile(pathToFile);
        System.out.println(this.getName() + ": " + this.getValue(key));
    }
}
