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
			System.out.println("Nenhum funcion�rio cadastrado");
		}

	}

	public static void cadastrar(String nome, String CPF, String telefone) {
		listaFuncionario.add(new Funcionario(nome, CPF, telefone));
	}

	public static void cadastrar(String nome, String CPF, String telefone, String login, String senha) {
		listaFuncionario.add(new Funcionario(nome, CPF, telefone, login, senha));
	}

	public static void remover(String CPF) {
		int pos = buscarPorCPF(CPF);
		if (pos == -1) {
			System.out.println("CPF n�o cadastrado como funcion�rio!");
		} else {
			listaFuncionario.remove(pos);
			System.out.println("Funcion�rio removido com sucesso!");
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
			return "Cliente n�o encontrado\n";
		} else {
			return saida;
		}

	}

	public static List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
}
