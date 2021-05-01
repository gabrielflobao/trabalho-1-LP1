package aplicação;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Reserva;
import entidades.auxiliares.ClienteAuxiliar;
import entidades.auxiliares.FuncionarioAuxiliar;
import entidades.auxiliares.ReservaAuxiliar;

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;
		boolean sair = false;

		String menu = "1 - Acessar opções sobre reserva\n" + "2 - Acessar opções sobre cliente\n"
				+ "3 - Acessar opções sobre funcionário\n" + "0 - Finalizar o programa\n" + "Escolha uma opção: ";

		try {
			do {

				System.out.print(menu);
				op = sc.nextInt();

				System.out.println();

				switch (op) {

				case 1:
					menuReserva();
					break;

				case 2:
					menuCliente();
					break;

				case 3:
					menuFuncionario();
					break;

				case 0:
					System.out.println("Programa finalizado!");
					sair = true;
					break;

				default:
					System.out.println("Opção inválida!");
					break;

				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	private static void menuReserva() {

		int op, num, pos;
		boolean sair = false;
		String nome, telefone, CPF;
		Date dataInicio, dataFim;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			do {
				System.out.print("1 - Adicionar uma nova reserva\n" + "2 - Excluir uma reserva\n"
						+ "3 - Listar reservas\n" + "4 - Listar reservas por nome do cliente\n"
						+ "5 - Listar reservas por CPF do cliente\n" + "6 - Atualizar lista de reservas\n"
						+ "0 - Voltar ao menu principal\n" + "Escolha uma opção: ");
				op = sc.nextInt();

				System.out.println();

				switch (op) {

				case 1:
					System.out.println("Informe os dados: ");

					do {
						System.out.print("Número do quarto: ");
						num = sc.nextInt();
						System.out.print("Data de entrada (dd/MM/yyyy): ");
						dataInicio = sdf.parse(sc.next());
						pos = ReservaAuxiliar.buscarReservaComData(num, dataInicio);
						if (pos != -1) {
							System.out.println("Quarto não disponível para reserva, informe novamente");
						}
					} while (pos != -1);

					do {
						System.out.print("Data de saída (dd/MM/yyyy): ");
						dataFim = sdf.parse(sc.next());
						if (dataFim.before(dataInicio)) {
							System.out.println("Data de saída deve ser igual ou posterior à data de entrada");
						}
					} while (dataFim.before(dataInicio));

					System.out.print("Nome: ");
					sc.nextLine();
					nome = sc.nextLine();
					System.out.print("CPF: ");
					CPF = sc.nextLine();
					System.out.print("Telefone: ");
					telefone = sc.nextLine();

					ReservaAuxiliar
							.adicionarReserva(new Reserva(num, new Cliente(nome, CPF, telefone), dataInicio, dataFim));
					System.out.println();
					break;

				case 2:
					System.out.print("Informe o número do quarto: ");
					num = sc.nextInt();
					System.out.print("Informe a data de entrada: ");
					dataInicio = sdf.parse(sc.next());
					ReservaAuxiliar.removerReserva(num, dataInicio);
					System.out.println();
					break;

				case 3:
					ReservaAuxiliar.listarReservas();
					System.out.println();
					break;

				case 4:
					System.out.print("Informe o nome: ");
					sc.nextLine();
					nome = sc.nextLine();
					System.out.println(ReservaAuxiliar.listarPorNome(nome));
					break;

				case 5:
					System.out.print("Informe o CPF: ");
					sc.nextLine();
					CPF = sc.nextLine();
					System.out.println(ReservaAuxiliar.listarPorCPF(CPF));
					break;

				case 6:
					ReservaAuxiliar.atualizar();
					System.out.println("Lista de reservas atualizada com sucesso!");
					System.out.println();
					break;
				case 0:
					sair = true;
					break;

				default:
					System.out.println("Opção inválida!");
					break;

				}
			} while (!sair);

		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	private static void menuCliente() {

		int op, pos;
		boolean sair = false;
		String nome, telefone, CPF;

		try {
			do {
				System.out.print("1 - Cadastrar novo cliente\n" + "2 - Remover cliente\n"
						+ "3 - Listar todos os clientes\n" + "4 - Buscar cliente por CPF\n"
						+ "5 - Listar clientes por nome\n" + "0 - Voltar ao menu principal\n" + "Escolha uma opção: ");
				op = sc.nextInt();

				System.out.println();

				switch (op) {
				case 1:
					System.out.println("Informe os dados: ");
					do {
						System.out.print("CPF: ");
						sc.nextLine();
						CPF = sc.nextLine();
						pos = ClienteAuxiliar.buscarPorCPF(CPF);
						if (pos != -1) {
							System.out.println("CPF já cadastrado como cliente!");
						}
					} while (pos != -1);
					System.out.print("Nome: ");
					nome = sc.nextLine();
					System.out.print("Telefone: ");
					telefone = sc.nextLine();

					ClienteAuxiliar.cadastrar(nome, CPF, telefone);
					System.out.println("Cliente cadastrado com sucesso!");
					System.out.println();
					break;

				case 2:
					System.out.print("Informe o CPF: ");
					sc.nextLine();
					CPF = sc.nextLine();
					ClienteAuxiliar.remover(CPF);
					System.out.println();
					break;

				case 3:
					ClienteAuxiliar.listarClientes();
					System.out.println();
					break;

				case 4:
					System.out.print("Informe o CPF: ");
					CPF = sc.next();
					pos = ClienteAuxiliar.buscarPorCPF(CPF);
					if (pos != -1) {
						System.out.println(ClienteAuxiliar.getListaCliente().get(pos));
					} else {
						System.out.println("CPF não cadastrado");
					}
					System.out.println();
					break;

				case 5:
					System.out.print("Informe o nome: ");
					sc.nextLine();
					nome = sc.nextLine();
					System.out.println(ClienteAuxiliar.listarPorNome(nome));
					break;

				case 0:
					sair = true;
					break;

				default:
					System.out.println("Opção inválida!");
					break;

				}
			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	private static void menuFuncionario() {

		int op, pos;
		boolean sair = false;
		String nome, telefone, CPF;

		try {
			do {

				System.out.print("1 - Cadastrar novo funcionário\n" + "2 - Remover funcionário\n"
						+ "3 - Listar todos os funcionários\n" + "4 - Buscar funcionário por CPF\n"
						+ "5 - Listar funcionários por nome\n" + "0 - Voltar ao menu principal\n"
						+ "Escolha uma opção: ");
				op = sc.nextInt();

				System.out.println();

				switch (op) {
				case 1:
					System.out.println("Informe os dados: ");
					do {
						System.out.print("CPF: ");
						sc.nextLine();
						CPF = sc.nextLine();
						pos = FuncionarioAuxiliar.buscarPorCPF(CPF);
						if (pos != -1) {
							System.out.println("CPF já cadastrado como funcionário!");
						}
					} while (pos != -1);
					System.out.print("Nome: ");
					nome = sc.nextLine();
					System.out.print("Telefone: ");
					telefone = sc.nextLine();

					FuncionarioAuxiliar.cadastrar(nome, CPF, telefone);
					System.out.println("Funcionário cadastrado com sucesso!");
					System.out.println();
					break;

				case 2:
					System.out.print("Informe o CPF: ");
					sc.nextLine();
					CPF = sc.nextLine();
					FuncionarioAuxiliar.remover(CPF);
					System.out.println();
					break;

				case 3:
					FuncionarioAuxiliar.listarFuncionarios();
					System.out.println();
					break;

				case 4:
					System.out.print("Informe o CPF: ");
					CPF = sc.next();
					pos = FuncionarioAuxiliar.buscarPorCPF(CPF);
					if (pos != -1) {
						System.out.println(FuncionarioAuxiliar.getListaFuncionario().get(pos));
					} else {
						System.out.println("CPF não cadastrado");
					}
					System.out.println();
					break;

				case 5:
					System.out.print("Informe o nome: ");
					sc.nextLine();
					nome = sc.nextLine();
					System.out.println(FuncionarioAuxiliar.listarPorNome(nome));
					break;

				case 0:
					sair = true;
					break;

				default:
					System.out.println("Opção inválida!");
					break;

				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

}