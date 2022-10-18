package com.recode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Destinos extends Entidade {

	@Column(nullable = false, length = 80)
	private String cidade;

	@Column(nullable = false, length = 80)
	private String pais;

	@OneToMany(mappedBy = "destinos")
	private List<Pacotes> pacotes;

	public Destinos(String cidade, String pais, List<Pacotes> pacotes) {
		this.cidade = cidade;
		this.pais = pais;
		this.pacotes = pacotes;
	}

	public Destinos() {
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Pacotes> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacotes> pacotes) {
		this.pacotes = pacotes;
	}

}
