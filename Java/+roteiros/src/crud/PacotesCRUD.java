package crud;

import java.util.Scanner;

import dao.PacotesDAO;
import modelo.Destino;
import modelo.Pacotes;

public class PacotesCRUD {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PacotesDAO pacotesDAO = new PacotesDAO();
		Pacotes pacotes = new Pacotes();
		Destino destino = new Destino();
		String opcao = "";

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
				pacotes.setTranslado(input.next());
				System.out.print("Digite o Hotel: ");
				pacotes.setHotel(input.next());
				System.out.print("Digite a quantidade de noites: ");
				pacotes.setQtNoites(input.next());
				System.out.print("Digite o ID do Destino: ");
				destino.setIdDestino(input.nextInt());
				System.out.print("Digite o Valor: ");
				pacotes.setPreco(input.nextInt());
				pacotesDAO.save(pacotes,destino);
				
				break;

			case "2":
				System.out.println("Digite o ID do Pacote para excluir: ");
				pacotesDAO.removeById(input.nextInt());
				System.out.println("Pacote removido com sucesso!");
				break;

			case "3":
				System.out.println("Digite o ID do Pacote para pesquisar: ");
				int id = input.nextInt();
				Pacotes p = pacotesDAO.buscarID(id);

				System.out.println("ID Pacote: " + p.getIdPacote());
				System.out.println("Traslado: " + p.getTranslado());
				System.out.println("Hotel: " + p.getHotel());
				System.out.println("ID Destino: " + p.getIdPacote());
				System.out.println("Valor: " + p.getPreco());

				System.out.println("-------------------------------------------------");
				break;

			case "4":
				for (Pacotes p1 : pacotesDAO.getPacotes()) {
					System.out.println("ID Pacote: " + p1.getIdPacote());
					System.out.println("Traslado: " + p1.getTranslado());
					System.out.println("Hotel: " + p1.getHotel());
					System.out.println("ID Destino: " + p1.getIdPacote());
					System.out.println("Valor: " + p1.getPreco());
					System.out.println("-------------------------------------------------");
				}
				break;

			case "5":
				System.out.println("Digite ID do pacote: ");
				pacotes.setIdPacote(input.nextInt());
				System.out.println("Digite o novo translado: ");
				pacotes.setTranslado(input.next());
				System.out.println("Digite o novo Hotel: ");
				pacotes.setHotel(input.next());
				System.out.println("Digite o novo Destino: ");
				destino.setIdDestino(input.nextInt());
				System.out.println("Digite o novo Valor: ");
				pacotes.setPreco(input.nextInt());
				pacotesDAO.update(pacotes);
				break;

			case "6":
				System.out.println("Programa encerrado!");
				break;
			}

		} while (opcao != "6");

		input.close();
	}

}
