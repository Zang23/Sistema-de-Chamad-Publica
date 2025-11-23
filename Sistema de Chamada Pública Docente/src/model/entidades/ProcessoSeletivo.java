package model.entidades;

public class ProcessoSeletivo {

	private String cod;
	private String codDisciplina;
	private boolean ativo;
	
	
	public ProcessoSeletivo(String codProcesso, String codDisciplina, boolean ativo) {
		this.cod = codProcesso;
		this.codDisciplina = codDisciplina;
		this.ativo = ativo;
	}


	public String getCod() {
		return cod;
	}


	public void setCod(String codProcesso) {
		this.cod = codProcesso;
	}


	public String getCodDisciplina() {
		return codDisciplina;
	}


	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
}
