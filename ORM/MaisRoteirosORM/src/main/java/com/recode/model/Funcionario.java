package com.recode.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Pessoa {

	@ManyToOne
	@JoinColumn(name = "idLogin", nullable = false)
	private Login login;

	public Funcionario() {
	}

	public Funcionario(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
