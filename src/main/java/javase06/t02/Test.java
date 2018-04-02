package javase06.t02;

public class Test {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager("prop");
        resourceManager.loadExtendedPropertyFile("src/main/resources/prop.properties");
        resourceManager.printBundleMap();
    }
}
