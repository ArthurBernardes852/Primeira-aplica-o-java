package com.metre.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3307/arthurTeste?user=metre&password=durama@357");
    }
}
