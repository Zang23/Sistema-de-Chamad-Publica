package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import br.fatec.edu.Lista.Lista;

public class ConsultaController {
	private Lista<String>[] tabelaHash; 

    @SuppressWarnings("unchecked")
    public ConsultaController() {
        super();
        
        tabelaHash = new Lista[10];
        for (int i = 0; i < 10; i++) {
            tabelaHash[i] = new Lista<>();
        }
    }
    
 
	public Object[][] listarTodosProcessos() throws Exception {
	    
	    // 1. LIMPEZA: Garante que a tabela hash comece vazia para não duplicar dados
	    for (int i = 0; i < 10; i++) {
	        if (!tabelaHash[i].isEmpty()) {
	            tabelaHash[i].clean();
	        }
	    }

	    // 2. POPULAR A TABELA HASH (Lendo do Arquivo)
	    File arquivo = new File("C:/temp/disciplina/disciplina.csv");
	    if (!arquivo.exists()) {
	        return new Object[0][0]; // Retorna matriz vazia se não tiver arquivo
	    }

	    FileInputStream fluxo = new FileInputStream(arquivo);
	    InputStreamReader leitor = new InputStreamReader(fluxo);
	    BufferedReader buffer = new BufferedReader(leitor);
	    String linha = buffer.readLine();

	    while (linha != null) {
	        String[] partes = linha.split(";");
	        
	        // Verificação de segurança: se a linha tem dados suficientes
	        // Estrutura esperada: Cod;Nome;Dia;Hora;Qtd;CodCurso;Status
	        if (partes.length > 6) {
	            String status = partes[6]; 
	            
	            // FILTRO: Só adiciona na Hash se o processo estiver ativo ("true" ou "Ativa")
	            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("Ativa")) {
	                try {
	                    int codCurso = Integer.parseInt(partes[5]); // A chave é o Código do Curso
	                    int posicao = funcaoHash(codCurso); // Calcula a posição (0 a 9)
	                    
	                    // Adiciona a linha na lista encadeada daquela posição
	                    tabelaHash[posicao].addFirst(linha);
	                    
	                } catch (NumberFormatException e) {
	                    // Ignora erros de conversão
	                }
	            }
	        }
	        linha = buffer.readLine();
	    }
	    buffer.close();
	    leitor.close();
	    fluxo.close();

	    // 3. CONVERTER TABELA HASH PARA MATRIZ (Object[][])
	    // Primeiro, contamos quantos itens existem no total (somando o tamanho de todas as listas)
	    int totalRegistros = 0;
	    for (int i = 0; i < 10; i++) {
	        totalRegistros += tabelaHash[i].size();
	    }

	    // Cria a matriz com o tamanho exato
	    Object[][] dados = new Object[totalRegistros][4]; 
	    int linhaAtual = 0;

	    // Varre o vetor (as gavetas da hash)
	    for (int i = 0; i < 10; i++) {
	        int tamanhoLista = tabelaHash[i].size();
	        
	        // Varre a lista encadeada dentro de cada gaveta
	        for (int j = 0; j < tamanhoLista; j++) {
	            try {
	                String linhaHash = tabelaHash[i].get(j);
	                String[] partes = linhaHash.split(";");
	                
	                // Preenche as colunas da tabela da tela
	                dados[linhaAtual][0] = partes[0]; // Cód. Disciplina
	                dados[linhaAtual][1] = partes[1]; // Nome Disciplina
	                dados[linhaAtual][2] = partes[5]; // Cód. Curso (Chave Hash)
	                dados[linhaAtual][3] = "Aberto";  // Status do Processo
	                
	                linhaAtual++;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return dados;
	}
	
	private int funcaoHash(int codigoCurso) {
	    return codigoCurso % 10;
	}
}
