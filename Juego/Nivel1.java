package Juego;

import java.util.ArrayList;

import GUI.GUI;
import Logica.Jugador;
import LogicaAbstracta.Entidad;
import LogicaAbstracta.Personaje;
public class Nivel1 extends Nivel{

	public Nivel1 (Juego j) {
		siguienteNivel = new Nivel2(j);
		miJuego = j;
		Entidades = new ArrayList<Entidad>();
		ganar = false;
		enemigos = new ArrayList<ArrayList<Personaje>>();
		cantOleadas = 2;
		crearOleadas(8); 
	}

	public Jugador getJugador() {
		return jugador;
	}


	@Override
	public void cambiarFondo() {
		miJuego.getGUI().cambiarFondo("img\\fondoNivel1.jpg");

	}

	@Override
	public void cambiarNivel() {
		GUI.setearNivel("Nivel 1");
	}
}
