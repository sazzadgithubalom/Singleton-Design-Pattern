package com.alomindia.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnction {
	private static Connection conn;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		
		FileReader fr = new FileReader("D:\\DatabaseConnction\\DatabaseConnection.properties");
		Properties pro = new Properties();
		pro.load(fr);
		
		String driverClass = pro.getProperty("driverClass");
		String url = pro.getProperty("url");
		String username = pro.getProperty("userName");
		String password = pro.getProperty("password");
		
		if(conn==null) {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Created and statblised the connection") ;
		}
		
		return conn;
	}
}
