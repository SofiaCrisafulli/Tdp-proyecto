package Hilos;

import Juego.Juego;

public class MovimientoDelJuego extends Thread{	
	protected static boolean GameOver;
	protected Juego miJuego;
	protected static boolean fin=false;

	public MovimientoDelJuego(Juego j){
		miJuego=j;
		GameOver=false;
	}


	public void run() {	
		while(!fin){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miJuego.turnoEnemigos();
		}
	}

	public static void fin() {
		fin=true;
	}
}
