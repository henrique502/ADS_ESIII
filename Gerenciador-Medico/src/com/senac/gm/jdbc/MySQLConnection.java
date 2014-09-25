package com.senac.gm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.senac.gm.Application;

public class MySQLConnection implements JDBC {
	
	private static Connection connection = null;
	
	public MySQLConnection(){}
	
	@Override
	public Connection getInstance(){
		if(connection == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String host = Application.data.config.getProperty("db_host");
				String database = Application.data.config.getProperty("db_name");
				String username = Application.data.config.getProperty("db_user");
				String password = Application.data.config.getProperty("db_pass");

				connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
			} catch (Exception e){
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}
		return connection;
	}
	
	@Override
	public void close(){
		if(connection == null) return;
		
		try {
			connection.close();
			connection = null;
		} catch (Exception e){}
	}
}
