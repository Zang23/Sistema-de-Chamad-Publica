package model.entidades;

public class Curso {

	private String cod;
	private String nome;
	private AreaConhecimento areaConhecimento;
	
	public Curso (String cod, String nome, AreaConhecimento areaConhecimento) {
		this.cod = cod;
		this.nome = nome;
		this.areaConhecimento = areaConhecimento;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	
}
