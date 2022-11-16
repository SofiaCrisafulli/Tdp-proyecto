package LogicaAbstracta;

public abstract class Premio extends Entidad {

	protected int fin=100;

	public  void eliminar() {
		miGrafico.eliminar();
		miNivel.removeEntidad(this);
	}
	public void aceptame(Personaje e) {
		e.aceptarPremio(this);
	}

	public abstract void activar();

	public void turno() {
		if(posY<=430) {
			for(int i = 0; i < velocidad; i++)
				moverse('s');
		}else
			fin--;

		if(fin==0)
			eliminar();	
		colision();
	}
}
