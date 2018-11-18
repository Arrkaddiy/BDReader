package my.util.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {

    public static HashMap<String, String> readProperties() {

        HashMap<String, String> propertymap = new HashMap<>();
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(".\\src\\main\\resources\\config.properties");
            property.load(fis);

            for (Object key : property.keySet()) {
                String sKey = (String) key;
                String sValue = (String) property.get(key);
                propertymap.put(sKey, sValue);
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return propertymap;
    }
}
