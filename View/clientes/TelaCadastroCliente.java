package View.clientes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Entity.ClienteEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField TextId;
	private JComboBox comboBoxCnh;
	private JLabel Titulo;
	private JButton botaoCadastrar = new JButton("Cadastrar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Formulario cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Titulo = new JLabel("Cadastro de cliente");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		
		JLabel lblNewLabel_5 = new JLabel("Carteira motorista");
		
		
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		
		comboBoxCnh = new JComboBox<>();
		
		
		comboBoxCnh.addItem("ACC");
		comboBoxCnh.addItem("A");
		comboBoxCnh.addItem("B");
		comboBoxCnh.addItem("AB");
		comboBoxCnh.addItem("D");
		comboBoxCnh.addItem("E");
		
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteEntity cliente = new ClienteEntity();
				
				cliente.setNome(textFieldNome.getText());
				cliente.setCPF(textFieldCPF.getText());
				cliente.setEmail(textFieldEmail.getText());
				cliente.setTelefone(textFieldTelefone.getText());
				cliente.setCarteiraMotorista(comboBoxCnh.getSelectedItem().toString());
				ClientService service = new ClientService();
				
				if(TextId.getText() != null && !TextId.getText().equalsIgnoreCase("")) { 
					
					cliente.setId(Long.parseLong(TextId.getText()));
					
					try {
						JOptionPane.showMessageDialog(null, service.atualizarCliente(cliente));
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
				} else {
					try {
						JOptionPane.showMessageDialog(null, service.salvarCliente(cliente));
					} catch (HeadlessException | RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
				}
					
				telaListarCliente tlc = new telaListarCliente();
				tlc.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo");
		
		TextId = new JTextField();
		TextId.setEnabled(false);
		TextId.setEditable(false);
		TextId.setColumns(10);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListarCliente tlc = new telaListarCliente();
				tlc.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(botaoVoltar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botaoCadastrar)))
					.addGap(29))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_6))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxCnh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)))
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(TextId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Titulo)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(TextId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(comboBoxCnh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoCadastrar)
						.addComponent(botaoVoltar))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public void carregarUsuarioPorId(Long id) {
		ClienteEntity cliente = new ClientService().buscarPorId(id);
		TextId.setText(cliente.getId().toString());
		textFieldNome.setText(cliente.getNome());
		textFieldCPF.setText(cliente.getCPF());
		textFieldEmail.setText(cliente.getEmail());
		textFieldTelefone.setText(cliente.getTelefone());
		comboBoxCnh.setSelectedItem(cliente.getCarteiraMotorista());
		 
		Titulo.setText("Alteração de Cliente");
		botaoCadastrar.setText("Atualizar");
		
	}
	
}
