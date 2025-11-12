package model.entidades;

public class Disciplina {
	
	private boolean status;
	private String cod;
	private String nome;
	private String diaSemana;
	private String horarioInicial;
	private int qtdHorasDiarias;
	private String codCurso; 	
	private String codProcesso;
	
	
	
	public Disciplina(boolean status, String cod, String nome, String diaSemana, String horarioInicial, int qtdHorasDiarias, String codCurso, String codProcesso) {
		this.status = status;
		this.cod = cod;
		this.nome = nome;
		this.diaSemana = diaSemana;
		this.horarioInicial = horarioInicial;
		this.qtdHorasDiarias = qtdHorasDiarias;
		this.codCurso = codCurso;
		this.codProcesso = codProcesso;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
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



	public String getDiaSemana() {
		return diaSemana;
	}



	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}



	public String getHorarioInicial() {
		return horarioInicial;
	}



	public void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}



	public int getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}



	public void setQtdHorasDiarias(int qtdHorasDiarias) {
		this.qtdHorasDiarias = qtdHorasDiarias;
	}



	public String getCodCurso() {
		return codCurso;
	}



	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}



	public String getCodProcesso() {
		return codProcesso;
	}



	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
	}
	
	
	
	
}
