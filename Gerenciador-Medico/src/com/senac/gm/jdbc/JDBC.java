package com.senac.gm.jdbc;

import java.sql.Connection;

public interface JDBC {
	
	public Connection getInstance();
	public void close();
	
}