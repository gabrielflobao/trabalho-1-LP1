package entidades.auxiliares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entidades.Funcionario;

public class FuncionarioAuxiliar {

	private static List<Funcionario> listaFuncionario = new ArrayList<>();

	public static void listarFuncionarios() {
		Iterator<Funcionario> iterador = listaFuncionario.iterator();
		Funcionario FuncionarioAux;
		if (!listaFuncionario.isEmpty()) {
			while (iterador.hasNext()) {
				FuncionarioAux = iterador.next();
				System.out.print(FuncionarioAux.toString());
				System.out.println();
			}
		} else {
			System.out.println("Nenhum funcionário cadastrado");
		}

	}

	public static void cadastrar(String nome, String CPF, String telefone) {
		listaFuncionario.add(new Funcionario(nome, CPF, telefone));
	}

	public static void remover(String CPF) {
		int pos = buscarPorCPF(CPF);
		if (pos == -1) {
			System.out.println("CPF não cadastrado como funcionário!");
		} else {
			listaFuncionario.remove(pos);
			System.out.println("Funcionário removido com sucesso!");
		}
	}

	public static int buscarPorCPF(String CPF) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getCPF().equalsIgnoreCase(CPF)) {
				return i;
			}
		}
		return -1;
	}

	public static String listarPorNome(String nome) {
		String saida = "";
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getNome().equalsIgnoreCase(nome)) {
				saida += listaFuncionario.get(i).toString() + "\n";
			}
		}

		if (saida.equals("")) {
			return "Cliente não encontrado\n";
		} else {
			return saida;
		}

	}

	public static List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
}
