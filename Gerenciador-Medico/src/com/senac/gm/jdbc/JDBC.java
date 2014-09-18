package com.senac.gm.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface JDBC {
	
	public Connection getInstance();
	public void checkDatabase() throws IOException, SQLException;
	public Statement createStatement() throws SQLException;
	public void close();
	
}