package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Editar_Personaje extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar_Personaje frame = new Editar_Personaje();
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
	Personaje temp;
	public int t= 0;
	JLabel lblID;
	JLabel lblImg;
	JLabel lblNombre;
	private JButton btnCambiarHabilidad;
	JCheckBox check1, check2;
	private JLabel lblHP;
	private JButton btnNewButton;
	private JTextField tfHP;
	private JLabel lblNewLabel;
	private JLabel lblHPS;
	private JLabel lblMPS;
	private JLabel lblDefS;
	private JLabel lblVoidS;
	private JLabel lblSpeS;
	private JLabel lblAtkS;
	private JLabel lblMagS;
	private JLabel lblDefMS;
	private JLabel lblVoidMS;
	private JLabel lblSpeMS;
	private JButton btnActualizar;
	public JLabel lblIDJ;
	
	public Editar_Personaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seleccionar_Personaje sp = new Seleccionar_Personaje();
				sp.lblIDJ.setText(lblIDJ.getText());
				sp.setVisible(true);
				Editar_Personaje.this.dispose();
				
			}
		});
		btnVolver.setBounds(10, 553, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblEditar = new JLabel("Editando al Personaje con ID:");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditar.setBounds(10, 37, 264, 62);
		contentPane.add(lblEditar);
		
		lblID = new JLabel("...");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setBounds(10, 97, 103, 36);
		contentPane.add(lblID);
		
		JButton btnEmpezar = new JButton("Empezar!!");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				t = Integer.parseInt(lblID.getText());
				
				activarP();
				lblImg.setIcon( new ImageIcon(Personajes_Menu.class.getResource(temp.getRuta())));
				lblNombre.setText("Nombre: " + temp.getNombre());
				
				btnCambiarHabilidad.setVisible(true);
				ajustarHabs();
				ajustarHP();
				mostrarStats();
				
				btnEmpezar.setVisible(false);
				check1.setVisible(true);
				check2.setVisible(true);
				
				
			}
		});
		btnEmpezar.setBounds(154, 110, 89, 23);
		contentPane.add(btnEmpezar);
		
		lblImg = new JLabel("");
		lblImg.setBounds(24, 199, 150, 150);
		contentPane.add(lblImg);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(24, 374, 215, 62);
		contentPane.add(lblNombre);
		
		btnCambiarHabilidad = new JButton("Cambiar Habilidad");
		btnCambiarHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				switch(temp.Clase) {
				case ESPADACHIN:
					if(check1.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.RAGE);
						msg = "Se cambió la habilidad!!!";
					}else if(check2.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.TANK);
						msg = "Se cambió la habilidad!!!";
					}else {
						msg = "Se tiene que seleccionar una habilidad!!!";
					}
				break;
				case ARQUERO:
					if(check1.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.SPEED);
						msg = "Se cambió la habilidad!!!";
					}else if(check2.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.VOID);
						msg = "Se cambió la habilidad!!!";
					}else {
						msg = "Se tiene que seleccionar una habilidad!!!";
					}
				break;
				case ASESINO:
					if(check1.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.SPEED);
						msg = "Se cambió la habilidad!!!";
					}else if(check2.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.SPECS);
						msg = "Se cambió la habilidad!!!";
					}else {
						msg = "Se tiene que seleccionar una habilidad!!!";
					}
				break;
				case INVOCADOR:
					if(check1.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.VOID);
						msg = "Se cambió la habilidad!!!";
					}else if(check2.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.SPECS);
						msg = "Se cambió la habilidad!!!";
					}else {
						msg = "Se tiene que seleccionar una habilidad!!!";
					}
				break;
				case TANQUE:
					if(check1.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.VOID);
						msg = "Se cambió la habilidad!!!";
					}else if(check2.isSelected()) {
						temp.asignarHabilidad(HabilidadesEnum.TANK);
						msg = "Se cambió la habilidad!!!";
					}else {
						msg = "Se tiene que seleccionar una habilidad!!!";
					}
				break;
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnCambiarHabilidad.setBounds(493, 106, 150, 44);
		contentPane.add(btnCambiarHabilidad);
		btnCambiarHabilidad.setVisible(false);
		
		
		check1 = new JCheckBox("...");
		check1.setBounds(694, 117, 97, 23);
		contentPane.add(check1);
		
		check2 = new JCheckBox("...");
		check2.setBounds(828, 117, 97, 23);
		contentPane.add(check2);
		
		ButtonGroup Habis = new ButtonGroup();
		Habis.add(check1);
		Habis.add(check2);
		
		lblHP = new JLabel("HP válido entre ");
		lblHP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHP.setBounds(437, 184, 264, 62);
		contentPane.add(lblHP);
		
		btnNewButton = new JButton("Reajustar Stats");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfHP.getText().equals("")) {
					switch(temp.Clase) {
					case ESPADACHIN:
						temp = new Espadachin(temp.getHP(), temp.getClase(), temp.getTipoH(), temp.getNombre());
					break;
					case ARQUERO:
						temp = new Arquero(temp.getHP(), temp.getClase(), temp.getTipoH(), temp.getNombre());
					break;
					case ASESINO:
						temp = new Asesino(temp.getHP(), temp.getClase(), temp.getTipoH(), temp.getNombre());
					break;
					case INVOCADOR:
						temp = new Invocador(temp.getHP(),temp.getClase(), temp.getTipoH(), temp.getNombre());
					break;
					case TANQUE:
						temp = new Tanque(temp.getHP(), temp.getClase(), temp.getTipoH(), temp.getNombre());
					break;
					}
				}else {//Se ingresa un nuevo HP
					switch(temp.Clase) {
					case ESPADACHIN:
						if(Espadachin.validHPEspadachin(  Integer.parseInt(tfHP.getText()) ))temp = new Espadachin(Integer.parseInt(tfHP.getText()), temp.getClase(), temp.getTipoH(), temp.getNombre());
						else JOptionPane.showMessageDialog(null, "Se ingresó un HP fuera de rango!!!");
					break;
					case ARQUERO:
						if(Arquero.validHPArquero(  Integer.parseInt(tfHP.getText()) ))temp = new Arquero(Integer.parseInt(tfHP.getText()), temp.getClase(), temp.getTipoH(), temp.getNombre());
						else JOptionPane.showMessageDialog(null, "Se ingresó un HP fuera de rango!!!");
					break;
					case ASESINO:
						if(Asesino.validHPAsesino(  Integer.parseInt(tfHP.getText()) ))temp = new Asesino(Integer.parseInt(tfHP.getText()), temp.getClase(), temp.getTipoH(), temp.getNombre());
						else JOptionPane.showMessageDialog(null, "Se ingresó un HP fuera de rango!!!");
					break;
					case INVOCADOR:
						if(Invocador.validHPInvocador(  Integer.parseInt(tfHP.getText()) ))temp = new Invocador(Integer.parseInt(tfHP.getText()), temp.getClase(), temp.getTipoH(), temp.getNombre());
						else JOptionPane.showMessageDialog(null, "Se ingresó un HP fuera de rango!!!");
					break;
					case TANQUE:
						if(Tanque.validHPTanque(  Integer.parseInt(tfHP.getText()) ))temp = new Tanque(Integer.parseInt(tfHP.getText()), temp.getClase(), temp.getTipoH(), temp.getNombre());
						else JOptionPane.showMessageDialog(null, "Se ingresó un HP fuera de rango!!!");
					break;
					}
				}
				mostrarStats();
				
			}
		});
		btnNewButton.setBounds(281, 252, 150, 51);
		contentPane.add(btnNewButton);
		
		tfHP = new JTextField();
		tfHP.setBounds(555, 257, 120, 40);
		contentPane.add(tfHP);
		tfHP.setColumns(10);
		
		lblNewLabel = new JLabel("Nuevo HP");
		lblNewLabel.setBounds(447, 257, 98, 40);
		contentPane.add(lblNewLabel);
		
		lblHPS = new JLabel("HP:");
		lblHPS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHPS.setBounds(267, 339, 103, 62);
		contentPane.add(lblHPS);
		
		lblMPS = new JLabel("MP:");
		lblMPS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMPS.setBounds(410, 339, 103, 62);
		contentPane.add(lblMPS);
		
		lblDefS = new JLabel("Def:");
		lblDefS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefS.setBounds(540, 339, 103, 62);
		contentPane.add(lblDefS);
		
		lblVoidS = new JLabel("Void:");
		lblVoidS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVoidS.setBounds(668, 339, 103, 62);
		contentPane.add(lblVoidS);
		
		lblSpeS = new JLabel("Vel:");
		lblSpeS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpeS.setBounds(803, 339, 103, 62);
		contentPane.add(lblSpeS);
		
		lblAtkS = new JLabel("Atk:");
		lblAtkS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtkS.setBounds(267, 438, 103, 62);
		contentPane.add(lblAtkS);
		
		lblMagS = new JLabel("Mag:");
		lblMagS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMagS.setBounds(397, 438, 103, 62);
		contentPane.add(lblMagS);
		
		lblDefMS = new JLabel("DefM:");
		lblDefMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefMS.setBounds(540, 438, 103, 62);
		contentPane.add(lblDefMS);
		
		lblVoidMS = new JLabel("VoidM:");
		lblVoidMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVoidMS.setBounds(668, 438, 103, 62);
		contentPane.add(lblVoidMS);
		
		lblSpeMS = new JLabel("VelM:");
		lblSpeMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpeMS.setBounds(803, 438, 103, 62);
		contentPane.add(lblSpeMS);
		
		btnActualizar = new JButton("Actualizar!!!");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s = n.createStatement();
					s.executeUpdate("UPDATE PERSONAJE SET TipoHabilidad = '"+temp.getTipoH()+"', HP = "+temp.getHP()+", MP = "+temp.getMP()+", "
							+ "Atk = "+temp.getAtk()+", Mag = "+temp.getMag()+", DefM = "+temp.getDefM()+", VoidM = "+temp.getVoidM()+", SpeM = "+temp.getSpeM()+", "
									+ "Def = "+temp.getDef()+", Void = "+temp.getVoid()+", Spe = "+temp.getSpe()+" WHERE idPERSONAJE = "+t+";");
					
					s.close();
					JOptionPane.showMessageDialog(null, "Los cambios al personaje se han guardado!!");
					Personajes_Menu t = new Personajes_Menu();
					t.lblIDJugador.setText(lblIDJ.getText());
					t.setVisible(true);
					Editar_Personaje.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnActualizar.setBounds(732, 511, 174, 65);
		contentPane.add(btnActualizar);
		
		lblIDJ = new JLabel("New label");
		lblIDJ.setBounds(128, 11, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
		
		check1.setVisible(false);
		check2.setVisible(false);
		
	}

	
	
	public void activarP() {
		try {
			
			s = n.createStatement();
			res = s.executeQuery("SELECT *\r\n"
					+ "FROM PERSONAJE p\r\n"
					+ "WHERE p.idPERSONAJE = "+t+";");
			
			
				while(res.next()){
					String temps = res.getString("Clase");
					int idt = res.getInt("idPERSONAJE");
					int hpt = res.getInt("HP");
					int mpt = res.getInt("MP");
					float atkt = res.getFloat("Atk");
					float defmt = res.getFloat("DefM");
					float voidmt = res.getFloat("VoidM");
					float spemt = res.getFloat("SpeM");
					float magt = res.getFloat("Mag");
					int deft = res.getInt("Def");
					int voidt = res.getInt("Void");
					int spet = res.getInt("Spe");
					String nomt = res.getString("Nombre");
					
					
					switch(temps) {
					case "ESPADACHIN":
						if(res.getString("TipoHabilidad").equals("RAGE") ) {
							temp = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.RAGE, nomt            );
							temp.setRuta(res.getString("Ruta"));
							
						}else {
							temp = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.TANK, nomt            );
							temp.setRuta(res.getString("Ruta"));
						}
					break;
					case "ARQUERO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							temp = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.SPEED, nomt            );
							temp.setRuta(res.getString("Ruta"));
							
						}else {
							temp = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.VOID, nomt            );
							temp.setRuta(res.getString("Ruta"));
						}
						
						
					break;
					
					case "ASESINO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							temp = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPEED, nomt            );
							temp.setRuta(res.getString("Ruta"));
							
						}else {
							temp = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPECS, nomt            );
							temp.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "INVOCADOR":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							temp = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.VOID, nomt            );
							temp.setRuta(res.getString("Ruta"));
							
						}else {
							temp = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.SPECS, nomt            );
							temp.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "TANQUE":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							temp = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.VOID, nomt            );
							temp.setRuta(res.getString("Ruta"));
							
						}else {
							temp = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.TANK, nomt            );
							temp.setRuta(res.getString("Ruta"));
						}
						
						
						break;
					}				
			}
				
			s.close();
			res.close();
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public void ajustarHabs() {
		if(temp.getClase().toString().equals("ESPADACHIN")) {
			check1.setText("RAGE");
			check2.setText("TANK");
		}else if(temp.getClase().toString().equals("ARQUERO")) {
			check1.setText("SPEED");
			check2.setText("VOID");
		}else if(temp.getClase().toString().equals("ASESINO")) {
			check1.setText("SPEED");
			check2.setText("SPECS");
		}else if(temp.getClase().toString().equals("INVOCADOR")) {
			check1.setText("VOID");
			check2.setText("SPECS");
		}else if(temp.getClase().toString().equals("TANQUE")) {
			check1.setText("VOID");
			check2.setText("TANk");
		}
		
	}
	
	
	public void ajustarHP() {
		if(temp.getClase().toString().equals("ESPADACHIN")) {
			lblHP.setText("HP válido entre 210 y 170");
		}else if(temp.getClase().toString().equals("ARQUERO")) {
			lblHP.setText("HP válido entre 190 y 160");
		}else if(temp.getClase().toString().equals("ASESINO")) {
			lblHP.setText("HP válido entre 220 y 170");
		}else if(temp.getClase().toString().equals("INVOCADOR")) {
			lblHP.setText("HP válido entre 185 y 160");
		}else if(temp.getClase().toString().equals("TANQUE")) {
			lblHP.setText("HP válido entre 250 y 200");
		}
	}


	public void mostrarStats() {
		lblHPS.setText("HP: " + temp.getHP());
		lblMPS.setText("MP: " + temp.getMP());
		
		lblDefS.setText("DEF: "+ temp.getDef());
		lblDefMS.setText("DEF M: "+ temp.getDefM());
		
		lblVoidS.setText("VOID: "+ temp.getVoid());
		lblVoidMS.setText("VOID M: "+ temp.getVoidM());

		lblSpeS.setText("VEL: "+ temp.getSpe());
		lblSpeMS.setText("VEL M: "+ temp.getSpeM());
		
		lblAtkS.setText("ATQ: " + temp.getAtk());
		lblMagS.setText("MAG: "+ temp.getMag());
	}
	
}
