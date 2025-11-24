package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fateczl.FilaGenerica.Fila;
import controller.TelaController;
import model.entidades.AreaConhecimento;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;


public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTable tabelaProfessores;
	private JTable tabelaCurso;
	private JTable tabelaInscricao;
	private JTable tabelaDiciplina;
	
	private JPanel contentPane;
	private JTextField txtDiciplinaNome;
	private JTextField txtDiciplinaCodigo;
	private JTextField txtDiciplinaHorario;
	private JTextField txtDiciplinaCodigoCurso;
	private JTextField txtDiciplinaCodigoProcesso;
	private JTextField txtProfessorCPF;
	private JTextField txtProfessorNome;
	private JTextField txtProfessorQntdPontos;
	private JTextField txtCursoCodigo;
	private JTextField txtCursoNome;
	private JTextField txtInscricaoCPF;
	private JTextField txtInscricaoCodDisciplina;
	private JTextField txtInscricaoCodProcesso;
	
	
	private String professorCPFSelecionado;
	private String cursoCodSelecionado;
	private String inscricaoSelecionada;
	
	private boolean carregandoTabela = false;
	private boolean carregandoTabelaInscricao = false;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criação das telas
	
	public Tela() {
		
		//Informações gerais da tela
		setForeground(Color.BLACK);
		setTitle("Sistema de chamada pública");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(34, 40, 49));
		contentPane.setBackground(new Color(34, 40, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(49, 54, 63));
		contentPane.add(tabbedPane);
		
		
		// Aba Diciplina
		JPanel tabDiciplina = new JPanel();
		tabDiciplina.setBorder(null);
		tabDiciplina.setForeground(new Color(0, 0, 0));
		tabDiciplina.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Diciplina", null, tabDiciplina, "Cadastro de diciplina");
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(128, 128, 128));
		tabDiciplina.setLayout(null);
		
		JLabel lblDiciplinaNome = new JLabel("Nome ");
		lblDiciplinaNome.setBounds(73, 84, 49, 34);
		lblDiciplinaNome.setBackground(new Color(0, 0, 0));
		lblDiciplinaNome.setForeground(new Color(255, 255, 255));
		lblDiciplinaNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDiciplinaNome);
		
		JLabel lblDicilpinaCodigoDiciplina = new JLabel("Codigo da diciplina");
		lblDicilpinaCodigoDiciplina.setBounds(73, 50, 112, 34);
		lblDicilpinaCodigoDiciplina.setForeground(new Color(255, 255, 255));
		lblDicilpinaCodigoDiciplina.setBackground(new Color(255, 255, 255));
		lblDicilpinaCodigoDiciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDicilpinaCodigoDiciplina);
		
		JLabel lblDiciplinaDia = new JLabel("Dia da diciplina");
		lblDiciplinaDia.setBounds(73, 118, 98, 34);
		lblDiciplinaDia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaDia.setForeground(new Color(255, 255, 255));
		lblDiciplinaDia.setBackground(new Color(255, 255, 255));
		tabDiciplina.add(lblDiciplinaDia);
		
		JLabel lblDiciplinaHorario = new JLabel("Horario");
		lblDiciplinaHorario.setBounds(73, 154, 61, 34);
		lblDiciplinaHorario.setForeground(new Color(255, 255, 255));
		lblDiciplinaHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDiciplinaHorario);
		
		JLabel lblDiciplinaQuantAula = new JLabel("Aula diária");
		lblDiciplinaQuantAula.setBounds(507, 56, 77, 23);
		lblDiciplinaQuantAula.setForeground(new Color(255, 255, 255));
		lblDiciplinaQuantAula.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDiciplinaQuantAula);
		
		JLabel lblDiciplinaCodCurso = new JLabel("Código do curso");
		lblDiciplinaCodCurso.setBounds(507, 90, 112, 23);
		lblDiciplinaCodCurso.setForeground(new Color(255, 255, 255));
		lblDiciplinaCodCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDiciplinaCodCurso);
		
