package Juego;

import java.util.ArrayList;

import Factory.FabricaNuevoPoder;
import Factory.FabricaParalisis;
import Factory.FabricaPocion;
import Factory.FabricaPremio;
import GUI.GUI;
import Hilos.HiloTeclado;
import Hilos.MovimientoDelJuego;
import Logica.Jugador;
import LogicaAbstracta.Entidad;
import LogicaAbstracta.Premio;

public class Juego {
	protected GUI miGui;
	protected Nivel miNivel;
	protected Jugador jugador;
	protected ArrayList<FabricaPremio> premios;

	public Juego(GUI g) {
		miGui=g;
		miNivel=new Nivel1(this);
		jugador= new Jugador(miNivel);
		miNivel.setJugador(jugador);
		miNivel.cambiarNivel();
		premios=new  ArrayList<FabricaPremio>();
		premios.add(new FabricaPocion());
		premios.add(new FabricaParalisis());
		premios.add(new FabricaNuevoPoder());
	}

	public void setGUI(GUI g) {
		miGui=g;
	}

	public GUI getGUI() {
		return miGui;
	}

	public void startJuego() {
		HiloTeclado ht=new HiloTeclado(miGui,jugador);
		ht.start();
		new MovimientoDelJuego(this).start();
	}

	public void turnoEnemigos() {
		miNivel.turno();

	}

	public void gameOver() {
		MovimientoDelJuego.fin();
		miNivel.reset();
		miNivel.reset();
		miGui.perder();
	}

	public void ganar() {
		MovimientoDelJuego.fin();
		miNivel.reset();
		miGui.ganar();	
	}

	public void actualizarNivel(Nivel n) {
		miNivel=n;
		miNivel.setJugador(jugador);
		jugador.setNivel(n);
		miNivel.cambiarFondo();
		miNivel.cambiarNivel();
		miNivel.getJugador().setVida(100);
	}
	
	public void agregarPremio(Entidad e) {
		int random=(int) (Math.random()*10);
		if(random<premios.size()) {	
			Premio p=premios.get(random).nuevoPremio(e.getCorx(),e.getCorY(), miNivel);
		}
		
	}

}
