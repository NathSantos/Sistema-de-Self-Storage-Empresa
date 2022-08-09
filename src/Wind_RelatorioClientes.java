import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Wind_RelatorioClientes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_RelatorioClientes window = new Wind_RelatorioClientes();
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
	public Wind_RelatorioClientes() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 773, 335);
		frame.getContentPane().add(scrollPane);
		
		ClienteDAO clientesBD = new ClienteDAO();
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 102, 153));
		textPane.setEditable(false);
		textPane.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textPane.setText(clientesBD.listarClientes());
		scrollPane.setViewportView(textPane);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblRelatrioDeClientes = new JLabel("RELAT\u00D3RIO DE CLIENTES CADASTRADOS:");
		lblRelatrioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDeClientes.setForeground(new Color(0, 102, 153));
		lblRelatrioDeClientes.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblRelatrioDeClientes.setBackground(Color.WHITE);
		lblRelatrioDeClientes.setBounds(190, 10, 415, 36);
		frame.getContentPane().add(lblRelatrioDeClientes);
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 419, 108, 36);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_ControleClientes wind = new Wind_ControleClientes();
				wind.main(null);
			}
		});
	}
}
