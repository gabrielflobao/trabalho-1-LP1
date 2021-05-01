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
		return String.format("%s [nome: %s, telefone: %s, CPF: %s]", this.idFuncionario, this.getNome(),
				this.getTelefone(), this.getCPF());
	}

}
