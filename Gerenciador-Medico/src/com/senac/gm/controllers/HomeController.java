package com.senac.gm.controllers;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import com.senac.gm.Application;
import com.senac.gm.views.AgendaView;
import com.toedter.calendar.JCalendar;


public class HomeController implements Controller {
	
	public HomeController() {
		setup();
	}

	private void setup() {
		Application.data.window.setTitle("Gerenciador Médico");
		
		setupMenu();
		
	
		
		

		
		
		AgendaView agenda = new AgendaView();
		agenda.setData(getAgendaData());
		
		JPanel leftPanel = new JPanel(new BorderLayout(5,5));
		
		
		JCalendar calendario = new JCalendar();
		leftPanel.add(calendario, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, agenda);
		Application.data.window.add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(200);
		splitPane.setEnabled(false);

	}

	private String[][] getAgendaData() {
		String[][] data = {
				{"Henrique 1", "Teste", "9:15", "Editar"},
				{"Henrique 2", "Teste", "9:30", "Editar"},
				{"Henrique 3", "Teste", "9:45", "Editar"},
				{"Henrique 4", "Teste", "10:00", "Editar"},
				{"Henrique 5", "Teste", "13:30", "Editar"},
				{"Henrique 6", "Teste", "13:50", "Editar"}
		   };
		return data;
	}

	private void setupMenu() {
		JMenuBar menu = Application.data.window.getJMenuBar();
		
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
		
		/* Ajuda */
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('A');
		
		menu.add(Box.createHorizontalGlue());
		menu.add(ajuda);
	}
}
