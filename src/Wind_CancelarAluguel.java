import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Wind_CancelarAluguel {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_CancelarAluguel window = new Wind_CancelarAluguel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wind_CancelarAluguel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Vault Storage App");
		frame.setBounds(100, 100, 807, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblCancelarAluguelPor = new JLabel("CANCELAR ALUGUEL POR CPF:");
		lblCancelarAluguelPor.setBounds(212, 10, 351, 36);
		lblCancelarAluguelPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarAluguelPor.setForeground(new Color(0, 102, 153));
		lblCancelarAluguelPor.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblCancelarAluguelPor.setBackground(Color.WHITE);
		frame.getContentPane().add(lblCancelarAluguelPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 773, 249);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(108, 69, 368, 36);
		textField.setToolTipText("digite seu cpf (somente n\u00FAmeros)");
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		JButton btnEnter = new JButton("Listar alugu\u00E9is");
		btnEnter.setToolTipText("clique aqui ap\u00F3s ter preenchido com o cpf");
		btnEnter.setForeground(new Color(51, 102, 153));
		btnEnter.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnEnter.setBackground(Color.WHITE);
		btnEnter.setBounds(603, 69, 134, 36);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO clienteDAO = new ClienteDAO();
				// VERIFICAÇÃO NÚMERO DE CARACTERES DO CAMPO CPF 
				int flag = 0;
				if (textField.getText().isEmpty() || textField.getText().length() > 11) {
					JOptionPane.showMessageDialog(null, "Confira o campo Cpf!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else { flag ++;} 
				// VERIFICAÇÃO SE CLIENTE ESTÁ CADASTRADO NA BASE DE DADOS
				if ((clienteDAO.getCliente(textField.getText()) == null) && (flag == 1)) {
					JOptionPane.showMessageDialog(null, "Este cpf não está cadastrado no banco de dados", "Usuário não encontrado", JOptionPane.WARNING_MESSAGE);
				} else {
					String[] columns = {"Número", "Categoria", "Início", "Término", "Custo Mês", "Meses", "Custo Local", "Custo Opc.", "Custo Total"};
					LocaisDAO locaisBD = new LocaisDAO();
					
					table = new JTable(locaisBD.tabelaAlugadosPorCpf(textField.getText()), columns);
					table.setFillsViewportHeight(true);
					table.setEnabled(false);
					table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
					scrollPane.setViewportView(table);
				}
			}
		});
		
		JButton btnRemoo = new JButton("Remover Aluguel");
		btnRemoo.setForeground(new Color(51, 102, 153));
		btnRemoo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRemoo.setBackground(Color.WHITE);
		btnRemoo.setBounds(586, 408, 151, 36);
		frame.getContentPane().add(btnRemoo);
		btnRemoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocaisDAO locaisDAO = new LocaisDAO();
				String numero = JOptionPane.showInputDialog(null, "Digite o número do aluguel que deseja cancelar:", "Cancelamento de Aluguel", JOptionPane.QUESTION_MESSAGE);
				
				// VERTIFICANDO SE O CPF DIGITADO BATE COM O CPF REGISTRADO NO NÚMERO DO ALUGUEL
				if(locaisDAO.cancelaAluguel(textField.getText(), numero) == true) {
					JOptionPane.showMessageDialog(null, "Aluguel Cancelado com Sucesso!", "Aluguel Cancelado", JOptionPane.INFORMATION_MESSAGE, 
							new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
					String[] columns = {"Número", "Categoria", "Início", "Término", "Custo Mês", "Meses", "Custo Local", "Custo Opc.", "Custo Total"};
					LocaisDAO locaisBD = new LocaisDAO();
					
					table = new JTable(locaisBD.tabelaAlugadosPorCpf(textField.getText()), columns);
					table.setFillsViewportHeight(true);
					table.setEnabled(false);
					table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
					scrollPane.setViewportView(table);
				} else {
					JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum aluguel com este Número e este Cpf!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setBounds(54, 408, 108, 36);
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisAlugados wind = new Wind_LocaisAlugados();
				wind.main(null);
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setBounds(54, 68, 43, 36);
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("somente n\u00FAmeros (11 d\u00EDgitos)");
		lblNewLabel_2_1.setBounds(108, 106, 184, 16);
		lblNewLabel_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		frame.getContentPane().add(lblNewLabel_2_1);
		
	}
}
