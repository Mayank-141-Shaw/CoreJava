package com.servletcarapp.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCProperties {

	static Connection con;
	
	public static String driverClass = null;
	public static String url = null;
	public static String username = null;
	public static String password = null;
	
	final static String PROJECT_PATH = "D:\\Eclipse Projects\\Workspaces\\CoreJavaServlet\\";
	
	public static void loadProperties() {
		
		try {
			FileInputStream fis = new FileInputStream(PROJECT_PATH + "res\\database.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			driverClass = prop.getProperty("MysqlJdbc.driver");
			url = prop.getProperty("MysqlJdbc.url");
			username = prop.getProperty("MysqlJdbc.user");
			password = prop.getProperty("MysqlJdbc.pass");
			prop.clear();
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			loadProperties();
			Class.forName(driverClass);
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
