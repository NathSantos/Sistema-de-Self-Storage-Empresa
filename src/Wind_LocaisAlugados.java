import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Wind_LocaisAlugados {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_LocaisAlugados window = new Wind_LocaisAlugados();
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
	public Wind_LocaisAlugados() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Vault Storage App");
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 807, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		URL url = new URL("https://raw.githubusercontent.com/NathSantos/Sistema-de-Self-Storage/main/icon.png");
		BufferedImage logo = ImageIO.read(url);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		lblNewLabel_3.setIcon(new ImageIcon(logo));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblAluguisAtuais = new JLabel("CONTROLE DE LOCAIS ALUGADOS:");
		lblAluguisAtuais.setBounds(212, 10, 351, 36);
		lblAluguisAtuais.setHorizontalAlignment(SwingConstants.CENTER);
		lblAluguisAtuais.setForeground(new Color(0, 102, 153));
		lblAluguisAtuais.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblAluguisAtuais.setBackground(Color.WHITE);
		frame.getContentPane().add(lblAluguisAtuais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 773, 303);
		frame.getContentPane().add(scrollPane);
		
		String[] columns = {"Número", "Categoria", "CPF", "Início", "Término", "Custo Mês", "Meses", "Custo Local", "Custo Opc.", "Custo Total"};
		LocaisDAO locaisBD = new LocaisDAO();
		
		table = new JTable(locaisBD.tabelaAlugados(), columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JButton btnCadastro = new JButton("Novo Aluguel");
		btnCadastro.setForeground(new Color(51, 102, 153));
		btnCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCadastro.setBackground(Color.WHITE);
		btnCadastro.setBounds(127, 420, 125, 35);
		frame.getContentPane().add(btnCadastro);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_NewAluguel wind = null;
				try {
					wind = new Wind_NewAluguel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 420, 97, 35);
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
		
		JButton btnLocaisDisponveis = new JButton("Locais Dispon\u00EDveis ->");
		btnLocaisDisponveis.setForeground(new Color(51, 102, 153));
		btnLocaisDisponveis.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnLocaisDisponveis.setBackground(Color.WHITE);
		btnLocaisDisponveis.setBounds(605, 10, 178, 36);
		frame.getContentPane().add(btnLocaisDisponveis);
		btnLocaisDisponveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisDisponiveis wind = null;
				try {
					wind = new Wind_LocaisDisponiveis();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnAl = new JButton("Cancelar Aluguel");
		btnAl.setForeground(new Color(51, 102, 153));
		btnAl.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAl.setBackground(Color.WHITE);
		btnAl.setBounds(262, 419, 152, 36);
		frame.getContentPane().add(btnAl);
		btnAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_CancelarAluguel wind = null;
				try {
					wind = new Wind_CancelarAluguel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnAlterao = new JButton("Renovar ");
		btnAlterao.setForeground(new Color(51, 102, 153));
		btnAlterao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAlterao.setBackground(Color.WHITE);
		btnAlterao.setBounds(547, 420, 113, 35);
		frame.getContentPane().add(btnAlterao);
		btnAlterao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_RenovarAluguel wind = null;
				try {
					wind = new Wind_RenovarAluguel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setForeground(new Color(51, 102, 153));
		btnRelatrio.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRelatrio.setBackground(Color.WHITE);
		btnRelatrio.setBounds(670, 420, 113, 35);
		frame.getContentPane().add(btnRelatrio);
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_RelatorioLocal wind = null;
				try {
					wind = new Wind_RelatorioLocal();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wind.main(null);
			}
		});
		
		JLabel lblQtdAlugados = new JLabel("Qtd. Alugados:");
		lblQtdAlugados.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdAlugados.setForeground(new Color(0, 102, 153));
		lblQtdAlugados.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblQtdAlugados.setBackground(Color.WHITE);
		lblQtdAlugados.setBounds(10, 370, 97, 28);
		frame.getContentPane().add(lblQtdAlugados);
		
		int qtdAlugados = locaisBD.quantAlugados();
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.menu);
		textPane.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textPane.setForeground(new Color(0, 102, 153));
		textPane.setEditable(false);
		textPane.setBounds(108, 372, 52, 24);
		frame.getContentPane().add(textPane);
		textPane.setText(""+qtdAlugados);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setForeground(new Color(51, 102, 153));
		btnProcurar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnProcurar.setBackground(Color.WHITE);
		btnProcurar.setBounds(424, 420, 113, 35);
		frame.getContentPane().add(btnProcurar);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocaisDAO locaisDAO = new LocaisDAO();
				String numero = JOptionPane.showInputDialog(null, "Digite o número do local que deseja procurar:", "Procura de Local Alugado", JOptionPane.QUESTION_MESSAGE);
				
				// PROCURANDO O LOCAL NA TABELA DOS LOCAIS ALUGADOS
				if(locaisDAO.getLocalAlugado(numero) == true) {
					JOptionPane.showMessageDialog(null, "Local está entre os Alugados!", "Aviso", JOptionPane.INFORMATION_MESSAGE, 
							new ImageIcon(logo));
				} else {
					JOptionPane.showMessageDialog(null, "Local Disponível!\nNão está sendo alugado no momento.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnInfoCategoria = new JButton("Info. Categorias");
		btnInfoCategoria.setForeground(new Color(51, 102, 153));
		btnInfoCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnInfoCategoria.setBackground(Color.WHITE);
		btnInfoCategoria.setBounds(640, 379, 143, 24);
		frame.getContentPane().add(btnInfoCategoria);
		btnInfoCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] listaCategorias = {"guarda-volumes", "contêiner", "quarto", "galpão"};
				String info = "CATEGORIAS DISPONÍVEIS:";
				
				for(int i=0;i<4;i++) {
					Categoria categoria = new Categoria(listaCategorias[i]);
					info += "\n--> " + categoria.getCategoria() +
							"\n  Custo por Mês: R$" + categoria.getCusto() + ",00" +
							"\n  Comprimento: " + categoria.getComprimento() + "m" +
							"\n  Largura: " + categoria.getLargura() + "m" +
							"\n  Altura: " + categoria.getAltura() + "m" +
							"\n  Volume: " + categoria.getVolume() + "m^3";
				}
				
				JOptionPane.showMessageDialog(null, info, "Informações Categorias", JOptionPane.INFORMATION_MESSAGE, 
								new ImageIcon(logo));
			}
		});
		
	}
}
