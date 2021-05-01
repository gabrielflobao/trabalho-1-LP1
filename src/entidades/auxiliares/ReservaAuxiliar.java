package entidades.auxiliares;

import entidades.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservaAuxiliar {

	static List<Reserva> lista = new ArrayList<>();

	public static void listarReservas() {
		Iterator<Reserva> iterador = lista.iterator();
		Reserva ReservaAux;
		if (!lista.isEmpty()) {
			while (iterador.hasNext()) {
				ReservaAux = iterador.next();
				System.out.print(
						ReservaAux.toString() + " Tempo ocupação: " + ReservaAux.calcularIntervaloData() + " dias");
				System.out.println();
			}
		} else {
			System.out.println("Nenhuma reserva encontrada");
		}

	}

	public static void adicionarReserva(Reserva reserva) {
		lista.add(reserva);
		System.out.println("Reserva cadastrada com sucesso!");
	}

	public static void removerReserva(int numeroQuarto, Date data) {
		int pos = buscarReserva(numeroQuarto);
		if (lista.get(pos).getDataInicio().equals(data)) {
			lista.remove(pos);
			System.out.println("Reserva removida com sucesso!");
		} else {
			System.out.println("Nenhuma reserva feita para esse quarto nesta data!");
		}
	}

	public static int buscarReserva(int num) { // busca o número de um determinado quarto na lista
												// de reservas
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumeroQuarto() == num) {
				return i;
			}
		}
		return -1;
	}

	public static int buscarReservaComData(int num, Date data) { // busca o número de um
																	// determinado quarto na lista
																	// de reservas e verifica se o
																	// quarto já está reservado para
																	// a data informada
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumeroQuarto() == num) {
				if ((lista.get(i).getDataInicio().before(data) && lista.get(i).getDataFim().after(data))
						|| lista.get(i).getDataInicio().equals(data) || lista.get(i).getDataFim().equals(data)) {
					return i;
				}

			}
		}
		return -1;
	}

	public static String filtroPorNome(String nome) {
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

	public static List<Reserva> getLista() {
		return lista;
	}

}