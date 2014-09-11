package com.senac.gm.models;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.senac.gm.models.Agenda;
import com.senac.gm.models.Consulta;

public class AgendaTest {

	@Test
	public void test() {
		// entrada: (dataInicial, dataFinal)
		//			["2014-06-06", "2014-07-06"]
		
		List<Consulta> consultas = Agenda.getConsultas("2014-06-06", "2014-07-06");
		assertEquals(2, consultas.size());
	}
	
	@Test
	public void test2() {
		// entrada: (dataInicial, dataFinal)
		//			["2014-06-06", "2014-07-06"]
		
		List<Consulta> consultas = Agenda.getConsultas("2014-06-06", "2014-07-06");
		assertEquals(2, consultas.size());
	}
	
	@Test
	public void test3() {
		// entrada: 
		
		List<Consulta> consultas = Agenda.getConsultas();
		assertEquals(2, consultas.size());
	}
}
