package entidades.auxiliares;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entidades.Cliente;
import entidades.Ocupacao;

public class OcupacaoAuxiliar {

	public static void listarReservas(List<Ocupacao> lista) {
		Iterator<Ocupacao> iterador = lista.iterator();
		Ocupacao ocupacaoAux;
		if (!lista.isEmpty()) {
			while (iterador.hasNext()) {
				ocupacaoAux = iterador.next();
				System.out.println(ocupacaoAux.toString());
				System.out.println();
			}
		} else {
			System.out.println("Nenhuma reserva encontrada");
		}

	}

	public static void adicionarReserva(int numeroQuarto, String nome, String CPF, String telefone, int tempo,
			Date data, List<Ocupacao> lista) {
		lista.add(new Ocupacao(numeroQuarto, new Cliente(nome, telefone, CPF), tempo, data));
		System.out.println("Reserva cadastrada com sucesso!");
	}

	public static void removerReserva(int numeroQuarto, List<Ocupacao> lista) {
		int pos = buscarReserva(numeroQuarto, lista);
		if (pos == -1) {
			System.out.println("Nenhuma reserva feita para esse quarto!");
		} else {
			lista.remove(pos);
			System.out.println("Reserva removida com sucesso!");
		}
	}

	public static int buscarReserva(int num, List<Ocupacao> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumeroQuarto() == num) {
				return i;
			}
		}
		return -1;
	}

	public static String filtroPorNome(String nome, List<Ocupacao> lista) {
		String saida = "";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getNome().equalsIgnoreCase(nome)) {
				saida += lista.get(i).toString() + "\n\n";
			}
		}

		if (saida.equals("")) {
			return "Nome não encontrado!";
		} else {
			return saida;
		}
	}

}
