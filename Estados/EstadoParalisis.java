package Estados;

import LogicaAbstracta.Estado;
import LogicaAbstracta.Personaje;

public class EstadoParalisis extends Estado{

	public EstadoParalisis(Personaje p) { 
		miEntidad = p;
	}
	public void disparar() {

	}

	public void movimiento(char c, int v) {

	}

}
