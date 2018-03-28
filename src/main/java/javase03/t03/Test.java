package javase03.t03;

public class Test {
    public static void main(String[] args) {
        TextParser textParser = new TextParser();
        textParser.loadFile("src/main/java/javase03/t03/article.html", "Cp1251");

        if(textParser.isOrderConsistent()){
            System.out.println("Порядок нарушен");
        } else {
            System.out.println("Порядок не нарушен");
        }
        textParser.printSentencesWithLinksToPictures();
    }
}