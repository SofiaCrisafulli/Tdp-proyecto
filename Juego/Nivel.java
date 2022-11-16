package Juego;

import Logica.Jugador;
import LogicaAbstracta.Entidad;
import LogicaAbstracta.Personaje;
import java.util.ArrayList;
import Factory.FabricaEnemigo;
import Factory.FabricaEnemigoAlpha;
import Factory.FabricaEnemigoBeta;
import Factory.FabricaPremio;
import Hilos.MovimientoDelJuego;

public abstract class Nivel{

	protected ArrayList<ArrayList<Personaje>> enemigos;	
	protected  ArrayList<Entidad> Entidades;		
	protected Jugador jugador  ;
	protected Juego miJuego;
	protected int cantOleadas;
	protected boolean ganar;
	protected Nivel siguienteNivel;

	public void removeEnemigo(Personaje p) {
		enemigos.get(0).remove(p);
	}

	public Juego getJuego() {
		return miJuego;
	}

	public ArrayList<Personaje> colision(Entidad e) {
		ArrayList<Personaje> colisiones = new ArrayList<Personaje>();
		if(jugador!=e && jugador.getHitbox().intersects(e.getHitbox()))
			colisiones.add(jugador);
		for(Personaje r: enemigos.get(0)) {
			if(e!=r &&  r.getHitbox().intersects(e.getHitbox()))
				colisiones.add(r);
		}
		return colisiones;
	}

	public void setJugador(Jugador jugador2) {
		jugador=jugador2;
	}

	public  void  turno() {
		if(!enemigos.isEmpty()) {
			ArrayList<Entidad> aux= new ArrayList<Entidad>();	
			for(Entidad e: enemigos.get(0))					
				aux.add(e);
			for(Entidad r: Entidades)
				aux.add(r);
			MoverEntidades(aux);
			jugador.turno();
			comprobarLista();
		}else {
			this.reset();		
			if(siguienteNivel!=null)
				miJuego.actualizarNivel(siguienteNivel);
			else {
				MovimientoDelJuego.fin();
				miJuego.ganar();
			}
		}
	}

	public void addEntidad(Entidad p) {
		Entidades.add(p);
	}

	

	public ArrayList<Personaje> getEnemigos() { 
		ArrayList<Personaje>ene;
		if(enemigos.size()==0)
			ene=null;
		else
			ene=enemigos.get(0);
		return ene;
	}

	public void removeEntidad(Entidad e) {
		Entidades.remove(e);

	}

	protected void MoverEntidades(ArrayList<Entidad> list) {
		for(Entidad e: list )
			e.turno();
	}

	public void reset() {
		ArrayList<Entidad> aux= new ArrayList<Entidad>();
		for(ArrayList<Personaje> lista: enemigos) {
			for(Entidad e:lista)
				aux.add(e);
		}
		for(Entidad e:Entidades)
			aux.add(e);

		for(Entidad e:aux)
			e.eliminar();
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void comprobarLista() { 
		if(enemigos.get(0).isEmpty())
			enemigos.remove(0);
	}

	protected void crearOleadas(int cantEnemigosOleada) { 
		ArrayList<Personaje> oleada;
		int x = 0;
		int y = -50;
		FabricaEnemigo enemigoA = new FabricaEnemigoAlpha();
		FabricaEnemigo enemigoB =new FabricaEnemigoBeta();
		int cantEnemigos = 0;
		int cantEnemigosAnterior;
		for(int i = 0; i < cantOleadas; i++) { 
			oleada = new ArrayList<Personaje>();
			cantEnemigosAnterior=cantEnemigos;
			cantEnemigos = (int) (cantEnemigosOleada -((Math.random()*cantEnemigosOleada)/2+1))+cantEnemigosAnterior;
			while(oleada.size() < cantEnemigos) { 
				x++;
				int VariacionX= (int)(Math.random()*20)+1;
				int VariacionY=(int)((Math.random()*6)+1)*-1;
				int aux=(int)(Math.random()*2+1);
				if(aux==1)
					oleada.add(enemigoA.crearEnemigo(this,( x * 60) + VariacionX, y+VariacionY));
				else
					oleada.add(enemigoB.crearEnemigo(this,( x * 60) + VariacionX, y+VariacionY));
				if(x >= 10) {
					y = y - 60;
					x=1;
				}
			}
			enemigos.add(oleada);
		}
	}

	public abstract void cambiarFondo();

	public abstract void cambiarNivel();
}

