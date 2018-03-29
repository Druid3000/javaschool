package javase04.t03;

public class Test {
    public static void main(String[] args) {
        EncodingConverter encodingConverter = new EncodingConverter();
        encodingConverter.readFile("src/javase04/t03/textUTF8.txt");
        encodingConverter.writeFile("src/javase04/t03/textUTF16.txt");
    }
}