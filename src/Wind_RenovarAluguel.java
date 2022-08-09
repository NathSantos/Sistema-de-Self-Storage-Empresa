import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

public class Wind_RenovarAluguel {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_RenovarAluguel window = new Wind_RenovarAluguel();
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
	public Wind_RenovarAluguel() throws IOException {
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
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(logo));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblRenovarAluguelPor = new JLabel("RENOVAR ALUGUEL POR CPF:");
		lblRenovarAluguelPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRenovarAluguelPor.setForeground(new Color(0, 102, 153));
		lblRenovarAluguelPor.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblRenovarAluguelPor.setBackground(Color.WHITE);
		lblRenovarAluguelPor.setBounds(259, 10, 304, 36);
		frame.getContentPane().add(lblRenovarAluguelPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 773, 182);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setToolTipText("digite seu cpf (somente n\u00FAmeros)");
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(108, 69, 222, 27);
		frame.getContentPane().add(textField);
		
		JButton btnEnter = new JButton("Listar alugu\u00E9is");
		btnEnter.setToolTipText("clique aqui ap\u00F3s ter preenchido com o cpf");
		btnEnter.setForeground(new Color(51, 102, 153));
		btnEnter.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnEnter.setBackground(Color.WHITE);
		btnEnter.setBounds(603, 70, 134, 29);
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
					//ATUALIZA A TABELA
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
		
		JButton btnVoltar = new JButton("<- Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(54, 419, 100, 36);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(54, 64, 43, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("somente n\u00FAmeros (11 d\u00EDgitos)");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(108, 94, 178, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("NOVA DATA IN\u00CDCIO:");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(181, 349, 181, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("NOVA DATA T\u00C9RMINO:");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1.setBounds(154, 383, 208, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(373, 349, 222, 27);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(373, 383, 222, 27);
		frame.getContentPane().add(dateChooser_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("N\u00DAMERO:");
		lblNewLabel_1_1_1_2_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_2_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_2.setBounds(275, 312, 87, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(373, 312, 222, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRenovar = new JButton("Renovar");
		btnRenovar.setForeground(new Color(51, 102, 153));
		btnRenovar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRenovar.setBackground(Color.WHITE);
		btnRenovar.setBounds(603, 419, 134, 36);
		frame.getContentPane().add(btnRenovar);
		btnRenovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocaisDAO localDAO = new LocaisDAO();
				
		        	
	        	// VERIFICAÇÃO SE AS DATAS FORAM SELECIONADAS
				if ((dateChooser.getDate() == null) || (dateChooser_1.getDate() == null)) {
					JOptionPane.showMessageDialog(null, "Selecione as Novas Datas!!", "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {	
					String dataHoje = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
					Date hoje = null;
					try {
						hoje = new SimpleDateFormat("yyyy-MM-dd").parse(dataHoje);
					} catch (ParseException e1) {e1.printStackTrace();}
						
					// VERIFICAÇÃO SE DATA DE INICIO FOR ANTES DA DATA DE HOJE
					if(dateChooser.getDate().before(hoje)) {
						JOptionPane.showMessageDialog(null, "Data de Início Inválida!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					} else { // DATA ESCOLHIDA CORRETAMENTE
						String dataInicio = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
						JOptionPane.showMessageDialog(null, "Data de Início Selecionada com Sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						Date inicio = null;
						try {
							inicio = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicio);
						} catch (ParseException e1) {e1.printStackTrace();}
						
						// VERIFICAÇÃO SE DATA DE TERMINO FOR ANTES DA DATA DE INICIO
						if(dateChooser_1.getDate().before(inicio)) {
							JOptionPane.showMessageDialog(null, "Data de Término Inválida!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						} else { // DATA ESCOLHIDA CORRETAMENTE
							String dataTermino = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_1.getDate());
							JOptionPane.showMessageDialog(null, "Data de Término Selecionada com Sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							
							// ETAPA PARA ALTERAR AS DATAS E CUSTOS CORRESPONDENTES DO ALUGUEL
							if(localDAO.alteraDataAluguel(textField.getText(), textField_1.getText(), dataInicio, dataTermino) == true) {
								JOptionPane.showMessageDialog(null, "Aluguel Renovado!!", "Aluguel Renovado", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon(logo));

								//ATUALIZA A TABELA
								String[] columns = {"Número", "Categoria", "Início", "Término", "Custo Mês", "Meses", "Custo Local", "Custo Opc.", "Custo Total"};
								LocaisDAO locaisBD = new LocaisDAO();
								
								table = new JTable(locaisBD.tabelaAlugadosPorCpf(textField.getText()), columns);
								table.setFillsViewportHeight(true);
								table.setEnabled(false);
								table.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
								scrollPane.setViewportView(table);
							
							} else {
								JOptionPane.showMessageDialog(null, "Não foi possível renovar o aluguel!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
	        } 
		});
		
	}
}

