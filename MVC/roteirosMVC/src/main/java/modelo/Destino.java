package modelo;


public class Destino {

	private int idDestino;
	private String cidade;
	private String pais;

	public Destino(int idDestino, String cidade, String pais) {
		this.idDestino = idDestino;
		this.cidade = cidade;
		this.pais = pais;
	}

	public Destino() {
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
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

	
}
