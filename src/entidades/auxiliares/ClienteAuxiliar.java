package entidades.auxiliares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entidades.Cliente;

public class ClienteAuxiliar {

	private static List<Cliente> listaCliente = new ArrayList<>();

	public static void listarClientes() {
		Iterator<Cliente> iterador = listaCliente.iterator();
		Cliente ClienteAux;
		if (!listaCliente.isEmpty()) {
			while (iterador.hasNext()) {
				ClienteAux = iterador.next();
				System.out.print(ClienteAux.toString());
				System.out.println();
			}
		} else {
			System.out.println("Nenhum cliente cadastrado");
		}

	}

	public static void cadastrar(String nome, String CPF, String telefone) {
		listaCliente.add(new Cliente(nome, CPF, telefone));
	}

	public static void remover(String CPF) {
		int pos = buscarPorCPF(CPF);
		if (pos == -1) {
			System.out.println("CPF não cadastrado como cliente!");
		} else {
			listaCliente.remove(pos);
			System.out.println("Cliente removido com sucesso!");
		}
	}

	public static int buscarPorCPF(String CPF) {
		for (int i = 0; i < listaCliente.size(); i++) {
			if (listaCliente.get(i).getCPF().equalsIgnoreCase(CPF)) {
				return i;
			}
		}
		return -1;
	}

	public static String listarPorNome(String nome) {
		String saida = "";
		for (int i = 0; i < listaCliente.size(); i++) {
			if (listaCliente.get(i).getNome().equalsIgnoreCase(nome)) {
				saida += listaCliente.get(i).toString() + "\n";
			}
		}

		if (saida.equals("")) {
			return "Cliente não encontrado\n";
		} else {
			return saida;
		}

	}

	public static List<Cliente> getListaCliente() {
		return listaCliente;
	}

}
