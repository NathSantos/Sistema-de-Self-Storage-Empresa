import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Wind_NewAluguel {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wind_NewAluguel window = new Wind_NewAluguel();
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
	public Wind_NewAluguel() {
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
		
		JLabel lblNovoAluguel = new JLabel("NOVO ALUGUEL:");
		lblNovoAluguel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAluguel.setForeground(new Color(0, 102, 153));
		lblNovoAluguel.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNovoAluguel.setBackground(Color.WHITE);
		lblNovoAluguel.setBounds(208, 20, 388, 36);
		frame.getContentPane().add(lblNovoAluguel);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("digite seu cpf (somente n\u00FAmeros)");
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(123, 106, 222, 36);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(70, 105, 43, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(157, 399, 228, 44);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wind_LocaisAlugados wind = new Wind_LocaisAlugados();
				wind.main(null);
			}
		});
		
		JLabel lblNewLabel_2_1 = new JLabel("somente n\u00FAmeros (11 d\u00EDgitos)");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(124, 143, 184, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
		lblNewLabel_3.setBounds(10, 10, 43, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 102, 153));
		comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"guarda-volumes", "cont\u00EAiner", "quarto", "galp\u00E3o"}));
		comboBox.setBounds(124, 213, 222, 36);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CATEGORIA:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(70, 178, 121, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxSeguro = new JCheckBox("Seguro");
		chckbxSeguro.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		chckbxSeguro.setForeground(new Color(0, 102, 153));
		chckbxSeguro.setBounds(494, 148, 121, 30);
		frame.getContentPane().add(chckbxSeguro);
		
		JCheckBox chckbxChaveExtra = new JCheckBox("Chave Extra");
		chckbxChaveExtra.setForeground(new Color(0, 102, 153));
		chckbxChaveExtra.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		chckbxChaveExtra.setBounds(494, 180, 121, 30);
		frame.getContentPane().add(chckbxChaveExtra);
		
		JCheckBox chckbxControleClimatico = new JCheckBox("Controle Clim\u00E1tico");
		chckbxControleClimatico.setForeground(new Color(0, 102, 153));
		chckbxControleClimatico.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		chckbxControleClimatico.setBounds(494, 212, 186, 30);
		frame.getContentPane().add(chckbxControleClimatico);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("OPCIONAIS:");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(442, 106, 121, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(123, 308, 222, 36);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(488, 308, 222, 36);
		frame.getContentPane().add(dateChooser_1);
		
		JButton btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.setForeground(new Color(51, 102, 153));
		btnProsseguir.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnProsseguir.setBackground(Color.WHITE);
		btnProsseguir.setBounds(417, 399, 228, 44);
		frame.getContentPane().add(btnProsseguir);
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO clienteDAO = new ClienteDAO();
				
				// VERIFICAÇÃO NÚMERO DE CARACTERES DO CAMPO CPF 
				int flag = 0;
				if (textField_1.getText().isEmpty() || textField_1.getText().length() > 11) {
					JOptionPane.showMessageDialog(null, "Confira o campo Cpf!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else { flag ++;} 
				// VERIFICAÇÃO SE CLIENTE ESTÁ CADASTRADO NA BASE DE DADOS
				if ((clienteDAO.getCliente(textField_1.getText()) == null) && (flag == 1)) {
					JOptionPane.showMessageDialog(null, "Este cpf não está cadastrado no banco de dados", "Usuário não encontrado", JOptionPane.WARNING_MESSAGE);
				} else { flag ++;} 

				if(flag == 2) {
					// VERIFICAÇÃO SE AS DATAS FORAM SELECIONADAS
					if ((dateChooser.getDate() == null) || (dateChooser_1.getDate() == null)) {
						JOptionPane.showMessageDialog(null, "Selecione as Datas!!", "Aviso", JOptionPane.WARNING_MESSAGE);
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
								JOptionPane.showMessageDialog(null, "Data de Término Selecionada com Sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								flag++;
							}
						}
					}
				}
				
				if(flag == 3) {
					String cpf = textField_1.getText();
					String categoriaSelecionada = comboBox.getSelectedItem().toString();
					String dataInicio = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
					String dataTermino = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_1.getDate());
					int seguroSelecionado = 0, chaveSelecionada = 0, controleSelecionado = 0;
					if(chckbxSeguro.isSelected()) { seguroSelecionado = 1; }
					if(chckbxChaveExtra.isSelected()) { chaveSelecionada = 1; }
					if(chckbxControleClimatico.isSelected()) { controleSelecionado = 1; }
							
					// PERSISTINDO O OBJETO NO BANCO DE DADOS
					LocaisDAO localDAO = new LocaisDAO();
					if(localDAO.procuraDisponibilidadeEAluga(cpf, categoriaSelecionada, dataInicio, dataTermino, seguroSelecionado, chaveSelecionada, controleSelecionado) == true) {
						JOptionPane.showMessageDialog(null, "Temos disponibilidade!\nLocal Alugado com Sucesso!", "Aluguel realizado", JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png"));
						
						Categoria cat = new Categoria(categoriaSelecionada);
						Opcionais opc = new Opcionais(seguroSelecionado, chaveSelecionada, controleSelecionado);
						int custoPorMes = cat.getCusto();
						int custoOpcionais = opc.getCustoOpcionais();
						int meses = localDAO.calculaMeses(dataInicio, dataTermino);
						int custoLocal = custoPorMes * meses;
						int custoTotal = custoLocal + custoOpcionais;
						
						JOptionPane.showMessageDialog(null, "Categoria: " + categoriaSelecionada + 
									"\nCusto por Mês: R$ " + custoPorMes + ",00" +
									"\nMeses de Aluguel: " + meses + " meses" +
									"\nCusto Aluguel Local: R$ " + custoLocal + ",00" +
									localDAO.listarOpcionaisFechamentoDeConta(seguroSelecionado, chaveSelecionada, controleSelecionado) +
									"\nCusto Opcionais: R$ " + custoOpcionais + ",00" +
									"\n-----------------------------------------------" +
									"\nCusto Total do Aluguel: " + custoTotal + ",00",
							      "Fechamento de Conta do Aluguel", JOptionPane.INFORMATION_MESSAGE,
							      new ImageIcon("C:\\Users\\naths\\Downloads\\TP1 Vault Logos\\iconPequeno.png")
							      );

						Wind_LocaisAlugados wind = new Wind_LocaisAlugados();
						wind.main(null);
					} else {
						JOptionPane.showMessageDialog(null, "Desculpe, não temos disponibilidade para essa categoria no momento", "Sem disponibilidade", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("DATA IN\u00CDCIO:");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(70, 273, 127, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("DATA T\u00C9RMINO:");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1.setBounds(442, 273, 152, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_1);

	}
}
