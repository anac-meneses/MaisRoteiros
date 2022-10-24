package com.recode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pacotes extends Entidade {

	@Column(nullable = false, length = 20)
	private String translado;

	@Column(nullable = false, length = 30)
	private String hotel;

	@Column(nullable = false, length = 3)
	private String qtNoites;

	@Column(nullable = false, length = 15)
	private Double preco;

	@ManyToOne
	@JoinColumn(name = "idDestino", nullable = false)
	private Destinos destinos;

	@OneToMany(mappedBy = "pacotes")
	private List<Compra> compra;

	public Pacotes(String translado, String hotel, String qtNoites, Double preco, Destinos destinos,
			List<Compra> compra) {

		this.translado = translado;
		this.hotel = hotel;
		this.qtNoites = qtNoites;
		this.preco = preco;
		this.destinos = destinos;

	}

	public Pacotes() {
	}

	public String getTranslado() {
		return translado;
	}

	public void setTranslado(String translado) {
		this.translado = translado;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getQtNoites() {
		return qtNoites;
	}

	public void setQtNoites(String qtNoites) {
		this.qtNoites = qtNoites;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	public List<Compra> getCompra() {
		return compra;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}
	
	

}
