package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

	private Integer numeroQuarto;
	private Cliente cliente;

	private Date dataInicio;
	private Date dataFim;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Cliente cliente, Date dataInicio, Date dataFim) {
		this.numeroQuarto = numeroQuarto;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {

	}

	public Long calcularIntervaloData() {
		Long dias = (dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24);
		return dias;

	}

	@Override
	public String toString() {
		return String.format("Número do quarto: %d, Data de entrada: %s, Data de Fim: %s\n%s", this.numeroQuarto,
				sdf.format(this.dataInicio), sdf.format(this.dataFim), cliente.toString());
	}

}