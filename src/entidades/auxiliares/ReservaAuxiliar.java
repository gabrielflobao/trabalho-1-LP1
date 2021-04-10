package entidades.auxiliares;

import entidades.Cliente;
import entidades.Reserva;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservaAuxiliar {

	public static void listarReservas(List<Reserva> lista) {
		Iterator<Reserva> iterador = lista.iterator();
		Reserva ReservaAux;
		if (!lista.isEmpty()) {
			while (iterador.hasNext()) {
				ReservaAux = iterador.next();
				System.out.print(ReservaAux.toString()+" Tempo ocupação"+ReservaAux.calcularIntervaloData());
				System.out.println();
			}
		} else {
			System.out.println("Nenhuma reserva encontrada");
		}

	}

	public static void adicionarReserva(int numeroQuarto, String nome, String CPF, String telefone,
										Date dataInicio, Date dataFim, List<Reserva> lista) {
		lista.add(new Reserva(numeroQuarto, new Cliente(nome, telefone, CPF),dataInicio, dataFim));
		System.out.println("Reserva cadastrada com sucesso!");
	}

	public static void removerReserva(int numeroQuarto, List<Reserva> lista) {
		int pos = buscarReserva(numeroQuarto, lista);
		if (pos == -1) {
			System.out.println("Nenhuma reserva feita para esse quarto!");
		} else {
			lista.remove(pos);
			System.out.println("Reserva removida com sucesso!");
		}
	}

	public static int buscarReserva(int num, List<Reserva> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumeroQuarto() == num) {
				return i;
			}
		}
		return -1;
	}

	public static String filtroPorNome(String nome, List<Reserva> lista) {
		String saida = "";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getNome().equalsIgnoreCase(nome)) {
				saida += lista.get(i).toString() + "\n\n";
			}
		}

		if (saida.equals("")) {
			return "Nome n�o encontrado!";
		} else {
			return saida;
		}
	}




}
