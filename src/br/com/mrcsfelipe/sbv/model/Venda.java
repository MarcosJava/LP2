package br.com.mrcsfelipe.sbv.model;

import java.util.Date;

public class Venda {
	
	private Long id;
	private Date dataVenda;
	private Cliente cliente;
	private Produto produto;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Venda [dataVenda=" + dataVenda + ", cliente=" + cliente
				+ ", produto=" + produto + "]";
	}
	
	

}
