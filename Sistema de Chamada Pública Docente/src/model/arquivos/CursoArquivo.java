package model.arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import br.fatec.edu.Lista.Lista;
import model.entidades.Curso;

public class CursoArquivo implements IMantemArquivos{

	public CursoArquivo() {
		super();
	}
	
	public void salvar(Curso curso) throws IOException {
		
		File diretorio = new File(caminhoArquivo);
	
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		File arquivo = new File(caminhoArquivo,"cursos.csv");
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
	public void remover(String codLinha) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	public Lista<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
