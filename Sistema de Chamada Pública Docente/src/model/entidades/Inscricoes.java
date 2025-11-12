package model.entidades;

public class Inscricoes {

	private String cpfProfessor;
	private String codDisciplina;
	private String codProcesso;
	
	public Inscricoes(String cpfProfessor, String codDisciplina, String codProcesso) {
		this.cpfProfessor = cpfProfessor;
		this.codDisciplina = codDisciplina;
		this.codProcesso = codProcesso;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
	}

	
	
	
	
	
	
}
