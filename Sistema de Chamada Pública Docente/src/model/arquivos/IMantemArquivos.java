package model.arquivos;


import java.io.IOException;

import br.fatec.edu.Lista.Lista;

public interface IMantemArquivos {


	String caminhoArquivo = "C:/temp";
	
    public void remover(String codLinha, String nomeEntidade)throws Exception;
    public void atualizar(String codLinha, String nomeEntidade, String novaLinha)throws Exception;
    public Lista<String> listar(String nomeEntidade)throws Exception;
	
}
