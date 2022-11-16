package Factory;

import Juego.Nivel;
import Logica.EnemigoAlpha;
import LogicaAbstracta.Enemigo;

public class FabricaEnemigoAlpha extends FabricaEnemigo {

	

	public Enemigo crearEnemigo(Nivel n,int x,int y) {
		EnemigoAlpha e= new EnemigoAlpha(n,x,y); 
		return e;							
	}										






}
