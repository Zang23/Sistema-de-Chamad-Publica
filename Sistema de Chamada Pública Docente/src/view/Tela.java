package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.fateczl.FilaGenerica.Fila;
import controller.TelaController;
import model.entidades.AreaConhecimento;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	// Tabelas
	private JTable tabelaProfessores;
	private JTable tabelaCurso;
	private JTable tabelaDiciplina;

	// Campos Disciplina
	private JTextField txtDiciplinaNome;
	private JTextField txtDiciplinaCodigo;
	private JTextField txtDiciplinaHorario;
	private JTextField txtDiciplinaCodigoCurso;

	// Campos Professor
	private JTextField txtProfessorCPF;
	private JTextField txtProfessorNome;
	private JTextField txtProfessorQntdPontos;

	// Campos Curso
	private JTextField txtCursoCodigo;
	private JTextField txtCursoNome;

	// Variáveis de seleção
	private String professorCPFSelecionado;
	private String cursoCodSelecionado;
	private String disciplinaCodSelecionado;

	// Flags
	private boolean carregandoTabela = false;

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

	// Construtor
	public Tela() {

		// Informações gerais da tela
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

		// =================================================================================
		// ABA DISCIPLINA
		// =================================================================================
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

		txtDiciplinaNome = new JTextField();
		txtDiciplinaNome.setBounds(132, 91, 180, 20);
		txtDiciplinaNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(txtDiciplinaNome);
		txtDiciplinaNome.setColumns(10);

		txtDiciplinaCodigo = new JTextField();
		txtDiciplinaCodigo.setBounds(195, 57, 61, 20);
		txtDiciplinaCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaCodigo.setColumns(10);
		tabDiciplina.add(txtDiciplinaCodigo);

		txtDiciplinaHorario = new JTextField();
		txtDiciplinaHorario.setBounds(211, 161, 101, 20);
		txtDiciplinaHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaHorario.setColumns(10);
		tabDiciplina.add(txtDiciplinaHorario);

		txtDiciplinaCodigoCurso = new JTextField();
		txtDiciplinaCodigoCurso.setBounds(665, 91, 77, 20);
		txtDiciplinaCodigoCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaCodigoCurso.setColumns(10);
		tabDiciplina.add(txtDiciplinaCodigoCurso);

		JComboBox<String> comboBoxDiciplinaAulaDiaria = new JComboBox<>();
		comboBoxDiciplinaAulaDiaria.setBounds(665, 56, 77, 22);
		comboBoxDiciplinaAulaDiaria.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxDiciplinaAulaDiaria);

		String[] aulasDiarias = { "2", "4" };
		for (String dia : aulasDiarias) {
			comboBoxDiciplinaAulaDiaria.addItem(dia);
		}

		String[] horas = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
				"18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00" };

		JComboBox<String> comboBoxHorario = new JComboBox<>();
		comboBoxHorario.setBounds(211, 160, 101, 22);
		comboBoxHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxHorario);

		for (String hora : horas) {
			comboBoxHorario.addItem(hora);
		}

		JLabel lblStatusDisciplina = new JLabel("Status:");
		lblStatusDisciplina.setForeground(new Color(255, 255, 255));
		lblStatusDisciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStatusDisciplina.setBounds(507, 129, 100, 25);
		tabDiciplina.add(lblStatusDisciplina);

		JComboBox<String> statusDisciplina = new JComboBox<>();
		statusDisciplina.addItem("Ativa");
		statusDisciplina.addItem("Inativa");
		statusDisciplina.setBounds(630, 130, 112, 23);
		tabDiciplina.add(statusDisciplina);

		JComboBox<String> comboBoxDiciplinaDia = new JComboBox<>();
		comboBoxDiciplinaDia.setBounds(211, 124, 101, 22);
		comboBoxDiciplinaDia.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxDiciplinaDia);

		String[] diasSemana = { 
		    "Segunda-feira", 
		    "Terça-feira", 
		    "Quarta-feira", 
		    "Quinta-feira", 
		    "Sexta-feira", 
		    "Sábado" 
		};

		for (String dia : diasSemana) {
		    comboBoxDiciplinaDia.addItem(dia);
		}

		JButton btnDiciplinaBuscar = new JButton("🔎");
		btnDiciplinaBuscar.setBounds(266, 55, 49, 24);
		tabDiciplina.add(btnDiciplinaBuscar);

		btnDiciplinaBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cod = txtDiciplinaCodigo.getText(); 
				mostrarDiciplinaConsultada(cod);
			}
		});

		JButton btnDiciplinaCadastrar = new JButton("Cadastrar");
		btnDiciplinaCadastrar.setBounds(446, 385, 112, 24);
		tabDiciplina.add(btnDiciplinaCadastrar);

		btnDiciplinaCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaController tlc = new TelaController();
				try {
					tlc.cadastrarDiciplina(txtDiciplinaCodigo.getText(), txtDiciplinaNome.getText(),
							txtDiciplinaHorario.getText(), (String) comboBoxHorario.getSelectedItem(),
							(String) comboBoxDiciplinaAulaDiaria.getSelectedItem(), txtDiciplinaCodigoCurso.getText(),
							(String) statusDisciplina.getSelectedItem());

					JOptionPane.showMessageDialog(null, "Disciplina Cadastrada");
					// Recarrega a tabela após cadastrar para ver o novo item
					carregarTabelaDisciplina(tabelaDiciplina);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDiciplinaLimparTela = new JButton("Limpar tela");
		btnDiciplinaLimparTela.setBounds(288, 385, 112, 24);
		tabDiciplina.add(btnDiciplinaLimparTela);

		btnDiciplinaLimparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtDiciplinaCodigo.setText("");
				txtDiciplinaNome.setText("");
				txtDiciplinaHorario.setText("");
				txtDiciplinaCodigoCurso.setText("");
				comboBoxDiciplinaAulaDiaria.setSelectedIndex(-1);
				comboBoxDiciplinaDia.setSelectedIndex(-1);
			}
		});

		JScrollPane scrollPaneDisciplina = new JScrollPane();
		scrollPaneDisciplina.setBounds(38, 215, 784, 159);
		tabDiciplina.add(scrollPaneDisciplina);

		tabelaDiciplina = new JTable(); 
		scrollPaneDisciplina.setViewportView(tabelaDiciplina);
		tabelaDiciplina.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome", "Dia",
				"Horario", "Aula diaria", "Codigo do curso", "Código do processo" }));
		tabelaDiciplina.setFont(new Font("Arial", Font.PLAIN, 12));

		// *** AQUI ESTAVA FALTANDO: CARREGAR OS DADOS AO INICIAR ***
		carregarTabelaDisciplina(tabelaDiciplina);
		// **********************************************************

		tabelaDiciplina.getSelectionModel().addListSelectionListener(event -> {
			if (!event.getValueIsAdjusting()) {
				int linha = tabelaDiciplina.getSelectedRow();
				if (linha != -1) {
					disciplinaCodSelecionado = tabelaDiciplina.getValueAt(linha, 0).toString();
					txtDiciplinaCodigo.setText(tabelaDiciplina.getValueAt(linha, 0).toString());
					txtDiciplinaNome.setText(tabelaDiciplina.getValueAt(linha, 1).toString());
				}
			}
		});

		JButton btnDisciplinaEditar = new JButton("Editar");
		btnDisciplinaEditar.setBounds(658, 184, 77, 24);
		tabDiciplina.add(btnDisciplinaEditar);

		btnDisciplinaEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (disciplinaCodSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina na tabela.");
					return;
				}
				try {
					JOptionPane.showMessageDialog(null, "Disciplina atualizada!");
					carregarTabelaDisciplina(tabelaDiciplina); // Atualiza tabela
					disciplinaCodSelecionado = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnDisciplinaExcluir = new JButton("Excluir");
		btnDisciplinaExcluir.setBounds(745, 184, 77, 24);
		tabDiciplina.add(btnDisciplinaExcluir);

		btnDisciplinaExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (disciplinaCodSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina na tabela.");
					return;
				}
				try {
					TelaController tlc = new TelaController();
					tlc.excluir(disciplinaCodSelecionado, "disciplina");
					JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso!");
					carregarTabelaDisciplina(tabelaDiciplina); // Atualiza tabela
					disciplinaCodSelecionado = null;
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao remover disciplina.");
				}
			}
		});

		// =================================================================================
		// ABA PROFESSOR
		// =================================================================================
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
		txtProfessorCPF.setBounds(144, 57, 112, 20);
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
		btnProfessorBuscar.setBounds(266, 55, 49, 24);
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

		JComboBox<String> comboBoxProfessorArea = new JComboBox<>();
		comboBoxProfessorArea.setBounds(604, 56, 113, 22);
		tabProfessor.add(comboBoxProfessorArea);

		// populando o comboBox
		for (AreaConhecimento area : AreaConhecimento.values()) {
			comboBoxProfessorArea.addItem(area.getDescricao());
		}

		JScrollPane scrollPaneProfessor = new JScrollPane();
		scrollPaneProfessor.setBounds(38, 215, 784, 159);
		tabProfessor.add(scrollPaneProfessor);

		// Tabela
		String[] colunas = { "CPF", "Nome", "Área", "Pontos" };
		DefaultTableModel modelProfessor = new DefaultTableModel(colunas, 0);

		tabelaProfessores = new JTable(modelProfessor);
		scrollPaneProfessor.setViewportView(tabelaProfessores);

		carregarTabelaProfessores(tabelaProfessores);

		tabelaProfessores.getSelectionModel().addListSelectionListener(event -> {
			if (carregandoTabela)
				return;
			if (!event.getValueIsAdjusting()) {
				int linha = tabelaProfessores.getSelectedRow();
				if (linha != -1) {
					txtProfessorCPF.setText(tabelaProfessores.getValueAt(linha, 0).toString());
					txtProfessorNome.setText(tabelaProfessores.getValueAt(linha, 1).toString());
					txtProfessorQntdPontos.setText(tabelaProfessores.getValueAt(linha, 3).toString());
					professorCPFSelecionado = tabelaProfessores.getValueAt(linha, 0).toString();
				}
			}
		});

		JButton btnProfessorLimparTela = new JButton("Limpar tela");
		btnProfessorLimparTela.setBounds(288, 385, 112, 24);
		tabProfessor.add(btnProfessorLimparTela);

		btnProfessorLimparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtProfessorCPF.setText("");
				txtProfessorNome.setText("");
				txtProfessorQntdPontos.setText("");
				comboBoxProfessorArea.setSelectedIndex(-1);
			}
		});

		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setBounds(446, 385, 112, 24);
		tabProfessor.add(btnProfessorCadastrar);

		btnProfessorCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaController tlc = new TelaController();
				try {
					tlc.cadastrarProfessor(txtProfessorCPF.getText(), txtProfessorNome.getText(),
							(String) comboBoxProfessorArea.getSelectedItem(), txtProfessorQntdPontos.getText());

					Object[][] dados = tlc.carregarTabelaProfessor("professor");
					tabelaProfessores.setModel(
							new javax.swing.table.DefaultTableModel(dados, new String[] { "CPF", "Nome", "Área", "Pontos" }));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnProfessorExcluir = new JButton("Excluir");
		btnProfessorExcluir.setBounds(745, 184, 77, 24);
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
		btnProfessorEditar.setBounds(658, 184, 77, 24);
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
					tlc.atualizarProfessor(professorCPFSelecionado, txtProfessorNome.getText(),
							comboBoxProfessorArea.getSelectedItem().toString(), txtProfessorQntdPontos.getText());
					JOptionPane.showMessageDialog(null, "Professor atualizado!");
					carregarTabelaProfessores(tabelaProfessores);
					professorCPFSelecionado = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		// =================================================================================
		// ABA CURSO
		// =================================================================================
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
		txtCursoCodigo.setBounds(175, 57, 67, 20);
		tabCurso.add(txtCursoCodigo);

		JButton btnCursoBuscar = new JButton("🔎");
		btnCursoBuscar.setBounds(254, 55, 49, 24);
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

		JComboBox<String> comboBoxCursoArea = new JComboBox<>();
		comboBoxCursoArea.setBounds(604, 56, 113, 22);
		tabCurso.add(comboBoxCursoArea);

		for (AreaConhecimento area : AreaConhecimento.values()) {
			comboBoxCursoArea.addItem(area.getDescricao());
		}

		JButton btnCursoLimparTela = new JButton("Limpar tela");
		btnCursoLimparTela.setBounds(288, 385, 112, 24);
		tabCurso.add(btnCursoLimparTela);

		btnCursoLimparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCursoCodigo.setText("");
				txtCursoNome.setText("");
				comboBoxCursoArea.setSelectedIndex(-1);
			}
		});

		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setBounds(446, 385, 112, 24);
		tabCurso.add(btnCursoCadastrar);

		btnCursoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaController tlc = new TelaController();
				try {
					tlc.cadastrarCurso(txtCursoCodigo.getText(), txtCursoNome.getText(),
							(String) comboBoxCursoArea.getSelectedItem());
					// Atualiza tabela
					Object[][] dados = tlc.carregarTabelaCurso("cursos");
					tabelaCurso.setModel(
							new javax.swing.table.DefaultTableModel(dados, new String[] { "Codigo", "Nome", "Área" }));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnCursoExcluir = new JButton("Excluir");
		btnCursoExcluir.setBounds(745, 184, 77, 24);
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
		scrollPaneCurso.setBounds(38, 215, 784, 159);
		tabCurso.add(scrollPaneCurso);

		String[] colunasCurso = { "Codigo", "Nome", "Área" };
		DefaultTableModel modelCurso = new DefaultTableModel(colunasCurso, 0);
		tabelaCurso = new JTable(modelCurso);
		scrollPaneCurso.setViewportView(tabelaCurso);

		carregarTabelaCursos(tabelaCurso);

		tabelaCurso.getSelectionModel().addListSelectionListener(event -> {
			if (carregandoTabela)
				return;
			if (!event.getValueIsAdjusting()) {
				int linha = tabelaCurso.getSelectedRow();
				if (linha != -1) {
					txtCursoCodigo.setText(tabelaCurso.getValueAt(linha, 0).toString());
					txtCursoNome.setText(tabelaCurso.getValueAt(linha, 1).toString());
					cursoCodSelecionado = tabelaCurso.getValueAt(linha, 0).toString();
				}
			}
		});

		JButton btnCursoEditar = new JButton("Editar");
		btnCursoEditar.setBounds(658, 184, 77, 24);
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
					tlc.atualizarCurso(cursoCodSelecionado, txtCursoNome.getText(),
							comboBoxCursoArea.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Curso atualizado!");
					carregarTabelaCursos(tabelaCurso);
					cursoCodSelecionado = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

	} // Fim do Construtor

	// =================================================================================
	// MÉTODOS AUXILIARES (FORA DO CONSTRUTOR)
	// =================================================================================

	private void carregarTabelaProfessores(JTable tabelaProfessores) {
		try {
			TelaController tlc = new TelaController();
			Object[][] dados = tlc.carregarTabelaProfessor("professor");

			DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
			model.setRowCount(0);

			for (Object[] linha : dados) {
				model.addRow(linha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// *** ESSE MÉTODO ESTAVA FALTANDO PARA A DISCIPLINA ***
	private void carregarTabelaDisciplina(JTable tabelaDiciplina) {
		try {
			TelaController tlc = new TelaController();
			Object[][] dados = tlc.carregarTabelaDisciplina("disciplina");

			DefaultTableModel model = (DefaultTableModel) tabelaDiciplina.getModel();
			model.setRowCount(0);

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

	public void mostrarProfessorConsultado(String cpf) {
		try {
			Fila<String> fila = new Fila<String>();
			TelaController tlc = new TelaController();
			fila = tlc.consultar(cpf);

			DefaultTableModel model = (DefaultTableModel) tabelaProfessores.getModel();
			model.setRowCount(0);

			while (!fila.isEmpty()) {
				String linha = fila.remove();
				String[] dados = linha.split(";");
				model.addRow(new Object[] { dados[0], dados[1], dados[2], dados[3] });
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
			model.setRowCount(0);

			while (!fila.isEmpty()) {
				String linha = fila.remove();
				String[] dados = linha.split(";");
				model.addRow(new Object[] { dados[0], dados[1], dados[2] });
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
			model.setRowCount(0);

			while (!fila.isEmpty()) {
				String linha = fila.remove();
				String[] dados = linha.split(";");
				// Ajuste conforme os dados da disciplina
				model.addRow(new Object[] { dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6] });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}