package com.recode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLogin", nullable = false)
	private Login login;

	@OneToMany(mappedBy = "cliente")
	private List<Compra> compra;
	

	public List<Compra> getCompra() {
		return compra;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}

	public Cliente(Login login, List<Compra> compra) {
		this.login = login;
		this.compra = compra;
	}

	public Cliente() {
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
}
