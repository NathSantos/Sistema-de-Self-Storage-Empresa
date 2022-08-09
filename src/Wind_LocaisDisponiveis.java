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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Wind_LocaisDisponiveis {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_LocaisDisponiveis window = new Wind_LocaisDisponiveis();
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
	public Wind_LocaisDisponiveis() {
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
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblControleDeLocais = new JLabel("CONTROLE DE LOCAIS DISPON\u00CDVEIS:");
		lblControleDeLocais.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDeLocais.setForeground(new Color(0, 102, 153));
		lblControleDeLocais.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblControleDeLocais.setBackground(Color.WHITE);
		lblControleDeLocais.setBounds(212, 10, 359, 36);
		frame.getContentPane().add(lblControleDeLocais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 773, 303);
		frame.getContentPane().add(scrollPane);
		
		String[] columns = {"Número", "Categoria"};
		LocaisDAO locaisBD = new LocaisDAO();
		
		table = new JTable(locaisBD.tabelaDisponiveis(), columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JButton btnProcurarLocal = new JButton("Procurar Local");
		btnProcurarLocal.setForeground(new Color(51, 102, 153));
		btnProcurarLocal.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnProcurarLocal.setBackground(Color.WHITE);
		btnProcurarLocal.setBounds(302, 422, 187, 35);
		frame.getContentPane().add(btnProcurarLocal);
		btnProcurarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocaisDAO locaisDAO = new LocaisDAO();
				String numero = JOptionPane.showInputDialog(null, "Digite o número do local que deseja procurar:", "Procura de Local Disponível", JOptionPane.QUESTION_MESSAGE);
				
				// PROCURANDO O LOCAL NA TABELA DOS LOCAIS DISPONÍVEIS
				if(locaisDAO.getLocalDisponivel(numero) == true) {
					JOptionPane.showMessageDialog(null, "Local Disponível!", "Aviso", JOptionPane.INFORMATION_MESSAGE, 
							new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
				} else {
					JOptionPane.showMessageDialog(null, "Local Indisponível!\nEstá sendo alugado no momento.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 423, 143, 33);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisAlugados wind = new Wind_LocaisAlugados();
				wind.main(null);
			}
		});
		
		JLabel lblQtdAlugados = new JLabel("Qtd. Dispon\u00EDveis:");
		lblQtdAlugados.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdAlugados.setForeground(new Color(0, 102, 153));
		lblQtdAlugados.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblQtdAlugados.setBackground(Color.WHITE);
		lblQtdAlugados.setBounds(10, 369, 108, 28);
		frame.getContentPane().add(lblQtdAlugados);
		
		int qtdDisp = locaisBD.quantDisponiveis();
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 102, 153));
		textPane.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(119, 373, 52, 24);
		frame.getContentPane().add(textPane);
		textPane.setText(""+qtdDisp);
		
		JButton btnInfoCategoria = new JButton("Info. Categorias");
		btnInfoCategoria.setForeground(new Color(51, 102, 153));
		btnInfoCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnInfoCategoria.setBackground(Color.WHITE);
		btnInfoCategoria.setBounds(640, 423, 143, 32);
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
								new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
			}
		});
			
	}

}
