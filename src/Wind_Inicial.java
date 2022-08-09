import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wind_Inicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_Inicial window = new Wind_Inicial();
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
	public Wind_Inicial() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 21, 410, 200);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\logo1A.png"));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnJControleLocais = new JButton("Controle de Locais");
		btnJControleLocais.setBackground(new Color(255, 255, 255));
		btnJControleLocais.setForeground(new Color(51, 102, 153));
		btnJControleLocais.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnJControleLocais.setBounds(257, 262, 279, 46);
		frame.getContentPane().add(btnJControleLocais);
		btnJControleLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisAlugados novoCadastro = new Wind_LocaisAlugados();
				novoCadastro.main(null);
			}
		});
		
		JButton btnJControleClientes = new JButton("Controle de Clientes");
		btnJControleClientes.setForeground(new Color(51, 102, 153));
		btnJControleClientes.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnJControleClientes.setBackground(new Color(255, 255, 255));
		btnJControleClientes.setBounds(257, 328, 279, 46);
		frame.getContentPane().add(btnJControleClientes);
		btnJControleClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_ControleClientes novoCadastro = new Wind_ControleClientes();
				novoCadastro.main(null);
			}
		});
		
		JButton btnSobreAVault = new JButton("Sobre a Vault");
		btnSobreAVault.setForeground(new Color(51, 102, 153));
		btnSobreAVault.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnSobreAVault.setBackground(new Color(255, 255, 255));
		btnSobreAVault.setBounds(257, 392, 279, 46);
		frame.getContentPane().add(btnSobreAVault);
		btnSobreAVault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_SobreVault novoCadastro = new Wind_SobreVault();
				novoCadastro.main(null);
			}
		});
	}
}
