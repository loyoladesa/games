package programa_leitura;

import java.util.Random;

public class Personagem {

	private String nome;
	private int energia;
	private int forca;
	private String [] mochila= new String[3];
	private int pos = 0;
	private boolean temPocao = true;
	private boolean jogador;
	
	
	
	
	
	
	public Personagem(String nome, int energia, int forca, boolean jogador) {
		super();
		this.nome = nome;
		this.energia = energia;
		this.forca = forca;
		this.jogador = jogador;
		
		mochila[0] = "espada";
		mochila[1] = "poção";
		mochila[2] = "--";
	}
	
	public void colocarMochila(String objeto) {
		mochila[2] = objeto;
	}
	
	public String retiraObjeto() {
		return mochila[2];
	}
	
	public void mostrarMochila() {
		System.out.println("Mochila: "+ mochila[0]+","+mochila[1]+","+mochila[2]);
	}
	
	public boolean temEsmeralda() {
		if(mochila[2].equals("Esmeralda")) {
			return true;
		}
		return false;
	}
	public boolean temChave() {
		if(mochila[2].equals("Chave")) {
			return true;
		}
		return false;
	}
	
	public int getPos() {
		return pos;
	}
	
	public boolean tomarPocao() {
		if(temPocao) {
			energia = energia + 8;
			if(energia > 10) {
				energia = 10;
			}
			temPocao = false;
			mochila[1] = "-";
			return true;
		}		
		return false;
	}


	public void setPos(int pos) {
		this.pos = pos;		
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	
	public boolean estaVivo() {
		if(energia > 0) {
			return true;
		}
		return false;
	}
	
	public int ataque() {
		Random rand = new Random();
		return rand.nextInt(forca);
	}
	
	public void sofrerDano(int dano) {
		energia = energia - dano;
	}
	
	public void mostrar() {
		System.out.println("Nome: "+nome);
		System.out.println("Força: "+forca);
		System.out.println("Energia: "+energia);
		
		if(this.jogador) {
			System.out.println("Mochila: "+ mochila[0]+","+mochila[1]+","+mochila[2]);
		}		
		System.out.println("----");
	}
	
	
	
}
