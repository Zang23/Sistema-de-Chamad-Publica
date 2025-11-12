package view;

import java.io.IOException;

import model.arquivos.CursoArquivo;
import model.entidades.Curso;


public class Main {

	public static void main(String[] args) {
		
		CursoArquivo arquivo = new CursoArquivo();
		Curso curso2 = new Curso("185", "RH", "Curso_chato");
		
		try {
			arquivo.salvar(curso2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
