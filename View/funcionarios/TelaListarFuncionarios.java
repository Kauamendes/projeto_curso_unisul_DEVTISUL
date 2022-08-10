package View.funcionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
import Core.Service.FuncionarioService;
import Core.Service.VeiculoService;
import View.veiculos.TelaCadastroVeiculo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaListarFuncionarios extends JFrame {

	private JPanel contentPane;
	private List<FuncionarioEntity> funcionarios;
	private JTable table;
	private JLabel titulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarFuncionarios frame = new TelaListarFuncionarios();
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
	public TelaListarFuncionarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.NORTH);
		
		JButton btnCadastroDeFuncionrio = new JButton("Cadastro de Funcion\u00E1rio");
		btnCadastroDeFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 TelaCadastroFuncionario tcf = new TelaCadastroFuncionario();
				tcf.setVisible(true);
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		titulo = new JLabel("Gerenciamento de Funcion\u00E1rios");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEntity funcionario = funcionarios.get(table.getSelectedRow());
				TelaCadastroFuncionario tcf = new TelaCadastroFuncionario();
				tcf.carregarFuncionarioPorId(funcionario.getId());
				tcf.setVisible(true);
				dispose();
			}
		});
		botaoEditar.setEnabled(false);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEntity funcionario = funcionarios.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o funcionario de id: "+funcionario.getId()) == JOptionPane.OK_OPTION) {
					try {
						new FuncionarioService().removerFuncioario(funcionario.getId());
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
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(147)
							.addComponent(btnCadastroDeFuncionrio))
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap(284, Short.MAX_VALUE)
					.addComponent(botaoEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botaoExcluir)
					.addContainerGap())
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(titulo)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoExcluir)
						.addComponent(botaoEditar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCadastroDeFuncionrio))
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
				"Id", "Nome", "CPF", "Email", "Telefone", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane_1.setLayout(gl_contentPane_1);
		popularTabela();
	}
	
	
	private void popularTabela() {
		try {
			funcionarios = new FuncionarioService().listarFuncionarios();
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  DefaultTableModel model = (DefaultTableModel) table.getModel();
		  model.getDataVector().removeAllElements();
		 
		
		for(FuncionarioEntity f : funcionarios) {
			model.addRow(new Object[] { f.getId(),
					   					f.getNome(), 
					   					f.getCPF(), 
					   					f.getEmail(), 
					   					f.getTelefone(),
					   					f.getSalario() });
		}
	}

}
