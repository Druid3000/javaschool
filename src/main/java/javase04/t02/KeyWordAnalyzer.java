package javase04.t02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KeyWordAnalyzer {

    private Map<String, Integer> mapOfKeyWordsAndTheirCounts = new HashMap<>();

    private StringBuilder textOfReadFile = new StringBuilder();

    private String[] keyWords =
            {"abstract", "continue", "for", "new", "switch",
                    "assert", "default", "goto", "package", "synchronized",
                    "boolean", "do", "if", "private", "this",
                    "break", "double", "implements", "protected", "throw",
                    "byte", "else", "import", "public", "throws",
                    "case", "enum", "instanceof", "return", "transient",
                    "catch", "extends", "int", "short", "try",
                    "char", "final", "interface", "static", "void",
                    "class", "finally", "long", "strictfp", "volatile",
                    "const", "float", "native", "super", "while"};

    public void readFile(String fileName) {
        int b;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            while ((b = fileReader.read()) != -1) {
                textOfReadFile.append((char)b);
            }
        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия: " + e);
            }
        }
    }

    public void writeFile(String filename) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            String tmp;
            for (String x : mapOfKeyWordsAndTheirCounts.keySet()) {
                if (mapOfKeyWordsAndTheirCounts.get(x) != 0) {
                    tmp = x + " " + mapOfKeyWordsAndTheirCounts.get(x) + "\n";
                    fileWriter.write(tmp);
                }
            }
        } catch (IOException e) {
            System.err.println("ошибка записи: " + e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока: " + e);
            }
        }
    }

    private void addWordToMap(String word) {
        if (mapOfKeyWordsAndTheirCounts.containsKey(word)) {
            Integer count = mapOfKeyWordsAndTheirCounts.get(word);
            mapOfKeyWordsAndTheirCounts.put(word, ++count);
        } else {
            mapOfKeyWordsAndTheirCounts.put(word, 1);
        }
    }

    public void searchForMatchingKeyWords() {
        String[] splitTextOfReadFile = textOfReadFile.toString().split("[^a-zA-Z&&[^\"a-zA-Z]]");
        for (String i : splitTextOfReadFile) {
            for (String j : keyWords) {
                if (i.equals(j)) {
                    addWordToMap(i);
                }
            }
        }
    }
}
