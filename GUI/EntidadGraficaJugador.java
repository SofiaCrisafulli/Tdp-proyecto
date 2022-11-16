package GUI;

import javax.swing.JLabel;
import LogicaAbstracta.Entidad;

public class EntidadGraficaJugador extends EntidadGrafica {
	
	public EntidadGraficaJugador(int x,int y,Entidad e) {
		miEntidad=e;
		miGrafico=new JLabel();
		miGrafico.setBounds(343,400,35, 35);
		acomodarImagen("/img/nave_jugador.png");
		e.getNivel().getJuego().getGUI().getlabel().add(miGrafico);
		miGrafico.setVisible(true);
		miGrafico.setFocusable(true);
	}
	


}
