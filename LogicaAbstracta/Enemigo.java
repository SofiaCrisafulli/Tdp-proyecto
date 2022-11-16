package LogicaAbstracta;

import Logica.Jugador;
import Logica.NuevoPoder;
import Logica.Paralisis;
import Logica.Pocion;

public abstract class Enemigo extends Personaje  {

	protected int rango;

	public void turno() {
		if(cooldown>0)				
			cooldown--;
		estadoActual.movimiento('s',velocidad);
		ComprobarRango();
		colision();

	}

	protected  void aceptame(Personaje e) {
		e.aceptarEnemigo(this);
	}

	public abstract void resetCooldown();

	public  void eliminar() {	
		miGrafico.eliminar();
		miNivel.removeEnemigo(this);
		miNivel.getJuego().agregarPremio(this);

	}

	public void ComprobarRango() {
		Jugador j = miNivel.getJugador();
		if(posX-20<=j.getCorx()&&posX+20>=j.getCorx() && posY+rango>=j.getCorY())
			disparar();
	}


}
