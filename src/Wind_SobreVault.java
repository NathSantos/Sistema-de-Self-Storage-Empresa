import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;

public class Wind_SobreVault {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_SobreVault window = new Wind_SobreVault();
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
	public Wind_SobreVault() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 807, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\logo1A.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 21, 410, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(274, 411, 228, 44);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_Inicial wind = new Wind_Inicial();
				wind.main(null);
			}
		});
		
		JTextPane txtpnAVaultStore = new JTextPane();
		txtpnAVaultStore.setBounds(165, 239, 452, 151);
		frame.getContentPane().add(txtpnAVaultStore);
		txtpnAVaultStore.setForeground(new Color(0, 102, 153));
		txtpnAVaultStore.setEditable(false);
		txtpnAVaultStore.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		txtpnAVaultStore.setText("A Vault Storage \u00E9 uma empresa de Auto-Servi\u00E7o de Armazenamento brasileira.\r\nCom mais de 5 anos de atua\u00E7\u00E3o no mercado, garantimos um servi\u00E7o de self storage tranquilo e seguro para voc\u00EA!\r\nContamos com diversas categorias que atendem muito bem a cada finalidade que voc\u00EA precise, al\u00E9m de estruturas protegidas por sistemas avan\u00E7ados de seguran\u00E7a.\r\nTodas as nossas instala\u00E7\u00F5es ficam em: Rua Malt\u00EAs, Bloco 54.\r\nPara mais informa\u00E7\u00F5es, contate nossa central: 0800 3655 2001\r\n");
	}
}
