package model.arquivos;


import java.io.IOException;

import br.fatec.edu.Lista.Lista;

public interface IMantemArquivos {


	String caminhoArquivo = "C:/temp";
	
    public void remover(String codLinha, String nomeEntidade)throws Exception;
    public Lista<String> listar(String nomeEntidade)throws Exception;
	
}
