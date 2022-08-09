import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Wind_RelatorioLocal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_RelatorioLocal window = new Wind_RelatorioLocal();
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
	public Wind_RelatorioLocal() throws IOException {
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
		scrollPane.setBounds(10, 68, 773, 335);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(logo));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		LocaisDAO localBD = new LocaisDAO();
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 102, 153));
		textPane.setEditable(false);
		textPane.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textPane.setText(localBD.listarLocaisAlugados());
		scrollPane.setViewportView(textPane);
		
		JLabel lblRelatrioDeLocais = new JLabel("RELAT\u00D3RIO DE LOCAIS ALUGADOS:");
		lblRelatrioDeLocais.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDeLocais.setForeground(new Color(0, 102, 153));
		lblRelatrioDeLocais.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblRelatrioDeLocais.setBackground(Color.WHITE);
		lblRelatrioDeLocais.setBounds(190, 10, 415, 36);
		frame.getContentPane().add(lblRelatrioDeLocais);
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 419, 108, 36);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisAlugados wind = null;
				try {
					wind = new Wind_LocaisAlugados();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
	}
}
