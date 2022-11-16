package Hilos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.GUI;
import Logica.Jugador;

public class HiloTeclado extends Thread implements KeyListener {

	private Jugador jugador;
	private GUI GUI;

	public HiloTeclado(GUI GUI,Jugador jugador) {
		this.jugador=jugador;
		this.GUI=GUI;
		GUI.agregarOyenteTeclas(this);
		GUI.requestFocus();
	}

	@Override
	public void run() {
		boolean fin=false;
		jugador.setDireccion('d');
		while(!fin){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:jugador.setDireccion('d');
		break;
		case KeyEvent.VK_LEFT:jugador.setDireccion('a');
		break;
		case KeyEvent.VK_D:jugador.setDireccion('d');
		break;
		case KeyEvent.VK_A:jugador.setDireccion('a');
		break;
		case KeyEvent.VK_W:jugador.disparar();
		break;
		case KeyEvent.VK_UP:jugador.disparar();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
