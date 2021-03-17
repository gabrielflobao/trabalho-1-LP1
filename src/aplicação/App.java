package aplicação;

import java.util.Scanner;

import entidades.Reserva;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int op, num, pos;
		String nome = "";

		Reserva reserva = new Reserva();

		do {

			System.out.print(menu());
			op = sc.nextInt();

			System.out.println();

			switch (op) {

			case 1:
				System.out.println("Informe os dados: ");

				do {
					System.out.print("Número do quarto: ");
					num = sc.nextInt();
					pos = reserva.buscarReserva(num);
					if (pos != -1) {
						System.out.println("Quarto não disponível para reserva, informe novamente:");
					}
				} while (pos != -1); //validação para não entrar número repetido

				System.out.print("Nome: ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();
				reserva.adicionarReserva(num, nome, telefone);
				break;

			case 2:
				System.out.print("Informe o número do quarto: ");
				num = sc.nextInt();
				reserva.removerReserva(num);
				break;

			case 3:
				System.out.print("Informe o número do quarto: ");
				num = sc.nextInt();
				pos = reserva.buscarReserva(num);
				if (pos == -1) {
					System.out.println("Nenhuma reserva feita para esse quarto!");
				} else {
					System.out.println(reserva.getLista().get(pos));
				}
				break;

			case 4:
				System.out.print("Informe o nome para pesquisar: ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.println();
				System.out.println(reserva.filtroPorNome(nome));
				break;

			case 5:
				if (reserva.getLista().size() == 0) {
					System.out.println("Nenhuma reserva cadastrada");
				} else {
					for (Reserva r : reserva.getLista()) {
						System.out.println(r);
					}
				}
				break;

			case 6:
				System.out.println("Programa finalizado!");
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}

			System.out.println();

		} while (op != 6);

		sc.close();

	}

	private static String menu() {
		return "1 - Adicionar uma nova reserva\n" + "2 - Excluir uma reserva\n"
				+ "3 - Pesquisar reserva por número de quarto\n" + "4 - Filtrar reservas por nome\n"
				+ "5 - Lista de reservas\n" + "6 - Finalizar o programa\n" + "Escolha uma opção: ";
	}

}
