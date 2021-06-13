package menu;

import javax.swing.JOptionPane;

public class MenuPrincipal {
	public static void exibirMenuPrincipal() {

		int op;
		boolean sair = false;

		try {

			do {

				String menu = JOptionPane.showInputDialog(null,
						"1 - Acessar opções sobre reserva\n" + "2 - Acessar opções sobre cliente\n"
								+ "3 - Acessar opções sobre funcionário\n" + "0 - Finalizar o programa\n"
								+ "Escolha uma opção: ",
						"OPÇÕES", 3);

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
					System.out.println("Opção inválida!");
					break;

				}
			} while (!sair);

		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

}
