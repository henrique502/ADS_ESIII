package com.senac.gm.controllers;

import javax.swing.JFrame;

import com.senac.gm.jdbc.JDBC;

public class HomeController implements Controller {
	
	private JFrame window;
	private JDBC jdbc;
	
	public HomeController(JFrame window, JDBC jdbc) {
		this.window = window;
		this.jdbc = jdbc;
		
		jdbc = null;
		jdbc.getInstance();
	}

}
