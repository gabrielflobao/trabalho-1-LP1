package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Ocupacao;
import entidades.auxiliares.OcupacaoAuxiliar;

public class App {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		int op, num, pos, tempo;
		String nome, telefone, CPF;
		Date data;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Ocupacao> lista = new ArrayList<>();

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
					pos = OcupacaoAuxiliar.buscarReserva(num, lista);
					if (pos != -1) {
						System.out.println("Quarto não disponível para reserva, informe novamente:");
					}
				} while (pos != -1); // validação para não entrar número repetido

				System.out.print("Nome: ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.print("Telefone: ");
				telefone = sc.nextLine();
				System.out.print("CPF: ");
				CPF = sc.nextLine();
				System.out.print("Data de entrada (dd/MM/yyyy): ");
				data = sdf.parse(sc.next());
				System.out.print("Tempo de ocupação (em dias): ");
				tempo = sc.nextInt();
				OcupacaoAuxiliar.adicionarReserva(num, nome, telefone, CPF, tempo, data, lista);
				break;

			case 2:
				System.out.print("Informe o número do quarto: ");
				num = sc.nextInt();
				OcupacaoAuxiliar.removerReserva(num, lista);
				break;

			case 3:
				System.out.print("Informe o número do quarto: ");
				num = sc.nextInt();
				pos = OcupacaoAuxiliar.buscarReserva(num, lista);
				if (pos == -1) {
					System.out.println("Nenhuma reserva feita para esse quarto!");
				} else {
					System.out.println(lista.get(pos));
				}
				break;

			case 4:
				System.out.print("Informe o nome para pesquisar: ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.println();
				System.out.print(OcupacaoAuxiliar.filtroPorNome(nome, lista));
				break;

			case 5:
				OcupacaoAuxiliar.listarReservas(lista);

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
