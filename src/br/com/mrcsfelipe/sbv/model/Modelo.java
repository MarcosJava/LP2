package br.com.mrcsfelipe.sbv.model;

public class Modelo {
	
	private Long id;
	private String modelo;
	private String marca;
	
	public Modelo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", modelo=" + modelo + ", marca=" + marca
				+ "]";
	}

	
	
	

}
