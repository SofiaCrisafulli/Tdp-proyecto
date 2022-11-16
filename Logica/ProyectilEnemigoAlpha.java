package Logica;


import GUI.EntidadGraficaProyectilEnemigo;
import Juego.Nivel;
import LogicaAbstracta.Personaje;
import LogicaAbstracta.ProyectilEnemigo;


public class ProyectilEnemigoAlpha extends ProyectilEnemigo {

	public ProyectilEnemigoAlpha(int x,int y,Nivel p){
		danio=20;
		velocidad=14;				
		miNivel=p;
		posX=x;
		posY=y;
		miGrafico= new EntidadGraficaProyectilEnemigo(x,y,this);
		miNivel=p;
		miNivel.addEntidad(this);
	}


}
