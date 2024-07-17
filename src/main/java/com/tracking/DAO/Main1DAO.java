package com.tracking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1DAO {
	private static final String URL = "jdbc:mysql://localhost:3306/time_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "Dharshu@22";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
