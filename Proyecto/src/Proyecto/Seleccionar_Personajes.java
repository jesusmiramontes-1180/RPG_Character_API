package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class Seleccionar_Personajes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblImgCPU;
	private JLabel lblImg;
	private JTextField tfPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccionar_Personajes frame = new Seleccionar_Personajes();
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
	Connection n = Conexion.conectar();
	Statement s = null;
	ResultSet res = null;
	
	String nom = "", ruta = "", clas = "";
	String nomCPU = "", rutaCPU = "";
	int idp = 0, idcpu;
	
	JLabel lblPersonaje;
	private JLabel lblClase;
	private JButton btnEmpezar;
	private JLabel lblTituloID;
	JLabel lblIDJ;
	JCheckBox Listo;
	private JScrollPane scrollPane;
	
	
	
	public Seleccionar_Personajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 344, 789, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes_Menu pm = new Personajes_Menu();
				pm.lblIDJugador.setText(lblIDJ.getText());
				
				pm.setVisible(true);
				
				Seleccionar_Personajes.this.dispose();
			}
		});
		btnCancelar.setBounds(24, 553, 89, 23);
		contentPane.add(btnCancelar);
		
		lblImgCPU = new JLabel("");
		lblImgCPU.setBounds(759, 47, 150, 150);
		contentPane.add(lblImgCPU);
		
		lblImg = new JLabel("");
		lblImg.setBounds(24, 47, 150, 150);
		contentPane.add(lblImg);
		
		tfPlayer = new JTextField();
		tfPlayer.setBounds(234, 295, 125, 20);
		contentPane.add(tfPlayer);
		tfPlayer.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IDtempo = 0;
				if(tfPlayer.getText().equals("")) {
					
				}else {
					try {
						IDtempo = Integer.parseInt(tfPlayer.getText());
					}catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Se debe ingresar un numero válido!!!");
					}
					
					if(IDtempo != 0) {
						System.out.println("su");
						try {
							s = n.createStatement();
							res = s.executeQuery("SELECT p.idPERSONAJE, p.Nombre, p.Clase, p.Ruta FROM PERSONAJE p JOIN  JUGADOR_PERSONAJES jp ON jp.idPERSONAJE = p.idPERSONAJE WHERE p.idPERSONAJE = "+IDtempo+" and jp.idJUGADOR = "+lblIDJ.getText()+";");
							
							
							if(res.next() == false   ) {
								JOptionPane.showMessageDialog(null, "No se encontró el ID ingresado para este Jugador");
								
							}else {
								do {
									nom = res.getString("Nombre");
									clas = res.getString("Clase");
									ruta = res.getString("Ruta");
									idp = res.getInt("idPERSONAJE");
									
									lblImg.setIcon( new ImageIcon(Personajes_Menu.class.getResource(ruta)));
									lblPersonaje.setText("Personaje: " + nom);
									lblClase.setText("Clase: " + clas);
								}while(res.next());
							}
							res.close();
							s.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
					}	
					}	
				}
			}
		});
		btnSeleccionar.setBounds(392, 281, 130, 36);
		contentPane.add(btnSeleccionar);
		btnSeleccionar.setVisible(false);
		
		JLabel lblRival = new JLabel("Rival: ");
		lblRival.setBounds(759, 221, 130, 36);
		contentPane.add(lblRival);
		
		JButton btnPelear = new JButton("Pelear!");
		btnPelear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Listo.isSelected() && idp != 0) {
					Pelea p = new Pelea();
					p.lblCPU.setText(String.valueOf(idcpu));
					p.lblID.setText(String.valueOf(idp));
					
					p.setVisible(true);
					
					Seleccionar_Personajes.this.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Selecciona un personaje y marca la casilla!!");
				}
				
				
			
				
			}
		});
		btnPelear.setBounds(392, 111, 118, 43);
		contentPane.add(btnPelear);
		btnPelear.setVisible(false);
		
		lblPersonaje = new JLabel("Personaje: ");
		lblPersonaje.setBounds(24, 228, 125, 29);
		contentPane.add(lblPersonaje);
		
		lblClase = new JLabel("Clase:");
		lblClase.setBounds(24, 257, 125, 29);
		contentPane.add(lblClase);
		
		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int IDtempo = (int)(Math.random() * ((5 - 1) + 1)) + 1;
					s = n.createStatement();
					res = s.executeQuery("SELECT p.idPERSONAJE, p.Nombre, p.Ruta FROM PERSONAJE p WHERE p.idPERSONAJE = "+IDtempo+";");
					
					while(res.next()) {
						nomCPU = res.getString("Nombre");
						rutaCPU = res.getString("Ruta");
						idcpu = res.getInt("idPERSONAJE");
					}
					
					
					lblImgCPU.setIcon( new ImageIcon(Personajes_Menu.class.getResource(rutaCPU)));
					lblRival.setText("Rival: " + nomCPU);
					
					res.close();
					s.close();
					
					s = n.createStatement();
					res = s.executeQuery("SELECT p.idPERSONAJE as 'ID', p.Nombre, p.Clase, p.TipoHabilidad as 'Hab'"
							+ "FROM PERSONAJE p JOIN JUGADOR_PERSONAJES jp ON jp.idPERSONAJE = p.idPERSONAJE WHERE jp.idJUGADOR = "+lblIDJ.getText()+"; ");
					ResultSetMetaData res1 = res.getMetaData();
					
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					int cols = res1.getColumnCount();
					String[] colN = new String [cols];
					for(int i = 0; i < cols; i++) {
						colN[i] = res1.getColumnName(i+1);
					}
					
					m.setColumnIdentifiers(colN);
					
					while(res.next()) {
						String[] fila = { String.valueOf(res.getInt("ID")),res.getString("Nombre") ,res.getString("Clase"),  res.getString("Hab")};
						m.addRow(fila);
						

					}
					
					res.close();
					s.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btnEmpezar.setVisible(false);
				Listo.setVisible(true);
				btnSeleccionar.setVisible(true);
				btnPelear.setVisible(true);
			}
		});
		btnEmpezar.setBounds(368, 202, 188, 45);
		contentPane.add(btnEmpezar);
		
		lblTituloID = new JLabel("Selecciona un ID");
		lblTituloID.setBounds(235, 270, 124, 14);
		contentPane.add(lblTituloID);
		
		lblIDJ = new JLabel("...");
		lblIDJ.setBounds(10, 387, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
		
		Listo = new JCheckBox("Listo");
		Listo.setBounds(262, 155, 97, 23);
		contentPane.add(Listo);
		Listo.setVisible(false);
	}
}
