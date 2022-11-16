package Estados;

import Logica.ProyectilEnemigoBeta;
import LogicaAbstracta.Estado;
import LogicaAbstracta.Personaje;

public class EstadoEnemigoBeta extends Estado{

	public EstadoEnemigoBeta(Personaje e) {
		miEntidad=e;
	}

	public void disparar() {
		int x= miEntidad.getCorx()+10;		
		int y=miEntidad.getCorY()+10;
		new ProyectilEnemigoBeta(x,y,miEntidad.getNivel());
	}

}
