package com.senac.gm.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.senac.gm.models.Consulta;
import com.senac.gm.utils.DataUtil;

public class AgendaView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private String[] columnNames = {"Paciente", "Médico", "Hora"};
	private Object[][] data = null;
	private ArrayList<Consulta> consultas;
	
	private ConsultaView formulario;
	
	public AgendaView() {
		super(new BorderLayout(5, 5));
		
		table = new JTable(new AgendaTableRender());
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(5,5));
		table.getTableHeader().setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setSelectionModel(new AgendaSelectionModel());
		
		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		formulario = new ConsultaView();

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tablePanel, formulario);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(530);
		splitPane.setEnabled(true);
	}
	
	public void setData(ArrayList<Consulta> dados){
		String[][] data = null;
		
		data = new String[dados.size()][3];
				
		for(int i = 0; i < dados.size(); i++){
			Consulta consulta = dados.get(i);
					
					
			data[i][0] = consulta.getPaciente().getNome();
			data[i][1] = consulta.getMedico().getNome();
			data[i][2] = DataUtil.timeView.format(consulta.getData());
		}

		this.consultas = dados;
		this.data = data;
		table.updateUI();
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
		public void clearSelection(){
			formulario.clearInfo();
		}

		@Override
		public void removeSelectionInterval(int index0, int index1) {}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(lastRow == table.getSelectedRow())
				return;
			
			lastRow = table.getSelectedRow();
			if(lastRow < 0){
				formulario.clearInfo();
			} else {
				int modelRow = table.convertRowIndexToModel(lastRow);
				formulario.carregaInfo(consultas.get(modelRow));
				
				updateUI();
			}
		}
	}
}
