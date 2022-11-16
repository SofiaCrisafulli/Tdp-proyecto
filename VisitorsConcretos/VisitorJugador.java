package VisitorsConcretos;

import Logica.Jugador;
import LogicaAbstracta.Enemigo;
import LogicaAbstracta.Premio;
import LogicaAbstracta.ProyectilEnemigo;
import LogicaAbstracta.VisitorAbstracto;

public class VisitorJugador extends VisitorAbstracto {

	protected Jugador miJugador;

	public VisitorJugador(Jugador j) {
		miJugador=j;
	}

	public void aceptarEnemigo(Enemigo ene) {
		miJugador.RecibirDanio(5);
	}

	public void aceptarPremio(Premio p) {//aun nada
		p.activar();
		p.eliminar(); 
	}

	public void aceptarProyectilEnemigo(ProyectilEnemigo p) {
		p.ImpactarPersonaje(miJugador);
	}

}
