package aplica��o;

import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Reserva;
import entidades.auxiliares.ClienteAuxiliar;
import entidades.auxiliares.FuncionarioAuxiliar;
import entidades.auxiliares.ReservaAuxiliar;
import util.BaseJson;
import org.json.JSONException;
import org.json.JSONObject;

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;
		boolean sair = false;
		// criando usu�rio admin
		try {
			JSONObject base = BaseJson.criarJson();
			System.out.println("Json Criado!!");
			String login = ((String) base.get("login"));
			String senha = ((String) base.get("senha"));
			String email = ((String) base.get("email"));
			String cpf = ((String) base.get("cpf"));
			String nome = ((String) base.get("nome"));
			String telefone = ((String) base.get("telefone"));
			FuncionarioAuxiliar.cadastrar(nome, cpf, telefone, login, senha);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String loginAutenticar;
		String senhaAutenticar;
		JOptionPane.showMessageDialog(null, "Informe os dados de restri��o");

		loginAutenticar = JOptionPane.showInputDialog(null, "Infome o login", "login", 3);
		senhaAutenticar = JOptionPane.showInputDialog(null, "Infome o senha", "senha", 3);

		if (FuncionarioAuxiliar.getListaFuncionario().get(0).autenticarFuncionario(loginAutenticar, senhaAutenticar)) {
			JOptionPane.showMessageDialog(null, "Acesso Concedido");
			String menu = JOptionPane.showInputDialog(null,
					"1 - Acessar op��es sobre reserva\n" + "2 - Acessar op��es sobre cliente\n"
							+ "3 - Acessar op��es sobre funcion�rio\n" + "0 - Finalizar o programa\n"
							+ "Escolha uma op��o: ",
					"OP��ES", 3);

			try {
				while (!sair) {

					System.out.print(menu);
					op = Integer.parseInt(menu);

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
						System.out.println("Op��o inv�lida!");
						break;

					}

				}

			} catch (Exception e) {
				System.out.println("ERRO");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Confira as informa��es e tente novamente");
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

				op = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"\"1 - Adicionar uma nova reserva\n" + "2 - Excluir uma reserva \n" + "3 - Listar reservas \n"
								+ "4 - Listar reservas por nome do cliente \n"
								+ "5 - Listar reservas por CPF do cliente \n " + "6 - Atualizar lista de reservas \n"
								+ "0 - Voltar ao menu principal\n" + "Escolha uma op��o: \n")));

				System.out.println();

				switch (op) {

				case 1:
					System.out.println("Informe os dados: ");

					do {
						System.out.print("N�mero do quarto: ");
						num = Integer.parseInt(JOptionPane.showInputDialog(null, "N�mero do quarto : "));
						dataInicio = sdf
								.parse(JOptionPane.showInputDialog(null, "Digite a data de entrada (dd/MM/yyyy)"));

						pos = ReservaAuxiliar.buscarReservaComData(num, dataInicio);
						if (pos != -1) {
							JOptionPane.showInternalMessageDialog(null,
									"Quarto n�o dispon�vel para reserva, informe novamente", "Quarto Indispon�vel", 2);
							System.out.println("Quarto n�o dispon�vel para reserva, informe novamente");
						}
					} while (pos != -1);

					do {
						dataFim = sdf.parse(JOptionPane.showInputDialog(null, "Informe e data de sa�da(dd/MM/yyyy)"));
						if (dataFim.before(dataInicio)) {
							JOptionPane.showMessageDialog(null, "",
									"Data de sa�da deve ser igual ou posterior � data de entrada", 0);
						}
					} while (dataFim.before(dataInicio));

					nome = JOptionPane.showInputDialog("Nome:");
					CPF = JOptionPane.showInputDialog("CPF:");
					telefone = JOptionPane.showInputDialog("Telefone:");
					ReservaAuxiliar
							.adicionarReserva(new Reserva(num, new Cliente(nome, CPF, telefone), dataInicio, dataFim));
					JOptionPane.showMessageDialog(null, "Reserva Adicionada Com Sucesso!!!", "Reserva Adicionada", 1);
					System.out.println();
					break;

				case 2:
					num = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe n�mero do quarto : "));
					dataInicio = sdf
							.parse((JOptionPane.showInputDialog(null, "Informe a data de entrada: (dd/MM/yyyy)")));
					ReservaAuxiliar.removerReserva(num, dataInicio);
					JOptionPane.showMessageDialog(null, "Reserva Removida Com Sucesso!!!", "Reserva Adicionada", 1);
					System.out.println();
					break;

				case 3:
					ReservaAuxiliar.listarReservas();
					System.out.println();
					break;

				case 4:
					nome = JOptionPane.showInputDialog("Nome:");
					System.out.println(ReservaAuxiliar.listarPorNome(nome));
					break;

				case 5:

					CPF = JOptionPane.showInputDialog("Informe o CPF: ");
					System.out.println(ReservaAuxiliar.listarPorCPF(CPF));
					break;

				case 6:
					ReservaAuxiliar.atualizar();
					JOptionPane.showMessageDialog(null, "Lista de reservas atualizada com sucesso",
							"Reservas Atualizadas", 1);
					System.out.println();
					break;
				case 0:
					sair = true;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "ERROR", 0);
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
				op = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - Cadastrar novo cliente\\n\" + \"2 - Remover cliente\\n\"\r\n"
								+ "						+ \"3 - Listar todos os clientes\\n\" + \"4 - Buscar cliente por CPF\\n\"\r\n"
								+ "						+ \"5 - Listar clientes por nome\\n\" + \"0 - Voltar ao menu principal\\n\" + \"Escolha uma op��o: \"")));

				System.out.println();

				switch (op) {
				case 1:
					JOptionPane.showMessageDialog(null, "Informe os dados: ");

					do {
						System.out.print("CPF: ");
						CPF = JOptionPane.showInputDialog("Informe o CPF: ");
						pos = ClienteAuxiliar.buscarPorCPF(CPF);
						if (pos != -1) {
							CPF = JOptionPane.showInputDialog("CPF j� cadastrado como cliente!");

						}
					} while (pos != -1);
					nome = JOptionPane.showInputDialog("Informe o nome: ");
					telefone = JOptionPane.showInputDialog("Informe o telefone: ");

					ClienteAuxiliar.cadastrar(nome, CPF, telefone);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

					break;

				case 2:
					System.out.print("Informe o CPF: ");
					sc.nextLine();
					CPF = JOptionPane.showInputDialog("Informe o CPF: ");
					ClienteAuxiliar.remover(CPF);
					System.out.println();
					break;

				case 3:
					ClienteAuxiliar.listarClientes();
					System.out.println();
					break;

				case 4:
					CPF = JOptionPane.showInputDialog("Informe o CPF: ");
					pos = ClienteAuxiliar.buscarPorCPF(CPF);
					if (pos != -1) {
						System.out.println(ClienteAuxiliar.getListaCliente().get(pos));
					} else {
						JOptionPane.showMessageDialog(null, "CPF n�o cadastrado");

					}
					System.out.println();
					break;

				case 5:
					nome = JOptionPane.showInputDialog("Informe o nome: ");
					System.out.println(ClienteAuxiliar.listarPorNome(nome));
					break;

				case 0:
					sair = true;
					break;

				default:
					System.out.println("Op��o inv�lida!");
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
				op = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - Cadastrar novo funcion�rio\n" + "2 - Remover funcion�rio\n"
								+ "3 - Listar todos os funcion�rios\n" + "4 - Buscar funcion�rio por CPF\n"
								+ "5 - Listar funcion�rios por nome\n" + "0 - Voltar ao menu principal\n"
								+ "Escolha uma op��o: ")));

				System.out.println();

				switch (op) {
				case 1:
					System.out.println("Informe os dados: ");
					do {
						
						CPF = JOptionPane.showInputDialog("Informe o CPF: ");
						pos = FuncionarioAuxiliar.buscarPorCPF(CPF);
						if (pos != -1) {
							System.out.println("CPF j� cadastrado como funcion�rio!");
						}
					} while (pos != -1);

					nome = JOptionPane.showInputDialog("Nome:");
					telefone = JOptionPane.showInputDialog("Informe o telefone: ");

					FuncionarioAuxiliar.cadastrar(nome, CPF, telefone);
					System.out.println("Funcion�rio cadastrado com sucesso!");
					System.out.println();
					break;

				case 2:

					CPF = JOptionPane.showInputDialog("Informe o CPF: ");
					FuncionarioAuxiliar.remover(CPF);
					System.out.println();
					break;

				case 3:
					FuncionarioAuxiliar.listarFuncionarios();
					System.out.println();
					break;

				case 4:
					CPF = JOptionPane.showInputDialog("Informe o CPF: ");
					pos = FuncionarioAuxiliar.buscarPorCPF(CPF);
					if (pos != -1) {
						System.out.println(FuncionarioAuxiliar.getListaFuncionario().get(pos));
					} else {
						System.out.println("CPF n�o cadastrado");
					}
					System.out.println();
					break;

				case 5:

					nome = JOptionPane.showInputDialog("Nome:");
					System.out.println(FuncionarioAuxiliar.listarPorNome(nome));
					break;

				case 0:
					sair = true;
					break;

				default:
					System.out.println("Op��o inv�lida!");
					break;

				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

}