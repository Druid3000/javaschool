package javase04.t01;

public class Test {
    public static void main(String[] args) {
        KeyWordAnalyzer keyWordAnalyzer = new KeyWordAnalyzer();
        keyWordAnalyzer.readFile("src/main/java/javase04/t01/KeyWordAnalyzer.java");
        keyWordAnalyzer.searchForMatchingKeyWords();
        keyWordAnalyzer.writeFile("src/main/java/javase04/t01/code.txt");
    }
}