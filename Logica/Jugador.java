package Logica;

import Estados.EstadoJugador;
import GUI.EntidadGraficaJugador;
import Juego.Nivel;
import LogicaAbstracta.Personaje;
import VisitorsConcretos.VisitorJugador;

public class Jugador extends Personaje  {

	protected boolean puedeMoverse;
	protected int invencibilidad;

	public Jugador(Nivel l) { 
		vida = 100;
		cooldown=0;
		estadoActual=new EstadoJugador(this);
		miVisitor= new VisitorJugador(this);
		posX=385;
		posY=430;
		velocidad=15;
		miNivel=l;
		miGrafico=new EntidadGraficaJugador(posX,posY,this);
		invencibilidad=0;
		miNivel.getJuego().getGUI().actualizarVida(100);
	}

	public void setDireccion(char d) { 
		direccionActual=d;
	}

	public void turno() {
		if(invencibilidad>0)
			invencibilidad--;
		if(cooldown>0)			
			cooldown--;

		estadoActual.movimiento(direccionActual,velocidad);
		direccionActual=('+');
	}

	public void setVida(int v) { 
		vida = v;
		miNivel.getJuego().getGUI().actualizarVida(vida);
	}

	@Override
	protected void aceptame(Personaje e) {
		e.aceptarJugador(this);
	}


	public void moverse(char s) {
		super.moverse(s);
		colision();
	}

	public void RecibirDanio(int dmg) {
		if(invencibilidad==0) {
			invencibilidad=20;				
			super.RecibirDanio(dmg);
			miNivel.getJuego().getGUI().actualizarVida(vida);
		}
	}

	public  void eliminar() {
		miGrafico.eliminar();
		miNivel.getJuego().gameOver();
	}

	protected void resetCooldown() {
		cooldown=5;
	}

	public void setNivel(Nivel n) {
		miNivel=n;
	}

	@Override
	public void resetEstado() {
		estadoActual=new EstadoJugador(this);
	}
}

