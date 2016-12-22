package com.geekhub.lesson9;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            run(new ConfigReader(), new org.h2.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void run(ConfigReader config, Driver driver) throws SQLException {
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(
                config.getHost(),
                config.getLogin(),
                config.getPassword()
        );

        DBManager dbManager = new DBManager(connection);
        dbManager.bootstrap();
        dbManager.selectedAllAndPrint();

        connection.close();
    }
}
