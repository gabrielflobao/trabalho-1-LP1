package menu;

import javax.swing.JOptionPane;

import entidades.auxiliares.FuncionarioAuxiliar;

public class MenuFuncionario {
	public static void exibirMenuFuncionario() {

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
