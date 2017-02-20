package com.anthony.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class Config {
    private Properties properties;
    private String propertiesPath="/config.properties";
    private static Config config=null;

    public Config getInstance(){
        if(null==config)
            config=new Config();
        return config;
    }

    private Config()
    {
        if(!loadProperties())
            properties=null;
    }

    private boolean loadProperties()
    {
        properties=new Properties();
        boolean flag=true;
        InputStream in;
        try {
            in=getClass().getResourceAsStream(propertiesPath);
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }

    public String getProperties(String key){
        if(null!=properties)
            return properties.getProperty(key);
        else
            return null;
    }

}
