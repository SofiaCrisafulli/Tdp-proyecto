package Logica;

import Estados.EstadoEnemigoAlpha;
import GUI.EntidadGraficaEnemigoAlpha;
import Juego.Nivel;
import LogicaAbstracta.Enemigo;
import VisitorsConcretos.VisitorEnemigo;

public class EnemigoAlpha extends Enemigo {

	protected int vidaMaxima;
	protected boolean velocidadAumentada;

	public EnemigoAlpha(Nivel n,int x,int y) {
		posX=x; 
		posY=y;
		miNivel=n;
		velocidad=3;
		miGrafico=new EntidadGraficaEnemigoAlpha(x,y,this);
		miVisitor=new VisitorEnemigo(this);
		estadoActual= new EstadoEnemigoAlpha(this);
		rango=200;
		cooldown=0;
		vida=100;
		vidaMaxima=vida;
		velocidadAumentada=false;
	}

	@Override
	public void resetCooldown() {
		cooldown=50;	
	}

	public void RecibirDanio(int dmg) {
		super.RecibirDanio(dmg);
		if(vida<=((vidaMaxima*20)/100)&&!velocidadAumentada) {
			velocidad=velocidad*2;
			velocidadAumentada=true;
		}
	}

	@Override
	public void resetEstado() {
		estadoActual= new EstadoEnemigoAlpha(this);
	}
}
