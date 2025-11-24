 package view;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fateczl.ordenacao.Ordenacao;
import br.fatec.edu.Lista.Lista;
import controller.ProfessorController;
import controller.TelaController;
import model.entidades.Professor;

public class TelaInscrição extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean carregandoTabela = false;
	private JTable tabelaProfessores;
	private String professorCPFSelecionado;
	ProfessorController pc = new ProfessorController();
	private JTable table;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInscrição frame = new TelaInscrição();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public TelaInscrição() {
		setForeground(Color.BLACK);
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(34, 40, 49));
		contentPane.setBackground(new Color(34, 40, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(49, 54, 63));
		contentPane.add(tabbedPane);
		
		JPanel tabInscricao = new JPanel();
		tabInscricao.setBorder(null);
		tabInscricao.setForeground(new Color(0, 0, 0));
		tabInscricao.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Inscrições realizadas");
		tabInscricao.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 88, 768, 294);
		tabInscricao.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CPF", "Nome", "Área", "Pontos"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Inscritos na Disciplina");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(331, 35, 179, 22);
		tabInscricao.add(lblNewLabel);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(128, 128, 128));
/**	
		String[] colunas = { "CPF", "Nome", "Área", "Pontos" }; //define as colunas
		DefaultTableModel modelProfessor = new DefaultTableModel(colunas, 0);

		tabelaProfessores = new JTable(modelProfessor);
		scrollPaneInscriicaoRealizada.setViewportView(tabelaProfessores);
		
		carregarTabelaProfessores(tabelaProfessores);
		

	}
	
	private void carregarTabelaProfessores(JTable tabelaProfessores) {
	    try {
	        TelaController tlc = new TelaController();

	        Object[][] dados = tlc.carregarTabela("professor");

	        DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
	        model.setRowCount(0); // limpa tabela

	        for (Object[] linha : dados) {
	            model.addRow(linha);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public Object[][] carregarTabela(String nomeEntidade) throws Exception {

	    String caminho = "C:/temp/professor/professor.csv";
	    File arquivo = new File(caminho);

	    if (!arquivo.exists()) {
	        return new Object[0][0];
	    }

	    BufferedReader br = new BufferedReader(new FileReader(arquivo));
	    String linha;

	    Lista<Object[]> lista = new Lista<>(); // <-- CORRETO

	    while ((linha = br.readLine()) != null) {
	        String[] partes = linha.split(";");

	        Object[] obj = {
	            partes[0], // CPF
	            partes[1], // Nome
	            partes[2], // Área
	            partes[3]  // Pontos
	        };

	        lista.add(obj);
	    } 

	    br.close();

	   return lista.toArray(new Object[0][]);
	   
	}

	public Object[][] carregarTabelaInscricao(String tipo) throws Exception {

	    if (!tipo.equalsIgnoreCase("inscricao")) {
	        return null;
	    }

	    Lista<Professor> lista = pc.lerProfessorCSV();

	    // LISTA → VETOR DE PROFESSORES
	    Professor[] vetor = new Professor[lista.size()];
	    for (int i = 0; i < lista.size(); i++) {
	        vetor[i] = lista.get(i);
	    }

	    // CRIA VETOR DE PONTUAÇÕES
	    int[] pontos = new int[vetor.length];
	    for (int i = 0; i < vetor.length; i++) {
	        pontos[i] = vetor[i].getQtdPontos();
	    }

	    // ORDENA APENAS O VETOR DE INTEIROS
	    Ordenacao or = new Ordenacao();
	    or.quickSort(pontos, 0, pontos.length - 1);

	    // RECRIA VETOR ORDENADO DE PROFESSORES
	    Professor[] ordenado = new Professor[vetor.length];
	    int index = 0;

	    // Para cada pontuação ordenada, encontra o professor original
	    for (int p = 0; p < pontos.length; p++) {
	        for (int x = 0; x < vetor.length; x++) {

	            // professor com a pontuação correspondente
	            if (vetor[x] != null && vetor[x].getQtdPontos() == pontos[p]) {

	                ordenado[index] = vetor[x];
	                vetor[x] = null; // evita duplicar caso pontos repitam
	                index++;
	                break;
	            }
	        }
	    }

	    // MONTA TABELA PARA A TELA
	    Object[][] dados = new Object[ordenado.length][4];
	    for (int i = 0; i < ordenado.length; i++) {
	        dados[i][0] = ordenado[i].getCpf();
	        dados[i][1] = ordenado[i].getNome();
	        dados[i][2] = ordenado[i].getArea().toString();
	        dados[i][3] = ordenado[i].getQtdPontos();
	    }

	    return dados;
	}
	**/
}
}
