package javase04.t03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncodingConverter {

    private StringBuilder textOfReadFile = new StringBuilder();

    public void readFile(String fileName) {
        int b;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((b = bufferedReader.read()) != -1) {
                textOfReadFile.append((char) b);
            }
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия: " + e);
            }
            //TODO Нужно ли поместить сюда InputStreamReader?
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
