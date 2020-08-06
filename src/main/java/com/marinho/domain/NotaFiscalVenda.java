package com.marinho.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class NotaFiscalVenda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String data;
	private float valorNota;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="notafiscal")
	private List<ItemNotaFiscal> items = new ArrayList<ItemNotaFiscal>();
	@ManyToOne
	@JoinColumn(name = "clientecod",referencedColumnName = "codigo")
	private Cliente cliente;	
	public NotaFiscalVenda() {}
	public NotaFiscalVenda(String data, Cliente cliente) {
		super();
		this.data = data;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getValorNota() {
		return valorNota;
	}
	public void setValorNota(float valorNota) {
		this.valorNota = valorNota;
	}
	
	public List<ItemNotaFiscal> getItems() {
		return items;
	}
	public void setItems(List<ItemNotaFiscal> items) {
		this.items = items;
	}
	public void criarItemNotaFiscal (ItemNotaFiscal item) {
        this.items.add(item);
        item.setNotafiscal(this);
    }
	public void removerItemNotaFiscal (ItemNotaFiscal item) {
        this.items.remove(item);
        item.setNotafiscal(null);
    }
	
	public void calcularValorNota () {
      this.valorNota=0;
        for (ItemNotaFiscal itnf : this.items)  {
            this.valorNota += (itnf.getValor());
        }
        this.setValorNota(valorNota);
	
	}
	public String tString() {
		String lista = "";
		for(ItemNotaFiscal intf: this.items) { 
			lista += String.format("Código: %d\nProduto: %s \nValor: %.2f \nQuantidade: %d\n\n",intf.getNumero(),intf.getProduto().getDescricao(),intf.getValor(),intf.getQuantidade()); 
		}
		return lista;
		
		

	}	
}

