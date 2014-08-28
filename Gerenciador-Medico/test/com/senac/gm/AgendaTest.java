package com.senac.gm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

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
}