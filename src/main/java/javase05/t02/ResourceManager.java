package javase05.t02;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceManager {
    private ResourceBundle resourceBundle;

    public ResourceManager(String path){
        try {
            resourceBundle = ResourceBundle.getBundle(path);
        }catch (MissingResourceException e){
            System.out.println("File does not exist");
        }
    }

    public String getValue(String key){
        try{
            return resourceBundle.getString(key);
        } catch(NullPointerException e){
            System.out.println("File does not exist");
        } catch(MissingResourceException e){
            System.out.println("Key does not exist");
        }
        return null;
    }
}
