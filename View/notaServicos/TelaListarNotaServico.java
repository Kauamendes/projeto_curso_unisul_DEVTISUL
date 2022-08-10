package View.notaServicos;

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
import Core.Entity.FuncionarioEntity;
import Core.Entity.NotaServicoEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
import Core.Service.FuncionarioService;
import Core.Service.NotaServicoService;
import View.clientes.TelaCadastroCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaListarNotaServico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<NotaServicoEntity> notas = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarNotaServico frame = new TelaListarNotaServico();
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
	public TelaListarNotaServico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblGerenciamentoDeNotas = new JLabel("Gerenciamento de Notas de Servi\u00E7o");
		lblGerenciamentoDeNotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotaServicoEntity nota = notas.get(table.getSelectedRow());
				TelaCadastroNotaServico tcns = new TelaCadastroNotaServico();
				tcns.carregarNotaPorId(nota.getId());
				tcns.setVisible(true);
				dispose();
			}
		});
		botaoEditar.setEnabled(false);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotaServicoEntity nota = notas.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Voc� realmente deseja excluir o cliente de id: "+nota.getId()) == JOptionPane.OK_OPTION) {
					try {
						new NotaServicoService().removerNotaServico(nota.getId());
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					popularTabela();
				}
			}
		});
		botaoExcluir.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCadastroDeNota = new JButton("Cadastro de Nota de Servi\u00E7o");
		btnCadastroDeNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroNotaServico tcns = new TelaCadastroNotaServico();
				tcns.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(35, Short.MAX_VALUE)
							.addComponent(btnCadastroDeNota, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(85))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(287, Short.MAX_VALUE)
					.addComponent(botaoEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botaoExcluir)
					.addGap(53))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addComponent(lblGerenciamentoDeNotas, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGerenciamentoDeNotas)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(botaoEditar)
						.addComponent(botaoExcluir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCadastroDeNota)
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
				"Id", "Dias alugados", "Valor", "Modelo", "Cliente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	
	
	private void popularTabela() {
		
		try {
			 notas = new NotaServicoService().listarNotaServico();
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  DefaultTableModel model = (DefaultTableModel) table.getModel();
		  model.getDataVector().removeAllElements();
		 
		
		for(NotaServicoEntity n : notas) {
			model.addRow(new Object[] { n.getId(),
										n.getDiasAlugados(),
										n.getVeiculoAlugado().getValorDiaria()*n.getDiasAlugados(),
										n.getVeiculoAlugado().getModelo(),
										n.getCliente().getNome()});
		}
	}

}
