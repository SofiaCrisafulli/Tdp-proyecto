package GUI;

import javax.swing.JLabel;

import LogicaAbstracta.Entidad;

public class EntidadGraficaSuperArma extends EntidadGrafica{
	 
	public EntidadGraficaSuperArma(int x, int y,Entidad e) {
		miEntidad=e;
		miGrafico=new JLabel();
		miGrafico.setBounds(x,y,40, 40);
		acomodarImagen("/img/premioArma.png");
		e.getNivel().getJuego().getGUI().getlabel().add(miGrafico);
		miGrafico.setVisible(true);	
	}
}
