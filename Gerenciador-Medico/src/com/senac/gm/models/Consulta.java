package com.senac.gm.models;

import java.util.Date;

public class Consulta {
	
	private int id;
	private Medico medico;
	private Paciente paciente;
	private Date data;
	private int status;
	private String observacao;
	
	
	
	public Consulta(int id, Medico medico, Paciente paciente, Date data,int status, String observacoes) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.status = status;
		this.observacao = observacoes;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacoes) {
		this.observacao = observacoes;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medico=" + medico + ", paciente="
				+ paciente + ", data=" + data + ", status="
				+ status + ", observacao=" + observacao + "]";
	}

}
