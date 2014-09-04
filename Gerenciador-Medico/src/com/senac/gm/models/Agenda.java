package com.senac.gm.models;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	public static List<Consulta> getConsultas(String dataInicial, String dataFinal) {
		// TODO Consultar usuário logado
		Usuario usuario;
		// TODO Restringir a um mes o retorno das consultas
		List<Consulta> lista = new ArrayList<Consulta>();
		
		lista.add(new Consulta());
		lista.add(new Consulta());
		
		return lista;
	}
}
