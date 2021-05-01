package entidades;

import entidades.enuns.TipoPessoa;

public class Cliente extends Pessoa {

	private TipoPessoa idCliente;

	public Cliente(String nome, String CPF, String endereco) {
		super(nome, CPF, endereco);
		idCliente = TipoPessoa.CLIENTE;
	}

	@Override
	public String toString() {
		return String.format("%s [nome: %s, CPF: %s, telefone: %s]", this.idCliente, this.getNome(), this.getCPF(),
				this.getTelefone());
	}

}