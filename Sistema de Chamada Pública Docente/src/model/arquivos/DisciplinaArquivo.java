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
import model.entidades.Curso;
import model.entidades.Disciplina;
import controller.DisciplinaController;

public class DisciplinaArquivo implements IMantemArquivos{

	
	public DisciplinaArquivo() {
		super();
	}
	
	
	public void salvar(Disciplina disciplina, String nomeEntidade) throws Exception {
		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);	
	
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		File arquivo = new File(novoCaminho,"disciplina.csv");
		FileWriter writer = new FileWriter(arquivo, true);
		StringBuffer buffer = new StringBuffer();
		
		if(arquivo.exists() && arquivo.isFile()) {
			
			DisciplinaController dcc = new DisciplinaController();
			if(dcc.validaDisciplina(disciplina)) {
				
				if(disciplina.isStatus()) {
					buffer.append("ativo").append(";");
				}else {
					buffer.append("inativo").append(";");
				}
				
				buffer.append(disciplina.getCod()).append(";");
				buffer.append(disciplina.getNome()).append(";");
				buffer.append(disciplina.getDiaSemana()).append(";");
				buffer.append(disciplina.getHorarioInicial()).append(";");
				buffer.append(disciplina.getQtdHorasDiarias()).append(";");
				buffer.append(disciplina.getCodCurso()).append("\r\n");
				
				writer.append(buffer.toString());
			}else {
				JOptionPane.showMessageDialog(null, "Disciplina invalida, verifique se ela possui um nome repetido\nou se o diretorio existe");
			}
			
			writer.close();
		}else {
			arquivo.createNewFile();
			
			if(disciplina.isStatus()) {
				buffer.append("ativo").append(";");
			}else {
				buffer.append("inativo").append(";");
			}
			
			buffer.append(disciplina.getCod()).append(";");
			buffer.append(disciplina.getNome()).append(";");
			buffer.append(disciplina.getDiaSemana()).append(";");
			buffer.append(disciplina.getHorarioInicial()).append(";");
			buffer.append(disciplina.getQtdHorasDiarias()).append(";");
			buffer.append(disciplina.getCodCurso()).append("\r\n");
			
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
						
						DisciplinaController dcc = new DisciplinaController();
						if(dcc.validaDisciplina(novaLinha)) {
							lista.addLast(novaLinha);
							atualizado = true;
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
		
		File arquivo = new File(caminhoArquivo, nomeEntidade + ".csv");
		
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
