package javase04.t03;

import java.io.*;

public class EncodingConverter {

    private StringBuilder textOfReadFile = new StringBuilder();

    public void readFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            int b = 0;
            while ((b = bufferedReader.read()) != -1) {
                textOfReadFile.append((char) b);
            }
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
    }

    public void writeFile(String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);) {
            bufferedWriter.append(textOfReadFile.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
    }
}
