package com.marinho.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String nome;
	@Column(length = 14)
	private String cnpfcnpj;
	@Column(name = "TipoCliente")
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cliente")
	private List<NotaFiscalVenda> nota = new ArrayList<NotaFiscalVenda>();
	public Cliente() {}
	public Cliente(String nome, String cnpfcnpj, TipoCliente tipocliente) {
		super();
		this.nome = nome;
		this.cnpfcnpj = cnpfcnpj;
		this.tipoCliente = tipocliente;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpfcnpj() {
		return cnpfcnpj;
	}
	public void setCnpfcnpj(String cnpfcnpj) {
		this.cnpfcnpj = cnpfcnpj;
	}
	public TipoCliente getTipocliente() {
		return tipoCliente;
	}
	public void setTipocliente(TipoCliente tipocliente) {
		this.tipoCliente = tipocliente;
	}
}
	
	
