package menu;

import javax.swing.JOptionPane;

public class MenuPrincipal {
	public static void exibirMenuPrincipal() {

		int op;
		boolean sair = false;

		try {

			do {

				String menu = JOptionPane.showInputDialog(null,
						"1 - Acessar op��es sobre reserva\n" + "2 - Acessar op��es sobre cliente\n"
								+ "3 - Acessar op��es sobre funcion�rio\n" + "0 - Finalizar o programa\n"
								+ "Escolha uma op��o: ",
						"OP��ES", 3);

				op = Integer.parseInt(menu);

				System.out.println();

				switch (op) {

				case 1:
					MenuReserva.exibirMenuReserva();
					break;

				case 2:
					MenuCliente.exibirMenuCliente();
					break;

				case 3:
					MenuFuncionario.exibirMenuFuncionario();
					break;

				case 0:
					System.out.println("Programa finalizado!");
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
