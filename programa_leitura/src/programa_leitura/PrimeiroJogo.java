package programa_leitura;

import java.util.Random;
import java.util.Scanner;

public class PrimeiroJogo {

	public static void menu() {
		System.out.println("O que você faz:");
		System.out.println("m: ver o que tem dentro da mochila.");
		System.out.println("p: usar a poção");
		System.out.println("x: pegar objeto.");
		System.out.println("w: Sair pela porta 1");
		System.out.println("y: Sair pela porta 2");
		System.out.println("z: Sair pela porta 3");
		System.out.println("s: sair do jogo.");
	}
	
	public static void menuComInimigo() {
		System.out.println("O que você faz:");
		System.out.println("m: ver o que tem dentro da mochila.");
		System.out.println("p: usar a poção");
		System.out.println("a: Atacar");
		System.out.println("c: Tentar passar correndo");
		System.out.println("v: Voltar");			
		System.out.println("s: sair do jogo.");
	}
	
	public static void menuSaida() {
		System.out.println("O que você faz:");
		System.out.println("w: Sair pela porta 1");
		System.out.println("y: Sair pela porta 2");
		System.out.println("z: Sair pela porta 3");
		System.out.println("s: sair do jogo.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//personagem		
		Personagem jogador = new Personagem("Jogador",10,10,true);
				
			
		//mapa do jogo
		Sala []mapa = new Sala[10];
		
		
		
		//inimigos
		Personagem samurai = new Personagem("Samurai",5,5,false);		
		Personagem ninja = new Personagem("Ninja",3,6,false);		
		Personagem orc = new Personagem("Orc",8,5,false);		
		Personagem ogro = new Personagem("Ogro",8,7,false);
		Personagem morto = new Personagem("Morto",0,0,false);
		
		//salas
		int [] saidas = {0,1,2};
		int [] saidas1 = {0,3,4};
		int [] saidas2 = {0,5,6};
		int [] saidas3 = {1,4,7};
		int [] saidas4 = {1,3,3};
		int [] saidas5 = {2,7,8};
		int [] saidas6 = {2,5,8};
		int [] saidas7 = {3,5,9};
		int [] saidas8 = {5,6,9};
		int [] saidas9 = {7,8,10};
				
		mapa[0] = new Sala("Entrada da Caverna",samurai,"-",saidas);
		mapa[1] = new Sala("Sala da Chave",morto,"Chave",saidas1);
		mapa[2] = new Sala("Sala do Ninja",ninja,"-",saidas2);
		mapa[3] = new Sala("Sala do Orc",orc,"-",saidas3);
		mapa[4] = new Sala("Sala do Ogro",ogro,"-",saidas4);
		mapa[5] = new Sala("Sala da Esmeralda",morto,"Esmeralda",saidas5);
		mapa[6] = new Sala("Sala do Amuleto",morto,"Amuleto",saidas6);
		mapa[7] = new Sala("Sala Vazia",morto,"-",saidas7);
		mapa[8] = new Sala("Sala Trancada",morto,"-",saidas8);
		mapa[9] = new Sala("Sala Vazia",morto,"-",saidas9);
		
		
		//mecânica do jogo
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String comando;
		
		
		
		System.out.println("Seja bem vindo ao JOGO:ENCONTRE A ESMERALDA!");
		
		System.out.println("Insira seu nome:");
		jogador.setNome(in.nextLine());
		
		System.out.println("---------------");
		
		System.out.println("HISTÓRIA:");
		System.out.println("No Reino de Malastril, um terrível Mago enfeitiçou o Rei e a Rainha.");
		System.out.println("Eles desejavam salvar o Reino do Dragão que destruía as cidades e fizeram um trato com o Mago.");
		System.out.println("Mas eles foram enganados e tiveram as suas almas aprisionadas em uma esmeralda.");
		System.out.println("Essa esmeralda está em uma caverna protegida por guerreiros e criaturas horrendas!");
		System.out.println("Os nobres de Malastril contrataram um Cavaleiro para poder entrar na Caverna e sair com a Esmeralda!");
		System.out.println("Cavaleiro "+jogador.getNome()+" o Reino de Malastril lhe entrega uma espada e poção(que recupera as energias).");
		System.out.println("Você deve entrar na Caverna e retornar com a Esmeralda em sua Mochila.");	
		
		
		
		System.out.println("##############");	
		
		while(jogador.estaVivo()) {
			
			if(jogador.getPos()==10) {
				jogador.setEnergia(-1);
			}else {
				System.out.println("xxxxx RODADA xxxxxxxxxx");
				System.out.println("Personagem:");
				jogador.mostrar();
				
				
				Sala sala = mapa[jogador.getPos()];
				
				System.out.println("Você está na "+ sala.getNome());
				System.out.println("Esta sala possui o seguinte objeto: "+sala.getObjeto());
				
				if(sala.getInimigo().estaVivo()) {
					System.out.println("Existe um Inimigo na Sala:");
					sala.getInimigo().mostrar();
					System.out.println("###############");
					menuComInimigo();
					comando = in.nextLine();
					
					switch(comando) {
					case "m":
						jogador.mostrarMochila();
						break;
					case "p":
						if (jogador.tomarPocao()) {
							System.out.println("Energia: "+jogador.getEnergia());
						}else {
							System.out.println("Não há poção para ser tomada");
						}				
						break;
					case "a":
					    int dano = jogador.ataque();	
						System.out.println("O seu ataque provocou um dano de "+dano);
						Personagem inimigo = sala.getInimigo();
						inimigo.sofrerDano(dano);
						System.out.println("Energia Inimigo: "+ inimigo.getEnergia());
						if(inimigo.estaVivo()) {
							int ataqueInimigo = inimigo.ataque();
							System.out.println("O Inimigo provocou um dano de :"+ataqueInimigo);
							jogador.sofrerDano(ataqueInimigo);
							if(!jogador.estaVivo()) {
								System.out.println("Você morreu!");
							}
						}else {
							System.out.println("Você matou o Inimigo");						
						}	
						sala.setInimigo(inimigo);
						break;
						
					case "c":
						int chance = rand.nextInt(10);
						if(chance < 3) {
							menuSaida();
							
							Scanner l = new Scanner(System.in);
							String saida = l.nextLine();
							int posicao = jogador.getPos();
								
							switch(saida) {
							
							case "w":
								jogador.setPos(sala.getSaidas()[0]);						
								break;
							case "y":
								jogador.setPos(sala.getSaidas()[1]);
								break;
							case "z":
								if(sala.getNome().equals("Sala Trancada")) {
									if(jogador.temChave()) {
										jogador.setPos(sala.getSaidas()[2]);
									}else {
										System.out.println("Esta porta está trancada! Você precisa de uma chave!");
									}
								}
								
								break;
							case "s":
								jogador.setEnergia(-1);
								break;
							}
							
						}else {
							System.out.println("Você não conseguiu!");
						}
						break;
					case "v":
						jogador.setPos(sala.getSaidas()[0]);
						break;
					case "s":
						jogador.setEnergia(-1);
						break;
					}			
					
				}else {
					System.out.println("Não Existe Inimigo na Sala");
					System.out.println("###############");
					menu();
					Scanner l = new Scanner(System.in);
					String saida = l.nextLine();
					
						
					switch(saida) {
					
					case "m":
						jogador.mostrarMochila();
						break;
					case "p":
						if (jogador.tomarPocao()) {
							System.out.println("Energia: "+jogador.getEnergia());
						}else {
							System.out.println("Não há poção para ser tomada");
						}				
						break;
					case "x":
						String objeto = jogador.retiraObjeto();
						jogador.colocarMochila(sala.getObjeto());
						sala.setObjeto(objeto);
						break;
					case "w":
						jogador.setPos(sala.getSaidas()[0]);						
						break;
					case "y":
						jogador.setPos(sala.getSaidas()[1]);
						break;
					case "z":
						if(sala.getNome().equals("Sala Trancada")) {
							if(jogador.temChave()) {
								jogador.setPos(sala.getSaidas()[2]);
							}else {
								System.out.println("Esta porta está trancada! Você precisa de uma chave!");
							}
						}else {
							jogador.setPos(sala.getSaidas()[2]);
						}
						break;
					case "s":
						jogador.setEnergia(-1);
						break;				
					}
				}
			}
		}
		
		if(jogador.getPos()==10) {
			System.out.println("Você saiu da Caverna!");
			if(jogador.temEsmeralda()) {
				System.out.println("Parabéns! Você conseguiu recuperar a Esmeralda!");
			}else {
				System.out.println("Você não tem a Esmeralda!");
				System.out.println("Você não conseguiu salvar o Reino de Malastril!");
			}
		}
		System.out.println("Fim de Jogo!");		
		
		
	}

}
