package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Juego.Juego;
import Logica.Jugador;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JLabel l_fondo;
	private Jugador jugador;
	private Juego juego;
	private JLabel vida;
	private JLabel aAgregar;
	private static JLabel l_nivel = new JLabel();
	private Clip clip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/icono.png")));
		setResizable(false);
		setTitle("Star Wars: Rise of the empire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JButton b_musica= new JButton("Musica ON");
		b_musica.setBounds(650, 510, 120, 20);
		contentPane.add(b_musica);
		b_musica.setFocusable(false);
		b_musica.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 10));


		JButton b_musicaOff= new JButton("Musica OFF");
		b_musicaOff.setBounds(525, 510, 120, 20);
		contentPane.add(b_musicaOff);
		b_musicaOff.setFocusable(false);
		b_musicaOff.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 10));

		l_fondo = new JLabel("");
		l_fondo.setIcon(new ImageIcon(this.getClass().getResource("/img/fondoNivel1.jpg")));
		l_fondo.setBounds(0, 0, 770, 540);
		contentPane.add(l_fondo);

		requestFocusInWindow();



		vida= new JLabel();
		vida.setForeground(Color.WHITE);
		vida.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		l_fondo.add(vida);
		vida.setBounds(10,-30,130,100);


		l_fondo.add(l_nivel);
		l_nivel.setBounds(710,-30,500,100);
		l_nivel.setForeground(Color.WHITE);
		l_nivel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));

		b_musica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL path=this.getClass().getResource("/img/sonido.wav");
				try {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
					clip = AudioSystem.getClip();

					clip.open(audioInput);
					clip.start();


				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}

			}
		});

		b_musicaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clip.stop();
			}
		});
	}

	public JLabel getlabel() {
		return l_fondo;
	}

	public void agregarOyenteTeclas(KeyListener kl) {
		addKeyListener(kl);
	}
	public void actualizarVida(int a) {
		if(a<0)
			a=0;
		String aux=("Vida:"+a+"%");
		vida.setText(aux);
	}

	public void perder() {
		aAgregar= new JLabel(""); 
		aAgregar.setIcon(new ImageIcon(this.getClass().getResource("/img/perdiste.png")));
		aAgregar.setBounds(110,120,550,300);
		l_fondo.add(aAgregar);
		aAgregar.setVisible(true);
		this.repaint();
	}

	public void ganar() {
		aAgregar= new JLabel(""); 
		aAgregar.setIcon(new ImageIcon(this.getClass().getResource("/img/ganaste.png")));
		aAgregar.setBounds(110,120,550,300);
		l_fondo.add(aAgregar);
		aAgregar.setVisible(true);
		this.repaint();
	}

	public static void setearNivel(String s) {
		l_nivel.setText(s);
	}

	public void cambiarFondo(String ruta) {
		l_fondo.setIcon(new ImageIcon(this.getClass().getResource(ruta)));
	}

}
