package com.senac.gm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.senac.gm.Application;

/**
 * @see http://www.tutorialspoint.com/sqlite/sqlite_java.htm
 */
public class SQLiteJDBC implements JDBC {
	
	private static Connection connection = null;
	private static List<Statement> statements = null;
	
	public SQLiteJDBC(){}
	
	@Override
	public Connection getInstance(){
		if(connection == null){
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection("jdbc:sqlite:" + Application.data.config.getProperty("db_name") +".db");
				statements = new ArrayList<Statement>();
			} catch (Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
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
			for(Statement s : statements)
				s.close();
				
		} catch (Exception e){}
	}

	@Override
	public Statement createStatement() throws SQLException {
		Statement statement = connection.createStatement();
		statements.add(statement);
		return statement;
	}
}