//		JLabel lblDiciplinaCodProcesso = new JLabel("Código do processo");
//		lblDiciplinaCodProcesso.setBounds(507, 124, 128, 23);
//		lblDiciplinaCodProcesso.setForeground(new Color(255, 255, 255));
//		lblDiciplinaCodProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
//		tabDiciplina.add(lblDiciplinaCodProcesso);
		
		txtDiciplinaNome = new JTextField();
		txtDiciplinaNome.setBounds(132, 91, 180, 20);
		txtDiciplinaNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(txtDiciplinaNome);
		txtDiciplinaNome.setColumns(10);
		
		txtDiciplinaCodigo = new JTextField();
		txtDiciplinaCodigo.setBounds(251, 57, 61, 20);
		txtDiciplinaCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaCodigo.setColumns(10);
		tabDiciplina.add(txtDiciplinaCodigo);
		
		txtDiciplinaHorario = new JTextField();
		txtDiciplinaHorario.setBounds(211, 125, 101, 20);
		txtDiciplinaHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaHorario.setColumns(10);
		tabDiciplina.add(txtDiciplinaHorario);
		
		txtDiciplinaCodigoCurso = new JTextField();
		txtDiciplinaCodigoCurso.setBounds(665, 91, 77, 20);
		txtDiciplinaCodigoCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaCodigoCurso.setColumns(10);
		tabDiciplina.add(txtDiciplinaCodigoCurso);
		
