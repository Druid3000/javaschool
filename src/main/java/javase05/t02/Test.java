package javase05.t02;

public class Test {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager("prop1");
        System.out.println(resourceManager.getValue("key1"));
    }
}
