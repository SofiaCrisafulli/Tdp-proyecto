package Factory;

import Juego.Nivel;
import Logica.NuevoPoder;
import LogicaAbstracta.Premio;

public class FabricaNuevoPoder extends FabricaPremio {

	public Premio nuevoPremio(int x,int y, Nivel n) {
		return new NuevoPoder(x,y,n);
		
	}
	
}
