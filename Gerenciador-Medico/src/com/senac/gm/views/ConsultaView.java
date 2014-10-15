package com.senac.gm.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.senac.gm.models.Consulta;
import com.toedter.calendar.JTextFieldDateEditor;

public class ConsultaView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// JComboBox
	private JTextField paciente;
	private JTextField medico;
	private JTextField status;
	private JTextFieldDateEditor data;
	private JTextPane obervacao;
	private JPanel panel;
	
	public ConsultaView(){
		setLayout(new BorderLayout(5, 5));
		panel = new JPanel();
		setBorder(new TitledBorder("Detalhes"));

		panel.setLayout(new GridLayout(2, 2, 5, 5));
		add(panel, BorderLayout.CENTER);
		
		JPanel coluna;
		JLabel label;
		
		/* Paciente */
		coluna = createColuna();
		label = createLabel("Paciente:");
		coluna.add(label, BorderLayout.WEST);
		
		paciente = new JTextField(20);
		coluna.add(paciente, BorderLayout.CENTER);
		
		/* Data */
		coluna = createColuna();
		
		label = createLabel("Data:");
		coluna.add(label, BorderLayout.WEST);
		
		data = new JTextFieldDateEditor();
		coluna.add(data, BorderLayout.CENTER);
		
		/* Medico */
		coluna = createColuna();
		label = createLabel("Médico:");
		coluna.add(label, BorderLayout.WEST);
		
		medico = new JTextField(20);
		coluna.add(medico, BorderLayout.CENTER);
		
		/* Status */
		coluna = createColuna();
		label = createLabel("Status:");
		coluna.add(label, BorderLayout.WEST);
		
		status = new JTextField(20);
		coluna.add(status, BorderLayout.CENTER);
		
		coluna = new JPanel(new BorderLayout(5, 5));
		coluna.add(createLabel("Obervação:"), BorderLayout.WEST);
		obervacao = new JTextPane();
		coluna.add(obervacao, BorderLayout.CENTER);
		add(coluna, BorderLayout.SOUTH);
		
		coluna = new JPanel(new GridLayout(1, 1, 5, 5));
		add(coluna, BorderLayout.EAST);
		
		JButton button = new JButton("Editar");
		button.setEnabled(false);
		
		coluna.add(button);
		
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text, SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(60, 20));
		return label;
	}

	private JPanel createColuna() {
		JPanel coluna = new JPanel(new BorderLayout(5, 5));
		panel.add(coluna);
		return coluna;
	}



	public void carregaInfo(Consulta consulta){
		setEnabled(true);
		
		paciente.setText(consulta.getPaciente().getNome());
		medico.setText(consulta.getMedico().getNome());
		data.setDate(consulta.getData());
		obervacao.setText(consulta.getObservacao());
		status.setText("" + consulta.getStatus());
	}
	
	public void clearInfo(){
		setEnabled(false);
		
		paciente.setText("");
		medico.setText("");
		//data.setDate();;
		obervacao.setText("");
		status.setText("");
	}
}
