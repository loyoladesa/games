package inicio_logica_games;

import java.util.ArrayList;

public class Game implements Runnable{
	
	private boolean isRunning;
	private Thread thread;
	
	private ArrayList<Entidade> entidades;
	
	public Game() {
		this.entidades.add(new Entidade());
		
		for(int i=0;i<entidades.size();i++) {
			Entidade e = entidades.get(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
		
		
	}
	
	public synchronized void start() {
		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public void update() {
		System.out.println("update");
	}
	
	public void render() {
		System.out.println("render");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			update();
			render();
			
			/*
			 * Thread.sleep(1000);
			 */
		}
	}

}
