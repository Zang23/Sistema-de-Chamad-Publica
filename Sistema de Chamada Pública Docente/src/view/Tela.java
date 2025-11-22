package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.List;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;


public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblDiciplinaCodProcesso = new JLabel("Código do processo");
		lblDiciplinaCodProcesso.setBounds(507, 124, 128, 23);
		lblDiciplinaCodProcesso.setForeground(new Color(255, 255, 255));
		lblDiciplinaCodProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(lblDiciplinaCodProcesso);
		
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
		
		txtDiciplinaCodigoProcesso = new JTextField();
		txtDiciplinaCodigoProcesso.setBounds(665, 125, 77, 20);
		txtDiciplinaCodigoProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiciplinaCodigoProcesso.setColumns(10);
		tabDiciplina.add(txtDiciplinaCodigoProcesso);
		
		JComboBox comboBoxDiciplinaAulaDiaria = new JComboBox();
		comboBoxDiciplinaAulaDiaria.setBounds(665, 56, 77, 22);
		comboBoxDiciplinaAulaDiaria.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxDiciplinaAulaDiaria);
		
		JComboBox comboBoxDiciplinaDia = new JComboBox();
		comboBoxDiciplinaDia.setBounds(211, 160, 101, 22);
		comboBoxDiciplinaDia.setFont(new Font("Arial", Font.PLAIN, 12));
		tabDiciplina.add(comboBoxDiciplinaDia);
		
		JButton btnDiciplinaBuscar = new JButton("🔎");
		btnDiciplinaBuscar.setBounds(774, 194, 49, 24);
		tabDiciplina.add(btnDiciplinaBuscar);
		
		JScrollPane scrollPaneDiciplina = new JScrollPane();
		scrollPaneDiciplina.setBounds(39, 234, 783, 159);
		tabDiciplina.add(scrollPaneDiciplina);
		
		JButton btnDiciplinaCadastrar = new JButton("Cadastrar");
		btnDiciplinaCadastrar.setBounds(640, 194, 112, 24);
		tabDiciplina.add(btnDiciplinaCadastrar);
		
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
		
		JScrollPane scrollPaneProfessor = new JScrollPane();
		scrollPaneProfessor.setBounds(39, 234, 783, 159);
		tabProfessor.add(scrollPaneProfessor);
		
		JButton btnProfessorLimparTela = new JButton("Limpar tela");
		btnProfessorLimparTela.setBounds(507, 194, 112, 24);
		tabProfessor.add(btnProfessorLimparTela);
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setBounds(640, 194, 112, 24);
		tabProfessor.add(btnProfessorCadastrar);
		
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
		
		JButton btnCursoLimparTela = new JButton("Limpar tela");
		btnCursoLimparTela.setBounds(507, 194, 112, 24);
		tabCurso.add(btnCursoLimparTela);
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setBounds(640, 194, 112, 24);
		tabCurso.add(btnCursoCadastrar);
		
		JScrollPane scrollPaneCurso = new JScrollPane();
		scrollPaneCurso.setBounds(39, 234, 783, 159);
		tabCurso.add(scrollPaneCurso);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(227, 57, 72, 20);
		tabInscricao.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(227, 104, 72, 20);
		tabInscricao.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(610, 57, 72, 20);
		tabInscricao.add(textField_2);
		
		JButton btnCursoLimparTela_1 = new JButton("Limpar tela");
		btnCursoLimparTela_1.setBounds(507, 194, 112, 24);
		tabInscricao.add(btnCursoLimparTela_1);
		
		JButton btnCursoCadastrar_1 = new JButton("Cadastrar");
		btnCursoCadastrar_1.setBounds(640, 194, 112, 24);
		tabInscricao.add(btnCursoCadastrar_1);
		
		JButton btnCursoBuscar_1 = new JButton("🔎");
		btnCursoBuscar_1.setBounds(774, 194, 49, 24);
		tabInscricao.add(btnCursoBuscar_1);
		
		JScrollPane scrollPaneCurso_1 = new JScrollPane();
		scrollPaneCurso_1.setBounds(39, 234, 783, 159);
		tabInscricao.add(scrollPaneCurso_1);

	}
}
