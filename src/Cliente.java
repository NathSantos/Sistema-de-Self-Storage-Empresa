/**
 * Classe Cliente - Representa um cliente na aplicação
 * @author Nathália Santos &lt;nathsantos2703@gmail.com&gt;
 * @version 1.0, 2022-08-06
 */
public class Cliente {
	/** 
	 * Nome do cliente 
	 * CPF do cliente
	 * Telefone do cliente
	 */
	private String nome;
	private String cpf;
	private String telefone;
	
	/**
	 * Construtor da classe.
	 * @param nome - nome do cliente 
	 * @param cpf - cpf do cliente
	 * @param telefone - telefone do cliente
	 */
	public Cliente(String nome, String cpf, String telefone) {
	    this.nome = nome;
	    this.cpf = cpf;
	    this.telefone = telefone;
	}
	
	/**
     * Pega o nome do cliente
     * @return String nome
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * Muda o nome do cliente (void)
     * @param nome - nome do cliente 
     */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
     * Pega o cpf do cliente
     * @return String cpf
     */
	public String getCpf() {
		return cpf;
	}
	
	/**
     * Muda o cpf do cliente (void)
     * @param cpf - cpf do cliente
     */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
     * Pega o telefone do cliente
     * @return String telefone
     */
	public String getTelefone() {
		return telefone;
	}
	
	/**
     * Muda o telefone do cliente (void)
     * @param telefone - telefone do cliente
     */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}