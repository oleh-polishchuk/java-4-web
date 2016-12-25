package com.geekhub.lesson10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config extends Properties {

    private static volatile Config instance = null;

    public static Properties getInstance() throws IOException {
        String filePath = "./src/com/geekhub/lesson10/resources/config.properties";

        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                    instance.load(new FileInputStream(filePath));
                }
            }
        }

        return instance;
    }
}
