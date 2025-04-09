package com.tpobjetperdu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //attributes
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/TPOP?useSSL=false";
    private static String user = "Emmanuella";
    private static String password = "monPapa@111";

    //
    public static Connection getConnection() {
        try{
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
