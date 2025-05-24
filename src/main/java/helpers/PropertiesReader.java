package helpers;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    @SneakyThrows
    public static String getProperty(String key) {
        Properties properties = new Properties();
        InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("env.properties");
        properties.load(input);
        return properties.getProperty(key);
    }
}
