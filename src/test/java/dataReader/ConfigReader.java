package dataReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    private String defPath = "C:\\Users\\John\\";
    private String defUrl = "";
    private String propPath = "src\\test\\resources\\config.properties";
    private Properties prop;

    public ConfigReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propPath));
            prop = new Properties();
            prop.load(reader);
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception in config reader " + e.getMessage());
        }
    }

    public String GetWebDriverPath() {
        String path = prop.getProperty("webdriverpath");
        if (path != null)
            return path;
        return defPath;
    }

    public String getHomePage() {
        String url = prop.getProperty("homepage");
        if (url != null)
            return url;
        return defUrl;
    }
}
