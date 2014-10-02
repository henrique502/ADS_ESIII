package com.senac.gm.views;

import javax.swing.JPanel;

import com.senac.gm.models.Consulta;

public class ConsultaView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	
	public ConsultaView(){
		setVisible(true);
		
		
	}



	public void carregaInfo(Consulta consulta) {
		System.out.println(consulta);
		
		
		
	}
}
