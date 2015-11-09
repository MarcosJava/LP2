package br.com.mrcsfelipe.sbv.model;

import java.util.Date;

public class Produto {

	private Long id;
	private String nome;
	private String modelo;
	private String marca;
	private Date dataFabricacao;
	private Double valor;
	private Integer quantidadeEstoque;
	
	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", " 
				+ ", modelo=" + modelo + ", dataFabricacao=" + dataFabricacao
				+ ", valor=" + valor + ", quantidadeEstoque="
				+ quantidadeEstoque + "]";
	}
	
}
