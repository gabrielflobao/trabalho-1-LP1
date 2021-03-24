package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ocupacao {

	private Integer numeroQuarto;
	private Cliente cliente;
	private Integer tempoDeOcupacao;
	private Date data;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Ocupacao() {

	}

	public Ocupacao(Integer numeroQuarto, Cliente cliente, Integer tempoDeOcupacao, Date data) {
		this.numeroQuarto = numeroQuarto;
		this.cliente = cliente;
		this.tempoDeOcupacao = tempoDeOcupacao;
		this.data = data;
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

	public Integer getTempoDeOcupacao() {
		return tempoDeOcupacao;
	}

	public void setTempoDeOcupacao(Integer tempoDeOcupacao) {
		this.tempoDeOcupacao = tempoDeOcupacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Número do quarto: %d, Data de entrada: %s, Tempo de ocupação: %d dia(s)\n%s",
				this.numeroQuarto, sdf.format(this.data), this.tempoDeOcupacao, cliente.toString());
	}

}
