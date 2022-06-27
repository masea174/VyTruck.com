package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
<<<<<<< HEAD
    private static Properties properties=new Properties();



=======

    private ConfigurationReader(){}

    private static Properties properties = new Properties();

// :D
>>>>>>> master
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (IOException e) {
<<<<<<< HEAD
            System.out.println("File not found in ConfigurationREader Class");
=======
>>>>>>> master
            e.printStackTrace();
        }
    }

<<<<<<< HEAD

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }



=======
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


>>>>>>> master
}
