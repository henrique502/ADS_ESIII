package com.senac.gm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.senac.gm.Application;
import com.senac.gm.jdbc.JDBC;
import com.senac.gm.models.Consulta;
import com.senac.gm.utils.DataUtil;

public class AgendaDaoSQL implements AgendaDao {
	
	private JDBC db = Application.data.jdbc;
	
	@Override
	public ArrayList<Consulta> getConsultas() throws SQLException {
		return getConsultas(Calendar.getInstance().getTime());
	}

	@Override
	public ArrayList<Consulta> getConsultas(Date date) throws SQLException {
		ArrayList<Consulta> resultados = new ArrayList<Consulta>();
		Connection con = db.getInstance();
		
		MedicosDao medicosDao = new MedicosDaoSQL();
		PacientesDao pacientesDao = new PacientesDaoSQL();
		
		String sql = "SELECT id, medico, paciente, data, status, observacao FROM consultas WHERE DATE(data) = ? ORDER BY data ASC";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDate(1, new java.sql.Date(date.getTime()));
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			try {
				resultados.add(new Consulta(
					rs.getInt("id"),
					medicosDao.getMedicoById(rs.getInt("medico")),
					pacientesDao.getPacienteById(rs.getInt("paciente")),
					DataUtil.dateTimeFormat.parse(rs.getString("data")),
					rs.getInt("status"),
					rs.getString("observacao")
				));
			} catch(ParseException e){
				e.printStackTrace();
			}
		}
		
		stmt.close();
		rs.close();
		
		return resultados;
	}
}
