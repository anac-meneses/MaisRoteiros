package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import modelo.Cliente;

public class ClienteCRUD {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		String opcao = "";

		do {
			System.out.println("        ==== CADASTRO CLIENTE ====");
			System.out.println("Digite uma opção: ");
			System.out.println("[1] - Cadastrar um cliente");
			System.out.println("[2] - Excluir cliente");
			System.out.println("[3] - Pesquisar cliente");
			System.out.println("[4] - Exibir todos os clientes");
			System.out.println("[5] - Atualizar cliente");
			System.out.println("[6] - Encerrar");
			System.out.println("--------------------------------");
			opcao = input.nextLine();

			switch (opcao) {
			case "1":
				System.out.println("==== Cadastro Cliente ====");
				System.out.print("Digite o Nome: ");
				cliente.setNome(input.next());
				System.out.print("Digite o Telefone: ");
				cliente.setTelefone(input.next());
				System.out.print("Digite o Email: ");
				cliente.setEmail(input.next());
				System.out.print("Digite a Senha: ");
				cliente.setSenha(input.next());
				System.out.print("Digite o Cpf: ");
				cliente.setCpf(input.next());
				clienteDAO.save(cliente);
				break;

			case "2":
				System.out.println("Digite o CPF do cliente para excluir: ");
				clienteDAO.removeById(input.next());
				System.out.println("Cliente removido com sucesso!");
				break;

			case "3":
				System.out.println("Digite o CPF do cliente para pesquisa: ");
				String cpf = input.next();
				Cliente c = clienteDAO.buscarID(cpf);

				System.out.println("Nome: " + c.getNome());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("Email: " + c.getEmail());
				System.out.println("CPF: " + c.getCpf());

				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Cliente c1 : clienteDAO.getCliente()) {
					System.out.println("Nome: " + c1.getNome());
					System.out.println("Telefone: " + c1.getTelefone());
					System.out.println("Email: " + c1.getEmail());
					System.out.println("CPF: " + c1.getCpf());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite o CPF do cliente: ");
				cliente.setCpf(input.next());
				System.out.println("Digite o novo nome: ");
				cliente.setNome(input.next());
				System.out.println("Digite o novo telefone: ");
				cliente.setTelefone(input.next());
				System.out.println("Digite o novo email: ");
				cliente.setEmail(input.next());
				System.out.println("Digite a nova senha: ");
				cliente.setSenha(input.next());
				clienteDAO.update(cliente);
				break;

			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}
}
