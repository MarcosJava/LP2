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

	
	
	public Produto(String nome, String modelo, String marca,
			Date dataFabricacao, Double valor, Integer quantidadeEstoque) {
		super();
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.valor = valor;
		this.quantidadeEstoque = quantidadeEstoque;
	}



	public Produto(Long id, String nome, String modelo, String marca,
			Date dataFabricacao, Double valor, Integer quantidadeEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.valor = valor;
		this.quantidadeEstoque = quantidadeEstoque;
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
		return "Produto [id=" + id + ", nome=" + nome + ", modelo=" + modelo
				+ ", marca=" + marca + ", dataFabricacao=" + dataFabricacao
				+ ", valor=" + valor + ", quantidadeEstoque="
				+ quantidadeEstoque + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
}
