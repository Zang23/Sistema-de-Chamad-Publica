package view;

import java.io.IOException;

import model.arquivos.CursoArquivo;
import model.entidades.Curso;


public class Main {

	public static void main(String[] args) {
		
		CursoArquivo arquivo = new CursoArquivo();
		Curso curso = new Curso("189", "RH", "humanas");
		
		try {
			arquivo.salvar(curso);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
