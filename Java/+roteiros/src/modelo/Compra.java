package modelo;



public class Compra {
	private double valor;
	private int idCompra;
	private int quantidade;
	private String dataCompra;
	private Cliente cliente;
	private Pacotes pacotes;
	
	public Compra( int quantidade, String dataCompra, Cliente cliente, Pacotes pacotes) {
	
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
		this.cliente = cliente;
		this.pacotes = pacotes;
		calculaTotal(pacotes.getPreco());
	}
	public Compra() {
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
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
	
	private void calculaTotal(double preco) {
		this.valor = quantidade * preco;
	}

	
}
