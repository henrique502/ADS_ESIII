package com.senac.gm.dao;

import java.sql.SQLException;

import com.senac.gm.models.Medico;

public interface MedicosDao {

	public Medico getMedicoById(int id) throws SQLException;
	
}
