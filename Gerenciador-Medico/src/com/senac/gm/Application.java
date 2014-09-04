package com.senac.gm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.security.auth.x500.X500PrivateCredential;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.senac.gm.controllers.HomeController;
import com.senac.gm.jdbc.JDBC;
import com.senac.gm.jdbc.SQLiteJDBC;

public class Application extends WindowAdapter implements Runnable {
	
	private JDBC jdbc = null;
	private JFrame window = null;
	private Dimension size = new Dimension(800, 600); 
	
	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			jdbc = new SQLiteJDBC();
			window = new JFrame();
			window.addWindowListener(this);
			window.setPreferredSize(size);
			window.setMinimumSize(size);
			window.setLocationRelativeTo(null);
			window.setJMenuBar(new JMenuBar());
			window.setLayout(new BorderLayout());
			window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			window.setTitle("Carregando...");
			window.setVisible(true);

			new HomeController(window, jdbc);
		} catch(Exception e){
			closeAll();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro Fatal", "Erro Fatal", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		closeAll();
		super.windowClosing(e);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
	
	private void closeAll(){
		if(jdbc != null)
			jdbc.close();
		
		if(window != null)
			window.dispose();
	}
}