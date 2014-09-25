package com.senac.gm.dao;

import java.sql.SQLException;

import com.senac.gm.models.Paciente;

public interface PacientesDao {
	
	public Paciente getPacienteById(int id) throws SQLException;
	
}
