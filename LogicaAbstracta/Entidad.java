package LogicaAbstracta;

import java.awt.Rectangle;
import java.util.ArrayList;
import GUI.EntidadGrafica;
import Juego.Nivel;

public abstract class Entidad {

	protected int velocidad;
	protected EntidadGrafica miGrafico;
	protected int posX;					
	protected int posY;	
	protected Nivel miNivel;
	public abstract void eliminar();

	public Nivel getNivel() {
		return miNivel;
	}

	public int getCorx() {
		return posX;
	}

	public int getCorY() {
		return posY;
	}

	public void moverse(char s) {
		switch(s) {					
		case('a'):
		{
			if(posX>0)				
				posX--;
		}break;
		case('s'):
		{
			if(posY<550) {
				posY++;
			}else posY=0;;
		}break;
		case('d'):
		{
			if(posX<735)			
				posX++;
		}break;
		case('w'):					
		{
			if(posY>0) {
				posY--;
			}else posY=550;
		}break;
		}
		miGrafico.ActualizarPosicion(posX, posY);	
	}
	public abstract void turno();

	public Rectangle getHitbox() {
		return miGrafico.hitbox();
	}

	protected abstract void aceptame(Personaje e); 

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int v) { 
		velocidad = v;
	}

	protected void colision() {
		ArrayList<Personaje> aux =miNivel.colision(this); 
		for(Personaje e:aux) {
			aceptame(e);
		}
	}
}
