import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Wind_ControleClientes {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_ControleClientes window = new Wind_ControleClientes();
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
	public Wind_ControleClientes() throws IOException {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 773, 333);
		frame.getContentPane().add(scrollPane);
		
		String[] columns = {"Nome", "CPF", "Telefone"};
		ClienteDAO clientesBD = new ClienteDAO();
		
		table = new JTable(clientesBD.tabelaClientes(), columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(logo));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("CONTROLE DE CLIENTES:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(243, 10, 329, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 419, 108, 36);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_Inicial wind = null;
				try {
					wind = new Wind_Inicial();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.setForeground(new Color(51, 102, 153));
		btnGerarRelatrio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGerarRelatrio.setBackground(Color.WHITE);
		btnGerarRelatrio.setBounds(638, 419, 145, 36);
		frame.getContentPane().add(btnGerarRelatrio);
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_RelatorioClientes wind = null;
				try {
					wind = new Wind_RelatorioClientes();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnRemoo = new JButton("Descadastrar");
		btnRemoo.setForeground(new Color(51, 102, 153));
		btnRemoo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRemoo.setBackground(Color.WHITE);
		btnRemoo.setBounds(500, 419, 128, 36);
		frame.getContentPane().add(btnRemoo);
		btnRemoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// REMOVER CLIENTE PELO CPF INFORMADO
				String cpf = JOptionPane.showInputDialog(null, "Digite o CPF que deseja descadastrar:", "Descadastração de Cliente", JOptionPane.QUESTION_MESSAGE);
				
				// se o cpf informado não estiver no BD
				if(clientesBD.getCliente(cpf) == null) {
					JOptionPane.showMessageDialog(null, "Este CPF não está cadastrado.", "Usuário não encontrado", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// se por algum motivo não for possível descadastrar o cliente
					if(clientesBD.removerCliente(clientesBD.getCliente(cpf)) == false) {
						JOptionPane.showMessageDialog(null, "Não foi possível descadastrar o cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
					} else {
						// foi possível fazer a descadastração 
						JOptionPane.showMessageDialog(null, "Cliente descadastrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						String[] columns = {"Nome", "CPF", "Telefone"};
						ClienteDAO clientesBD = new ClienteDAO();
						
						table = new JTable(clientesBD.tabelaClientes(), columns);
						table.setFillsViewportHeight(true);
						table.setEnabled(false);
						table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
						scrollPane.setViewportView(table);
					}
				}
			}
		});
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setForeground(new Color(51, 102, 153));
		btnCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCadastro.setBackground(Color.WHITE);
		btnCadastro.setBounds(397, 420, 93, 35);
		frame.getContentPane().add(btnCadastro);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_NewCliente wind = null;
				try {
					wind = new Wind_NewCliente();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});

	}
}
