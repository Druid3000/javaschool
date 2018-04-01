package javase05.t01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {

    public static String readFile(String fileName) {
        int b;
        FileReader fileReader = null;
        StringBuilder textOfReadFile = null;
        try {
            fileReader = new FileReader(fileName);
            textOfReadFile = new StringBuilder();
            while ((b = fileReader.read()) != -1) {
                textOfReadFile.append((char) b);
            }
        } catch (IOException e) {
            System.err.println("Ошибка файла.");
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия.");
            }
        }
        return textOfReadFile.toString();
    }

    public static void writeFile(String filename, String text) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            fileWriter.write(text);
        } catch (IOException e) {
            System.err.println("Ошибка записи.");
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока.");
            }
        }
    }

    public static void addTextAndWriteFile(String filename, String addedText) {
        writeFile(filename, readFile(filename) + addedText);
    }
}
