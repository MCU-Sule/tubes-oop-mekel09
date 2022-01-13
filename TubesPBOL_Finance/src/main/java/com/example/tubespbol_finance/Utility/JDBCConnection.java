package com.example.tubespbol_finance.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class JDBCConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbFinance",
                    "root",
                    "edwardm05"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
