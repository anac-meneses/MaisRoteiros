package modelo;

import java.util.Scanner;

public class PacotesCRUD {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PacotesDAO pacotesDAO = new PacotesDAO();
		DestinosDAO destinoDAO = new DestinosDAO();
		String opcao = "", translado =  "", hotel = "", qnoites="";
		int valor =0, destino = 0, id = 0, id2 = 0;
		

		do {
			System.out.println("  ==== CADASTRO DE PACOTE CLIENTE ====");
			System.out.println("Digite uma opção: ");
			System.out.println("[1] - Cadastrar um Pacote");
			System.out.println("[2] - Excluir Pacote");
			System.out.println("[3] - Pesquisar Pacote");
			System.out.println("[4] - Exibir todos os Pacotes");
			System.out.println("[5] - Atualizar Pacotes");
			System.out.println("[6] - Encerrar");
			System.out.println("--------------------------------");
			opcao = input.nextLine();

			switch (opcao) {
			case "1":
				System.out.println("==== Cadastro Pacote ====");
				System.out.print("Digite o pacote tem translado: ");
				translado = input.next();
				System.out.print("Digite o Hotel: ");
				hotel = input.next();
				System.out.print("Digite a quantidade de noites: ");
				qnoites = input.next();
				System.out.print("Digite o ID do Destino: ");
				destino = input.nextInt();
				System.out.print("Digite o Valor: ");
				valor = input.nextInt();
				Destino destino1 = destinoDAO.buscarID(destino);
				Pacotes p2 = new Pacotes(id,translado, hotel, qnoites, destino1, valor);
				pacotesDAO.save(p2);
				
				break;

			case "2":
				System.out.println("Digite o ID do Pacote para excluir: ");
				pacotesDAO.removeById(input.nextInt());
				System.out.println("Pacote removido com sucesso!");
				break;

			case "3":
				System.out.println("Digite o ID do Pacote para pesquisar: ");
				id = input.nextInt();
				Pacotes p = pacotesDAO.buscarID(id);

				System.out.println("ID Pacote: " + p.getIdPacote());
				System.out.println("Traslado: " + p.getTranslado());
				System.out.println("Hotel: " + p.getHotel());
				System.out.println("ID Destino: " + p.getIdPacote());
				System.out.println("Valor: " + p.getPreco());
				System.out.println("Quantidade de Noites: " + p.getQtNoites());

				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Pacotes p1 : pacotesDAO.getPacotes()) {
					System.out.println("ID Pacote: " + p1.getIdPacote());
					System.out.println("Traslado: " + p1.getTranslado());
					System.out.println("Hotel: " + p1.getHotel());
					System.out.println("ID Destino: " + p1.getIdPacote());
					System.out.println("Valor: " + p1.getPreco());
					System.out.println("Quantidade de Noites: " + p1.getQtNoites());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite ID do pacote: ");
				id2 = input.nextInt();
				System.out.print("Digite o pacote tem translado: ");
				translado = input.next();
				System.out.print("Digite o Hotel: ");
				hotel = input.next();
				System.out.print("Digite a quantidade de noites: ");
				qnoites = input.next();
				System.out.print("Digite o ID do Destino: ");
				destino = input.nextInt();
				System.out.print("Digite o Valor: ");
				valor = input.nextInt();
				Destino destino2 = destinoDAO.buscarID(destino);
				Pacotes p3 = new Pacotes(id2,translado, hotel, qnoites, destino2, valor);
				pacotesDAO.update(p3);
				break;

			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}

}
