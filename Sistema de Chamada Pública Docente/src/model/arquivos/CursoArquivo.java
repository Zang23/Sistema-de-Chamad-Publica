package model.arquivos;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import javax.swing.JOptionPane;

import br.fatec.edu.Lista.Lista;
import model.entidades.Curso;

public class CursoArquivo implements IMantemArquivos{

	public CursoArquivo() {
		super();
	}
	
	public void salvar(Curso curso, String nomeEntidade) throws IOException {
		
		
		String novoCaminho = caminhoArquivo + "/" + nomeEntidade;
		File diretorio = new File(novoCaminho);
	
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		File arquivo = new File(novoCaminho,"cursos.csv");
		FileWriter writer = new FileWriter(arquivo, true);
		StringBuffer buffer = new StringBuffer();
		
		if(arquivo.exists() && arquivo.isFile()) {
			
			buffer.append(curso.getCod()).append(";");
			buffer.append(curso.getNome()).append(";");
			buffer.append(curso.getAreaConhecimento()).append("\r\n");
			
			writer.append(buffer.toString());
			writer.close();
		}else {
			arquivo.createNewFile();
			buffer.append(curso.getCod()).append(";");
			buffer.append(curso.getNome()).append(";");
			buffer.append(curso.getAreaConhecimento()).append("\r\n");
			
			writer.write(buffer.toString());
			writer.close();
		}
		
		
	}

	@Override
	public void remover(String codLinha, String nomeEntidade)throws Exception {

		
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

	public void atualizar(Object objeto) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public Lista<String> listar(String curso) throws Exception {
		
		File diretorio = new File(caminhoArquivo);
		Lista<String> lista = new Lista<String>();
		
		if(!diretorio.exists()) {
			JOptionPane.showMessageDialog(null, "Diretorio nao existe");		
		}
		
		File arquivo = new File(caminhoArquivo,curso + ".csv");
		
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
