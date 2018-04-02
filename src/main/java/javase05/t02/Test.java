package javase05.t02;

public class Test {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager("prop");
        System.out.println(resourceManager.getValue("key1"));

        resourceManager.loadExtendedPropertyFile("src/main/resources/prop.properties");
        System.out.println(resourceManager.getValueFromExtendedPropertyFile("key1"));
    }
}
