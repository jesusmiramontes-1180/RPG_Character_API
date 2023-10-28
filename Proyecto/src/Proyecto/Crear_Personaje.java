package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Crear_Personaje extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_Personaje frame = new Crear_Personaje();
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
	CallableStatement cl = null;
	
	
	
	Personaje temp;
	
	int claseSeleccionada= 0;
	
	JRadioButton rdbtnEspadachin;
	JRadioButton rdbtnArquero;
	
	
	JLabel lblClaseSeleccionada;
	JLabel lblHP;
	JTextField tfHP;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JLabel lblHabilidad;
	JCheckBox check2;
	JCheckBox check1;
	JButton btnCrear;
	private JLabel lblStatsTitulo;
	private JLabel lblSHP;
	private JLabel lblSMP;
	private JLabel lblSDef;
	private JLabel lblSVoid;
	private JLabel lblSSpe;
	private JLabel lblMulti;
	private JLabel lblSDefM;
	private JLabel lblSVoidM;
	private JLabel lblSSpeM;
	private JLabel lblSAtk;
	private JLabel lblSMag;
	private JButton btnCancelar;
	private JButton btnSubir;
	private JLabel lblImg1;
	private JLabel lblImg2;
	private JLabel lblImg3;
	private JRadioButton rdbtnAsesino;
	private JRadioButton rdbtnInvocador;
	private JRadioButton rdbtnTanque;
	JRadioButton rbImg1, rbImg2, rbImg3;
	JLabel lblIDJ;
	
	public Crear_Personaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIDJ = new JLabel("...");
		lblIDJ.setForeground(Color.CYAN);
		lblIDJ.setBounds(544, 23, 63, 23);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
		
		rdbtnEspadachin = new JRadioButton("Espadachin");
		rdbtnEspadachin.setBounds(58, 47, 96, 23);
		contentPane.add(rdbtnEspadachin);
		
		rdbtnArquero = new JRadioButton("Arquero");
		rdbtnArquero.setBounds(156, 47, 76, 23);
		contentPane.add(rdbtnArquero);
		
		
		rdbtnAsesino = new JRadioButton("Asesino");
		rdbtnAsesino.setBounds(234, 47, 72, 23);
		contentPane.add(rdbtnAsesino);
		
		rdbtnInvocador = new JRadioButton("Invocador");
		rdbtnInvocador.setBounds(308, 47, 96, 23);
		contentPane.add(rdbtnInvocador);
		
		rdbtnTanque = new JRadioButton("Tanque");
		rdbtnTanque.setBounds(406, 47, 72, 23);
		contentPane.add(rdbtnTanque);
		
		rdbtnEspadachin.addActionListener(this);
		rdbtnArquero.addActionListener(this);
		rdbtnAsesino.addActionListener(this);
		rdbtnInvocador.addActionListener(this);
		rdbtnTanque.addActionListener(this);
		
		
		
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnArquero);
		group.add(rdbtnEspadachin);
		group.add(rdbtnAsesino);
		group.add(rdbtnInvocador);
		group.add(rdbtnTanque);
		
		lblClaseSeleccionada = new JLabel("Selecciona una Clase para empezar!!!");
		lblClaseSeleccionada.setForeground(Color.WHITE);
		lblClaseSeleccionada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClaseSeleccionada.setBounds(73, 89, 279, 35);
		contentPane.add(lblClaseSeleccionada);
		
		lblHP = new JLabel("HP");
		lblHP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHP.setForeground(Color.WHITE);
		lblHP.setBounds(58, 265, 174, 35);
		contentPane.add(lblHP);
		
		tfHP = new JTextField();
		tfHP.setBounds(276, 267, 189, 35);
		contentPane.add(tfHP);
		tfHP.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(156, 145, 89, 35);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(276, 147, 189, 35);
		contentPane.add(tfNombre);
		
		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHabilidad.setForeground(Color.WHITE);
		lblHabilidad.setBounds(156, 193, 97, 35);
		contentPane.add(lblHabilidad);
		
		check1 = new JCheckBox("");
		check1.setBounds(276, 199, 97, 23);
		contentPane.add(check1);
		
		check2 = new JCheckBox("");
		check2.setBounds(381, 199, 97, 23);
		contentPane.add(check2);
	
		
		
		ButtonGroup Habis = new ButtonGroup();
		Habis.add(check1);
		Habis.add(check2);
		
		lblStatsTitulo = new JLabel("Stats");
		lblStatsTitulo.setForeground(Color.WHITE);
		lblStatsTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatsTitulo.setBounds(773, 47, 97, 35);
		contentPane.add(lblStatsTitulo);
		
		lblSHP = new JLabel("HP: ");
		lblSHP.setForeground(Color.WHITE);
		lblSHP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSHP.setBounds(684, 81, 89, 46);
		contentPane.add(lblSHP);
		
		lblSMP = new JLabel("MP:");
		lblSMP.setForeground(Color.WHITE);
		lblSMP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSMP.setBounds(824, 81, 89, 46);
		contentPane.add(lblSMP);
		
		lblSDef = new JLabel("DEF: ");
		lblSDef.setForeground(Color.WHITE);
		lblSDef.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSDef.setBounds(684, 139, 89, 46);
		contentPane.add(lblSDef);
		
		lblSVoid = new JLabel("VOID: ");
		lblSVoid.setForeground(Color.WHITE);
		lblSVoid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSVoid.setBounds(822, 139, 118, 46);
		contentPane.add(lblSVoid);
		
		lblSSpe = new JLabel("VEL: ");
		lblSSpe.setForeground(Color.WHITE);
		lblSSpe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSSpe.setBounds(684, 199, 140, 46);
		contentPane.add(lblSSpe);
		
		lblMulti = new JLabel("MULTIPLICADORES");
		lblMulti.setForeground(Color.WHITE);
		lblMulti.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMulti.setBounds(684, 241, 140, 46);
		contentPane.add(lblMulti);
		
		lblSDefM = new JLabel("DEF M: ");
		lblSDefM.setForeground(Color.WHITE);
		lblSDefM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSDefM.setBounds(684, 355, 97, 46);
		contentPane.add(lblSDefM);
		
		lblSVoidM = new JLabel("VOID M: ");
		lblSVoidM.setForeground(Color.WHITE);
		lblSVoidM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSVoidM.setBounds(824, 355, 97, 46);
		contentPane.add(lblSVoidM);
		
		lblSSpeM = new JLabel("VEL M: ");
		lblSSpeM.setForeground(Color.WHITE);
		lblSSpeM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSSpeM.setBounds(684, 412, 140, 46);
		contentPane.add(lblSSpeM);
		
		lblSAtk = new JLabel("ATQ:");
		lblSAtk.setForeground(Color.WHITE);
		lblSAtk.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSAtk.setBounds(684, 298, 97, 46);
		contentPane.add(lblSAtk);
		
		lblSMag = new JLabel("MAG:");
		lblSMag.setForeground(Color.WHITE);
		lblSMag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSMag.setBounds(824, 298, 102, 46);
		contentPane.add(lblSMag);
		
		
		btnCrear = new JButton("Crear Personaje");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempr = "";
				
				
					if(claseSeleccionada == 1) {
						if(!(tfHP.getText().equals(""))) {
							if(Espadachin.validHPEspadachin(  Integer.parseInt(tfHP.getText()))        ) {
								if(rbImg1.isSelected()) {
									tempr = "/Proyecto/Personajes/Esp_1.png";
								}else if(rbImg2.isSelected()) {
									tempr = "/Proyecto/Personajes/Esp_2.png";
								}else if(rbImg3.isSelected()) {
									tempr = "/Proyecto/Personajes/Esp_3.png";
								}else {
									tempr = "/Proyecto/Personajes/Esp_1.png";
								}
								
								
								
								
								
								if(!(tfNombre.getText().equals(""))) {
									if(check1.isSelected()) {//Rage
										temp = new Espadachin(Integer.parseInt(tfHP.getText()), Clases.ESPADACHIN, HabilidadesEnum.RAGE, tfNombre.getText());
										temp.setRuta(tempr);
									}else if(check2.isSelected()) {//Tank
										temp = new Espadachin(Integer.parseInt(tfHP.getText()), Clases.ESPADACHIN, HabilidadesEnum.TANK, tfNombre.getText());
										temp.setRuta(tempr);
									}else {
										JOptionPane.showMessageDialog(null, "Se debe seleccionar alguna Habilidad!!!");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Se debe ingresar algún nombre para el personaje!!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "El HP ingresado no es válido!!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Se debe ingresar un HP!!");
						}
					}
					
					if(claseSeleccionada == 2) {
						if(rbImg1.isSelected()) {
							tempr = "/Proyecto/Personajes/Arc_1.png";
						}else if(rbImg2.isSelected()) {
							tempr = "/Proyecto/Personajes/Arc_2.png";
						}else if(rbImg3.isSelected()) {
							tempr = "/Proyecto/Personajes/Arc_3.png";
						}else {
							tempr = "/Proyecto/Personajes/Arc_1.png";
						}
						
						if(!(tfHP.getText().equals(""))) {
							if(Arquero.validHPArquero(  Integer.parseInt(tfHP.getText()))        ) {
								
								if(!(tfNombre.getText().equals(""))) {
									if(check1.isSelected()) {//Speed
										temp = new Arquero(Integer.parseInt(tfHP.getText()), Clases.ARQUERO, HabilidadesEnum.SPEED, tfNombre.getText());
										temp.setRuta(tempr);
									}else if(check2.isSelected()) {//void
										temp = new Arquero(Integer.parseInt(tfHP.getText()), Clases.ARQUERO, HabilidadesEnum.VOID, tfNombre.getText());
										temp.setRuta(tempr);
									}else {
										JOptionPane.showMessageDialog(null, "Se debe seleccionar alguna Habilidad!!!");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Se debe ingresar algún nombre para el personaje!!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "El HP ingresado no es válido!!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Se debe ingresar un HP!!");
						}
					}
					
					if(claseSeleccionada == 3) {
						if(rbImg1.isSelected()) {
							tempr = "/Proyecto/Personajes/Ase_1.png";
						}else if(rbImg2.isSelected()) {
							tempr = "/Proyecto/Personajes/Ase_2.png";
						}else if(rbImg3.isSelected()) {
							tempr = "/Proyecto/Personajes/Ase_3.png";
						}else {
							tempr = "/Proyecto/Personajes/Ase_1.png";
						}
						
						if(!(tfHP.getText().equals(""))) {
							if(Asesino.validHPAsesino(  Integer.parseInt(tfHP.getText()))        ) {
								
								if(!(tfNombre.getText().equals(""))) {
									if(check1.isSelected()) {//Speed
										temp = new Asesino(Integer.parseInt(tfHP.getText()), Clases.ASESINO, HabilidadesEnum.SPEED, tfNombre.getText());
										temp.setRuta(tempr);
									}else if(check2.isSelected()) {//Specs
										temp = new Asesino(Integer.parseInt(tfHP.getText()), Clases.ASESINO, HabilidadesEnum.SPECS, tfNombre.getText());
										temp.setRuta(tempr);
									}else {
										JOptionPane.showMessageDialog(null, "Se debe seleccionar alguna Habilidad!!!");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Se debe ingresar algún nombre para el personaje!!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "El HP ingresado no es válido!!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Se debe ingresar un HP!!");
						}
					}
					if(claseSeleccionada == 4) {
						if(rbImg1.isSelected()) {
							tempr = "/Proyecto/Personajes/Inv_1.png";
						}else if(rbImg2.isSelected()) {
							tempr = "/Proyecto/Personajes/Inv_2.png";
						}else if(rbImg3.isSelected()) {
							tempr = "/Proyecto/Personajes/Inv_3.png";
						}else {
							tempr = "/Proyecto/Personajes/Inv_1.png";
						}
						
						if(!(tfHP.getText().equals(""))) {
							if(Invocador.validHPInvocador(  Integer.parseInt(tfHP.getText()))        ) {
								
								if(!(tfNombre.getText().equals(""))) {
									if(check1.isSelected()) {//Void
										temp = new Invocador(Integer.parseInt(tfHP.getText()), Clases.INVOCADOR, HabilidadesEnum.VOID, tfNombre.getText());
										temp.setRuta(tempr);
									}else if(check2.isSelected()) {//Specs
										temp = new Invocador(Integer.parseInt(tfHP.getText()), Clases.INVOCADOR, HabilidadesEnum.SPECS, tfNombre.getText());
										temp.setRuta(tempr);
									}else {
										JOptionPane.showMessageDialog(null, "Se debe seleccionar alguna Habilidad!!!");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Se debe ingresar algún nombre para el personaje!!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "El HP ingresado no es válido!!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Se debe ingresar un HP!!");
						}
					}
					if(claseSeleccionada == 5) {
						if(rbImg1.isSelected()) {
							tempr = "/Proyecto/Personajes/Tan_1.png";
						}else if(rbImg2.isSelected()) {
							tempr = "/Proyecto/Personajes/Tan_2.png";
						}else if(rbImg3.isSelected()) {
							tempr = "/Proyecto/Personajes/Tan_3.png";
						}else {
							tempr = "/Proyecto/Personajes/Tan_1.png";
						}
						
						if(!(tfHP.getText().equals(""))) {
							if(Tanque.validHPTanque(  Integer.parseInt(tfHP.getText()))        ) {
								
								if(!(tfNombre.getText().equals(""))) {
									if(check1.isSelected()) {//Void
										temp = new Tanque(Integer.parseInt(tfHP.getText()), Clases.TANQUE, HabilidadesEnum.VOID, tfNombre.getText());
										temp.setRuta(tempr);
									}else if(check2.isSelected()) {//Tank
										temp = new Tanque(Integer.parseInt(tfHP.getText()), Clases.TANQUE, HabilidadesEnum.TANK, tfNombre.getText());
										temp.setRuta(tempr);
									}else {
										JOptionPane.showMessageDialog(null, "Se debe seleccionar alguna Habilidad!!!");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Se debe ingresar algún nombre para el personaje!!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "El HP ingresado no es válido!!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Se debe ingresar un HP!!");
						}
					}
					
					
					if(temp != null) {
						btnCrear.setText("Re roll!!");
						lblSHP.setText("HP: " + temp.getHP());
						lblSMP.setText("MP: " + temp.getMP());
						
						lblSDef.setText("DEF: "+ temp.getDef());
						lblSDefM.setText("DEF M: "+ temp.getDefM());
						
						lblSVoid.setText("VOID: "+ temp.getVoid());
						lblSVoidM.setText("VOID M: "+ temp.getVoidM());

						lblSSpe.setText("VEL: "+ temp.getSpe());
						lblSSpeM.setText("VEL M: "+ temp.getSpeM());
						
						lblSAtk.setText("ATQ: " + temp.getAtk());
						lblSMag.setText("Mag: "+ temp.getMag());
						btnSubir.setVisible(true);
						
					}else {
						btnSubir.setVisible(false);
					}
					System.out.println(temp);
					
				}//Final del boton
				
				
				
				
				
				
				
				
				
			
		});
		btnCrear.setBounds(273, 509, 142, 63);
		contentPane.add(btnCrear);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes_Menu t = new Personajes_Menu();
				t.lblIDJugador.setText(lblIDJ.getText());
				t.setVisible(true);
				Crear_Personaje.this.dispose();
				
			}
		});
		btnCancelar.setBounds(25, 553, 89, 23);
		contentPane.add(btnCancelar);
		
		btnSubir = new JButton("Subir!!");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cargar el objeto creado a la base de datos y volver al menú principal
				try {
					s = n.createStatement();
					res = s.executeQuery("SELECT MAX(idPERSONAJE) + 1 as 'resu' FROM PERSONAJE;"); 
					int tempo = 0;
					while(res.next()) {
						tempo = res.getInt("resu");
					}
					
					res.close();
					s.close();
					
					s = n.createStatement();
					s.executeUpdate("INSERT INTO PERSONAJE VALUES("+tempo+ ", " +  temp.getHP()  + ", "+temp.getMP()+", " +temp.getAtk()+ ", "+ temp.getMag()+ ", "+ temp.getDefM()+""
							+ ", "+temp.getVoidM()+", "+temp.getSpeM()+", "+temp.getDef()+", "+temp.getVoid()+", "+temp.getSpe()+", '"+ temp.getClase()  +"', '"+temp.getTipoH()+"'"
									+ ", '"+ temp.getNombre() +"', '"+ temp.getRuta() +"')");
					
					s.close();
					
					s = n.createStatement();
					s.executeUpdate("INSERT INTO JUGADOR_PERSONAJES VALUES ("+lblIDJ.getText()+", "+tempo+");");
					s.close();
					n.close();
					
					
					JOptionPane.showMessageDialog(null, "El personaje se añadió al sistema!!\nSe pueden añadir movimientos desde 'Editar Personajes'");
					Personajes_Menu t = new Personajes_Menu();
					t.lblIDJugador.setText(lblIDJ.getText());
					t.setVisible(true);
					Crear_Personaje.this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnSubir.setBounds(824, 529, 89, 23);
		contentPane.add(btnSubir);
		btnSubir.setVisible(false);
		
		
		//Imagenes
		lblImg1 = new JLabel("");
		lblImg1.setBounds(49, 313, 150, 150);
		contentPane.add(lblImg1);
		
		lblImg2 = new JLabel("");
		lblImg2.setBounds(233, 313, 150, 150);
		contentPane.add(lblImg2);
		
		lblImg3 = new JLabel("");
		lblImg3.setBounds(421, 308, 150, 150);
		contentPane.add(lblImg3);
		
		rbImg1 = new JRadioButton("Img1");
		rbImg1.setBounds(58, 470, 109, 23);
		contentPane.add(rbImg1);
		
		rbImg2 = new JRadioButton("Img2");
		rbImg2.setBounds(243, 470, 109, 23);
		contentPane.add(rbImg2);
		
		rbImg3 = new JRadioButton("Img3");
		rbImg3.setBounds(443, 470, 109, 23);
		contentPane.add(rbImg3);
		
		ButtonGroup ims = new ButtonGroup();
		ims.add(rbImg1);
		ims.add(rbImg2);
		ims.add(rbImg3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Crear_Personaje.class.getResource("/Proyecto/ImagenesP/Fondo_Menu_Personajes.png")));
		lblNewLabel.setBounds(0, 0, 1008, 587);
		contentPane.add(lblNewLabel);
		
		
	
		
		check1.addActionListener(this);
		check2.addActionListener(this);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rdbtnEspadachin) {
			lblClaseSeleccionada.setText("Clase Seleccionada: Espadachin");
			lblHP.setText("HP entre 210 y 170: ");
			check1.setText("RAGE");
			check2.setText("TANK");
			claseSeleccionada = 1;
			
			lblImg1.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Esp_1.png")));
			lblImg2.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Esp_2.png")));
			lblImg3.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Esp_3.png")));
			
		}else if(e.getSource() == rdbtnArquero) {
			lblClaseSeleccionada.setText("Clase Seleccionada: Arquero");
			lblHP.setText("HP entre 190 y 160: ");
			check1.setText("SPEED");
			check2.setText("VOID");
			claseSeleccionada = 2;
			
			lblImg1.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Arc_1.png")));
			lblImg2.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Arc_2.png")));
			lblImg3.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Arc_3.png")));
			
		}else if(e.getSource() == rdbtnAsesino) {
			lblClaseSeleccionada.setText("Clase Seleccionada: Asesino");
			lblHP.setText("HP entre 220 y 170: ");
			check1.setText("SPEED");
			check2.setText("SPECS");
			claseSeleccionada = 3;
			
			lblImg1.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Ase_1.png")));
			lblImg2.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Ase_2.png")));
			lblImg3.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Ase_3.png")));
			
		}else if(e.getSource() == rdbtnInvocador) {
			lblClaseSeleccionada.setText("Clase Seleccionada: Invocador");
			lblHP.setText("HP entre 185 y 160: ");
			check1.setText("VOID");
			check2.setText("SPECS");
			claseSeleccionada = 4;
			
			lblImg1.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Inv_1.png")));
			lblImg2.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Inv_2.png")));
			lblImg3.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Inv_3.png")));
			
		}else if(e.getSource() == rdbtnTanque) {
			lblClaseSeleccionada.setText("Clase Seleccionada: Tanque");
			lblHP.setText("HP entre 250 y 200: ");
			check1.setText("VOID");
			check2.setText("TANK");
			claseSeleccionada = 5;
			
			lblImg1.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Tan_1.png")));
			lblImg2.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Tan_2.png")));
			lblImg3.setIcon( new ImageIcon(Personajes_Menu.class.getResource("/Proyecto/Personajes/Tan_3.png")));
			
		}
		
		
		
	}
}
