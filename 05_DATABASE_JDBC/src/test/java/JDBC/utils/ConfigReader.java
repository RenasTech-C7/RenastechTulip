package JDBC.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;


    static {
        try (FileInputStream fileInputStream= new FileInputStream("Configuration.properties")){
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to find configuration.properties");
        }
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }

}
