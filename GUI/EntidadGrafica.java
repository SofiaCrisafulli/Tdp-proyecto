package GUI;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import LogicaAbstracta.Entidad;

public abstract class EntidadGrafica {

	protected JLabel miGrafico;
	protected Entidad miEntidad;

	public void ActualizarPosicion(int posX,int posY) {
		miGrafico.setLocation(posX, posY);
	}

	public void setGrafico(String i) {
		acomodarImagen(i);
	}

	public void eliminar() {
		miGrafico.setIcon(null);
		miEntidad.getNivel().getJuego().getGUI().remove(miGrafico);
	}

	protected void acomodarImagen(String img) {
		ImageIcon aux=new ImageIcon(this.getClass().getResource(img));
		Icon toChange= new ImageIcon(aux.getImage().getScaledInstance(miGrafico.getWidth(), miGrafico.getHeight(), Image.SCALE_DEFAULT));
		miGrafico.setIcon(toChange);
	}

	public Rectangle hitbox() {
		return miGrafico.getBounds();
	}
}
