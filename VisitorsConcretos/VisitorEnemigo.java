package VisitorsConcretos;

import LogicaAbstracta.Personaje;
import LogicaAbstracta.Proyectil;
import LogicaAbstracta.VisitorAbstracto;

public class VisitorEnemigo  extends VisitorAbstracto {

	public VisitorEnemigo(Personaje ene) {
		miPj=ene;
	}

	public void aceptarProyectil(Proyectil L) {
		L.ImpactarPersonaje(miPj);

	}

}
