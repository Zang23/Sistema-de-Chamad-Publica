package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import br.edu.fateczl.FilaGenerica.Fila;
import br.fatec.edu.Lista.Lista;
import model.arquivos.ProfessorArquivo;
import model.entidades.AreaConhecimento;
import model.entidades.Professor;
import br.edu.fateczl.ordenacao.Ordenacao;


public class TelaController {

	ProfessorArquivo arquivoProf = new ProfessorArquivo();
	
	
	public TelaController() {
		super();
	}
	
	public void cadastrarProfessor(String cpf, String nome, String area, String pontos) throws Exception {
		
		AreaConhecimento areaEnum = AreaConhecimento.fromDescricao(area);
		
		Professor professor = new Professor(cpf, nome, areaEnum, Integer.parseInt(pontos));
		
		
		arquivoProf.salvar(professor, "professor");
		
	}
	
	public Object[][] carregarTabela(String nomeEntidade) throws Exception {
	    
		
		Lista<String> linhas = arquivoProf.listar(nomeEntidade);
		
		Object[][] dados = new Object[linhas.size()][5];

	    for (int i = 0; i < linhas.size(); i++) {
	        String[] partes = linhas.get(i).split(";");
	        
	        dados[i][0] = partes[0]; // CPF
	        dados[i][1] = partes[1]; // Nome
	        dados[i][2] = partes[2]; // Área
	        dados[i][3] = partes[3]; // Pontos
	    }

	    return dados;
	}

	public void excluir(String professorCPFSelecionado, String nomeEntidade) throws Exception {

		arquivoProf.remover(professorCPFSelecionado, nomeEntidade);
		
	}

	public void atualizarProfessor(String professorCPFSelecionado, String nome, String area, String pontos) throws Exception {

		
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(professorCPFSelecionado).append(";");
		buffer.append(nome).append(";");
		buffer.append(area).append(";");
		buffer.append(pontos);
		
		String novaLinha = buffer.toString();
		
		arquivoProf.atualizar(professorCPFSelecionado, "professor", novaLinha);
		
	}

	public Fila<String> consultar(String cpf) throws Exception {
		
		File diretorio = new File("C:/temp/professor");
	    File arquivo = new File(diretorio, "professor.csv");

	    Fila<String> fila = new Fila<>();

	    if (!arquivo.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
	        return fila;
	    }
	    
	    FileInputStream fluxo = new FileInputStream(arquivo);
	    InputStreamReader leitor = new InputStreamReader(fluxo);
	    BufferedReader buffer = new BufferedReader(leitor);
		
	    String linha = buffer.readLine();
	    
	    while(linha != null){
	    	
	    	String[] partes = linha.split(";");
	    	
	    	if(partes[0].equals(cpf)) {
	    		fila.insert(linha);
	    		break;
	    	}
	    	
	    	linha = buffer.readLine();
	    	
	    }
	    fluxo.close();
	    leitor.close();
	    buffer.close();
	    
		return fila;
	}


	
	
}
