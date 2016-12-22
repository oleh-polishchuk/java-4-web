package com.geekhub.lesson9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    Connection connection;

    public DBManager(Connection connection) throws SQLException {
        if (connection == null || connection.isClosed()) {
            System.err.println("Connection is closed or null");
            return;
        }

        this.connection = connection;

        createUser("admin");
    }

    public void createUser(String name) throws SQLException {
        System.out.println("=> Create " + name + " user ...");

        PreparedStatement statement = connection.prepareStatement(
                "CREATE USER IF NOT EXISTS " + name + " PASSWORD " + name + ";\n" +
                "ALTER USER " + name + " ADMIN TRUE;\n"
        );

        statement.execute();
    }

    /**
     * Create table User, Salary and insert example of data
     * @throws SQLException
     */
    public void bootstrap() throws SQLException {
        PreparedStatement statement;

        System.out.println("=> Create table User ...");
        statement = connection.prepareStatement(
                "DROP TABLE IF EXISTS USER;\n" +
                "CREATE TABLE USER(ID INT PRIMARY KEY, NAME VARCHAR(255));\n" +
                "INSERT INTO USER VALUES(1, 'John');\n" +
                "INSERT INTO USER VALUES(2, 'Joe');\n" +
                "INSERT INTO USER VALUES(3, 'Jack');\n"
        );
        statement.execute();

        System.out.println("=> Create table Salary ...");
        statement = connection.prepareStatement(
                "DROP TABLE IF EXISTS SALARY;\n" +
                "CREATE TABLE SALARY (ID INT PRIMARY KEY, FK_USER_ID INT, AMOUNT INT);\n" +
                "ALTER TABLE SALARY ADD FOREIGN KEY ( FK_USER_ID ) REFERENCES USER( ID );\n" +
                "INSERT INTO SALARY VALUES(0, 1, 100);\n" +
                "INSERT INTO SALARY VALUES(1, 1, 125);\n" +
                "INSERT INTO SALARY VALUES(2, 2, 700);\n" +
                "INSERT INTO SALARY VALUES(3, 2, 725);\n"
        );
        statement.execute();
    }

    /**
     * Select all records and print result
     * @throws SQLException
     */
    public void selectedAllAndPrint() throws SQLException {
        PreparedStatement statement;
        ResultSet resultSet;
        Integer sum = 0;

        System.out.println("=> Select all data ...");
        statement = connection.prepareStatement(
                "SELECT USER.name, SALARY.amount \n" +
                "FROM USER \n" +
                "INNER JOIN SALARY\n" +
                "ON USER.id=SALARY.fk_user_id;"
        );
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("NAME") + " " + resultSet.getInt("AMOUNT"));
            sum += resultSet.getInt("AMOUNT");
        }
        System.out.println("Total amount of salary in company: " + sum);
    }
}
