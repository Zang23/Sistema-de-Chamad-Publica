package view;

import java.io.IOException;

import model.arquivos.CursoArquivo;
import model.arquivos.DisciplinaArquivo;
import model.entidades.Curso;
import model.entidades.Disciplina;


public class Main {

	public static void main(String[] args) {
		
		CursoArquivo arquivo = new CursoArquivo();
		Curso curso3 = new Curso("ADS01", "ADS", "O mais legal que tem");
		
	
		
//		Disciplina disciplina = new Disciplina(true,"CALC21","Calculo","segunda","13:00",4,curso3.getCod());
		DisciplinaArquivo arquivoDisciplina = new DisciplinaArquivo();
	
		
		
		try {
			//arquivo.atualizar(curso3.getCod() + ";" + curso3.getNome() + ";" + curso3.getAreaConhecimento(),"cursos" , "ADS01;AMS;O_mais_legal");
			arquivoDisciplina.remover("ativo;CALC21;Calculo;segunda;13:00;4;ADS01", "disciplina");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
