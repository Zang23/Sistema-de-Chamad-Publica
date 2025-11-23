package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import br.fatec.edu.Lista.Lista;
import model.entidades.Disciplina;

public class DisciplinaController {

	public DisciplinaController() {
		super();
	}
	
	public boolean validaDisciplina(Disciplina disciplina) throws Exception {
		
		File diretorio = new File("C:/temp/disciplina");
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
		}else {
		
			File arquivo = new File(diretorio, "disciplina.csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer =  new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while(linha != null) {
					String[] vetLinha = linha.split(";");
					
					if(vetLinha[1].equals(disciplina.getNome()) && vetLinha[vetLinha.length-1].equals(disciplina.getCodCurso())) {
						return false;
					}
					
					linha = buffer.readLine();
					
				}
				
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "arquivo nao encontrado");
			}
		}
		
		return false;
	}
	
public boolean validaDisciplina(String disciplina) throws Exception {
		
		File diretorio = new File("C:/temp/disciplina");
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
		}else {
		
			File arquivo = new File(diretorio, "disciplina.csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer =  new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				String[] vetLinhaNova = disciplina.split(";");
				
				int tamanho = vetLinhaNova.length;
				
				while(linha != null) {
					String[] vetLinha = linha.split(";");
					
					if(vetLinha[1].equals(vetLinhaNova[1]) && vetLinha[vetLinha.length-1].equals(vetLinhaNova[tamanho - 1])) {
						return false;
					}
					
					linha = buffer.readLine();
					
				}
				
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "arquivo nao encontrado");
			}
		}
		
		return false;
	}
	
}
