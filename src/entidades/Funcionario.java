package entidades;

import entidades.enuns.TipoPessoa;
import interfaces.AutenticarFuncionario;

public class Funcionario extends Pessoa implements AutenticarFuncionario {

	private TipoPessoa idFuncionario;
	private String login;
	private String senha;

	public Funcionario(String nome, String CPF, String endereco) {
		super(nome, CPF, endereco);
		this.idFuncionario = TipoPessoa.FUNCIONARIO;
	}

	public Funcionario(String nome, String CPF, String endereco, String login, String senha) {
		super(nome, CPF, endereco);
		this.idFuncionario = TipoPessoa.FUNCIONARIO;
		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return String.format("%s [nome: %s, CPF: %s, telefone: %s]", this.idFuncionario, this.getNome(), this.getCPF(),
				this.getTelefone());
	}

	@Override
	public boolean autenticarFuncionario(String login, String senha) {

		return (this.login.equals(login) && this.senha.equals(senha)) ? true : false;

	}

}
