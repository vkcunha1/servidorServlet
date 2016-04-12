package com.projetovini.model;

import java.util.Date;

public class Cliente {
	
	private int idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String rgCliente;
	private Date dataNascimentoCli;
	private String telCli;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public Date getDataNascimentoCli() {
		return dataNascimentoCli;
	}
	public void setDataNascimentoCli(Date dataNascimentoCli) {
		this.dataNascimentoCli = dataNascimentoCli;
	}
	public String getTelCli() {
		return telCli;
	}
	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}
	
}
