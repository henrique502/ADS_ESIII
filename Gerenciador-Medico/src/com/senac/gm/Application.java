package com.senac.gm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.senac.gm.controllers.HomeController;
import com.senac.gm.jdbc.JDBC;
import com.senac.gm.jdbc.SQLiteJDBC;

public class Application extends WindowAdapter implements Runnable {
	
	public static Data data = null;

	@Override
	public void run() {
		try {
			
			data = new Data();
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			data.jdbc = new SQLiteJDBC();
			data.window = new JFrame();
			data.window.addWindowListener(this);
			
			loadConfig();
			setWindowSize();
			
			data.window.setLocationRelativeTo(null);
			data.window.setJMenuBar(new JMenuBar());
			data.window.setLayout(new BorderLayout());
			data.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			data.window.setTitle("Carregando...");
			data.window.setVisible(true);

			new HomeController();
		} catch(Exception e){
			closeAll();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro Fatal", "Erro Fatal", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadConfig() throws IOException {
		data.config = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		data.config.load(input);
		if(input == null)
			System.err.println("config.properties nao encontrado");
		
		input.close();
	}
	
	private void setWindowSize() {
		int width = Integer.parseInt(data.config.getProperty("screen_width"));
		int height = Integer.parseInt(data.config.getProperty("screen_height"));
		
		data.window.setPreferredSize(new Dimension(width, height));
		data.window.setMinimumSize(new Dimension(width, height));
	}

	@Override
	public void windowClosing(WindowEvent e){
		closeAll();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
	
	private void closeAll(){
		if(data.jdbc != null)
			data.jdbc.close();
		
		if(data.window != null)
			data.window.dispose();
	}
	
	public class Data {
		public JDBC jdbc;
		public JFrame window;
		public Properties config;
	}
}