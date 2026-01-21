package config;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/main/java/properties/config.properties"
            );
            properties.load(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        String url = properties.getProperty("base.url");
        if (url == null) {
            throw new RuntimeException("base.url not found in config.properties");
        }
        return url;
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }
}
