package entidades;

import entidades.enuns.TipoPessoa;

public class Funcionario extends Pessoa {

	private TipoPessoa idFuncionario;

	public Funcionario(String nome, String CPF, String endereco) {
		super(nome, CPF, endereco);
		this.idFuncionario = TipoPessoa.FUNCIONARIO;
	}

	@Override
	public String toString() {
		return String.format("%s [nome: %s, CPF: %s, telefone: %s]", this.idFuncionario, this.getNome(), this.getCPF(),
				this.getTelefone());
	}

}
