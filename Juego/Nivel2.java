package Juego;

import java.util.ArrayList;

import GUI.GUI;
import Logica.Jugador;
import LogicaAbstracta.Entidad;
import LogicaAbstracta.Personaje;

public class Nivel2 extends Nivel {

	public Nivel2 (Juego j) {
		siguienteNivel = null;
		miJuego = j;
		Entidades = new ArrayList<Entidad>();
		ganar = false;
		enemigos = new ArrayList<ArrayList<Personaje>>();
		cantOleadas = 3;
		crearOleadas(12); 
	}

	public Jugador getJugador() {
		return jugador;
	}

	@Override
	public void cambiarFondo() {
		miJuego.getGUI().cambiarFondo("/img/fondoNivel2.jpg");

	}

	@Override
	public void cambiarNivel() {
		GUI.setearNivel("Nivel 2");

	}

}
