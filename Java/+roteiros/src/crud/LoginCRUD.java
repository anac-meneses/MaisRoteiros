package crud;

import java.util.Scanner;
import dao.LoginDAO;
import modelo.Login;

public class LoginCRUD {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LoginDAO loginDAO = new LoginDAO();
		Login login = new Login();
		String opcao = "";

		do {
			System.out.println("  ==== CADASTRO LOGIN ====");
			System.out.println("Digite uma opção: ");
			System.out.println("[1] - Cadastrar");
			System.out.println("[2] - Excluir ");
			System.out.println("[3] - Pesquisar");
			System.out.println("[4] - Exibir todos");
			System.out.println("[5] - Atualizar");
			System.out.println("[6] - Encerrar");
			System.out.println("--------------------------------");
			opcao = input.nextLine();

			switch (opcao) {
			case "1":
				System.out.println("==== Cadastro ====");
				System.out.print("Digite o Tipo de Permisao: ");
				login.setTipoLogin(input.next());
				loginDAO.save(login);
				break;

			case "2":
				System.out.println("Digite o ID para excluir: ");
				loginDAO.removeById(input.nextInt());
				System.out.println("Login removido com sucesso!");
				break;

			case "3":
				
				System.out.println("Digite o ID para pesquisa: ");
				int id = input.nextInt();
				Login l = loginDAO.buscarID(id);

				System.out.println("Tipo de Permissão: " + l.getTipoLogin());
				System.out.println("ID Login: " + l.getIdLogin());
				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Login l1 : loginDAO.getLogin()) {
					System.out.println("Tipo de Permissão: " + l1.getTipoLogin());
					System.out.println("ID Login: " + l1.getIdLogin());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite o ID do Login: ");
				login.setIdLogin(input.nextInt());
				System.out.println("Digite o tipo de Permissão: ");
				login.setTipoLogin(input.next());
				loginDAO.update(login);
			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}

}
