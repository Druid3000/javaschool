package javase03.t03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    StringBuilder text = new StringBuilder();

    public void loadFile(String pathToFile, String charset) {
        try {
            FileInputStream fstream = new FileInputStream(pathToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream, charset));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                text.append(strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }

    public boolean isOrderConsistent() {
        Pattern p = Pattern.compile("\\([Рр]ис\\. ([0-9]+)[^)[0-9]]*([0-9]*)[^)]*\\)");
        Matcher m = p.matcher(text);
        int numberOfPicture;
        int nextNumberOfPicture;
        int maxNumberOfPicture = 0;
        while (m.find()) {
            numberOfPicture = Integer.parseInt(m.group(1));
            if (m.group(2).equals("")) {
                nextNumberOfPicture = Integer.MAX_VALUE;
            } else {
                nextNumberOfPicture = Integer.parseInt(m.group(2));
            }
            if ( numberOfPicture > nextNumberOfPicture || numberOfPicture < maxNumberOfPicture) {
                return true;
            } else {
                maxNumberOfPicture = numberOfPicture;
            }
        }
        return false;
    }

    public void printSentencesWithLinksToPictures() {
        Pattern p = Pattern.compile("[А-ЯA-Z]([^.!?]*((ис(\\. \\d+)|унк)))+[^.!?]*[.!?]?");
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group(0) + "\n");
        }
    }
}
