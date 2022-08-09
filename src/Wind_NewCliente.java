import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Wind_NewCliente {

	private JFrame frame;
	private JTextField txtDigiteSeuNome;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_NewCliente window = new Wind_NewCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Wind_NewCliente() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		frame = new JFrame("Vault Storage App");
		frame.setBounds(100, 100, 807, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		URL url = new URL("https://raw.githubusercontent.com/NathSantos/Sistema-de-Self-Storage/main/icon.png");
		BufferedImage logo = ImageIO.read(url);
		
		JLabel lblNewLabel = new JLabel("CADASTRE UM NOVO CLIENTE VAULT:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNewLabel.setBounds(208, 20, 388, 36);
		frame.getContentPane().add(lblNewLabel);
		
		txtDigiteSeuNome = new JTextField();
		txtDigiteSeuNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		txtDigiteSeuNome.setToolTipText("digite seu nome e sobrenome");
		txtDigiteSeuNome.setBounds(228, 110, 368, 36);
		frame.getContentPane().add(txtDigiteSeuNome);
		txtDigiteSeuNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1.setBounds(158, 109, 60, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("digite seu cpf (somente n\u00FAmeros)");
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(228, 178, 368, 36);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(174, 177, 43, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("digite seu telefone para contato");
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(228, 255, 368, 36);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(125, 254, 98, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(158, 376, 228, 44);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_ControleClientes wind = null;
				try {
					wind = new Wind_ControleClientes();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.setForeground(new Color(51, 102, 153));
		btnProsseguir.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnProsseguir.setBackground(Color.WHITE);
		btnProsseguir.setBounds(418, 376, 228, 44);
		frame.getContentPane().add(btnProsseguir);
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//se fosse inteiro: = Integer.parseInt(textField.getText());
				String nome = txtDigiteSeuNome.getText();
				String cpf = textField.getText();
				String telefone = textField_1.getText();
				
				// VERIFICAÇÃO NÚMERO DE CARACTERES DE CADA CAMPO
				int flag = 0;
				if (txtDigiteSeuNome.getText().isEmpty() || txtDigiteSeuNome.getText().length() > 40) {
					JOptionPane.showMessageDialog(null, "Confira o campo Nome!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else { flag ++;} 
				if (textField.getText().isEmpty() || textField.getText().length() > 11) {
					JOptionPane.showMessageDialog(null, "Confira o campo Cpf!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else { flag ++;} 
				if (textField_1.getText().isEmpty() || textField_1.getText().length() > 9) {
					JOptionPane.showMessageDialog(null, "Confira o campo Telefone!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else { flag ++;} 

				// VERIFICAÇÃO SE O USUÁRIO PREENCHEU TODOS OS CAMPOS
				if(flag == 3) {
					if ((txtDigiteSeuNome.getText().length()>0) && (textField.getText().length()> 0)
							&& (textField_1.getText().length() > 0)) {
							
							Cliente cliente = new Cliente(nome, cpf, telefone);
							
							// PERSISTINDO O OBJETO NO BANCO DE DADOS
							ClienteDAO clienteDAO = new ClienteDAO();
							if(clienteDAO.adicionarCliente(cliente) == true) {
								JOptionPane.showMessageDialog(null, "Cliente Vault Cadastrado com Sucesso!", "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon(logo));
								Wind_ControleClientes wind = null;
								try {
									wind = new Wind_ControleClientes();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								wind.main(null);
							}
							else {
								JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado.", "Usuário já existente", JOptionPane.INFORMATION_MESSAGE);
							}
							
				        } else {
				            JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						}	
				}	
			}
		});
		
		JLabel lblNewLabel_2_1 = new JLabel("somente n\u00FAmeros (11 d\u00EDgitos)");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(228, 215, 184, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("somente n\u00FAmeros (9 d\u00EDgitos)");
		lblNewLabel_2_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(228, 290, 184, 16);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("m\u00E1x. 40 caracteres");
		lblNewLabel_2_1_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(228, 145, 184, 16);
		frame.getContentPane().add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(logo));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
