package controller;

import java.io.BufferedReader;
import java.io.*;

import javax.swing.JOptionPane;

import br.fatec.edu.Lista.Lista;
import model.entidades.AreaConhecimento;
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
	
	public Lista<Professor> lerProfessorCSV() throws Exception {

	    File arquivo = new File("C:/temp/professor/professor.csv");

	    if (!arquivo.exists()) {
	        throw new Exception("Arquivo não encontrado: " + arquivo.getAbsolutePath());
	    }

	    Lista<Professor> lista = new Lista<>(); // SUA estrutura

	    BufferedReader br = new BufferedReader(
	            new InputStreamReader(new FileInputStream(arquivo))
	    );

	    String linha = br.readLine();

	    while (linha != null) {

	        String[] campos = linha.split(";");

	        Professor p = new Professor(
	            campos[0],                           // CPF
	            campos[1],                           // Nome
	            AreaConhecimento.fromDescricao(campos[2]), // Enum
	            Integer.parseInt(campos[3])          // Pontos
	        );

	        lista.addLast(p); // ADICIONA NA SUA LISTA

	        linha = br.readLine();
	    }

	    br.close();

	    return lista;
	}

}
