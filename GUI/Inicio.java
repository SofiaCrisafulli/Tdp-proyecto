package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import InicioDelJuego.InicioDelJuego;
import Juego.Juego;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Juego miJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/icono.png")));
		setTitle("Star Wars: Rise of the empire ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Boton_iniciar = new JButton("Iniciar");
		Boton_iniciar.setBounds(0, 321, 668, 37);
		contentPane.add(Boton_iniciar);
		Boton_iniciar.setFocusable(false);
		
		
		Boton_iniciar.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				GUI g=new GUI();//Instancio una Gui para hacerla visible al momento que el usuario presione le boton Iniciar.
				contentPane.setVisible(false);
				g.setVisible(true);
				dispose();
				miJ=new Juego(g);
				InicioDelJuego.empezar();		
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/cartelInicio.jpg")));
		lblNewLabel.setBounds(0, 0, 668, 358);
		contentPane.add(lblNewLabel);
	}
	
	public Juego rJ() {
		return miJ;
	}
}
