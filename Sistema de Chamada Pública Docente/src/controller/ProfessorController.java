package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import model.entidades.Professor;

public class ProfessorController {


	public boolean validaProfessor(Professor professor) throws Exception {
		
		File diretorio = new File("C:/temp/professor");
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
		}else {
		
			File arquivo = new File(diretorio, "professor.csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer =  new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while(linha != null){
					String[] vetLinha = linha.split(";");
					
					if(vetLinha[0].equals(professor.getCpf())) {
						return false;
					}
					
					linha = buffer.readLine();
					
				}
				
				return true;
			}
		}
		
		return false;
	}

	public boolean validaProfessorAtualizacao(String cpfOriginal, String novaLinha) throws Exception {

	    File diretorio = new File("C:/temp/professor");
	    if (!diretorio.exists()) return false;

	    File arquivo = new File(diretorio, "professor.csv");
	    if (!arquivo.exists()) return false;

	    FileInputStream fluxo = new FileInputStream(arquivo);
	    InputStreamReader leitor = new InputStreamReader(fluxo);
	    BufferedReader buffer = new BufferedReader(leitor);

	    String linha = buffer.readLine();

	    String[] vetNova = novaLinha.split(";");
	    String novoCPF = vetNova[0];

	    while (linha != null) {
	        String[] vet = linha.split(";");

	        // Se encontrou outro professor com o mesmo CPF
	        if (!vet[0].equals(cpfOriginal) && vet[0].equals(novoCPF)) {
	            return false; // CPF duplicado
	        }
	        
	        linha = buffer.readLine();
	    }

	    return true;
	}


}
