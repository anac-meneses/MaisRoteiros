package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {
	private double valor;
	private int idCompra;
	private int quantidade;
	private LocalDate dataCompra;
	private Cliente cliente;
	private Pacotes pacotes;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Compra(int quantidade, String dataCompra, Cliente cliente, Pacotes pacotes) {

		this.quantidade = quantidade;
		this.dataCompra = LocalDate.parse(dataCompra, formatter);
		this.cliente = cliente;
		this.pacotes = pacotes;
		this.valor = pacotes.getPreco();

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
		return formatter.format(dataCompra);
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = LocalDate.parse(dataCompra, formatter);
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

}
