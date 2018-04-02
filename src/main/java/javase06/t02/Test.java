package javase06.t02;

public class Test {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager();

        resourceManager.loadBundleFromResources("prop");
        resourceManager.loadExtendedPropertyFile("src/main/resources/prop.properties");

        resourceManager.printBundleMap();
    }
}
