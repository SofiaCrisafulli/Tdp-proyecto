package Factory;

import Juego.Nivel;
import Logica.Paralisis;
import LogicaAbstracta.Premio;

public class FabricaParalisis extends FabricaPremio {

	@Override
	public Premio nuevoPremio(int x,int y, Nivel n) {
		return new Paralisis(x,y,n);
		
	}

}
