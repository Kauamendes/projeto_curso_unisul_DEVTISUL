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
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
import Core.Service.VeiculoService;
import View.clientes.TelaCadastroCliente;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblGerenciamentoDeVeiculos = new JLabel("Gerenciamento de Veiculos");
		lblGerenciamentoDeVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoEntity veiculo = veiculos.get(table.getSelectedRow());
				TelaCadastroVeiculo tcv = new TelaCadastroVeiculo();
				tcv.carregarVeiculorId(veiculo.getId());
				tcv.setVisible(true);
				dispose();
			}
		});
		botaoEditar.setEnabled(false);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoEntity veiculo = veiculos.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o veiculo de id: "+veiculo.getId()) == JOptionPane.OK_OPTION) {
					try {
						new VeiculoService().removerVeiculo(veiculo.getId());
						popularTabela();
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				botaoExcluir.setEnabled(false);
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(lblGerenciamentoDeVeiculos, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(205)
							.addComponent(botaoEditar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(botaoExcluir, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(245)
							.addComponent(btnCadastroDeVeiculos, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGerenciamentoDeVeiculos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoExcluir, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoEditar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCadastroDeVeiculos)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botaoExcluir.setEnabled(true);
				botaoEditar.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		popularTabela();
	}
	
	
	private void popularTabela() {
		try {
			veiculos = new VeiculoService().listarVeiculos();
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		
		for(VeiculoEntity v : veiculos) {
			model.addRow(new Object[] { v.getId(),
									   v.getModelo(),
									   v.getCor(),
									   v.getMarca(),
									   v.getPlaca() });
		}
	}
}
