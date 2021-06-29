package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :( ");
			e.printStackTrace();
		}

		
		String url = System.getenv("url1");
		String username = System.getenv("username1");
		String password = System.getenv("password1");
		
		
		
		
		return DriverManager.getConnection(url,username,password);

	}
		
}
		

