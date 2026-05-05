package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties prop;

    private ConfigManager(){
        try{
            prop=new Properties();
            FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance(){
        if(instance==null){
            instance=new ConfigManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}
