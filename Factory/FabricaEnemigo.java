package Factory;

import Juego.Nivel;
import LogicaAbstracta.Enemigo;

public abstract class FabricaEnemigo {
	
	public abstract Enemigo crearEnemigo(Nivel n,int x,int y); 
	 
}
