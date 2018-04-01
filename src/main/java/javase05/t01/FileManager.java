package javase05.t01;

import java.io.File;

public class FileManager {
    private File file;

    public FileManager() {
        file = new File(System.getProperty("user.dir"));
    }

    private File setPath(String path) {
        return new File(pathHandler(path));
    }

    private String pathHandler(String path) {
        if (path.startsWith("/")) {
            return path;
        } else if (file.isFile()) {
            return file.getPath()/* + "/"*/;
        } else {
            return file.getPath() + "/" + path;
        }
    }

    private void printCurrentDirectory() {
        System.out.println("Current directory is " + file.toString());
    }


}
