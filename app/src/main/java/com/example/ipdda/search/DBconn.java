package com.example.ipdda.search;

import android.telecom.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
    private static final String DB_URL = "jdbc:oracle:thin:@hanul202_high?TNS_ADMIN=D:/Wallet_Hanul202";
    private static final String DB_USER = "BTEAM";
    private static final String DB_PASSWORD = "Rhkrrlawhdl12!";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}