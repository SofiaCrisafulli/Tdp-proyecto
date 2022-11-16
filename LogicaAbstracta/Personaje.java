package LogicaAbstracta;

import Logica.Jugador;

public abstract class Personaje extends Entidad  {

	protected VisitorAbstracto miVisitor;
	protected int vida;
	protected int cooldown;
	protected Estado estadoActual;
	protected char direccionActual;

	public void disparar() {
		if(cooldown==0) {
			estadoActual.disparar();
			resetCooldown();
		}
	}

	protected abstract void resetCooldown();

	public  void cambiarEstado(Estado est) {
		estadoActual=est;
	}

	public void RecibirDanio(int dmg) {
		vida=vida-dmg;
		if(vida<=0)
			eliminar();
	}

	public void setVida(int v) {
		vida=v;
	}

	public int getVida() {
		return vida;
	}

	public Estado getEstadoActual() { 
		return estadoActual;
	}
	public void aceptarEnemigo(Enemigo e) {
		miVisitor.aceptarEnemigo(e);
	}
	public void aceptarJugador(Jugador j) {
		miVisitor.aceptarJugador(j);
	}
	public void aceptarPremio(Premio p) {
		miVisitor.aceptarPremio(p);
	}
	public void aceptarProyectil(Proyectil p) {
		miVisitor.aceptarProyectil(p);
	}
	public void aceptarProyectilEnemigo(ProyectilEnemigo p) {
		miVisitor.aceptarProyectilEnemigo(p);
	}

	public abstract void resetEstado();

}
