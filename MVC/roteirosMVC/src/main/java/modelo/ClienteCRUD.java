package modelo;

import java.util.Scanner;

public class ClienteCRUD {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		LoginDAO loginDAO = new LoginDAO();
		String opcao, nome, telefone, email, senha, cpf = "";
		int login1 = 0;

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
				nome=input.next();
				System.out.print("Digite o Telefone: ");
				telefone=input.next();
				System.out.print("Digite o Email: ");
				email=input.next();
				System.out.print("Digite a Senha: ");
				senha=input.next();
				System.out.print("Digite o Cpf: ");
				cpf=input.next();
				System.out.println("Digite ID Login: ");
				login1 = input.nextInt();
				Login log = loginDAO.buscarID(login1);
				Cliente cli1 = new Cliente(cpf, telefone, nome, email, senha, log);
				clienteDAO.save(cli1);
				break;

			case "2":
				System.out.println("Digite o CPF do cliente para excluir: ");
				clienteDAO.removeById(input.next());
				System.out.println("Cliente removido com sucesso!");
				break;

			case "3":
				System.out.println("Digite o CPF do cliente para pesquisa: ");
				cpf = input.next();
				Cliente c = clienteDAO.buscarID(cpf);

				System.out.println("Nome: " + c.getNome());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("Email: " + c.getEmail());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("ID Login: " + c.getLogin().getIdLogin());

				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Cliente c1 : clienteDAO.getCliente()) {
					System.out.println("Nome: " + c1.getNome());
					System.out.println("Telefone: " + c1.getTelefone());
					System.out.println("Email: " + c1.getEmail());
					System.out.println("CPF: " + c1.getCpf());
					System.out.println("ID Login: " + c1.getLogin().getIdLogin());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite o CPF do cliente: ");
				cliente.setCpf(input.next());
				System.out.print("Digite o Nome: ");
				nome=input.next();
				System.out.print("Digite o Telefone: ");
				telefone=input.next();
				System.out.print("Digite o Email: ");
				email=input.next();
				System.out.print("Digite a Senha: ");
				senha=input.next();
				System.out.println("Digite ID Login: ");
				login1 = input.nextInt();
				Login log1 = loginDAO.buscarID(login1);
				Cliente cli = new Cliente(cpf, telefone, nome, email, senha, log1);
				clienteDAO.update(cli);
				break;

			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}
}
