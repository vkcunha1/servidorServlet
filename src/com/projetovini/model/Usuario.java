package com.projetovini.model;


public class Usuario {
	
	private int idUsuario;
	private String emailUsu;
	private String senhaUsu;
	private String telefoneUsu;
	private String nomeUsu;
	private static final int _ID_NOVO_OBJETO= 0;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmailUsu() {
		return emailUsu;
	}
	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}
	public String getSenhaUsu() {
		return senhaUsu;
	}
	public void setSenhaUsu(String senhaUsu) {
		this.senhaUsu = senhaUsu;
	}
	public static boolean notNovoObjeto(Usuario obj) {
		return obj != null && obj.getIdUsuario() != _ID_NOVO_OBJETO;
	}
	public String getTelefoneUsu() {
		return telefoneUsu;
	}
	public void setTelefoneUsu(String telefoneUsu) {
		this.telefoneUsu = telefoneUsu;
	}
	public String getNomeUsu() {
		return nomeUsu;
	}
	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	
}
