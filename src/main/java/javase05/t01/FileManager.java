package javase05.t01;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;

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
            return file.getPath();
        } else {
            return file.getPath() + "/" + path;
        }
    }

    private void printCurrentDirectory() {
        System.out.println("Current directory is " + file.toString());
    }

    public void ls(String path) {
        try {
            if (path.equals(".")) {
                printCurrentDirectory();
                file = new File(file.getPath());
                for (File i : this.file.listFiles()) {
                    System.out.println(i.getName());
                }
            } else {
                printCurrentDirectory();
                file = setPath(path);
                for (File i : file.listFiles()) {
                    System.out.println(i.getName());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is no directory with that name.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void cd(String path) {
        try {
            if (path.equals("..")) {
                file = new File(file.getParent());
                printCurrentDirectory();
            } else {
                file = setPath(path);
                if (!file.isDirectory()) {
                    file = new File(file.getParent());
                    throw new NotDirectoryException(path);
                }
                printCurrentDirectory();
            }
        } catch (NullPointerException e) {
            System.out.println("This is the root directory. There is no directory above.");
        } catch (NotDirectoryException e) {
            System.out.println("There is no directory with name " + e.getMessage() + ".");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void rm(String path) {
        try {
            file = setPath(path);
            if (!file.delete())
                throw new FileNotFoundException();
            System.out.println("The file was deleted.");
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void createFile(String path, String text) {
        file = setPath(path);
        TextEditor.writeFile(file.toString(), text);
    }

    public void writeInFile(String path, String text) {
        file = setPath(path);
        TextEditor.addTextAndWriteFile(file.toString(), text);
    }

    public void cat(String path) {
        file = setPath(path);
        System.out.println(TextEditor.readFile(file.toString()));
    }
}
