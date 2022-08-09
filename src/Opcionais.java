/**
 * Classe Opcionais - Representa os opcionais que o cliente pode escolher para o aluguel
 * @author Nathália Santos &lt;nathsantos2703@gmail.com&gt;
 * @version 1.0, 2022-08-06
 */
public class Opcionais {
	/** 
	 * seguro do local
	 * chave extra para o local
	 * controle climático para o local
	 */
	private int seguro;
	private int chave;
	private int controle;
	
	/**
	 * Construtor da classe.
	 * @param seguro - seguro do local
	 * @param chave - chave extra para o local
	 * @param controle - controle climático para o local
	 */
	public Opcionais(int seguro, int chave, int controle) {
	    this.seguro = seguro;
	    this.chave = chave;
	    this.controle = controle;
	}
	
	/**
     * Muda o atributo controle (void)
     * @param controle - o controle climático foi escolhido ou não (1 ou 0)
     */
	public void setControle(int controle) {
		this.controle = controle;
	}
	
	/**
     * Pega se o controle climático foi escolhido ou não (1 ou 0)
     * @return int controle 
     */
	public int getControle() {
		return controle;
	}
	
	/**
     * Muda o atributo chave (void)
     * @param chave - a chave extra foi escolhida ou não (1 ou 0)
     */
	public void setChave(int chave) {
		this.chave = chave;
	}
	
	/**
     * Pega se a chave extra foi escolhida ou não (1 ou 0)
     * @return int chave 
     */
	public int getChave() {
		return chave;
	}
	
	/**
     * Muda o atributo seguro (void)
     * @param seguro - o seguro foi escolhido ou não (1 ou 0)
     */
	public void setSeguro(int seguro) {
		this.seguro = seguro;
	}
	
	/**
     * Pega se o seguro foi escolhido ou não (1 ou 0)
     * @return int seguro 
     */
	public int getSeguro() {
		return seguro;
	}
	
	/**
     * Pega o custo total dos opcionais escolhidos
     * @return int custo 
     */
	public int getCustoOpcionais() {
		int custo = 0;
		if (seguro == 1) { // seguro: R$250,00
			custo += 250;
		}
		if (chave == 1) { // chave extra: R$50,00
			custo += 50;
		}
		if (controle == 1) { // controle climático: R$200,00
			custo += 200;
		}
		return custo;
	}
}
