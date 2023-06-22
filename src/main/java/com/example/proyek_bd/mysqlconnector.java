package com.example.proyek_bd;

import java.sql.Connection;
import java.sql.DriverManager;


public class mysqlconnector {
    public static Connection conn = null;
    public static String dbName,dbUser,dbPass;

    public static Connection connectDB(){
        dbName = "proyek_laundry_bd";
        dbUser = "root";
        dbPass = "";

        String url = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUser, dbPass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static String getDbName() {
        return dbName;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPass() {
        return dbPass;
    }
}
