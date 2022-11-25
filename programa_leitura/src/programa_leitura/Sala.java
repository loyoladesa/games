package programa_leitura;

public class Sala {

	private String nome;
	private Personagem inimigo;
	private String objeto;
	int [] saidas = new int[3];
	
	
	public Sala(String nome, Personagem inimigo, String objeto, int[] saidas) {
		super();
		this.nome = nome;
		this.inimigo = inimigo;
		this.objeto = objeto;
		this.saidas = saidas;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Personagem getInimigo() {
		return inimigo;
	}


	public void setInimigo(Personagem inimigo) {
		this.inimigo = inimigo;
	}


	public String getObjeto() {
		return objeto;
	}


	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}


	public int[] getSaidas() {
		return saidas;
	}


	public void setSaidas(int[] saidas) {
		this.saidas = saidas;
	}
	
	
	
	
	
	
}
