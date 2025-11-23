package model.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import br.fatec.edu.Lista.Lista;
import controller.CursoController;
import controller.ProfessorController;
import model.entidades.Professor;

public class ProfessorArquivo implements IMantemArquivos {

	public ProfessorArquivo() {
		super();
	}

	public void salvar(Professor professor, String nomeEntidade) throws Exception {
		
		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);
	
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		File arquivo = new File(novoCaminho,"professor.csv");
		FileWriter writer = new FileWriter(arquivo, true);
		StringBuffer buffer = new StringBuffer();
		
		if(arquivo.exists() && arquivo.isFile()) {
			
			ProfessorController prc = new  ProfessorController();
			
			if(prc.validaProfessor(professor)) {
				buffer.append(professor.getCpf()).append(";");
				buffer.append(professor.getNome()).append(";");
				buffer.append(professor.getArea()).append(";");
				buffer.append(professor.getQtdPontos()).append("\r\n");
				
				writer.append(buffer.toString());
			}else {
				JOptionPane.showMessageDialog(null, "Professor invalido, verifique se ele possui um nome repetido\nou se o diretorio existe");
			}
			
			writer.close();
		}else {
			arquivo.createNewFile();
			buffer.append(professor.getCpf()).append(";");
			buffer.append(professor.getNome()).append(";");
			buffer.append(professor.getArea()).append(";");
			buffer.append(professor.getQtdPontos()).append("\r\n");
			
			writer.write(buffer.toString());
			writer.close();
		}
		
		
	}
		
	
	
	@Override
	public void remover(String codLinha, String nomeEntidade) throws Exception {
		
		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);

		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "Diretorio Não encontrado");
		}else {
			
			File arquivo = new File(novoCaminho + "/" + nomeEntidade + ".csv");
			
			if(arquivo.exists() && arquivo.isFile()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				Lista<String> lista = new Lista<String>();
				boolean isApagado = false;
				
				while(linha != null) {
					if(!isApagado && linha.equals(codLinha)) {
						JOptionPane.showMessageDialog(null, nomeEntidade + " foi removido");
						isApagado = true;
					}else {
						lista.addLast(linha);	
					}
					
					linha = buffer.readLine();
				}
				
				if(!isApagado){
					JOptionPane.showMessageDialog(null, nomeEntidade + " nao encontrado");
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
				FileWriter arquivoSobrescrito = new FileWriter(arquivo, false);
				BufferedWriter escritor = new BufferedWriter(arquivoSobrescrito);
				
				int tamanho = lista.size();
				
				for (int i = 0; i < tamanho; i++) {
			        escritor.write(lista.get(i));
			        escritor.newLine();
			    }
				
				escritor.close();
				arquivoSobrescrito.close();
				
			}else {
				JOptionPane.showMessageDialog(null, "Arquivo Nao encontrado");
			}
		}
		
	}

	@Override
	public void atualizar(String codLinha, String nomeEntidade, String novaLinha) throws Exception {

		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "Diretorio nao encontrado");
		}else {
			
			File arquivo = new File(novoCaminho + "/" + nomeEntidade + ".csv");
			
			if(arquivo.exists()) {
				
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor =  new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				Lista<String> lista = new Lista<String>();
				boolean atualizado = false;
				
				while(linha != null) {

					if(!atualizado && linha.equals(codLinha)) {
						ProfessorController prc = new  ProfessorController();
						
						if(prc.validaProfessor(novaLinha)) {
							lista.addLast(novaLinha);
							atualizado = true;
						}else {
							JOptionPane.showMessageDialog(null, "Curso invalido, verifique se ele possui um nome repetido\nou se o diretorio existe");
						}
						
					}else {
						lista.addLast(linha);
					}
					
					linha = buffer.readLine();
					
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
				if(!atualizado) {
					JOptionPane.showMessageDialog(null, "O " + nomeEntidade + " nao foi atualizado");
				}else {
				
					FileWriter arquivoSobrescrito = new FileWriter(arquivo, false);
					BufferedWriter escritor = new BufferedWriter(arquivoSobrescrito);
					
					int tamanho = lista.size();
					
					for (int i = 0; i < tamanho; i++) {
				        escritor.write(lista.get(i));
				        escritor.newLine();
				    }
					
					escritor.close();
					arquivoSobrescrito.close();
					
					 JOptionPane.showMessageDialog(null, nomeEntidade + " atualizado com sucesso!");
				}
				 
			}else {
				JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
			}
			
			
		}
		
	}

	@Override
	public Lista<String> listar(String nomeEntidade) throws Exception {
		
		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);
		Lista<String> lista = new Lista<String>();
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "Diretorio nao existe");		
		}
		
		File arquivo = new File(caminhoArquivo,nomeEntidade + ".csv");
		
		if(arquivo.exists() && arquivo.isFile()) {
			
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();	
			
			
			while(linha != null){
				lista.addLast(linha);
				linha = buffer.readLine();
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Arquivo Não encontrado");
		}
		
		return lista;
	}
	
	
	
}
