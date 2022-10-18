package com.recode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Compra extends Entidade {

	@Column
	private double valor;

	@Column(nullable = false, unique = true)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataCompra;

	@Column(nullable = false, length = 20)
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "IdCliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "IdPacote", nullable = false)
	private Pacotes pacotes;

	public Compra(LocalDate dataCompra, int quantidade, Cliente cliente, Pacotes pacotes) {

		this.dataCompra = dataCompra;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.pacotes = pacotes;
	}

	public Compra() {
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacotes getPacotes() {
		return pacotes;
	}

	public void setPacotes(Pacotes pacotes) {
		this.pacotes = pacotes;
	}

	public double valorTotal(Pacotes pacotes) {
		return this.valor = this.quantidade * pacotes.getPreco();

	}

}
