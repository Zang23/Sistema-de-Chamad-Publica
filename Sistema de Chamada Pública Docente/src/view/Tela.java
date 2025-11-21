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


public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

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

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		
		setForeground(Color.BLACK);
		setTitle("Chamada pública");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(34, 40, 49));
		contentPane.setBackground(new Color(24, 29, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(223, 208, 184));
		tabbedPane.setBounds(10, 11, 604, 339);
		contentPane.add(tabbedPane);
		
		JPanel tabDiciplina = new JPanel();
		tabDiciplina.setBorder(null);
		tabDiciplina.setForeground(new Color(0, 0, 0));
		tabDiciplina.setBackground(new Color(49, 54, 63));
		tabbedPane.addTab("Diciplina", null, tabDiciplina, "Cadastro de diciplinas");
		tabbedPane.setBackgroundAt(0, new Color(64, 0, 64));
		tabDiciplina.setLayout(null);
		
		JLabel lblDiciplinaNome = new JLabel("Nome ");
		lblDiciplinaNome.setBackground(new Color(0, 0, 0));
		lblDiciplinaNome.setForeground(new Color(255, 255, 255));
		lblDiciplinaNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaNome.setBounds(35, 33, 49, 34);
		tabDiciplina.add(lblDiciplinaNome);
		
		JLabel lblDicilpinaCodigoDiciplina = new JLabel("Codigo da diciplina");
		lblDicilpinaCodigoDiciplina.setForeground(new Color(255, 255, 255));
		lblDicilpinaCodigoDiciplina.setBackground(new Color(255, 255, 255));
		lblDicilpinaCodigoDiciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDicilpinaCodigoDiciplina.setBounds(35, 5, 112, 34);
		tabDiciplina.add(lblDicilpinaCodigoDiciplina);
		
		JLabel lblDiciplinaDia = new JLabel("Dia da diciplina");
		lblDiciplinaDia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaDia.setForeground(new Color(255, 255, 255));
		lblDiciplinaDia.setBackground(new Color(255, 255, 255));
		lblDiciplinaDia.setBounds(35, 65, 98, 34);
		tabDiciplina.add(lblDiciplinaDia);
		
		JLabel lblDiciplinaHorario = new JLabel("Horario");
		lblDiciplinaHorario.setForeground(new Color(255, 255, 255));
		lblDiciplinaHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaHorario.setBounds(35, 95, 61, 34);
		tabDiciplina.add(lblDiciplinaHorario);
		
		JLabel lblDiciplinaQuantAula = new JLabel("Aula diária");
		lblDiciplinaQuantAula.setForeground(new Color(255, 255, 255));
		lblDiciplinaQuantAula.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaQuantAula.setBounds(321, 11, 77, 23);
		tabDiciplina.add(lblDiciplinaQuantAula);
		
		JLabel lblDiciplinaCodCurso = new JLabel("Código do curso");
		lblDiciplinaCodCurso.setForeground(new Color(255, 255, 255));
		lblDiciplinaCodCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaCodCurso.setBounds(321, 39, 112, 23);
		tabDiciplina.add(lblDiciplinaCodCurso);
		
		JLabel lblDiciplinaCodProcesso = new JLabel("Código do processo");
		lblDiciplinaCodProcesso.setForeground(new Color(255, 255, 255));
		lblDiciplinaCodProcesso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiciplinaCodProcesso.setBounds(321, 71, 128, 23);
		tabDiciplina.add(lblDiciplinaCodProcesso);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBounds(107, 41, 180, 20);
		tabDiciplina.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(167, 13, 61, 20);
		tabDiciplina.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(183, 103, 101, 20);
		tabDiciplina.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(461, 41, 77, 20);
		tabDiciplina.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(461, 73, 77, 20);
		tabDiciplina.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setBounds(461, 12, 77, 22);
		tabDiciplina.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_1.setBounds(183, 72, 101, 22);
		tabDiciplina.add(comboBox_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 162, 525, 138);
		tabDiciplina.add(textArea);
		
		JButton btnNewButton = new JButton("🔎");
		btnNewButton.setBounds(238, 12, 49, 23);
		tabDiciplina.add(btnNewButton);

	}
}
