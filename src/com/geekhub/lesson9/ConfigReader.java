package com.geekhub.lesson9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private String host;
    private String login;
    private String password;

    public ConfigReader() {
        getConfig();
    }

    private void getConfig() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream("src/com/geekhub/lesson9/resources/config.properties");
            properties.load(fileInputStream);

            host = properties.getProperty("db.host");
            login = properties.getProperty("db.login");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public String getHost() {
        return host;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
