package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pelea extends JFrame implements ActionListener  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pelea frame = new Pelea();
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
	
	JLabel lblID, lblCPU;
	private JLabel lblImgP;
	private JLabel lblImgC;
	
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
	
	private JLabel lblHPC;
	private JLabel lblMPC;
	private JLabel lblDefC;
	private JLabel lblVoidC;
	private JLabel lblSpeC;
	private JLabel lblAtkC;
	private JLabel lblMagC;
	private JLabel lblDefMC;
	private JLabel lblVoidMC;
	private JLabel lblSpeMC;
	Personaje Jugador;
	Personaje CPU;
	Connection n = Conexion.conectar();	
	Statement s = null;
	ResultSet res = null;
	private JButton btnEmpezar;
	JButton btnH;
	private JLabel lblNombreP;
	private JLabel lblNombreC;
	private JButton btnHC;
	JButton btnMov1;
	JButton btnMov2;
	JButton btnMov3;
	JButton btnMov4;
	private JButton btnBaseCPU;
	private JButton btnMov1C;
	private JButton btnMov2C;
	private JButton btnMov3C;
	private JButton btnMov4C;
	JButton btnBase;
	
	boolean turnoS;
	Arena combate = new Arena();
	
	
	public Pelea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("IDJugador1");
		lblID.setBounds(10, 11, 69, 32);
		contentPane.add(lblID);
		
		lblCPU = new JLabel("IDCPU");
		lblCPU.setBounds(641, 11, 97, 32);
		contentPane.add(lblCPU);
		
		lblImgP = new JLabel("New label");
		lblImgP.setBounds(10, 56, 150, 150);
		contentPane.add(lblImgP);
		
		lblImgC = new JLabel("New label");
		lblImgC.setBounds(751, 68, 150, 150);
		contentPane.add(lblImgC);
		
		lblHPS = new JLabel("HP:");
		lblHPS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHPS.setBounds(10, 229, 75, 62);
		contentPane.add(lblHPS);
		
		lblMPS = new JLabel("MP:");
		lblMPS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMPS.setBounds(95, 229, 59, 62);
		contentPane.add(lblMPS);
		
		lblDefS = new JLabel("Def:");
		lblDefS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDefS.setBounds(87, 287, 103, 62);
		contentPane.add(lblDefS);
		
		lblVoidS = new JLabel("Void:");
		lblVoidS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVoidS.setBounds(178, 287, 66, 62);
		contentPane.add(lblVoidS);
		
		lblSpeS = new JLabel("Vel:");
		lblSpeS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpeS.setBounds(10, 340, 69, 62);
		contentPane.add(lblSpeS);
		
		lblAtkS = new JLabel("Atk:");
		lblAtkS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAtkS.setBounds(185, 229, 81, 62);
		contentPane.add(lblAtkS);
		
		lblMagS = new JLabel("Mag:");
		lblMagS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMagS.setBounds(10, 287, 69, 62);
		contentPane.add(lblMagS);
		
		lblDefMS = new JLabel("DefM:");
		lblDefMS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDefMS.setBounds(71, 340, 91, 62);
		contentPane.add(lblDefMS);
		
		lblVoidMS = new JLabel("VoidM:");
		lblVoidMS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVoidMS.setBounds(175, 340, 91, 62);
		contentPane.add(lblVoidMS);
		
		lblSpeMS = new JLabel("VelM:");
		lblSpeMS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpeMS.setBounds(10, 413, 69, 62);
		contentPane.add(lblSpeMS);
		
		//CPU
		lblHPC = new JLabel("HP:");
		lblHPC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHPC.setBounds(697, 229, 75, 62);
		contentPane.add(lblHPC);
		
		lblMPC = new JLabel("MP:");
		lblMPC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMPC.setBounds(789, 229, 59, 62);
		contentPane.add(lblMPC);
		
		lblDefC = new JLabel("Def:");
		lblDefC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDefC.setBounds(766, 287, 81, 62);
		contentPane.add(lblDefC);
		
		lblVoidC = new JLabel("Void:");
		lblVoidC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVoidC.setBounds(690, 287, 66, 62);
		contentPane.add(lblVoidC);
		
		lblSpeC = new JLabel("Vel:");
		lblSpeC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpeC.setBounds(690, 340, 69, 62);
		contentPane.add(lblSpeC);
		
		lblAtkC = new JLabel("Atk:");
		lblAtkC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAtkC.setBounds(867, 229, 81, 62);
		contentPane.add(lblAtkC);
		
		lblMagC = new JLabel("Mag:");
		lblMagC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMagC.setBounds(858, 287, 69, 62);
		contentPane.add(lblMagC);
		
		lblDefMC = new JLabel("DefM:");
		lblDefMC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDefMC.setBounds(766, 340, 82, 62);
		contentPane.add(lblDefMC);
		
		lblVoidMC = new JLabel("VoidM:");
		lblVoidMC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVoidMC.setBounds(857, 340, 91, 62);
		contentPane.add(lblVoidMC);
		
		lblSpeMC = new JLabel("VelM:");
		lblSpeMC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpeMC.setBounds(690, 413, 69, 62);
		contentPane.add(lblSpeMC);
		
		
		btnBase = new JButton("Atq Base");
		btnBase.addActionListener(this);
		btnBase.setBounds(281, 249, 150, 23);
		contentPane.add(btnBase);
		
		btnMov1 = new JButton("Mov 1");
		btnMov1.addActionListener(this);
		btnMov1.setBounds(281, 293, 150, 23);
		contentPane.add(btnMov1);
		btnMov1.setVisible(false);
		
		btnMov2 = new JButton("Mov 2");
		btnMov2.addActionListener(this);
		btnMov2.setBounds(281, 337, 150, 23);
		contentPane.add(btnMov2);
		btnMov2.setVisible(false);
		
		btnMov3 = new JButton("Mov 3");
		btnMov3.addActionListener(this);
		btnMov3.setBounds(281, 379, 150, 23);
		contentPane.add(btnMov3);
		btnMov3.setVisible(false);
		
		btnMov4 = new JButton("Mov 4");
		btnMov4.addActionListener(this);
		btnMov4.setBounds(281, 422, 150, 23);
		contentPane.add(btnMov4);
		btnMov4.setVisible(false);
		
		btnH = new JButton("Habilidad");
		btnH.addActionListener(this);
		btnH.setBounds(281, 456, 150, 23);
		contentPane.add(btnH);
		
		
		
		
		
		
		btnEmpezar = new JButton("EMPEZAR!!");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarP(Integer.parseInt(lblID.getText()));
				mostrarMovsP(Integer.parseInt(lblID.getText()));
				mostrarStatsP();
				lblImgP.setIcon( new ImageIcon(Personajes_Menu.class.getResource(Jugador.getRuta())));
				lblImgP.setText("");
				
				
				activarCPU(Integer.parseInt(lblCPU.getText()));
				mostrarMovsCPU(Integer.parseInt(lblCPU.getText()));
				mostrarStatsCPU();
				lblImgC.setIcon( new ImageIcon(Personajes_Menu.class.getResource(CPU.getRuta())));
				lblImgC.setText("");
				
				turnoS = combate.determinarOrden(Jugador, CPU);
				
				
				
				btnEmpezar.setVisible(false);
				CombateON();
			}
		});
		btnEmpezar.setBounds(350, 16, 177, 62);
		contentPane.add(btnEmpezar);
		
		lblNombreP = new JLabel("");
		lblNombreP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreP.setBounds(106, 0, 239, 62);
		contentPane.add(lblNombreP);
		
		lblNombreC = new JLabel("");
		lblNombreC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreC.setBounds(690, 0, 239, 62);
		contentPane.add(lblNombreC);
		
		btnHC = new JButton("Habilidad");
		btnHC.setBounds(520, 456, 150, 23);
		contentPane.add(btnHC);
		
		btnBaseCPU = new JButton("Atq Base");
		btnBaseCPU.setBounds(520, 249, 150, 23);
		contentPane.add(btnBaseCPU);
		
		btnMov1C = new JButton("Mov1");
		btnMov1C.setBounds(520, 293, 150, 23);
		contentPane.add(btnMov1C);
		
		btnMov2C = new JButton("Mov2");
		btnMov2C.setBounds(520, 340, 150, 23);
		contentPane.add(btnMov2C);
		
		btnMov3C = new JButton("Mov3");
		btnMov3C.setBounds(520, 379, 150, 23);
		contentPane.add(btnMov3C);
		
		btnMov4C = new JButton("Mov4");
		btnMov4C.setBounds(520, 422, 150, 23);
		contentPane.add(btnMov4C);
		
		btnMov1C.setVisible(false);
		btnMov2C.setVisible(false);
		btnMov3C.setVisible(false);
		btnMov4C.setVisible(false);
		
	}
	
	
	public void CombateON() {
		String msg = "", message = "", show = "";
		int val = 0;
		String tempoval = "";
		int lon = Jugador.ListaMovimientos.size();	
		while(combate.getEstadoBatalla()) {
			turnoS = combate.determinarOrden(Jugador, CPU);
			if(turnoS) {
				
							
				
				do {
					msg = "INTRODUCE TU ACCIÓN:\n[1] Ataque básico\n[2] Habilidad\n[3-6]Movimientos";
					
					
					tempoval =  JOptionPane.showInputDialog(msg);
					
					
					if(tempoval.equals("")) {
						continue;
					}
					
					try {
						val = Integer.parseInt(tempoval );
				    }
				    catch (NumberFormatException e) {
				       continue;
				    }
					
			
					switch( val ) {
					case 1:
						combate.listaOrdenes(0, Jugador, CPU, null);
						show = Jugador.getNombre() + " usó el ataque base!";
					break;
					case 2:
						combate.listaOrdenes(2, Jugador, CPU, null);
						if(Jugador.UsandoHabilidad) {
							show = "Ya se esta usando la habilidad!!!";
						}
						
						btnH.setVisible(false);
					break;
					case 3:
						if(lon >= 1) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(0))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(0));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(0).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 4:
						if(lon >= 2) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(1))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(1));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(1).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 5:
						if(lon >= 3) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(2))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(2));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(2).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 6:
						if(lon == 4) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(3))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(3));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(3).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;				
					}
					
				}while(val < 1 || val > lon+2);
				
				
				JOptionPane.showMessageDialog(null, show);
				
				mostrarStatsP();
				mostrarStatsCPU();
				
				if(combate.getEstadoBatalla() == false) {
					if(Personaje.revisarHP(Jugador)) {
						//Gana p2
						message = String.format("Gana %s!!!!!!", Jugador.nombre);
						
					}else {
						message = String.format("Gana %s!!!!!!", CPU.nombre);
						
					}
					JOptionPane.showMessageDialog(null, message);
					break;
				}
				
				CPUTurno();
				mostrarStatsP();
				mostrarStatsCPU();
				
					if(combate.getEstadoBatalla() == false) {
						if(Personaje.revisarHP(Jugador)) {
							//Gana p2
							message = String.format("Gana %s!!!!!!", Jugador.nombre);
							
						}else {
							message = String.format("Gana %s!!!!!!", CPU.nombre);
							
						}
						JOptionPane.showMessageDialog(null, message);
						Pelea.this.dispose();
						break;
					}
				
					
					
					
			}else {
				CPUTurno();
				
				mostrarStatsP();
				mostrarStatsCPU();
				
				if(combate.getEstadoBatalla() == false) {
					if(Personaje.revisarHP(Jugador)) {
						//Gana p2
						message = String.format("Gana %s!!!!!!", Jugador.nombre);
						
					}else {
						message = String.format("Gana %s!!!!!!", CPU.nombre);
						
					}
					JOptionPane.showMessageDialog(null, message);
					Pelea.this.dispose();
					break;
				}
				
				
				
				do {
					msg = "INTRODUCE TU ACCIÓN:\n[1] Ataque básico\n[2] Habilidad\n[3-6]Movimientos";
					
					
					tempoval =  JOptionPane.showInputDialog(msg);
					
					
					if(tempoval.equals("")) {
						continue;
					}
					
					try {
						val = Integer.parseInt(tempoval );
				    }
				    catch (NumberFormatException e) {
				       continue;
				    }
					
			
					switch( val ) {
					case 1:
						combate.listaOrdenes(0, Jugador, CPU, null);
						show = Jugador.getNombre() + " usó el ataque base!";
					break;
					case 2:
						combate.listaOrdenes(2, Jugador, CPU, null);
						if(Jugador.UsandoHabilidad) {
							show = "Ya se esta usando la habilidad!!!";
						}
						
						btnH.setVisible(false);
					break;
					case 3:
						if(lon >= 1) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(0))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(0));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(0).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 4:
						if(lon >= 2) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(1))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(1));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(1).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 5:
						if(lon >= 3) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(2))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(2));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(2).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;
					case 6:
						if(lon == 4) {
							if(Personaje.revisarMagia(Jugador, Jugador.ListaMovimientos.get(3))) {
								combate.listaOrdenes(1, Jugador, CPU, Jugador.ListaMovimientos.get(3));
								show = (Jugador.getNombre() + " usó " + Jugador.ListaMovimientos.get(3).getNombre());
							}else {
								show = ("El ataque de " + CPU.getNombre() + " falló!");
							}
						}
						
					break;				
					}
					
				}while(val < 1 || val > lon+2);
				JOptionPane.showMessageDialog(null, show);
				
				mostrarStatsP();
				mostrarStatsCPU();
				
				if(combate.getEstadoBatalla() == false) {
					if(Personaje.revisarHP(Jugador)) {
					
						message = String.format("Gana %s!!!!!!", Jugador.nombre);
						
					}else {
						message = String.format("Gana %s!!!!!!", CPU.nombre);
						
						
					}
					JOptionPane.showMessageDialog(null, message);
					Pelea.this.dispose();
					break;
				}
				
				
			}
			
			
			
			
			
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
	
	
	public void activarP(int t) {
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
							Jugador = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.RAGE, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
							
						}else {
							Jugador = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.TANK, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
						}
					break;
					case "ARQUERO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							Jugador = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.SPEED, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
							
						}else {
							Jugador = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.VOID, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
						}
						
						
					break;
					
					case "ASESINO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							Jugador = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPEED, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
							
						}else {
							Jugador = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPECS, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "INVOCADOR":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							Jugador = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.VOID, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
							
						}else {
							Jugador = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.SPECS, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "TANQUE":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							Jugador = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.VOID, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
							
						}else {
							Jugador = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.TANK, nomt            );
							Jugador.setRuta(res.getString("Ruta"));
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
	

	
	
			
	public void mostrarMovsP(int t) {
		Clases temporalC = null;
		TiposMovimientos temporalT = null;
		Integer[] ids = new Integer[4];
		int counter = 0;
		Movimiento mov;
		
		
		
		try {
			s = n.createStatement();
			res = s.executeQuery("SELECT m.idMovimiento, m.NombreMov, m.TipoMov, m.Coste FROM MOVIMIENTO m JOIN PERSONAJE_MOVIMIENTOS pm ON pm.idMOVIMIENTO = m.idMOVIMIENTO WHERE pm.idPERSONAJE  = "+t+";");
			
			
			
		
			
			while(res.next()) {
				ids[counter] = res.getInt("idMOVIMIENTO");
				counter++;
				String[] fila = {String.valueOf(res.getInt("idMOVIMIENTO")), res.getString("NombreMov"), res.getString("TipoMov") ,String.valueOf(res.getInt("Coste"))      };
				
			}
			
			res.close();
			s.close();
			
			if(Jugador.ListaMovimientos.size() > 0) {
				for(int i = 0; i < Jugador.ListaMovimientos.size(); i++) {
					Jugador.quitarMovimiento(ids[i]);
				}
			}
			
			//Java movs
			for(int i = 0; i < counter; i++) {
				s = n.createStatement();
				res = s.executeQuery("SELECT * FROM MOVIMIENTO WHERE idMOVIMIENTO = "+ ids[i] +";");
				
				while(res.next()) {
					switch(res.getString("ClaseMov")) {
					case "ESPADACHIN":
						temporalC = Clases.ESPADACHIN;
					break;
					case "ARQUERO":
						temporalC = Clases.ARQUERO;
					break;
					case "ASESINO":
						temporalC = Clases.ASESINO;
					break;
					case "INVOCADOR":
						temporalC = Clases.INVOCADOR;
					break;
					case "TANQUE":
						temporalC = Clases.TANQUE;
					break;
					}
					
					switch(res.getString("TipoMov")) {
					case "ATAQUE_FISICO":
						temporalT = TiposMovimientos.ATAQUE_FISICO;
					break;
					case "ATAQUE_ESPECIAL":
						temporalT = TiposMovimientos.ATAQUE_ESPECIAL;
					break;
					case "BUFF":
						temporalT = TiposMovimientos.BUFF;
					break;
					case "DEBUFF":
						temporalT = TiposMovimientos.DEBUFF;
					break;
					}
					
					
					
					mov = new Movimiento(res.getString("NombreMov") , res.getInt("Dano"),  res.getInt("Presicion"),  res.getFloat("Efecto"),
							temporalC , temporalT , res.getString("EfectoStat") , res.getInt("idMOVIMIENTO") ,  res.getInt("Coste"));
					
					Jugador.asignarMovimiento(mov);
				}
			}
			
			System.out.println(ids.length);
			
			if(ids[0] != null) {
				btnMov1.setText(Jugador.ListaMovimientos.get(0).getNombre());
				btnMov1.setVisible(true);
			}
			if(ids[1] != null) {
				btnMov2.setText(Jugador.ListaMovimientos.get(1).getNombre());
				btnMov2.setVisible(true);
			}
			if(ids[2] != null) {
				btnMov3.setText(Jugador.ListaMovimientos.get(2).getNombre());
				btnMov3.setVisible(true);
			}
			if(ids[3] != null) {
				btnMov4.setText(Jugador.ListaMovimientos.get(3).getNombre());
				btnMov4.setVisible(true);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	
	
	public void mostrarStatsP() {
		lblHPS.setText("HP: " + Jugador.getHP());
		lblMPS.setText("MP: " + Jugador.getMP());
		
		lblDefS.setText("DEF: "+ Jugador.getDef());
		lblDefMS.setText("DEF M: "+ Jugador.getDefM());
		
		lblVoidS.setText("VOID: "+ Jugador.getVoid());
		lblVoidMS.setText("VOID M: "+ Jugador.getVoidM());

		lblSpeS.setText("VEL: "+ Jugador.getSpe());
		lblSpeMS.setText("VEL M: "+ Jugador.getSpeM());
		
		lblAtkS.setText("ATQ: " + Jugador.getAtk());
		lblMagS.setText("MAG: "+ Jugador.getMag());
		
		lblNombreP.setText( Jugador.getNombre());
		btnH.setText( Jugador.getTipoH().toString());
	}
	
	
	//Funciones CPU
	public void activarCPU(int t) {
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
							CPU = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.RAGE, nomt            );
							CPU.setRuta(res.getString("Ruta"));
							
						}else {
							CPU = new Espadachin( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ESPADACHIN,HabilidadesEnum.TANK, nomt            );
							CPU.setRuta(res.getString("Ruta"));
						}
					break;
					case "ARQUERO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							CPU = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.SPEED, nomt            );
							CPU.setRuta(res.getString("Ruta"));
							
						}else {
							CPU = new Arquero( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ARQUERO,HabilidadesEnum.VOID, nomt            );
							CPU.setRuta(res.getString("Ruta"));
						}
						
						
					break;
					
					case "ASESINO":
						if(res.getString("TipoHabilidad").equals("SPEED") ) {
							CPU = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPEED, nomt            );
							CPU.setRuta(res.getString("Ruta"));
							
						}else {
							CPU = new Asesino( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.ASESINO,HabilidadesEnum.SPECS, nomt            );
							CPU.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "INVOCADOR":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							CPU = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.VOID, nomt            );
							CPU.setRuta(res.getString("Ruta"));
							
						}else {
							CPU = new Invocador( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.INVOCADOR,HabilidadesEnum.SPECS, nomt            );
							CPU.setRuta(res.getString("Ruta"));
						}
						
						
						break;
						
					case "TANQUE":
						if(res.getString("TipoHabilidad").equals("VOID") ) {
							CPU = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.VOID, nomt            );
							CPU.setRuta(res.getString("Ruta"));
							
						}else {
							CPU = new Tanque( idt , hpt , mpt, atkt, defmt, voidmt, spemt, magt, deft, voidt, spet, Clases.TANQUE,HabilidadesEnum.TANK, nomt            );
							CPU.setRuta(res.getString("Ruta"));
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
	
	
	
	
	
	
	public void mostrarMovsCPU(int t) {
		Clases temporalC = null;
		TiposMovimientos temporalT = null;
		Integer[] ids = new Integer[4];
		int counter = 0;
		Movimiento mov;
		
		
		
		try {
			s = n.createStatement();
			res = s.executeQuery("SELECT m.idMovimiento, m.NombreMov, m.TipoMov, m.Coste FROM MOVIMIENTO m JOIN PERSONAJE_MOVIMIENTOS pm ON pm.idMOVIMIENTO = m.idMOVIMIENTO WHERE pm.idPERSONAJE  = "+t+";");
			
			
			
		
			
			while(res.next()) {
				ids[counter] = res.getInt("idMOVIMIENTO");
				counter++;
				String[] fila = {String.valueOf(res.getInt("idMOVIMIENTO")), res.getString("NombreMov"), res.getString("TipoMov") ,String.valueOf(res.getInt("Coste"))      };
				
			}
			
			res.close();
			s.close();
			
			if(CPU.ListaMovimientos.size() > 0) {
				for(int i = 0; i <CPU.ListaMovimientos.size(); i++) {
					CPU.quitarMovimiento(ids[i]);
				}
			}
			
			//Java movs
			for(int i = 0; i < counter; i++) {
				s = n.createStatement();
				res = s.executeQuery("SELECT * FROM MOVIMIENTO WHERE idMOVIMIENTO = "+ ids[i] +";");
				
				while(res.next()) {
					switch(res.getString("ClaseMov")) {
					case "ESPADACHIN":
						temporalC = Clases.ESPADACHIN;
					break;
					case "ARQUERO":
						temporalC = Clases.ARQUERO;
					break;
					case "ASESINO":
						temporalC = Clases.ASESINO;
					break;
					case "INVOCADOR":
						temporalC = Clases.INVOCADOR;
					break;
					case "TANQUE":
						temporalC = Clases.TANQUE;
					break;
					}
					
					switch(res.getString("TipoMov")) {
					case "ATAQUE_FISICO":
						temporalT = TiposMovimientos.ATAQUE_FISICO;
					break;
					case "ATAQUE_ESPECIAL":
						temporalT = TiposMovimientos.ATAQUE_ESPECIAL;
					break;
					case "BUFF":
						temporalT = TiposMovimientos.BUFF;
					break;
					case "DEBUFF":
						temporalT = TiposMovimientos.DEBUFF;
					break;
					}
					
					
					
					mov = new Movimiento(res.getString("NombreMov") , res.getInt("Dano"),  res.getInt("Presicion"),  res.getFloat("Efecto"),
							temporalC , temporalT , res.getString("EfectoStat") , res.getInt("idMOVIMIENTO") ,  res.getInt("Coste"));
					
					CPU.asignarMovimiento(mov);
				}
			}
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public void mostrarStatsCPU() {
		lblHPC.setText("HP: " + CPU.getHP());
		lblMPC.setText("MP: " + CPU.getMP());
		
		lblDefC.setText("DEF: "+ CPU.getDef());
		lblDefMC.setText("DEF M: "+ CPU.getDefM());
		
		lblVoidC.setText("VOID: "+ CPU.getVoid());
		lblVoidMC.setText("VOID M: "+ CPU.getVoidM());

		lblSpeC.setText("VEL: "+ CPU.getSpe());
		lblSpeMC.setText("VEL M: "+ CPU.getSpeM());
		
		lblAtkC.setText("ATQ: " + CPU.getAtk());
		lblMagC.setText("MAG: "+ CPU.getMag());
		
		lblNombreC.setText( CPU.getNombre());
		btnHC.setText( CPU.getTipoH().toString());
	}
	
	
	public void CPUTurno() {
		int IDtempo = (int)(Math.random() * ((5 - 1) + 1)) + 1;
		String show = "";
		if(CPU.getMP() < 11) IDtempo = 1;
		
		switch(IDtempo) {
		case 1:
			combate.listaOrdenes(0, CPU, Jugador, null);
			show = CPU.getNombre() + " usó el ataque base!";
		break;
		case 2:
			if(Personaje.revisarMagia(CPU, CPU.ListaMovimientos.get(0))) {
				combate.listaOrdenes(1, CPU, Jugador, CPU.ListaMovimientos.get(0));
				show = (CPU.getNombre() + " usó " + CPU.ListaMovimientos.get(0).getNombre());
			}else {
				show = ("El ataque de " + CPU.getNombre() + " falló!");
			}
		break;
		case 3:
			if(Personaje.revisarMagia(CPU, CPU.ListaMovimientos.get(1))) {
				combate.listaOrdenes(1, CPU, Jugador, CPU.ListaMovimientos.get(1));
				show = (CPU.getNombre() + " usó " + CPU.ListaMovimientos.get(1).getNombre());
			}else {
				show = ("El ataque de " + CPU.getNombre() + " falló!");
			}
		break;
		case 4:
			if(Personaje.revisarMagia(CPU, CPU.ListaMovimientos.get(2))) {
				combate.listaOrdenes(1, CPU, Jugador, CPU.ListaMovimientos.get(2));
				show = (CPU.getNombre() + " usó " + CPU.ListaMovimientos.get(2).getNombre());
			}else {
				show = ("El ataque de " + CPU.getNombre() + " falló!");
			}
		break;
		case 5:
			if(Personaje.revisarMagia(CPU, CPU.ListaMovimientos.get(3))) {
				combate.listaOrdenes(1, CPU, Jugador, CPU.ListaMovimientos.get(3));
				show = (CPU.getNombre() + " usó " + CPU.ListaMovimientos.get(3).getNombre());
			}else {
				show = ("El ataque de " + CPU.getNombre() + " falló!");
			}
		break;
		}
		JOptionPane.showMessageDialog(null, show);
	}


	
	
	
	
	
}
