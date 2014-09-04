package com.senac.gm.controllers;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.senac.gm.jdbc.JDBC;

public class HomeController implements Controller {
	
	private JFrame window;
	private JDBC jdbc;
	
	public HomeController(JFrame window, JDBC jdbc) {
		this.window = window;
		this.jdbc = jdbc;
		setup();
	}

	private void setup() {
		window.setTitle("Gerenciador Médico");
		
		JMenuBar menu = window.getJMenuBar();
		
		/* Programa */
		JMenu programa = new JMenu("Programa");
		programa.setMnemonic('G');
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
		
		programa.add(sair);
		menu.add(programa);
		
		/* Agenda */
		JMenu agenda = new JMenu("Agenda");
		agenda.setMnemonic('A');
		
		JMenuItem agendaHoje = new JMenuItem("Hoje");
		agendaHoje.setMnemonic('H');
		agenda.add(agendaHoje);
		
		JMenuItem agendaBuscar = new JMenuItem("Procurar");
		agendaBuscar.setMnemonic('P');
		agenda.add(agendaBuscar);
		
		menu.add(agenda);
		
		/* Pacientes */
		JMenu pacientes = new JMenu("Pacientes");
		pacientes.setMnemonic('P');
		
		JMenuItem pacientesCadastrar = new JMenuItem("Cadastrar");
		pacientesCadastrar.setMnemonic('C');
		
		
		pacientes.add(pacientesCadastrar);
		menu.add(pacientes);
		
		/* Ajuda */
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('A');
		
		menu.add(Box.createHorizontalGlue());
		menu.add(ajuda);
		
		
		/* Image */
		
		JPanel panel = new LogoPanel();
		window.add(panel, BorderLayout.CENTER);
	}
}

class LogoPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image cache = null;
	
	public LogoPanel(){
		URL imgURL = getClass().getResource("/assets/img/logo.png");
	    if (imgURL != null) {
	    	cache =  new ImageIcon(imgURL).getImage();
	    }
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if(cache != null){
		    Graphics2D g2d = (Graphics2D) g;
		    int x = (this.getWidth() - cache.getWidth(null)) / 2;
		    int y = (this.getHeight() - cache.getHeight(null)) / 2;
		    g2d.drawImage(cache, x, y, null);
	    }
	}
}
