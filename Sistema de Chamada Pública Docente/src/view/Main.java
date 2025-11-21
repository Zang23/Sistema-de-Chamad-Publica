package view;

import java.io.IOException;

import model.arquivos.CursoArquivo;
import model.entidades.Curso;


public class Main {

	public static void main(String[] args) {
		
		CursoArquivo arquivo = new CursoArquivo();
		Curso curso3 = new Curso("123", "ADS", "O mais legal que tem");
		System.out.println(curso3.getNome());
		
//		try {
//			arquivo.salvar(curso3, "cursos");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		

	}

}
