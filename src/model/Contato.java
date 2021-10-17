package model;

public class Contato {
	
	private long id;
	private String nome;
	private int idade;
	private String endereco;
	private String telefone;
	
	public Contato() {}
	
	public Contato(long id, String nome, int idade,String endereco, String telefone) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
	}

}
