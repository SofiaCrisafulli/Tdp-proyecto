package Logica;

import GUI.EntidadGraficaProyectilAliado;
import Juego.Nivel;
import LogicaAbstracta.Proyectil;


public class ProyectilAliado extends Proyectil {

	public ProyectilAliado(int x,int y,Nivel p) {
		danio=15;
		velocidad=14;				
		miNivel=p;
		posX=x;
		posY=y;
		miGrafico= new EntidadGraficaProyectilAliado(x,y,this);
		miNivel=p;
		miNivel.addEntidad(this);
	}

	public void turno() {
		for(int i=0;i<velocidad;i++) {
			moverse('w');
		}
		colision();
	}

}
