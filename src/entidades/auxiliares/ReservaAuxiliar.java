package entidades.auxiliares;

import entidades.Reserva;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservaAuxiliar {

	static List<Reserva> listaReserva = new ArrayList<>();

	public static void listarReservas() { // lista todas as reservas
		Iterator<Reserva> iterador = listaReserva.iterator();
		Reserva ReservaAux;
		if (!listaReserva.isEmpty()) {
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

	public static void adicionarReserva(Reserva reserva) { // adiciona nova reserva na lista
		listaReserva.add(reserva);
		System.out.println("Reserva cadastrada com sucesso!");
	}

	public static void removerReserva(int numeroQuarto, Date data) { // remove reserva da lista através de número do
																		// quarto e data informadas pelo usuário
		int pos = buscarReserva(numeroQuarto);
		if (listaReserva.get(pos).getDataInicio().equals(data)) {
			listaReserva.remove(pos);
			System.out.println("Reserva removida com sucesso!");
		} else {
			System.out.println("Nenhuma reserva feita para esse quarto nesta data!");
		}
	}

	public static int buscarReserva(int num) { // busca reserva através do número do quarto informado pelo usuário
		for (int i = 0; i < listaReserva.size(); i++) {
			if (listaReserva.get(i).getNumeroQuarto() == num) {
				return i;
			}
		}
		return -1;
	}

	public static int buscarReservaComData(int num, Date data) { // busca reserva através de número do quarto e data
																	// informados pelo usuário
		for (int i = 0; i < listaReserva.size(); i++) {
			if (listaReserva.get(i).getNumeroQuarto() == num) {
				if ((listaReserva.get(i).getDataInicio().before(data) && listaReserva.get(i).getDataFim().after(data))
						|| listaReserva.get(i).getDataInicio().equals(data) || listaReserva.get(i).getDataFim().equals(data)) {
					return i;
				}

			}
		}
		return -1;
	}

	public static String listarPorNome(String nome) { // realiza a busca de um nome na lista de reservas e retorna uma
														// string com todas a reservas que possuírem ele
		String saida = "";
		for (int i = 0; i < listaReserva.size(); i++) {
			if (listaReserva.get(i).getCliente().getNome().equalsIgnoreCase(nome)) {
				saida += listaReserva.get(i).toString() + "\n\n";
			}
		}

		if (saida.equals("")) {
			return "Nome não encontrado!";
		} else {
			return saida;
		}
	}

	public static String listarPorCPF(String CPF) { // realiza a busca de um CPF na lista de reservas e retorna uma
													// string com todas a reservas que possuírem ele
		String saida = "";
		for (int i = 0; i < listaReserva.size(); i++) {
			if (listaReserva.get(i).getCliente().getCPF().equalsIgnoreCase(CPF)) {
				saida += listaReserva.get(i).toString() + "\n\n";
			}
		}

		if (saida.equals("")) {
			return "CPF não encontrado!";
		} else {
			return saida;
		}
	}

	public static void atualizar() { // atualiza a lista de reservas, removendo todas as que a data final for menor
										// que a data atual
		Date dataAux = Calendar.getInstance().getTime();
		for (int i = 0; i < listaReserva.size(); i++) {
			if (listaReserva.get(i).getDataFim().before(dataAux)) {
				listaReserva.remove(i);
			}

		}
	}

	public static List<Reserva> getLista() {
		return listaReserva;
	}

}