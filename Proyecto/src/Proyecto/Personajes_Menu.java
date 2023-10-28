package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Personajes_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personajes_Menu frame = new Personajes_Menu();
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
	JLabel lblIDJugador;
	
	
	public Personajes_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditarPersonajes = new JButton("");
		btnEditarPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seleccionar_Personaje sp = new Seleccionar_Personaje();
				sp.lblIDJ.setText(lblIDJugador.getText());
				sp.setVisible(true);
				Personajes_Menu.this.dispose();
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes_Menu.this.dispose();
			}
		});
		
		lblIDJugador = new JLabel("...");
		lblIDJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIDJugador.setForeground(Color.WHITE);
		lblIDJugador.setBounds(210, 144, 78, 31);
		contentPane.add(lblIDJugador);
		btnSalir.setBounds(44, 462, 89, 23);
		contentPane.add(btnSalir);
		btnEditarPersonajes.setIcon(new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/ImagenesP/Boton_Editar_Personajes.png")));
		btnEditarPersonajes.setBackground(Color.BLUE);
		btnEditarPersonajes.setBounds(731, 408, 150, 90);
		contentPane.add(btnEditarPersonajes);
		
		JButton btVerPersonajes = new JButton("");
		btVerPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Personajes mostrar = new Ver_Personajes();
				mostrar.lblIDJ.setText(lblIDJugador.getText());
				mostrar.setVisible(true);
				Personajes_Menu.this.dispose();
			}
		});
		btVerPersonajes.setIcon(new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/ImagenesP/Boton_Ver_Personajes.png")));
		btVerPersonajes.setBackground(Color.BLUE);
		btVerPersonajes.setBounds(731, 236, 150, 90);
		contentPane.add(btVerPersonajes);
		
		JButton btnCrearPersonaje = new JButton("");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Personaje temp = new Crear_Personaje();
				temp.lblIDJ.setText(lblIDJugador.getText());
				temp.setVisible(true);
				Personajes_Menu.this.dispose();
				
			}
		});
		btnCrearPersonaje.setSelectedIcon(null);
		btnCrearPersonaje.setBackground(Color.BLUE);
		btnCrearPersonaje.setIcon(new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/ImagenesP/Boton_Crear_Personaje.png")));
		btnCrearPersonaje.setBounds(731, 99, 150, 90);
		contentPane.add(btnCrearPersonaje);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/ImagenesP/Personajes_2.png")));
		lblNewLabel.setBounds(106, 24, 500, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblSesion = new JLabel("Sesion bajo el Jugador con ID: ");
		lblSesion.setForeground(Color.WHITE);
		lblSesion.setBackground(Color.WHITE);
		lblSesion.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSesion.setBounds(200, 113, 265, 38);
		contentPane.add(lblSesion);
		
		JButton btnPelearCPU = new JButton("Vs. CPU");
		btnPelearCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seleccionar_Personajes sps = new Seleccionar_Personajes();
				sps.lblIDJ.setText(lblIDJugador.getText());
				sps.setVisible(true);
				Personajes_Menu.this.dispose();
				
			}
		});
		btnPelearCPU.setBounds(224, 349, 142, 96);
		contentPane.add(btnPelearCPU);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/ImagenesP/Fondo_Menu_Personajes.png")));
		Fondo.setBounds(0, 0, 1008, 587);
		contentPane.add(Fondo);
	}
}
