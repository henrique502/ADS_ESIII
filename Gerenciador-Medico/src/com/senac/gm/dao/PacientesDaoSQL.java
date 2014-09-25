package com.senac.gm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senac.gm.Application;
import com.senac.gm.jdbc.JDBC;
import com.senac.gm.models.Paciente;

public class PacientesDaoSQL implements PacientesDao {
	
	private JDBC db = Application.data.jdbc;
	
	@Override
	public Paciente getPacienteById(int id) throws SQLException {
		Paciente resultado = null;
		Connection con = db.getInstance();

		String sql = "SELECT id, nome FROM pacientes WHERE id = ? LIMIT 1";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			resultado = new Paciente(
				rs.getInt("id"),
				rs.getString("nome")
			);
			
			break;
		}
		
		stmt.close();
		rs.close();
		
		return resultado;
	}

}
