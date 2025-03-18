package utillities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;

    public static String getProp(String key) {
        return properties.getProperty(key);
    }

    static {
        String path = "src/test/resources/configurations.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException var2) {
            IOException e = var2;
            System.out.println("File not found " + path);
            e.printStackTrace();
        }
    }
}
