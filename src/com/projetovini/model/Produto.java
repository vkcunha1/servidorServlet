package com.projetovini.model;


public class Produto {
	private int codProd;
	private String nomeProd;
	private String tipoProd;
	private String tamanhoProd;
	private Fornecedor prodFornec;
	
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getTipoProd() {
		return tipoProd;
	}
	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}
	public String getTamanhoProd() {
		return tamanhoProd;
	}
	public void setTamanhoProd(String tamanhoProd) {
		this.tamanhoProd = tamanhoProd;
	}
	public Fornecedor getProdFornec() {
		return prodFornec;
	}
	public void setProdFornec(Fornecedor prodFornec) {
		this.prodFornec = prodFornec;
	}
}
