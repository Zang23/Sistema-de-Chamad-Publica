package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import model.entidades.ProcessoSeletivo;

public class InscricaoController {

	public InscricaoController() {
		super();
	}

	public boolean validaInscricao(ProcessoSeletivo processo) throws Exception {

		
		if(processo.isAtivo()) {
			File diretorio = new File("C:/temp/inscricao");
			
			if(!diretorio.exists()) {
				JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
			}else {
			
				File arquivo = new File(diretorio, "inscricao.csv");
				
				if(arquivo.exists() && arquivo.isFile()) {
					
					FileInputStream fluxo = new FileInputStream(arquivo);
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer =  new BufferedReader(leitor);
					
					String linha = buffer.readLine();
					
					while(linha != null){
						String[] vetLinha = linha.split(";");
						
						if(vetLinha[2].equals(processo.getCod())) {
							return false;
						}
						
						linha = buffer.readLine();
						
					}
					
					return true;
				}
			}
		}
		
		return  false;
		
	
	}

	public boolean validaInscricao(String inscricao, ProcessoSeletivo processo) throws Exception {

		if(processo.isAtivo()){
			File diretorio = new File("C:/temp/processo");
			
			if(!diretorio.exists()) {
				JOptionPane.showMessageDialog(null, "diretorio nao encontrado");
			}else {
			
				File arquivo = new File(diretorio, "processo.csv");
				
				if(arquivo.exists() && arquivo.isFile()) {
					
					FileInputStream fluxo = new FileInputStream(arquivo);
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer =  new BufferedReader(leitor);
					
					String linha = buffer.readLine();
					
					String[] vetLinhaNova = inscricao.split(";");
					
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
		return false;
		
	}
	
}