//		txtDiciplinaCodigoProcesso = new JTextField();
//		txtDiciplinaCodigoProcesso.setBounds(665, 125, 77, 20);
//		txtDiciplinaCodigoProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
//		txtDiciplinaCodigoProcesso.setColumns(10);
//		tabDiciplina.add(txtDiciplinaCodigoProcesso);
		
		JComboBox comboBoxDiciplinaAulaDiaria = new JComboBox();
		comboBoxDiciplinaAulaDiaria.setBounds(665, 56, 77, 22);
		comboBoxDiciplinaAulaDiaria.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxDiciplinaAulaDiaria);
		
		String[] aulasDiarias = {"2", "4"};
		
		for(String dia: aulasDiarias) {
			comboBoxDiciplinaAulaDiaria.addItem(dia);
		}
		
		
		String[] horas = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
				"16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"};
		
		JComboBox comboBoxHorario = new JComboBox();
		comboBoxHorario.setBounds(211, 160, 101, 22);
		comboBoxHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxHorario);
		
		for(String hora : horas) {
			comboBoxHorario.addItem(hora);
		}
		
		JLabel lblStatusDisciplina = new JLabel("Status:");
		lblStatusDisciplina.setBounds(20, 160, 100, 25);
		tabDiciplina.add(lblStatusDisciplina);

		JComboBox<String> statusDisciplina = new JComboBox<>();
		statusDisciplina.addItem("Ativa");
		statusDisciplina.addItem("Inativa");
		statusDisciplina.setBounds(630, 130, 112, 23);
		tabDiciplina.add(statusDisciplina);
		
		JButton btnDiciplinaBuscar = new JButton("🔎");
		btnDiciplinaBuscar.setBounds(774, 194, 49, 24);
		tabDiciplina.add(btnDiciplinaBuscar);
		
		btnDiciplinaBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cod = txtProfessorCPF.getText();
				mostrarDiciplinaConsultada(cod);
				
			}

			
		});
		
		
		JScrollPane scrollPaneDiciplina = new JScrollPane();
		scrollPaneDiciplina.setBounds(39, 234, 783, 159);
		tabDiciplina.add(scrollPaneDiciplina);
		
		JButton btnDiciplinaCadastrar = new JButton("Cadastrar");
		btnDiciplinaCadastrar.setBounds(640, 194, 112, 24);
		tabDiciplina.add(btnDiciplinaCadastrar);
		
		btnDiciplinaCadastrar.addActionListener(new ActionListener() { // Adicionando funcao ao botao
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TelaController tlc = new TelaController();
				
				try {
					//Cadastrar Professor
					
					tlc.cadastrarDiciplina(
							txtDiciplinaCodigo.getText(),
							txtDiciplinaNome.getText(),
							txtDiciplinaHorario.getText(),
							(String) comboBoxHorario.getSelectedItem(),
							(String) comboBoxDiciplinaAulaDiaria.getSelectedItem(),
							txtDiciplinaCodigoCurso.getText(), 
							(String) statusDisciplina.getSelectedItem()
					);
					
					//Atualiza tabela
					  Object[][] dados = tlc.carregarTabelaProfessor("professor");
			            tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
			                dados,
			                new String[] { "CPF", "Nome", "Área", "Pontos" }
			            ));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnDiciplinaLimparTela = new JButton("Limpar tela");
		btnDiciplinaLimparTela.setBounds(507, 194, 112, 24);
		tabDiciplina.add(btnDiciplinaLimparTela);
		
		JPanel tabProfessor = new JPanel();
		tabProfessor.setForeground(new Color(0, 0, 0));
		tabProfessor.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de professor");
		tabbedPane.setBackgroundAt(1, new Color(128, 128, 128));
		tabProfessor.setLayout(null);
		
		JLabel lblProfessorCPF = new JLabel("CPF");
		lblProfessorCPF.setForeground(Color.WHITE);
		lblProfessorCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProfessorCPF.setBackground(Color.WHITE);
		lblProfessorCPF.setBounds(73, 50, 112, 34);
		tabProfessor.add(lblProfessorCPF);
		
		txtProfessorCPF = new JTextField();
		txtProfessorCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		txtProfessorCPF.setColumns(10);
		txtProfessorCPF.setBounds(203, 57, 112, 20);
		tabProfessor.add(txtProfessorCPF);
		
		JLabel lblProfessorNome = new JLabel("Nome");
		lblProfessorNome.setForeground(Color.WHITE);
		lblProfessorNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProfessorNome.setBackground(Color.WHITE);
		lblProfessorNome.setBounds(73, 97, 49, 34);
		tabProfessor.add(lblProfessorNome);
		
		txtProfessorNome = new JTextField();
		txtProfessorNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtProfessorNome.setColumns(10);
		txtProfessorNome.setBounds(144, 104, 171, 20);
		tabProfessor.add(txtProfessorNome);
		
		JButton btnProfessorBuscar = new JButton("🔎");
		btnProfessorBuscar.setBounds(774, 194, 49, 24);
		tabProfessor.add(btnProfessorBuscar);
		
		btnProfessorBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cpf = txtProfessorCPF.getText();
				mostrarProfessorConsultado(cpf);
				
			}
		});
		
		JLabel lblProfessorArea = new JLabel("Area");
		lblProfessorArea.setForeground(Color.WHITE);
		lblProfessorArea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProfessorArea.setBackground(Color.WHITE);
		lblProfessorArea.setBounds(507, 56, 77, 23);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorQntdPontos = new JLabel("Quantidade de pontos");
		lblProfessorQntdPontos.setForeground(Color.WHITE);
		lblProfessorQntdPontos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProfessorQntdPontos.setBackground(Color.WHITE);
		lblProfessorQntdPontos.setBounds(507, 97, 181, 34);
		tabProfessor.add(lblProfessorQntdPontos);
		
		txtProfessorQntdPontos = new JTextField();
		txtProfessorQntdPontos.setFont(new Font("Arial", Font.PLAIN, 12));
		txtProfessorQntdPontos.setColumns(10);
		txtProfessorQntdPontos.setBounds(656, 104, 61, 20);
		tabProfessor.add(txtProfessorQntdPontos);
		
		JComboBox comboBoxProfessorArea = new JComboBox();
		comboBoxProfessorArea.setBounds(604, 56, 113, 22);
		tabProfessor.add(comboBoxProfessorArea);
		
		//populando o comboBox
		for (AreaConhecimento area : AreaConhecimento.values()) {
		    comboBoxProfessorArea.addItem(area.getDescricao());
		}
		
		
		JScrollPane scrollPaneProfessor = new JScrollPane();
		scrollPaneProfessor.setBounds(39, 234, 783, 159);
		tabProfessor.add(scrollPaneProfessor);

		//Tabela
		
		String[] colunas = { "CPF", "Nome", "Área", "Pontos" }; //define as colunas
		DefaultTableModel modelProfessor = new DefaultTableModel(colunas, 0);

		tabelaProfessores = new JTable(modelProfessor);
		scrollPaneProfessor.setViewportView(tabelaProfessores);
		
		carregarTabelaProfessores(tabelaProfessores);
		
		// Quando o usuário clicar em uma linha da tabela, salvar o CPF da linha
		tabelaProfessores.getSelectionModel().addListSelectionListener(event -> {
			 
			
			if (carregandoTabela) return;
			
			if (!event.getValueIsAdjusting()) {

		        int linha = tabelaProfessores.getSelectedRow();
		        
		        if (linha != -1) {

		            txtProfessorCPF.setText(tabelaProfessores.getValueAt(linha, 0).toString());
		            txtProfessorNome.setText(tabelaProfessores.getValueAt(linha, 1).toString());
		            txtProfessorQntdPontos.setText(tabelaProfessores.getValueAt(linha, 3).toString());
		            
		            // Pegando o CPF da coluna 0
		            professorCPFSelecionado = tabelaProfessores.getValueAt(linha, 0).toString();
		        }

		      
		      
		    }
		});

		

		
		JButton btnProfessorLimparTela = new JButton("Limpar tela");
		btnProfessorLimparTela.setBounds(507, 194, 112, 24);
		tabProfessor.add(btnProfessorLimparTela);
		
		btnProfessorLimparTela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtProfessorCPF.setText("");
				txtProfessorNome.setText("");
				txtProfessorQntdPontos.setText("");
				comboBoxProfessorArea.setSelectedIndex(-1); // limpa a selecao
				
			}
		});
		
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setBounds(640, 194, 112, 24);
		tabProfessor.add(btnProfessorCadastrar);
		
		
		btnProfessorCadastrar.addActionListener(new ActionListener() { // Adicionando funcao ao botao
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TelaController tlc = new TelaController();
				
				try {
					//Cadastrar Professor
					
					tlc.cadastrarProfessor(
							txtProfessorCPF.getText(),
							txtProfessorNome.getText(),
							(String) comboBoxProfessorArea.getSelectedItem(),
							txtProfessorQntdPontos.getText()
					);
					
					//Atualiza tabela
					  Object[][] dados = tlc.carregarTabelaProfessor("professor");
			            tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
			                dados,
			                new String[] { "CPF", "Nome", "Área", "Pontos" }
			            ));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnProfessorExcluir = new JButton("Excluir");
		btnProfessorExcluir.setBounds(374, 194, 112, 24);
		tabProfessor.add(btnProfessorExcluir);

		btnProfessorExcluir.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        if (professorCPFSelecionado == null) {
		            JOptionPane.showMessageDialog(null, "Selecione um professor na tabela.");
		            return;
		        }

		        try {
		            TelaController tlc = new TelaController();
		            tlc.excluir(professorCPFSelecionado, "professor");

		            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");

		            carregarTabelaProfessores(tabelaProfessores);
		            professorCPFSelecionado = null;

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro ao remover professor.");
		        }
		    }
		});
		
		JButton btnProfessorEditar = new JButton("Editar");
		btnProfessorEditar.setBounds(241, 194, 112, 24);
		tabProfessor.add(btnProfessorEditar);

		btnProfessorEditar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        if (professorCPFSelecionado == null) {
		            JOptionPane.showMessageDialog(null, "Selecione um professor na tabela.");
		            return;
		        }

		        try {
		            TelaController tlc = new TelaController();

		            tlc.atualizarProfessor(
		                    professorCPFSelecionado,
		                    txtProfessorNome.getText(),
		                    comboBoxProfessorArea.getSelectedItem().toString(),
		                    txtProfessorQntdPontos.getText()
		            );

		            JOptionPane.showMessageDialog(null, "Professor atualizado!");
		            carregarTabelaProfessores(tabelaProfessores);
		            professorCPFSelecionado = null;

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

//######################################################## CURSO ###########################################################################//
		
		
		JPanel tabCurso = new JPanel();
		tabCurso.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de curso");
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setBackgroundAt(2, new Color(128, 128, 128));
		tabCurso.setLayout(null);
		
		JLabel lblCursoCodigo = new JLabel("Código do curso");
		lblCursoCodigo.setForeground(Color.WHITE);
		lblCursoCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoCodigo.setBackground(Color.WHITE);
		lblCursoCodigo.setBounds(73, 50, 112, 34);
		tabCurso.add(lblCursoCodigo);
		
		txtCursoCodigo = new JTextField();
		txtCursoCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCursoCodigo.setColumns(10);
		txtCursoCodigo.setBounds(231, 57, 72, 20);
		tabCurso.add(txtCursoCodigo);
		
		JButton btnCursoBuscar = new JButton("🔎");
		btnCursoBuscar.setBounds(774, 194, 49, 24);
		tabCurso.add(btnCursoBuscar);
		btnCursoBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cod = txtCursoCodigo.getText();
				mostrarCursoConsultado(cod);
				
			}

			
		});
		
		
		
		JLabel lblCursoNome = new JLabel("Nome");
		lblCursoNome.setForeground(Color.WHITE);
		lblCursoNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoNome.setBackground(Color.WHITE);
		lblCursoNome.setBounds(73, 97, 49, 34);
		tabCurso.add(lblCursoNome);
		
		txtCursoNome = new JTextField();
		txtCursoNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCursoNome.setColumns(10);
		txtCursoNome.setBounds(132, 104, 171, 20);
		tabCurso.add(txtCursoNome);
		
		JLabel lblCursoArea = new JLabel("Area");
		lblCursoArea.setForeground(Color.WHITE);
		lblCursoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoArea.setBackground(Color.WHITE);
		lblCursoArea.setBounds(507, 50, 112, 34);
		tabCurso.add(lblCursoArea);
		
		JComboBox comboBoxCursoArea = new JComboBox();
		comboBoxCursoArea.setBounds(604, 56, 113, 22);
		tabCurso.add(comboBoxCursoArea);
		
		//populando o comboBox
		for (AreaConhecimento area : AreaConhecimento.values()) {
		    comboBoxCursoArea.addItem(area.getDescricao());
		}
		
		JButton btnCursoLimparTela = new JButton("Limpar tela");
		btnCursoLimparTela.setBounds(507, 194, 112, 24);
		tabCurso.add(btnCursoLimparTela);
		
		btnCursoLimparTela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtCursoCodigo.setText("");
				txtCursoNome.setText("");
				comboBoxCursoArea.setSelectedIndex(-1); // limpa a selecao				
			}
		});
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setBounds(640, 194, 112, 24);
		tabCurso.add(btnCursoCadastrar);
		
		btnCursoCadastrar.addActionListener(new ActionListener() { // Adicionando funcao ao botao
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TelaController tlc = new TelaController();
				
				try {
					//Cadastrar Professor
					
					tlc.cadastrarCurso(
							txtCursoCodigo.getText(),
							txtCursoNome.getText(),
							(String) comboBoxCursoArea.getSelectedItem()
					);
					
					//Atualiza tabela
					  Object[][] dados = tlc.carregarTabelaCurso("cursos");
			            tabelaCurso.setModel(new javax.swing.table.DefaultTableModel(
			                dados,
			                new String[] { "Codigo", "Nome", "Área"}
			            ));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnCursoExcluir = new JButton("Excluir");
		btnCursoExcluir.setBounds(374, 194, 112, 24);
		tabCurso.add(btnCursoExcluir);

		btnCursoExcluir.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        if (cursoCodSelecionado == null) {
		            JOptionPane.showMessageDialog(null, "Selecione um curso na tabela.");
		            return;
		        }

		        try {
		            TelaController tlc = new TelaController();
		            tlc.excluir(cursoCodSelecionado, "cursos");

		            JOptionPane.showMessageDialog(null, "Curso removido com sucesso!");

		            carregarTabelaCursos(tabelaCurso);
		            cursoCodSelecionado = null;

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro ao remover curso.");
		        }
		    }
		});
		
		JScrollPane scrollPaneCurso = new JScrollPane();
		scrollPaneCurso.setBounds(39, 234, 783, 159);
		tabCurso.add(scrollPaneCurso);
		
		String[] colunasCurso = { "Codigo", "Nome", "Área"}; //define as colunas
		DefaultTableModel modelCurso = new DefaultTableModel(colunasCurso, 0);

		tabelaCurso = new JTable(modelCurso);
		scrollPaneCurso.setViewportView(tabelaCurso);
		
		carregarTabelaCursos(tabelaCurso);
		
		// Quando o usuário clicar em uma linha da tabela, salvar o CPF da linha
		tabelaCurso.getSelectionModel().addListSelectionListener(event -> {
			 
			
			if (carregandoTabela) return;
			
			if (!event.getValueIsAdjusting()) {

		        int linha = tabelaCurso.getSelectedRow();
		        
		        if (linha != -1) {

		            txtCursoCodigo.setText(tabelaCurso.getValueAt(linha, 0).toString());
		            txtCursoNome.setText(tabelaCurso.getValueAt(linha, 1).toString());

		            // Pegando o CPF da coluna 0
		            cursoCodSelecionado = tabelaCurso.getValueAt(linha, 0).toString();
		        }

		      
		      
		    }
		});
		
		JButton btnCursoEditar = new JButton("Editar");
		btnCursoEditar.setBounds(241, 194, 112, 24);
		tabCurso.add(btnCursoEditar);
		
		btnCursoEditar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        if (cursoCodSelecionado == null) {
		            JOptionPane.showMessageDialog(null, "Selecione um curso na tabela.");
		            return;
		        }

		        try {
		            TelaController tlc = new TelaController();

		            tlc.atualizarCurso(
		            		cursoCodSelecionado,
		                txtCursoNome.getText(),
		                comboBoxCursoArea.getSelectedItem().toString()
		            );

		            JOptionPane.showMessageDialog(null, "Curso atualizado!");
		            carregarTabelaCursos(tabelaCurso);
		            cursoCodSelecionado = null;

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		
		
		
		
		JPanel tabInscricao = new JPanel();
		tabInscricao.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Inscrição ", null, tabInscricao, "Inscrição em processo seletivo");
		tabbedPane.setBackgroundAt(3, new Color(128, 128, 128));
		tabInscricao.setLayout(null);
		
		JLabel lblInscricaoCpfProfessor = new JLabel("CPF do professor");
		lblInscricaoCpfProfessor.setForeground(Color.WHITE);
		lblInscricaoCpfProfessor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInscricaoCpfProfessor.setBackground(Color.WHITE);
		lblInscricaoCpfProfessor.setBounds(73, 50, 112, 34);
		tabInscricao.add(lblInscricaoCpfProfessor);
		
		JLabel lblInscricaoCodDiciplina = new JLabel("Código da diciplina");
		lblInscricaoCodDiciplina.setForeground(Color.WHITE);
		lblInscricaoCodDiciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInscricaoCodDiciplina.setBackground(Color.WHITE);
		lblInscricaoCodDiciplina.setBounds(73, 97, 137, 34);
		tabInscricao.add(lblInscricaoCodDiciplina);
		
		JLabel lblInscricaoCodProcesso = new JLabel("Código do processo");
		lblInscricaoCodProcesso.setForeground(Color.WHITE);
		lblInscricaoCodProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInscricaoCodProcesso.setBackground(Color.WHITE);
		lblInscricaoCodProcesso.setBounds(460, 50, 112, 34);
		tabInscricao.add(lblInscricaoCodProcesso);
		
		txtInscricaoCPF = new JTextField();
		txtInscricaoCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInscricaoCPF.setColumns(10);
		txtInscricaoCPF.setBounds(227, 57, 72, 20);
		tabInscricao.add(txtInscricaoCPF);
		
		txtInscricaoCodDisciplina = new JTextField();
		txtInscricaoCodDisciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInscricaoCodDisciplina.setColumns(10);
		txtInscricaoCodDisciplina.setBounds(227, 104, 72, 20);
		tabInscricao.add(txtInscricaoCodDisciplina);
		
		txtInscricaoCodProcesso = new JTextField();
		txtInscricaoCodProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInscricaoCodProcesso.setColumns(10);
		txtInscricaoCodProcesso.setBounds(610, 57, 72, 20);
		tabInscricao.add(txtInscricaoCodProcesso);
		
		JButton btnInscricaoLimparTela = new JButton("Limpar tela");
		btnCursoLimparTela.setBounds(507, 194, 112, 24);
		tabInscricao.add(btnCursoLimparTela	);
		
		btnInscricaoLimparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			txtInscricaoCPF.setText("");
			txtInscricaoCodDisciplina.setText("");
			txtInscricaoCodProcesso.setText("");
			inscricaoSelecionada = null;
			}
			});
		
		JButton btnInscricaoCadastrar= new JButton("Cadastrar");
		btnInscricaoCadastrar.setBounds(640, 194, 112, 24);
		tabInscricao.add(btnInscricaoCadastrar);
		
		btnInscricaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
			TelaController tlc = new TelaController();
			tlc.cadastrarInscricao(
			txtInscricaoCPF.getText(),
			txtInscricaoCodDisciplina.getText(),
			txtInscricaoCodProcesso.getText()
			);


			JOptionPane.showMessageDialog(null, "Inscrição cadastrada!");
			carregarTabelaInscricao(tabelaInscricao);
			inscricaoSelecionada = null;
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			}
			});
		
		JButton btnInscricaoBuscar = new JButton("🔎");
		btnInscricaoBuscar.setBounds(774, 194, 49, 24);
		tabInscricao.add(btnInscricaoBuscar);
		
		btnInscricaoBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String cod = txtInscricaoCodProcesso.getText();
			mostrarInscricaoConsultada(cod);
			}
		});
		
		JButton btnInscricaoEditar = new JButton("Editar");
		btnInscricaoEditar.setBounds(241, 194, 112, 24);
		tabInscricao.add(btnInscricaoEditar);
		
		btnInscricaoEditar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String cpf = txtInscricaoCPF.getText();
		        String codDisc = txtInscricaoCodDisciplina.getText();
		        String codProcesso = txtInscricaoCodProcesso.getText();

		        try {
		            TelaController telaController = new TelaController();
					telaController.atualizarInscricao(cpf, codDisc, codProcesso);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		
		JButton btnInscricaoExcluir = new JButton("Excluir");
		btnInscricaoExcluir.setBounds(374, 194, 112, 24);
		tabInscricao.add(btnInscricaoExcluir);
		
		
		btnInscricaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


			if (inscricaoSelecionada == null) {
			JOptionPane.showMessageDialog(null, "Selecione uma inscrição na tabela.");
			return;
			}


			try {
			TelaController tlc = new TelaController();


			tlc.excluir(inscricaoSelecionada, "inscricao");


			JOptionPane.showMessageDialog(null, "Inscrição excluída!");
			carregarTabelaInscricao(tabelaInscricao);
			inscricaoSelecionada = null;


			} catch (Exception ex) {
			ex.printStackTrace();
			}
			}
			});
		
		JScrollPane scrollPaneCurso_1 = new JScrollPane();
		scrollPaneCurso_1.setBounds(39, 234, 783, 159);
		tabInscricao.add(scrollPaneCurso_1);

	}
	
	private void carregarTabelaProfessores(JTable tabelaProfessores) {
	    try {
	        TelaController tlc = new TelaController();

	        Object[][] dados = tlc.carregarTabelaProfessor("professor");

	        DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
	        model.setRowCount(0); // limpa tabela

	        for (Object[] linha : dados) {
	            model.addRow(linha);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void carregarTabelaCursos(JTable tabelaCursos) {
	    try {
	        TelaController tlc = new TelaController();
	        Object[][] dados = tlc.carregarTabelaCurso("cursos");

	        DefaultTableModel model = (DefaultTableModel) tabelaCursos.getModel();
	        model.setRowCount(0);

	        for (Object[] linha : dados) {
	            model.addRow(linha);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void carregarTabelaInscricao(JTable tabela) {


		try {
		TelaController tlc = new TelaController();


		Object[][] dados = tlc.carregarTabelaInscricao("inscricoes");


		carregandoTabelaInscricao = true;
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);


		for (Object[] linha : dados) {
		model.addRow(linha);
		}


		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		carregandoTabelaInscricao = false;
		}
		}
	

	
	public void mostrarProfessorConsultado(String cpf) {
	    try {
	        Fila<String> fila = new Fila<String>();
	        
	        TelaController tlc = new TelaController();
	        
	        fila = tlc.consultar(cpf);

	        DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
	        model.setRowCount(0); // limpa tabela

	        while (!fila.isEmpty()) {
	            String linha = fila.remove();
	            String[] dados = linha.split(";");

	            model.addRow(new Object[]{
	                    dados[0],  // CPF
	                    dados[1],  // Nome
	                    dados[2],  // Área
	                    dados[3]   // Pontos
	            });
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void mostrarCursoConsultado(String cod) {
		try {
	        Fila<String> fila = new Fila<String>();
	        
	        TelaController tlc = new TelaController();
	        
	        fila = tlc.consultarCurso(cod);

	        DefaultTableModel model = (DefaultTableModel) tabelaCurso.getModel();
	        model.setRowCount(0); // limpa tabela

	        while (!fila.isEmpty()) {
	            String linha = fila.remove();
	            String[] dados = linha.split(";");

	            model.addRow(new Object[]{
	                    dados[0],  // Cod
	                    dados[1],  // Nome
	                    dados[2],  // Área
	            });
	            
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	private void mostrarInscricaoConsultada(String cod) {


		try {
		Fila<String> fila = new Fila<String>();
		TelaController tlc = new TelaController();


		fila = tlc.consultarInscricao(cod);


		DefaultTableModel model = (DefaultTableModel) tabelaInscricao.getModel();
		model.setRowCount(0);


		while (!fila.isEmpty()) {
		String linha = fila.remove();
		String[] dados = linha.split(";");


		model.addRow(new Object[]{
		dados[0], // CPF
		dados[1], // Cod Disciplina
		dados[2] // Cod Processo
		});
		}


		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	private void mostrarDiciplinaConsultada(String cod) {
		
		try {
	        Fila<String> fila = new Fila<String>();
	        
	        TelaController tlc = new TelaController();
	        
	        fila = tlc.consultarDiciplina(cod);

	        DefaultTableModel model = (DefaultTableModel) tabelaDiciplina.getModel();
	        model.setRowCount(0); // limpa tabela

	        while (!fila.isEmpty()) {
	            String linha = fila.remove();
	            String[] dados = linha.split(";");

	            model.addRow(new Object[]{
	                    dados[0],  // Cod
	                    dados[1],  // Nome
	                    dados[2],  // Área
	            });
	            
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}


}


