package com.senac.gm.controllers;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
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
import com.toedter.calendar.JCalendar;


public class HomeController implements Controller {
	
	private Date currentDate;
	private JCalendar calendario;
	private AgendaView agenda;
	
	public HomeController() {
		setup();
	}

	private void setup() {
		Application.data.window.setTitle("Gerenciador Médico");
		
		setupMenu();
		
		currentDate = new Date();
		
		agenda = new AgendaView();
		agenda.setData(getAgendaData(currentDate));
		
		JPanel leftPanel = new JPanel(new BorderLayout(5,5));
		
		JPanel calendarioPainel = new JPanel(new BorderLayout());
		calendario = new JCalendar(currentDate);
		//calendario.setSelectableDateRange();
		calendarioPainel.add(calendario, BorderLayout.CENTER);
		
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 5, 5));
		JButton button = new JButton("Atualizar");
		button.addActionListener(updateTableContent());
		buttonsPanel.add(button);
		
		button = new JButton("Hoje");
		button.addActionListener(setDataHoje());
		buttonsPanel.add(button);
		
		button = new JButton("Selecionar");
		button.addActionListener(setNewData());
		buttonsPanel.add(button);
		
		calendarioPainel.add(buttonsPanel, BorderLayout.SOUTH);
		leftPanel.add(calendarioPainel, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, agenda);
		Application.data.window.add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(250);
		splitPane.setEnabled(true);
	}
	
	private ActionListener setNewData(){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Date data = calendario.getDate();
				
				if(DataUtil.compareDate(currentDate, data) == false){
				
					currentDate = data;
					agenda.setData(getAgendaData(currentDate));
				}
			}
		};
	}
	
	private ActionListener updateTableContent(){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				agenda.setData(getAgendaData(currentDate));
			}
		};
	}
	
	private ActionListener setDataHoje(){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Date data = new Date();
				
				if(DataUtil.compareDate(currentDate, data) == false){
				
					currentDate = data;
					agenda.setData(getAgendaData(currentDate));
				}
			}
		};
	}
	
	private ArrayList<Consulta> getAgendaData(Date data) {
		AgendaDao agendaDao = new AgendaDaoSQL();

		try {
			return agendaDao.getConsultas(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
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
		
		menu.add(agenda);
		
		/* Ajuda */
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('A');
		
		menu.add(Box.createHorizontalGlue());
		menu.add(ajuda);
	}
}
