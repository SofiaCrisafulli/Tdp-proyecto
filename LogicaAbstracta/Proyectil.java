package LogicaAbstracta;

public abstract class Proyectil extends Entidad  {

	protected int danio;

	public int miDanio() {
		return danio;
	}

	protected void aceptame(Personaje e) {	
		e.aceptarProyectil(this);
	}

	public void ImpactarPersonaje(Personaje pj) {
		pj.RecibirDanio(danio);
		this.eliminar();
	}

	public  void eliminar() {
		miGrafico.eliminar();
		miNivel.removeEntidad(this);	
	}

	public synchronized void moverse(char s) {
		super.moverse(s);
		if(posY==0)
			eliminar(); 
	}
}