package com.senac.gm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.senac.gm.models.Consulta;

public interface AgendaDao {

	public ArrayList<Consulta> getConsultas() throws SQLException;
	public ArrayList<Consulta> getConsultas(Date date) throws SQLException;
	
}
