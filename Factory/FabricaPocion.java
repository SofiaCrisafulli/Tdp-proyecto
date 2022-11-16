package Factory;

import Juego.Nivel;
import Logica.Pocion;
import LogicaAbstracta.Premio;

public class FabricaPocion extends FabricaPremio{

	public Premio nuevoPremio(int x,int y, Nivel n) {
		return new Pocion(x,y,n);
		
	}
}
