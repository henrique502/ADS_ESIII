package com.senac.gm.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class AgendaView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private String[] columnNames = {"Paciente", "Médico", "Data"};
	private Object[][] data = null;
	
	public AgendaView() {
		super(new BorderLayout(5, 5));
		
		table = new JTable(new AgendaTableRender());
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(5,5));
		table.getTableHeader().setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setSelectionModel(new AgendaSelectionModel());
		
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		
		
		
	}
	
	public void setData(Object[][] data){
		this.data = data;
	}
	
	private class AgendaTableRender extends AbstractTableModel {

		private static final long serialVersionUID = 1L;

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			if(data == null) return 0;
			
			return data.length;
		}
		
		@Override
		public boolean isCellEditable(int row, int col){
			return false;
		}
		
		@Override
		public String getColumnName(int col) {
	        return columnNames[col];
	    }
		
		@Override
		public Object getValueAt(int row, int col) {
			if(data == null) return null;
			return data[row][col];
		}
	}
	
	private class AgendaSelectionModel extends DefaultListSelectionModel implements ListSelectionListener {
		
		private static final long serialVersionUID = 1L;
		private int lastRow = -1;
		
		public AgendaSelectionModel () {
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			addListSelectionListener(this);
		}

		@Override
		public void clearSelection(){}

		@Override
		public void removeSelectionInterval(int index0, int index1) {}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(lastRow == table.getSelectedRow())
				return;
			
			lastRow = table.getSelectedRow();
			
			if(lastRow < 0){
				System.out.println("a");
			} else {
				int modelRow = table.convertRowIndexToModel(lastRow);
				System.out.println(data[modelRow][0]);
			}
		}
	}
}
