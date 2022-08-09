import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe infoAluguel - Representa informações sobre um aluguel na aplicação
 * @author Nathália Santos &lt;nathsantos2703@gmail.com&gt;
 * @version 1.0, 2022-08-06
 */
public class infoAluguel {
	/** 
	 * data de início do aluguel ("yyyy-MM-dd")
	 * data de término do aluguel ("yyyy-MM-dd")
	 * categoria do local
	 */
	private String dataInicio;
	private String dataTermino;
	private String categoria;
	
	/**
	 * Construtor da classe.
	 * @param dataInicio - data de início do aluguel ("yyyy-MM-dd")
	 * @param dataTermino - data de término do aluguel ("yyyy-MM-dd")
	 * @param categoria - categoria do local
	 */
	public infoAluguel(String dataInicio, String dataTermino, String categoria) {
	    this.dataInicio = dataInicio;
	    this.dataTermino = dataTermino;
	    this.categoria = categoria;
	}
	
	/**
     * Converte a data de início do tipo String para o tipo Date
     * @return Date data de início
     */
	public Date converteInicio() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = formato.parse(dataInicio);
		return dataFormatada; 
	}
	
	/**
     * Converte a data de término do tipo String para o tipo Date
     * @return Date data de término
     */
	public Date converteTermino() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = formato.parse(dataTermino);
		return dataFormatada; 
	}
	
	/**
     * Pega a data de início do aluguel 
     * @return String data de início
     */
	public String getDataInicio() {
		return dataInicio;
	}
	
	/**
     * Muda a data de início do aluguel (void)
     * @param dataInicio - data de início do aluguel 
     */
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	/**
     * Pega a data de término do aluguel 
     * @return String data de término
     */
	public String getDataTermino() {
		return dataTermino;
	}
	
	/**
     * Muda a data de término do aluguel (void)
     * @param dataTermino - data de término do aluguel 
     */
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	/**
     * Pega a categoria do local
     * @return String categoria
     */
	public String getCategoria() {
		return categoria;
	}
	
	/**
     * Muda a categoria do local (void)
     * @param categoria - categoria do local 
     */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
