package com.asos.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    Properties prop;

    public ReadProperties() throws IOException {
        prop = new Properties();
        String propFile = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile);

        if(inputStream != null){
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file "+propFile+" not found in the class path");
        }
    }

    public String getTestUrl(){
        return prop.getProperty("url");
    }

}
