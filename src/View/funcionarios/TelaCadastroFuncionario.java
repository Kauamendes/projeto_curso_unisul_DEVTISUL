package View.funcionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
import Core.Service.FuncionarioService;
import View.clientes.telaListarCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField TextId;
	private JTextField textFieldSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblCadastroDeFuncinario = new JLabel("Cadastro de funcion\u00E1rio");
		lblCadastroDeFuncinario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton botaoVoltar = new JButton("Voltar");
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEntity funcionario = new FuncionarioEntity();
				funcionario.setId(Long.parseLong(TextId.getText()));
				funcionario.setNome(textFieldNome.getText());
				funcionario.setCPF(textFieldCPF.getText());
				funcionario.setEmail(textFieldEmail.getText());
				funcionario.setTelefone(textFieldTelefone.getText());
				funcionario.setSalario(Double.parseDouble(textFieldSalario.getText()));
				FuncionarioService service = new FuncionarioService();
				
				if(funcionario.getId() != null) { 
					try {
						JOptionPane.showMessageDialog(null, service.atualizarFuncionario(funcionario));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						JOptionPane.showMessageDialog(null, service.salvarFuncionario(funcionario));
					} catch (RegraNegocioException e1) {
						e1.getMessage();
					}
				}
					
				telaListarCliente tlc = new telaListarCliente();
				tlc.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo");
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		
		TextId = new JTextField();
		TextId.setEnabled(false);
		TextId.setEditable(false);
		TextId.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Sal\u00E1rio");
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGap(89)
					.addComponent(botaoVoltar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(29))
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_6))
					.addGap(18)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
								.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
								.addGroup(gl_contentPane_1.createSequentialGroup()
									.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(25))
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addComponent(TextId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(Alignment.TRAILING, gl_contentPane_1.createSequentialGroup()
					.addContainerGap(147, Short.MAX_VALUE)
					.addComponent(lblCadastroDeFuncinario, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addComponent(lblCadastroDeFuncinario)
					.addGap(26)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(TextId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_4_1)
							.addComponent(textFieldSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(botaoVoltar))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane_1.setLayout(gl_contentPane_1);
	}

}
