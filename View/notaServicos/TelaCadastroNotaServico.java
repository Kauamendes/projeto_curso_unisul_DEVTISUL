package View.notaServicos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Entity.ClienteEntity;
import Core.Entity.NotaServicoEntity;
import Core.Entity.VeiculoEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
import Core.Service.NotaServicoService;
import Core.Service.VeiculoService;
import View.clientes.telaListarCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroNotaServico extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField diasAlugados;
	private JComboBox<String> comboBoxClientes;
	private JComboBox<String> comboBoxVeiculos;
	private List<ClienteEntity> clientes = new ArrayList<>();
	private List<VeiculoEntity> veiculos = new ArrayList<>();
	private JLabel Titulo;
	private JButton BotaoCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroNotaServico frame = new TelaCadastroNotaServico();
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
	public TelaCadastroNotaServico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 Titulo = new JLabel("Cadastro de Nota de Servi\u00E7o");
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarNotaServico tlns = new TelaListarNotaServico();
				tlns.setVisible(true);
				dispose();
			}
		});
		
		BotaoCadastrar = new JButton("Cadastrar");
		BotaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotaServicoEntity nota = new NotaServicoEntity();
				NotaServicoService service = new NotaServicoService();
				
				ClientService clienteService = new ClientService();
				VeiculoService veiculoService = new VeiculoService();
				
				nota.setCliente(clienteService.buscarPorId(clientes.get(comboBoxClientes.getSelectedIndex()).getId()));
				try {
					nota.setVeiculoAlugado(veiculoService.buscarPorId(veiculos.get(comboBoxVeiculos.getSelectedIndex()).getId()));
				} catch (RegraNegocioException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				nota.setDiasAlugados(Integer.parseInt(diasAlugados.getText()));
				
				if(textId.getText() != null && !textId.getText().equalsIgnoreCase("")) { 
					
					nota.setId(Long.parseLong(textId.getText()));
					
					try {
						JOptionPane.showMessageDialog(null, service.atualizarNotaServico(nota));
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
				} else {
					try {
						JOptionPane.showMessageDialog(null, service.salvarNotaServico(nota));
					} catch (HeadlessException | RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
				}
					
				TelaListarNotaServico tlns = new TelaListarNotaServico();
				tlns.setVisible(true);
				dispose();
			}
		});
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setEditable(false);
		textId.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo");
		
		JLabel lblNewLabel_6_1 = new JLabel("Cliente");
		
		JLabel lblNewLabel_6_2 = new JLabel("Veiculo");
		
		JLabel lblNewLabel_6_3 = new JLabel("Dias alugados");
		
		diasAlugados = new JTextField();
		diasAlugados.setColumns(10);
		
		 comboBoxClientes = new JComboBox();
		
		 comboBoxVeiculos = new JComboBox();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(botaoVoltar)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(52)
									.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(diasAlugados, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(67)
									.addComponent(BotaoCadastrar))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6_2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxVeiculos, 0, 272, Short.MAX_VALUE)
								.addComponent(comboBoxClientes, 0, 272, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(Titulo, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
					.addContainerGap(19, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Titulo)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_6)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_6_3)
							.addComponent(diasAlugados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6_1)
							.addGap(18)
							.addComponent(lblNewLabel_6_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBoxClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxVeiculos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotaoCadastrar)
						.addComponent(botaoVoltar))
					.addGap(44))
		);
		contentPane.setLayout(gl_contentPane);
		listarClientes();
		listarVeiculos();
	}
	
	public void listarClientes() {
		
		clientes = new ClientService().listarClientes();
		for(ClienteEntity c : clientes) {
			comboBoxClientes.addItem(c.getNome());
		}
			
	}
	
	public void listarVeiculos() {
		
		try {
			veiculos = new VeiculoService().listarVeiculos();
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(VeiculoEntity v : veiculos) {
			comboBoxVeiculos.addItem(v.getModelo());
		}
			
	}
	
	public void carregarNotaPorId(Long id) {
		NotaServicoEntity nota = new NotaServicoEntity();
		try {
			nota = new NotaServicoService().buscarPorId(id);
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textId.setText(nota.getId().toString());
		diasAlugados.setText(Integer.toString(nota.getDiasAlugados()));
		comboBoxClientes.setSelectedItem(nota.getCliente().getNome());
		comboBoxVeiculos.setSelectedItem(nota.getVeiculoAlugado().getModelo());
		 
		Titulo.setText("Alteração de Nota de Serviço");
		BotaoCadastrar.setText("Atualizar");
		
	}

}
