package modelo;

public class Pacotes {
	private int idPacote;
	private String translado;
	private String hotel;
	private String qtNoites;
	private int preco;
	private Destino destino;
	private int idDestino;

	public Pacotes(int idPacotes, String translado, String hotel, String qtNoites, Destino destino, int preco) {
		this.idPacote = idPacotes;
		this.translado = translado;
		this.hotel = hotel;
		this.qtNoites = qtNoites;
		this.preco = preco;
		this.destino = destino;
	}

	public Pacotes() {
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public int idDestino() {
		return idDestino = destino.getIdDestino();
	}

}
