package entidades;

public class Ocupacao {

	private Integer numeroQuarto;
	private Cliente cliente;
	private String tempoDeOcupacao;

	public Ocupacao() {

	}

	public Ocupacao(Integer numeroQuarto, Cliente cliente, String tempoDeOcupacao) {
		this.numeroQuarto = numeroQuarto;
		this.cliente = cliente;
		this.tempoDeOcupacao = tempoDeOcupacao;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTempoDeOcupacao() {
		return tempoDeOcupacao;
	}

	public void setTempoDeOcupacao(String tempoDeOcupacao) {
		this.tempoDeOcupacao = tempoDeOcupacao;
	}

	@Override
	public String toString() {
		return String.format("Número do quarto: %d, Tempo de ocupação: %s\n%s", this.numeroQuarto, this.tempoDeOcupacao,
				cliente.toString());
	}

}
