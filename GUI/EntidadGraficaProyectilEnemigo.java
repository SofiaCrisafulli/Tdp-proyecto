package GUI;

import javax.swing.JLabel;

import LogicaAbstracta.Entidad;

public class EntidadGraficaProyectilEnemigo extends EntidadGrafica {
	public EntidadGraficaProyectilEnemigo(int x, int y,Entidad e) {
		miEntidad=e;
		miGrafico=new JLabel();
		miGrafico.setBounds(x,y,5, 10);
		e.getNivel().getJuego().getGUI().getlabel().add(miGrafico);
		acomodarImagen("/img/disparoverde.png");
		miGrafico.setVisible(true);
	}
}
