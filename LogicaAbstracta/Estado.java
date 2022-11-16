package LogicaAbstracta;

public abstract class Estado { 
	protected Personaje miEntidad;

	public abstract void disparar();

	public void movimiento(char c, int v) {
		for(int i=0;i<=v;i++) {
			miEntidad.moverse(c);
		}
	}
}
