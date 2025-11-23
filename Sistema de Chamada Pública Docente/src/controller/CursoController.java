package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import model.entidades.Curso;

public class CursoController {

	
	public CursoController() {
		super();
	}
	
	
	public boolean validaCurso(Curso curso) throws IOException{
		
		File diretorio = new File("C:/temp/cursos");
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
		}else {
		
			File arquivo = new File(diretorio, "cursos.csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer =  new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while(linha != null){
					String[] vetLinha = linha.split(";");
					
					if(vetLinha[0].equals(curso.getCod())) {
						return false;
					}
					
					linha = buffer.readLine();
					
				}
				
				return true;
			}
		}
					
		
		return false;
		
	}
	
	public boolean validaCurso(String curso) throws IOException{
		
		File diretorio = new File("C:/temp/cursos");
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
		}else {
		
			File arquivo = new File(diretorio, "cursos.csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer =  new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				String[] vetLinhaNova = curso.split(";");
				
				while(linha != null){
					String[] vetLinha = linha.split(";");
					
					if(vetLinha[0].equals(vetLinhaNova[0])) {
						return false;
					}
					
					linha = buffer.readLine();
					
				}
				
				return true;
			}
		}
					
		
		return false;
		
	}
	
	
}
