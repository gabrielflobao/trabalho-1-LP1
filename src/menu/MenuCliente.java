package menu;

import javax.swing.JOptionPane;

import entidades.auxiliares.ClienteAuxiliar;

public class MenuCliente {
	public static void exibirMenuCliente() {

		int op, pos;
		boolean sair = false;
		String nome, telefone, CPF;

		try {
			do {
				op = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - Cadastrar novo cliente\\n\" + \"2 - Remover cliente\\n\"\r\n"
								+ "						+ \"3 - Listar todos os clientes\\n\" + \"4 - Buscar cliente por CPF\\n\"\r\n"
								+ "						+ \"5 - Listar clientes por nome\\n\" + \"0 - Voltar ao menu principal\\n\" + \"Escolha uma opção: \"")));

				System.out.println();

				switch (op) {
				case 1:
					JOptionPane.showMessageDialog(null, "Informe os dados: ");

					do {
						System.out.print("CPF: ");
						CPF = JOptionPane.showInputDialog("Informe o CPF: ");
						pos = ClienteAuxiliar.buscarPorCPF(CPF);
						if (pos != -1) {
							CPF = JOptionPane.showInputDialog("CPF já cadastrado como cliente!");

						}
					} while (pos != -1);
					nome = JOptionPane.showInputDialog("Informe o nome: ");
					telefone = JOptionPane.showInputDialog("Informe o telefone: ");

					ClienteAuxiliar.cadastrar(nome, CPF, telefone);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

					break;

				case 2:
					
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
						JOptionPane.showMessageDialog(null, "CPF não cadastrado");

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
					System.out.println("Opção inválida!");
					break;

				}
			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

}
