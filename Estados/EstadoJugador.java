package Estados;

import Logica.ProyectilAliado;
import LogicaAbstracta.Estado;
import LogicaAbstracta.Personaje;

public class EstadoJugador extends Estado {

	public EstadoJugador(Personaje e) {
		miEntidad=e;
	}

	@Override
	public void disparar() {		
		int x=miEntidad.getCorx()+10;		 
		int y=miEntidad.getCorY()+10;
		new ProyectilAliado(x,y,miEntidad.getNivel());
	}
	
}
