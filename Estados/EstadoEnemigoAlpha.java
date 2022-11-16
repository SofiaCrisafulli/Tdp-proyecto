package Estados;

import Logica.ProyectilEnemigoAlpha;
import LogicaAbstracta.Estado;
import LogicaAbstracta.Personaje;

public class EstadoEnemigoAlpha extends Estado{

	public EstadoEnemigoAlpha(Personaje e) {
		miEntidad=e;
	}

	public void disparar() {
		int x= miEntidad.getCorx()+10;		
		int y=miEntidad.getCorY()+10;
		new ProyectilEnemigoAlpha(x,y,miEntidad.getNivel());
	}

}
