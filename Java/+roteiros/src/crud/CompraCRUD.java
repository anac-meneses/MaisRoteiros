package crud;


import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PacotesDAO;
import modelo.Cliente;
import modelo.Compra;
import modelo.Pacotes;

public class CompraCRUD {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		PacotesDAO pacoteDAO = new PacotesDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		Compra compra = new Compra();
		int quantidade = 0, idPacote = 0;
		String cpf = "", opcao = "", dcompra = "";
		
	
		do {
			System.out.println(" ==== CADASTRO COMPRA ====");
			System.out.println("Digite uma opção: ");
			System.out.println("[1] - Cadastrar uma Compra");
			System.out.println("[2] - Excluir Compra");
			System.out.println("[3] - Pesquisar Compra");
			System.out.println("[4] - Exibir todos as Compras");
			System.out.println("[5] - Atualizar Compra");
			System.out.println("[6] - Encerrar");
			System.out.println("--------------------------------");
			opcao = input.nextLine();

			switch (opcao) {
			case "1":
				System.out.println("==== Cadastro Compra ====");
	
				System.out.println("Digite a quantidade: ");
				quantidade = input.nextInt();
				System.out.println("Digite o CPF do cliente: ");
				cpf = input.next();
				System.out.println("Digite o ID do Pacote: ");
				idPacote = input.nextInt();
				System.out.println("Digite a data da compra: ");
				dcompra = input.next();
				Cliente cliente = clienteDAO.buscarID(cpf);
				Pacotes pacote = pacoteDAO.buscarID(idPacote);
				Compra c1  = new Compra(quantidade,dcompra, cliente, pacote);
				compraDAO.save(c1);
				break;

			case "2":
				System.out.println("Digite o ID da compra para excluir: ");
				compraDAO.removeById(input.nextInt());
				System.out.println("Compra removida com sucesso!");
				break;

			case "3":
				System.out.println("Digite o Id da Compra para pesquisa: ");
				int id = input.nextInt();
				Compra c = compraDAO.buscarID(id);

				System.out.println("ID Compra: " + c.getIdCompra());
				System.out.println("Valor: " + c.getValor());
				System.out.println("Quantidade: " + c.getQuantidade());
				System.out.println("CPF: " + c.getCliente().getCpf());
				System.out.println("ID Pacote" + c.getPacotes().getIdPacote());
				System.out.println("Data: " + c.getDataCompra());

				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Compra c2 : compraDAO.getCompra()) {
					System.out.println("ID Compra: " + c2.getIdCompra());
					System.out.println("Valor: " + c2.getValor());
					System.out.println("Quantidade: " + c2.getQuantidade());
					System.out.println("CPF: " + c2.getCliente().getCpf());
					System.out.println("ID Pacote" + c2.getPacotes().getIdPacote());
					System.out.println("Data: " + c2.getDataCompra());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite o ID da Compra: ");
				compra.setIdCompra(input.nextInt());
				System.out.println("Digite a quantidade: ");
				quantidade = input.nextInt();
				System.out.println("Digite o CPF do cliente: ");
				cpf = input.next();
				System.out.println("Digite o ID do Pacote: ");
				idPacote = input.nextInt();
				System.out.println("Digite a data da compra: ");
				dcompra = input.next();
				
				Cliente cliente1 = clienteDAO.buscarID(cpf);
				Pacotes pacote2 = pacoteDAO.buscarID(idPacote);
				Compra c3  = new Compra(quantidade,dcompra, cliente1, pacote2);
				compraDAO.update(c3);
				
				break;

			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}

}
