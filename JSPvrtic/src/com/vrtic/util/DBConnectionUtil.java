package com.vrtic.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	
	private static final String URL = "jdbc:mysql://bj0uq4f4gzhcotvkaqbi-mysql.services.clever-cloud.com:3306/bj0uq4f4gzhcotvkaqbi?autoReconnect=true&useSSL=false";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "uzxiajpbg4iuc7js";
	
	private static final String PASSWORD = "2heLXvy98p7E5XsDw89i";
	
	private static Connection connection = null;
	
	public static Connection openConnection() {
		if (connection != null)
            return connection;
        else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
	}
	
	
}
