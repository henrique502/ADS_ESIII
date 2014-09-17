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
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.senac.gm.Application;
import com.senac.gm.ui.ButtonColumn;

public class HomeController implements Controller {
	
	public HomeController() {
		setup();
	}

	private void setup() {
		Application.data.window.setTitle("Gerenciador Médico");
		
		setupMenu();
		
	
		
		
		
		JPanel container = new JPanel(new BorderLayout());
		
		String[][] data = getAgendaData();
		String[] columnNames = {"Paciente", "Médico", "Data", ""};
		JTable table = new JTable(data, columnNames);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(container.getSize());
		table.setFillsViewportHeight(true);
		
		container.add(table.getTableHeader(), BorderLayout.PAGE_START);
		container.add(scrollPane, BorderLayout.CENTER);
		
		Application.data.window.add(container, BorderLayout.CENTER);
		
		
		ButtonColumn buttonColumn = new ButtonColumn(table, null, 3);
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

	private class MyTableModel extends AbstractTableModel {

	    public boolean isCellEditable(int row, int column){  
	        return false;  
	    }

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
