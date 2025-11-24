package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import br.edu.fateczl.FilaGenerica.Fila;
import br.fatec.edu.Lista.Lista;
import model.arquivos.CursoArquivo;
import model.arquivos.DisciplinaArquivo;
import model.arquivos.InscricaoArquivo;
import model.arquivos.ProfessorArquivo;
import model.entidades.AreaConhecimento;
import model.entidades.Curso;
import model.entidades.Disciplina;
import model.entidades.Inscricoes;
import model.entidades.ProcessoSeletivo;
import model.entidades.Professor;
import br.edu.fateczl.ordenacao.Ordenacao;


public class TelaController {

	ProfessorArquivo arquivoProf = new ProfessorArquivo();
	CursoArquivo arquivoCurso = new CursoArquivo();
	InscricaoArquivo arquivoInscricao = new InscricaoArquivo();
	DisciplinaArquivo arquivoDisciplina = new DisciplinaArquivo();
	
	
	public TelaController() {
		super();
	}
	
	public void cadastrarProfessor(String cpf, String nome, String area, String pontos) throws Exception {
		
		AreaConhecimento areaEnum = AreaConhecimento.fromDescricao(area);
		
		Professor professor = new Professor(cpf, nome, areaEnum, Integer.parseInt(pontos));
		
		
		arquivoProf.salvar(professor, "professor");
		
	}
	
	public Object[][] carregarTabelaProfessor(String nomeEntidade) throws Exception {
	    
		
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
	
	public void atualizarCurso(String codigoCursoSelecionado, String nome, String area) throws Exception {

	    StringBuffer buffer = new StringBuffer();

	    buffer.append(codigoCursoSelecionado).append(";");
	    buffer.append(nome).append(";");
	    buffer.append(area);

	    String novaLinha = buffer.toString();

	    arquivoCurso.atualizar(codigoCursoSelecionado, "cursos", novaLinha);
	}
	
	public void cadastrarCurso(String codigo, String nome, String area) throws IOException {

		AreaConhecimento areaEnum = AreaConhecimento.fromDescricao(area);
		
		Curso curso = new Curso(codigo, nome, areaEnum);
		
		arquivoCurso.salvar(curso, "cursos");
		
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
	
	public Fila<String> consultarCurso(String cod) throws Exception {
		
		File diretorio = new File("C:/temp/cursos");
	    File arquivo = new File(diretorio, "cursos.csv");

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
	    	
	    	if(partes[0].equals(cod)) {
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
	
	public Fila<String> consultarInscricao(String cod) throws Exception {

		File diretorio = new File("C:/temp/inscricao");
	    File arquivo = new File(diretorio, "inscricao.csv");

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
	    	
	    	if(partes[0].equals(cod)) {
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

	
	public Object[][] carregarTabelaCurso(String nomeEntidade) throws Exception {

		Lista<String> linhas = arquivoProf.listar(nomeEntidade);
		
		Object[][] dados = new Object[linhas.size()][3];

	    for (int i = 0; i < linhas.size(); i++) {
	        String[] partes = linhas.get(i).split(";");
	        
	        dados[i][0] = partes[0]; // Codigo
	        dados[i][1] = partes[1]; // Nome
	        dados[i][2] = partes[2]; // Área
	    }

	    return dados;
	}

	

	public Object[][] carregarTabelaInscricao(String nomeEntidade) throws Exception {
		Lista<String> linhas = arquivoInscricao.listar(nomeEntidade);
		
		Object[][] dados = new Object[linhas.size()][3];

	    for (int i = 0; i < linhas.size(); i++) {
	        String[] partes = linhas.get(i).split(";");
	        
	        dados[i][0] = partes[0]; // CPF
	        dados[i][1] = partes[1]; // Cod disciplina
	        dados[i][2] = partes[2]; // cod procecsso
	    }

	    return dados;
		
	}

	public void atualizarInscricao(String cpf, String codDisc, String codProcesso) throws Exception {

	    // 1. buscar processo no arquivo
	    ProcessoSeletivo processo = consultarProcesso(codProcesso);

	    if (processo == null) {
	        JOptionPane.showMessageDialog(null, "Processo não encontrado");
	        return;
	    }

	    // 2. criar linha nova
	    String novaLinha = cpf + ";" + codDisc + ";" + codProcesso;

	    // 3. atualizar no arquivo
	    InscricaoArquivo arquivo = new InscricaoArquivo();
	    arquivo.atualizar(codProcesso, "inscricao", novaLinha, processo);
	}

	
	public ProcessoSeletivo consultarProcesso(String codProcesso) throws Exception {

	    File arquivo = new File("C:/temp/processo/processo.csv");

	    if (!arquivo.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo de processo não encontrado");
	        return null;
	    }

	    FileInputStream fluxo = new FileInputStream(arquivo);
	    BufferedReader buffer = new BufferedReader(new InputStreamReader(fluxo));

	    String linha = buffer.readLine();

	    while (linha != null) {

	        String[] partes = linha.split(";");

	        if (partes[0].equals(codProcesso)) {

	            // partes[0] = código
	            // partes[1] = nome
	            // partes[2] = ativo (true/false)

	            ProcessoSeletivo p = new ProcessoSeletivo();
	            p.setCod(partes[0]);
	            p.setCodDisciplina(partes[1]);
	            p.setAtivo(Boolean.parseBoolean(partes[2]));

	            buffer.close();
	            return p;
	        }

	        linha = buffer.readLine();
	    }

	    buffer.close();
	    return null;
	}

	public void cadastrarInscricao(String cpf, String codDisciplina, String codProcesso) throws Exception {

		// 1. buscar processo no arquivo
	    ProcessoSeletivo processo = consultarProcesso(codProcesso);
		Inscricoes inscricao = new Inscricoes(cpf, codDisciplina, codProcesso);
		
		
		arquivoInscricao.salvar(processo, inscricao, "inscricao");
		
	}

	public Fila<String> consultarDiciplina(String cod) throws Exception {

		File diretorio = new File("C:/temp/disciplina");
	    File arquivo = new File(diretorio, "disciplina.csv");

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
	    	
	    	if(partes[0].equals(cod)) {
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

	public void cadastrarDiciplina(String cod, String nome, String diaSemana, String horaIni, String qtdHora,
			String codCurso, String status) throws Exception {
		
		Disciplina d = new Disciplina();
		
		if(status.equals("ativa")) {

			d.setStatus(true);
			d.setCod(cod);
			d.setNome(nome);
			d.setDiaSemana(diaSemana);
			d.setHorarioInicial(horaIni);
			d.setQtdHorasDiarias(Integer.parseInt(qtdHora));
			d.setCodCurso(codCurso);
		}else {
			d.setStatus(false);
			d.setCod(cod);
			d.setNome(nome);
			d.setDiaSemana(diaSemana);
			d.setHorarioInicial(horaIni);
			d.setQtdHorasDiarias(Integer.parseInt(qtdHora));
			d.setCodCurso(codCurso);	
		}
		
		
		
		
		arquivoDisciplina.salvar(d, "disciplina");
		
	}

	

	


	
	
}
