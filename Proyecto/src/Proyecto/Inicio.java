package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;

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
	
	JComboBox Tipo;
	private JPasswordField pfClave;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Inicio");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(85, 29, 73, 52);
		contentPane.add(lblTitulo);
		
		tfID = new JTextField();
		tfID.setBounds(115, 147, 113, 28);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblID_Titulo = new JLabel("ID:");
		lblID_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID_Titulo.setBounds(10, 147, 79, 25);
		contentPane.add(lblID_Titulo);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave.setBounds(10, 200, 79, 25);
		contentPane.add(lblClave);
		
		
		String[] tipoos = {"Jugador", "Administrador"};
		Tipo = new JComboBox(tipoos);
		Tipo.setBounds(115, 91, 114, 22);
		contentPane.add(Tipo);
		
		
		
		JLabel lblID_Titulo_1 = new JLabel("Tipo:");
		lblID_Titulo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID_Titulo_1.setBounds(10, 88, 79, 25);
		contentPane.add(lblID_Titulo_1);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clavetempo = " ";
				int IDtempo = 0;
				
				try {
					IDtempo = Integer.parseInt(tfID.getText());
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Se debe ingresar un numero válido!!!");
				}
				
				if(IDtempo != 0) {
					if(pfClave.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Se debe ingresar una clave!!!");
					}else {
						
						
						
						if(Tipo.getSelectedItem().equals("Jugador")) {
							clavetempo = pfClave.getText();
							
							if(Jugador.ingresar(clavetempo, IDtempo)) {
								JOptionPane.showMessageDialog(null, "Redireccionando...");
								Personajes_Menu pm = new Personajes_Menu();
								
								pm.lblIDJugador.setText(String.valueOf(IDtempo));
								pm.setVisible(true);
								Inicio.this.dispose();
								
								
							}else {
								JOptionPane.showMessageDialog(null, "Los datos ingresados no coinciden");
							}
							
							
							
						}
						
						
						
					}
					
					
					
					
					
					
					
				}
				
				
				
				
				
				
			}
		});
		btnIngresar.setBounds(115, 256, 113, 28);
		contentPane.add(btnIngresar);
		
		pfClave = new JPasswordField();
		pfClave.setBounds(115, 204, 113, 20);
		contentPane.add(pfClave);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Jugador");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistrarUsuario.setBounds(371, 29, 196, 52);
		contentPane.add(lblRegistrarUsuario);
		
		JLabel lblClave_1 = new JLabel("Clave:");
		lblClave_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave_1.setBounds(334, 207, 79, 25);
		contentPane.add(lblClave_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(423, 211, 113, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(423, 151, 113, 28);
		contentPane.add(textField);
		
		JLabel lblClave_1_1 = new JLabel("Nombre:");
		lblClave_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave_1_1.setBounds(334, 154, 79, 25);
		contentPane.add(lblClave_1_1);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals("") || textField.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Se debe ingresar algo en ambos campos!!");
				}else {
					Jugador.registrarJugadores(passwordField.getText(), textField.getText());
				}
				
				
			}
		});
		btnRegistrar.setBounds(435, 259, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
