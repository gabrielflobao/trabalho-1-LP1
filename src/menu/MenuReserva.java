package menu;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Reserva;
import entidades.auxiliares.ReservaAuxiliar;

public class MenuReserva {
	public static void exibirMenuReserva() {

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
								+ "0 - Voltar ao menu principal\n" + "Escolha uma opção: \n")));

				System.out.println();

				switch (op) {

				case 1:
					System.out.println("Informe os dados: ");

					do {
						System.out.print("Número do quarto: ");
						num = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do quarto : "));
						dataInicio = sdf
								.parse(JOptionPane.showInputDialog(null, "Digite a data de entrada (dd/MM/yyyy)"));

						pos = ReservaAuxiliar.buscarReservaComData(num, dataInicio);
						if (pos != -1) {
							JOptionPane.showInternalMessageDialog(null,
									"Quarto não disponível para reserva, informe novamente", "Quarto Indisponível", 2);
							System.out.println("Quarto não disponível para reserva, informe novamente");
						}
					} while (pos != -1);

					do {
						dataFim = sdf.parse(JOptionPane.showInputDialog(null, "Informe e data de saída(dd/MM/yyyy)"));
						if (dataFim.before(dataInicio)) {
							JOptionPane.showMessageDialog(null, "",
									"Data de saída deve ser igual ou posterior à data de entrada", 0);
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
					num = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe número do quarto : "));
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
					JOptionPane.showMessageDialog(null, "Opção inválida!", "ERROR", 0);
					break;

				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

}
