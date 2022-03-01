package com.catalina.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLib {

    public static String getValue(String key) {
        Properties prop = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("src/test/resources/common Data.properties");
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

}
