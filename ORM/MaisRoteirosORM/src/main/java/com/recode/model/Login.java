package com.recode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Login extends Entidade {

	@Column(nullable = false)
	private String tipoLogin;

	@OneToMany(mappedBy = "login")
	private List<Cliente> cliente;

	@OneToMany(mappedBy = "login")
	private List<Funcionario> funcionario;

	public Login(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public Login() {
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

}
