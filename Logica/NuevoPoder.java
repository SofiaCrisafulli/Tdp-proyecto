package Logica;


import java.util.Timer;
import java.util.TimerTask;
import Estados.EstadoNuevoPoder;
import GUI.EntidadGraficaSuperArma;
import Juego.Nivel;
import LogicaAbstracta.EfectoTemporal;
import LogicaAbstracta.Estado;

public class NuevoPoder extends EfectoTemporal{

	public NuevoPoder(int corX, int corY, Nivel n) { 
		velocidad = 4;
		posX = corX;
		posY = corY;
		miNivel = n;
		timer = new Timer();
		miGrafico = new EntidadGraficaSuperArma(corX, corY, this);
		miNivel.addEntidad(this);
	}

	public void activar() {
		Estado NuevoPoder = new EstadoNuevoPoder(miNivel.getJugador()); 
		miNivel.getJugador().cambiarEstado(NuevoPoder);
		timer.schedule(new SacarPoder(), 5000);
	}

	private class SacarPoder extends TimerTask{
		public void run() {
			miNivel.getJugador().resetEstado();
		}
	} 
}