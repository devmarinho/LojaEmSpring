package com.marinho.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemNotaFiscal {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long numero;
	private int quantidade;
	private double valor;
	@OneToOne(cascade = CascadeType.ALL)
	private Produto produto;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "notaid",referencedColumnName = "codigo")
	private NotaFiscalVenda notafiscal;
	public ItemNotaFiscal() {}
	public ItemNotaFiscal(int quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public NotaFiscalVenda getNotafiscal() {
		return notafiscal;
	}
	public void setNotafiscal(NotaFiscalVenda notafiscal) {
		this.notafiscal = notafiscal;
	}
	public void valoItemNF() {
		this.valor = this.produto.getValor()*this.getQuantidade();
		
	}
	public String toString() {
		String a = "O valor do seu produto é " + this.valor ;
		return a;
	}
}
