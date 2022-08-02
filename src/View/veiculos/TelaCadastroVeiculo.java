package View.veiculos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.FuncionarioService;
import Core.Service.VeiculoService;
import View.clientes.telaListarCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldModelo;
	private JTextField textFieldMarca;
	private JTextField textFieldPlaca;
	private JTextField textFieldDiaria;
	private JTextField textFieldLugares;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVeiculo frame = new TelaCadastroVeiculo();
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
	public TelaCadastroVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCadastroDeVeiculo = new JLabel("Cadastro de veiculo");
		
		JButton botaoVoltar = new JButton("Voltar");
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoEntity veiculo = new VeiculoEntity();
				veiculo.setId(Long.parseLong(textFieldId.getText()));
				veiculo.setMarca(textFieldMarca.getText());
				veiculo.setModelo(textFieldModelo.getText());
				veiculo.setPlaca(textFieldPlaca.getText());
				
				VeiculoService service = new VeiculoService();
				
				if(veiculo.getId() != null) { 
					try {
						JOptionPane.showMessageDialog(null, service.atualizarVeiculo(veiculo));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RegraNegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						JOptionPane.showMessageDialog(null, service.salvarVeiculo(veiculo));
					} catch (RegraNegocioException e1) {
						e1.getMessage();
					}
				}
					
				telaListarCliente tlc = new telaListarCliente();
				tlc.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Carteira exigida");
		
		JComboBox<Object> comboBoxCnh = new JComboBox<Object>();
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		
		JLabel lblModelo = new JLabel("Modelo");
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblPlac = new JLabel("Placa");
		
		JLabel lblValorDiaria = new JLabel("Valor diaria");
		
		JLabel lblCor = new JLabel("Cor");
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setEditable(false);
		textFieldId.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setColumns(10);
		
		textFieldDiaria = new JTextField();
		textFieldDiaria.setColumns(10);
		
		JLabel lblLugares = new JLabel("Lugares");
		
		textFieldLugares = new JTextField();
		textFieldLugares.setColumns(10);
		
		JCheckBox alugado = new JCheckBox("Alugado");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCor)
							.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
							.addComponent(lblCadastroDeVeiculo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(151, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(botaoVoltar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(comboBoxCnh, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblLugares, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldLugares, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblValorDiaria)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldDiaria, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblModelo))
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblMarca)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblPlac)))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(15)
									.addComponent(alugado))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
							.addGap(61))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeVeiculo)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMarca)
						.addComponent(lblPlac)
						.addComponent(lblModelo)
						.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorDiaria)
						.addComponent(textFieldDiaria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxCnh, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblLugares)
							.addComponent(textFieldLugares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(alugado)))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoVoltar)
						.addComponent(btnNewButton))
					.addGap(12)
					.addComponent(lblCor)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
