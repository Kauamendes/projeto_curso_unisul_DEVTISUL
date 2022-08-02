package View.veiculos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.Entity.ClienteEntity;
import Core.Entity.VeiculoEntity;
import Core.Service.ClientService;
import Core.Service.VeiculoService;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaListarVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<VeiculoEntity> veiculos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarVeiculos frame = new TelaListarVeiculos();
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
	public TelaListarVeiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblGerenciamentoDeVeiculos = new JLabel("Gerenciamento de Veiculos");
		lblGerenciamentoDeVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setEnabled(false);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoEntity veiculo = veiculos.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o veiculo de id: "+veiculo.getId()) == JOptionPane.OK_OPTION) {

					//popularTabela();
				}
			}
		});
		botaoExcluir.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCadastroDeVeiculos = new JButton("Cadastro de Veiculos");
		btnCadastroDeVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroVeiculo tcv = new TelaCadastroVeiculo();
				tcv.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(lblGerenciamentoDeVeiculos, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(264)
							.addComponent(botaoEditar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(botaoExcluir, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(245)
							.addComponent(btnCadastroDeVeiculos, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGerenciamentoDeVeiculos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoEditar)
						.addComponent(botaoExcluir))
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCadastroDeVeiculos)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Modelo", "Cor", "Marca", "Placa"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
