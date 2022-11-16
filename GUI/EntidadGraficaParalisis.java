package GUI;

import javax.swing.JLabel;

import LogicaAbstracta.Entidad;

public class EntidadGraficaParalisis extends EntidadGrafica{
	
	public EntidadGraficaParalisis(int x, int y,Entidad e) {
		miEntidad=e;
		miGrafico=new JLabel();
		miGrafico.setBounds(x,y,40, 40);
		acomodarImagen("/img/relojblanco.gif");
		e.getNivel().getJuego().getGUI().getlabel().add(miGrafico);
		miGrafico.setVisible(true);	
	}
}
