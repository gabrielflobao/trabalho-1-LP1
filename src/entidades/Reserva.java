package entidades;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

	private Integer numeroQuarto;
	private String nome;
	private String telefone;

	List<Reserva> lista = new ArrayList<>();

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, String nome, String telefone) {
		this.numeroQuarto = numeroQuarto;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Reserva> getLista() {
		return lista;
	}

	public void adicionarReserva(int numeroQuarto, String nome, String telefone) {
		lista.add(new Reserva(numeroQuarto, nome, telefone));
	}

	public void removerReserva(int numeroQuarto) {
		int pos = buscarReserva(numeroQuarto);
		if (pos == -1) {
			System.out.println("Nenhuma reserva feita para esse quarto!");
		} else {
			lista.remove(pos);
		}
	}

	public int buscarReserva(int num) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumeroQuarto() == num) {
				return i;
			}
		}
		return -1;
	}

	public String filtroPorNome(String nome) {
		String saida = "";
		for (Reserva r : lista) {
			if (r.getNome().equalsIgnoreCase(nome)) {
				saida += r + "\n";
			}
		}

		if (saida.equals("")) {
			return "Nome não encontrado!";
		} else {
			return saida;
		}
	}

	@Override
	public String toString() {
		return String.format("Número do quarto: %d, Nome: %s, Telefone: %s ", this.numeroQuarto, this.nome,
				this.telefone);
	}

}
