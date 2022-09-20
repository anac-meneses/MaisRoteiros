package modelo;

import java.util.Scanner;

public class DestinosCRUD {

	public static void main(String[] args) {
		
			try (Scanner input = new Scanner(System.in)) {
				DestinosDAO destinosDAO = new DestinosDAO();
				Destino destino = new Destino();

				String opcao = "";

				do {
					System.out.println("        ==== CADASTRO DESTINO ====");
					System.out.println("Digite uma opção: ");
					System.out.println("[1] - Cadastrar um destino");
					System.out.println("[2] - Excluir destino");
					System.out.println("[3] - Pesquisar destino");
					System.out.println("[4] - Exibir todos os destinos");
					System.out.println("[5] - Atualizar destino");
					System.out.println("[6] - Encerrar");
					System.out.println("--------------------------------");
					opcao = input.nextLine();

					switch (opcao) {
					case "1":
						System.out.println("==== Cadastro ====");
						System.out.print("Digite o País: ");
						destino.setPais(input.nextLine());
						System.out.print("Digite a Cidade: ");
						destino.setCidade(input.nextLine());
						destinosDAO.save(destino);
						break;

					case "2":
						System.out.println("Digite o ID do destino para excluir: ");
						destinosDAO.removeById(input.nextInt());
						System.out.println("destino removido com sucesso!");
						break;

					case "3":
						System.out.println("Digite o ID do destino para pesquisa: ");
						int id = input.nextInt();
						Destino d = destinosDAO.buscarID(id);
						
						System.out.println("Pais: " + d.getPais());
						System.out.println("Cidade: " + d.getCidade());
						System.out.println("Id Destino: " + d.getIdDestino());

						System.out.println("-------------------------------------------------");
						break;

					case "4":
						for (Destino d1 : destinosDAO.getDestino()) {
							System.out.println("Pais: " + d1.getPais());
							System.out.println("Cidade: " + d1.getCidade());
							System.out.println("Id Destino: " + d1.getIdDestino());
							System.out.println("-------------------------------------------------");
						}
						break;

					case "5":
						System.out.println("Digite o ID do destino: ");
						destino.setIdDestino(input.nextInt());
						System.out.println("Digite o novo pais: ");
						destino.setPais(input.nextLine());
						System.out.println("Digite a nova cidade: ");
						destino.setCidade(input.nextLine());
						destinosDAO.update(destino);;
					break;
					
					case "6":
						System.out.println("Programa encerrado!");
						break;
					}

				} while (opcao != "6");
			}
			
			
		}
		


	}


