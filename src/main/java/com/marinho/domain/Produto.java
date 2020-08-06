package com.marinho.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class Produto  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String descricao;
	private double valor;
	public Produto() {}
	public Produto(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
