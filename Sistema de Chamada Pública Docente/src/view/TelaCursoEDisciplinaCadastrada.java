package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCursoEDisciplinaCadastrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel tabConsulta;

	/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCursoEDisciplinaCadastrada frame = new TelaCursoEDisciplinaCadastrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCursoEDisciplinaCadastrada() {
		setForeground(Color.BLACK);
		setTitle("Sistema de chamada pública");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		tabConsulta = new JPanel();
		tabConsulta.setForeground(new Color(34, 40, 49));
		tabConsulta.setBackground(new Color(34, 40, 49));
		tabConsulta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabConsulta);
		tabConsulta.setLayout(null);
		
		JButton btnCarregarConsulta = new JButton("Listar Processos Abertos");
        btnCarregarConsulta.setBounds(39, 82, 200, 30);
        tabConsulta.add(btnCarregarConsulta);
		
		
        
        JScrollPane scrollPaneConsulta = new JScrollPane();
        scrollPaneConsulta.setBounds(39, 123, 783, 300);
        tabConsulta.add(scrollPaneConsulta);

        JTable tabelaConsulta = new JTable();
        tabelaConsulta.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cód. Disciplina", "Disciplina", "Cód. Curso", "Processo" }
        ));
        scrollPaneConsulta.setViewportView(tabelaConsulta);
        
        JLabel lblProcessoAberto = new JLabel("Processos abertos");
        lblProcessoAberto.setForeground(Color.WHITE);
        lblProcessoAberto.setFont(new Font("Arial", Font.PLAIN, 16));
        lblProcessoAberto.setBounds(361, 36, 179, 22);
        tabConsulta.add(lblProcessoAberto);

        // Ação do Botão
        btnCarregarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Instancia o controller novo
                    controller.ConsultaController consultaCtrl = new controller.ConsultaController();
                    
                    // Pega os dados vindos da Hash Table
                    Object[][] dados = consultaCtrl.listarTodosProcessos();
                    
                    // Joga na tabela
                    DefaultTableModel model = (DefaultTableModel) tabelaConsulta.getModel();
                    model.setRowCount(0); // Limpa
                    
                    for (Object[] linha : dados) {
                        model.addRow(linha);
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao consultar processos: " + ex.getMessage());
                }
            }
        });
		
		
	}
}
