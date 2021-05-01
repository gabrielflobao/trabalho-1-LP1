package entidades;

public class Pessoa {

	private String nome;
	private String CPF;
	private String telefone;

	public Pessoa(String nome, String CPF, String telefone) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return String.format("Nome: %s, CPF: %s, Telefone: %s", this.nome, this.CPF, this.telefone);
	}

}
