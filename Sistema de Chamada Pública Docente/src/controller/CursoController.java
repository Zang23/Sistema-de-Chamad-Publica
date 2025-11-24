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
	
	public boolean validaCurso(String curso) throws IOException {

	    File diretorio = new File("C:/temp/cursos");

	    if (!diretorio.exists()) {
	        JOptionPane.showMessageDialog(null, "Diretório não encontrado");
	        return false;
	    }

	    File arquivo = new File(diretorio, "cursos.csv");

	    if (!arquivo.exists() || !arquivo.isFile()) {
	        JOptionPane.showMessageDialog(null, "Arquivo cursos.csv não encontrado");
	        return false;
	    }

	    // Código do curso que o usuário está tentando atualizar
	    String[] novaLinha = curso.split(";");
	    String codigoCursoNovo = novaLinha[0];

	    FileInputStream fluxo = new FileInputStream(arquivo);
	    InputStreamReader leitor = new InputStreamReader(fluxo);
	    BufferedReader buffer = new BufferedReader(leitor);

	    String linha = buffer.readLine();

	    while (linha != null) {
	        String[] vetLinha = linha.split(";");

	        // Se o código já existir no arquivo,
	        // e não for o mesmo que o atual selecionado → inválido
	        
	        if (vetLinha[0].equals(codigoCursoNovo)) {
	            buffer.close();
	            leitor.close();
	            fluxo.close();
	            return false;
	        }

	        linha = buffer.readLine();
	    }

	    buffer.close();
	    leitor.close();
	    fluxo.close();

	    return true; // código não duplicado → atualização permitida
	}

	
	
}
