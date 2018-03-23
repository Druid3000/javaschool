package javase03.t01;

public class Test {
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("message1");
        logger.addMessage("message2");
        logger.addMessage("message2");
        logger.addMessage("message4");

        System.out.println(logger.search("message2"));
    }
}
