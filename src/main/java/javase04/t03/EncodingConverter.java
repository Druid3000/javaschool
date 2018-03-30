package javase04.t03;

import java.io.*;

public class EncodingConverter {

    private StringBuilder textOfReadFile = new StringBuilder();

    public void readFile(String fileName) {
        int b;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader; //TODO нужен ли здесь null?
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

    public void writeFile(String filename) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream(filename);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.append(textOfReadFile.toString());
            bufferedWriter.flush();

        } catch (IOException e) {
            System.err.println("ошибка записи: " + e);
        } finally {

            //TODO Нужно ли поместить сюда InputStreamReader и BufferedWriter?

            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока: " + e);
            }
        }
    }
}
