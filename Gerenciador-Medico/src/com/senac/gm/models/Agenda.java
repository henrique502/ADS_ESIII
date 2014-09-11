package com.senac.gm.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.senac.gm.dao.AgendaDao;
import com.senac.gm.dao.AgendaDaoSQLite;

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

	public static List<Consulta> getConsultas() {
		AgendaDao dao = new AgendaDaoSQLite();
		
		Date data = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		data = cal.getTime();
		
		return null;
	}
}
