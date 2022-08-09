import java.sql.*;

/**
 * Classe ClienteDAO - Classe intermediária entre as tabelas clientes, locaisAlugados (mysql) e a classe Cliente (java)
 * @author Nathália Santos &lt;nathsantos2703@gmail.com&gt;
 * @version 1.0, 2022-08-06
 */
public class ClienteDAO extends BancoDeDados{
	
	/**
     * Pega a quantidade de clientes na tabela clientes
     * @return int quantidade de clientes
     */
	public int quantClientes() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes");	
			int quantidadeClientes = 0;
			while (rs.next()) {
				quantidadeClientes++;
			}
			return quantidadeClientes;
	    }
	    catch (SQLException e) { return -1; }
	}
	
	/**
     * Lista os clientes de acordo com: nome, CPF, telefone e os locais alugados daquele cliente
     * @return String relatório dos clientes
     */
	public String listarClientes() {
		try {			
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes");
			int i = 1;
			String relatorio = "";
			while (rs.next()) {
				relatorio += i + ". " + rs.getString(1) + ", CPF = " + rs.getString(2) + ", Telefone: " + rs.getString(3) +
						"\n-> Locais Alugados deste Cliente:" +
						listarAlugadosPorCliente(rs.getString(2));
				i++;
			}
			System.out.println(relatorio);
			return relatorio;
	    }
	    catch (SQLException e) { }
		return null;
	}
	
	/**
     * Lista os locais alugados (tabela locaisAlugados) de um determinado cliente 
     * @param cpf - cpf do cliente
     * @return String relatório dos locais alugados de um cliente
     */
	public String listarAlugadosPorCliente(String cpf) {
		try {			
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT numero, categoria, dataInicio, dataTermino, custoTotal FROM locaisAlugados WHERE cpf='" + cpf + "'");
			String relatorio = "";
			int i = 1;
			while (rs.next()) {
				relatorio += "\n    " + i + ". Núm: " + rs.getString(1) + ", Categoria: " + rs.getString(2) +
						"\n       Início Aluguel: " + rs.getString(3) + ", Término Aluguel: " + rs.getString(4) + 
						"\n       Custo Total: R$" + rs.getString(5) + ",00";
				i++;
			}
			relatorio += "\n-------------------------------------------------------------------------------\n";
			return relatorio;
	    }
	    catch (SQLException e) { }
		return null;
	}
	
	/**
     * Adiciona um cliente na tabela de clientes
     * @param cliente - cliente da classe Cliente
     * @return boolean
     */
	public boolean adicionarCliente(Cliente cliente) {
	    try {
	      Statement st = conexao.createStatement();
	      st.executeUpdate("INSERT INTO clientes VALUES ('" + cliente.getNome() + "'," + " '" + cliente.getCpf()
	                       + "', '" + cliente.getTelefone() + "')");
	      return true;
	    } catch (SQLException e) { return false; }
	  }
	
	/**
     * Remove um cliente da tabela de clientes
     * @param cliente - cliente da classe Cliente
     * @return boolean
     */
	public boolean removerCliente(Cliente cliente) {
	    try {
	      Statement st = conexao.createStatement();
	      st.executeUpdate("DELETE FROM clientes WHERE cpf='" + cliente.getCpf() + "'");
	      return true;
	    } catch (SQLException e) { return false; }
	  }
	
	/**
     * Pega um cliente (classe Cliente) da tabela de clientes a partir do cpf
     * @param cpf - cpf do cliente
     * @return Cliente
     */
	public Cliente getCliente(String cpf) {
	    try {
	      Statement st = conexao.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf='" + cpf + "'");
	      if (rs.next()) {
	        return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3));
	      }
	      else return null;
	    }
	    catch (SQLException e) { return null; }
	}
	
	/**
     * Pega o nome do cliente a partir do cpf
     * @param cpf - cpf do cliente
     * @return String nome do cliente
     */
	public String getNomePorCpf(String cpf) {
	    try {
	      Statement st = conexao.createStatement();
	      ResultSet rs = st.executeQuery("SELECT nome FROM clientes WHERE cpf='" + cpf + "'");
	      if (rs.next()) {
	        return rs.getString(1);
	      }
	      else return null;
	    }
	    catch (SQLException e) { return null; }
	}
	
	/**
     * Gera a tabela de clientes que vai ser mostrada na interface gráfica
     * @return String[][] tabela
     */
	public String[][] tabelaClientes() {
		String[][] data = new String[quantClientes()][3]; // [rows][columns]
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes");
			int i = 0;
			while (rs.next()) {
				for(int j=0; j < 3; j++) {
					data[i][j] = rs.getString(j+1);
				}
				i=i+1;
			}
			return data;
	    }
	    catch (SQLException e) { System.out.println(e); }
		return data;
	}
}
