package javase07.t02;

public class Test {
    public static void main(String[] args) {

        String pathToFile = "src/main/java/javase07/t02/prop.properties";

        ResourceManager resourceManager1
                = new ResourceManager("Thread 1", pathToFile, "key1");

        ResourceManager resourceManager2
                = new ResourceManager("Thread 2", pathToFile, "key2");
        try {
            resourceManager1.join();
            resourceManager2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
