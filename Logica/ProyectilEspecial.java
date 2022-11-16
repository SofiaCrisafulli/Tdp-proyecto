package Logica;

import Juego.Nivel;

public class ProyectilEspecial extends ProyectilAliado{

	public ProyectilEspecial(int x, int y, Nivel p) {
		super(x, y, p);
		danio = danio * 2; 
		miGrafico.setGrafico("/img/disparoazul.png");
	}
}
