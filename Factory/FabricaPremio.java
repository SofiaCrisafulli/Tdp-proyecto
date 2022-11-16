package Factory;

import Juego.Nivel;
import LogicaAbstracta.Premio;

public abstract class FabricaPremio {

	public abstract Premio nuevoPremio(int x,int y, Nivel n);
	
}
