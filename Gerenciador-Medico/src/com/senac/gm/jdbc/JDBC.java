package com.senac.gm.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface JDBC {
	
	public Connection getInstance();
	public Statement createStatement() throws SQLException;
	public void close();
	
}