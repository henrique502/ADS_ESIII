package com.senac.gm.controllers;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import com.senac.gm.Application;
import com.senac.gm.dao.AgendaDao;
import com.senac.gm.dao.AgendaDaoSQL;
import com.senac.gm.models.Consulta;
import com.senac.gm.utils.DataUtil;
import com.senac.gm.views.AgendaView;
import com.toedter.calendar.JDayChooser;


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
		
		
		JDayChooser calendario = new JDayChooser();
		
		//calendario.addMouseListener(null);
		
		
		// setSelectableDateRange
		
		leftPanel.add(calendario, BorderLayout.NORTH);
		
		
		
		
		
		
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, agenda);
		Application.data.window.add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(200);
		splitPane.setEnabled(false);

	}

	private String[][] getAgendaData() {
		AgendaDao agendaDao = new AgendaDaoSQL();
		String[][] data = null;
		
		try {
			ArrayList<Consulta> consultas = agendaDao.getConsultas();
			data = new String[consultas.size()][3];
			
			for(int i = 0; i < consultas.size(); i++){
				Consulta consulta = consultas.get(i);
				
				data[i][0] = consulta.getPaciente().getNome();
				data[i][1] = consulta.getMedico().getNome();
				data[i][2] = DataUtil.timeView.format(consulta.getData());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

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
