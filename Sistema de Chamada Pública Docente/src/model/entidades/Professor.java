package model.entidades;

public class Professor {

	private String cpf;
	private String nome;
	private String area;
	private int qtdPontos;
	
	public Professor(String cpf, String nome, String area, int qtdPontos) {
		this.cpf = cpf;
		this.nome = nome;
		this.area = area;
		this.qtdPontos = qtdPontos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(int qtdPontos) {
		this.qtdPontos = qtdPontos;
	}
	
	
	
	
}
