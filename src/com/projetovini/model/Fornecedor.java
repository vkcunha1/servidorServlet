package com.projetovini.model;


public class Fornecedor {
	private int idFornec;
	private String nomeFornec;
	private String cnpjFornec;
	private String fornecUf;
	private String dsFornec;
	private String telFornec;
	
	public int getIdFornec() {
		return idFornec;
	}
	public void setIdFornec(int idFornec) {
		this.idFornec = idFornec;
	}
	public String getNomeFornec() {
		return nomeFornec;
	}
	public void setNomeFornec(String nomeFornec) {
		this.nomeFornec = nomeFornec;
	}
	public String getCnpjFornec() {
		return cnpjFornec;
	}
	public void setCnpjFornec(String cnpjFornec) {
		this.cnpjFornec = cnpjFornec;
	}
	public String getFornecUf() {
		return fornecUf;
	}
	public void setFornecUf(String fornecUf) {
		this.fornecUf = fornecUf;
	}
	public String getDsFornec() {
		return dsFornec;
	}
	public void setDsFornec(String dsFornec) {
		this.dsFornec = dsFornec;
	}
	public String getTelFornec() {
		return telFornec;
	}
	public void setTelFornec(String telFornec) {
		this.telFornec = telFornec;
	}
}
