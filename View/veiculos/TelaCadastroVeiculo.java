package View.veiculos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;
import Core.Exception.RegraNegocioException;
import Core.Service.ClientService;
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
	private JTextField textFieldCor;
	private JComboBox comboBoxCnh;
	private JCheckBox alugado;
	private JComboBox<Object> comboBoxCnh_1;
	private JLabel titulo;
	private JButton cadastrar;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		titulo = new JLabel("Cadastro de veiculo");
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVeiculos tlv = new TelaListarVeiculos();
				tlv.setVisible(true);
				dispose();
			}
		});
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoEntity veiculo = new VeiculoEntity();
				
				veiculo.setMarca(textFieldMarca.getText());
				veiculo.setModelo(textFieldModelo.getText());
				veiculo.setPlaca(textFieldPlaca.getText());
				veiculo.setCor(textFieldCor.getText());
				veiculo.setLugares(Integer.parseInt(textFieldLugares.getText()));
				veiculo.setValorDiaria(Double.parseDouble(textFieldDiaria.getText()));
				veiculo.setCarteiraExigida(comboBoxCnh_1.getSelectedItem().toString());
				veiculo.setAlugado(alugado.isSelected());
				
				VeiculoService service = new VeiculoService();
				
				if(textFieldId.getText() != null && !textFieldId.getText().equalsIgnoreCase("")) { 
					
					veiculo.setId(Long.parseLong(textFieldId.getText()));
					
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
					
				TelaListarVeiculos tlv = new TelaListarVeiculos();
				tlv.setVisible(true);
				dispose();
			}
		});
		
		JComboBox<Object> comboBoxCnh = new JComboBox<Object>();
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		
		JLabel lblModelo = new JLabel("Modelo");
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblPlac = new JLabel("Placa");
		
		JLabel lblValorDiaria = new JLabel("Valor diaria");
		
		JLabel lblCor = new JLabel("Cor");
		
		alugado = new JCheckBox();
		
		comboBoxCnh_1 = new JComboBox<>();
		
		
		comboBoxCnh_1.addItem("ACC");
		comboBoxCnh_1.addItem("A");
		comboBoxCnh_1.addItem("B");
		comboBoxCnh_1.addItem("AB");
		comboBoxCnh_1.addItem("D");
		comboBoxCnh_1.addItem("E");
		
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
		
		JLabel lblCarteiraExigida = new JLabel("Carteira Exigida");
		
		textFieldCor = new JTextField();
		textFieldCor.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
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
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblMarca)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(lblPlac)))))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldCor, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(botaoVoltar, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(cadastrar, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(122)
											.addComponent(lblLugares, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldLugares, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(alugado)))
									.addGap(2)))
							.addGap(18)
							.addComponent(textFieldPlaca, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(62))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCarteiraExigida)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxCnh_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(334, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(titulo)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCor)
								.addComponent(textFieldCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLugares)
								.addComponent(textFieldLugares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(alugado))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarteiraExigida)
						.addComponent(comboBoxCnh_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cadastrar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public void carregarVeiculorId(Long id) {
		VeiculoEntity veiculo = new VeiculoEntity(); 
		try {
			veiculo = new VeiculoService().buscarPorId(id);
		} catch (RegraNegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFieldId.setText(veiculo.getId().toString());
		textFieldMarca.setText(veiculo.getMarca());
		textFieldCor.setText(veiculo.getCor());
		textFieldDiaria.setText(veiculo.getValorDiaria().toString());
		textFieldLugares.setText(Integer.toString(veiculo.getLugares()));
		textFieldModelo.setText(veiculo.getModelo());
		comboBoxCnh_1.setSelectedItem(veiculo.getCarteiraExigida());

		 
		titulo.setText("Alteração de Veiculo");
		cadastrar.setText("Atualizar");
		
	}
}
