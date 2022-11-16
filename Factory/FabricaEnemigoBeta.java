package Factory;

import Juego.Nivel;
import Logica.EnemigoBeta;
import LogicaAbstracta.Enemigo;

public class FabricaEnemigoBeta extends FabricaEnemigo {

	@Override
	public Enemigo crearEnemigo(Nivel n, int x, int y) {
		Enemigo e= new EnemigoBeta(n,x,y); 
		return e;	
	}

}
