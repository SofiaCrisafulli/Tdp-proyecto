package InicioDelJuego;

import GUI.Inicio;


public class InicioDelJuego {

	protected static boolean empieza;
	
	public static void main(String[] args) {
		empieza=false;
		Inicio ini= new Inicio();
		ini.setVisible(true);
		while(!empieza) {
			try {		
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ini.rJ().startJuego();
	}
	
	public static void empezar() {
		empieza=true;
	}
}
