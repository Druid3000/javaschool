package javase07.t02;

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

}
