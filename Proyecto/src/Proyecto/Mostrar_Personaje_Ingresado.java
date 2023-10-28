package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Mostrar_Personaje_Ingresado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Personaje_Ingresado frame = new Mostrar_Personaje_Ingresado();
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
	JLabel lblIDJ;
	Movimiento mov;
	
	Connection n = Conexion.conectar();
	
	Statement s = null;
	ResultSet res = null;
	Personaje temp;
	public int t= 0;
	JLabel lblID;
	private JLabel lblConsulta;
	private JButton btnVolver;
	private JLabel lblNombre;
	private JLabel lblClase;
	private JLabel lblHabilidad;
	private JTable table;
	
	public Mostrar_Personaje_Ingresado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblImg = new JLabel("");
		
		lblImg.setBounds(34, 177, 150, 150);
		contentPane.add(lblImg);
		
		lblID = new JLabel("New label");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setText("...");
		lblID.setBounds(34, 97, 92, 35);
		contentPane.add(lblID);
		
		lblConsulta = new JLabel("Clic para mostrar datos de Peronsaje con ID: ");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsulta.setBounds(34, 44, 335, 42);
		contentPane.add(lblConsulta);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = Integer.parseInt(lblID.getText());
				
				activarP();
				mostrarMovs();
				mostrarStats();
				lblImg.setIcon( new ImageIcon(Personajes_Menu.class.getResource(temp.getRuta())));
				
			}
		});
		btnMostrar.setBounds(157, 105, 89, 23);
		contentPane.add(btnMostrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Personajes tempo = new Ver_Personajes();
				tempo.lblIDJ.setText(lblIDJ.getText());
				tempo.setVisible(true);
				Mostrar_Personaje_Ingresado.this.dispose();
				
			}
		});
		btnVolver.setBounds(10, 540, 89, 23);
		contentPane.add(btnVolver);
		
		lblHPS = new JLabel("HP:");
		lblHPS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHPS.setBounds(267, 188, 103, 62);
		contentPane.add(lblHPS);
		
		lblMPS = new JLabel("MP:");
		lblMPS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMPS.setBounds(397, 188, 103, 62);
		contentPane.add(lblMPS);
		
		lblDefS = new JLabel("Def:");
		lblDefS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefS.setBounds(540, 188, 103, 62);
		contentPane.add(lblDefS);
		
		lblVoidS = new JLabel("Void:");
		lblVoidS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVoidS.setBounds(668, 188, 103, 62);
		contentPane.add(lblVoidS);
		
		lblSpeS = new JLabel("Vel:");
		lblSpeS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpeS.setBounds(803, 188, 103, 62);
		contentPane.add(lblSpeS);
		
		lblAtkS = new JLabel("Atk:");
		lblAtkS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtkS.setBounds(267, 261, 103, 62);
		contentPane.add(lblAtkS);
		
		lblMagS = new JLabel("Mag:");
		lblMagS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMagS.setBounds(397, 261, 103, 62);
		contentPane.add(lblMagS);
		
		lblDefMS = new JLabel("DefM:");
		lblDefMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefMS.setBounds(540, 261, 103, 62);
		contentPane.add(lblDefMS);
		
		lblVoidMS = new JLabel("VoidM:");
		lblVoidMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVoidMS.setBounds(653, 265, 103, 62);
		contentPane.add(lblVoidMS);
		
		lblSpeMS = new JLabel("VelM:");
		lblSpeMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpeMS.setBounds(803, 265, 103, 62);
		contentPane.add(lblSpeMS);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(397, 11, 359, 62);
		contentPane.add(lblNombre);
		
		lblClase = new JLabel("Clase:");
		lblClase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClase.setBounds(397, 96, 187, 62);
		contentPane.add(lblClase);
		
		lblHabilidad = new JLabel("Hab:");
		lblHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHabilidad.setBounds(633, 97, 187, 62);
		contentPane.add(lblHabilidad);
		
		lblIDJ = new JLabel("New label");
		lblIDJ.setBounds(34, 11, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 351, 612, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
	
	
	public void mostrarMovs() {
		Clases temporalC = null;
		TiposMovimientos temporalT = null;
		Integer[] ids = new Integer[4];
		int counter = 0;
		
		table.setModel(new DefaultTableModel());
		
		
		
		try {
			s = n.createStatement();
			res = s.executeQuery("SELECT m.idMovimiento, m.NombreMov, m.TipoMov, m.Coste FROM MOVIMIENTO m JOIN PERSONAJE_MOVIMIENTOS pm ON pm.idMOVIMIENTO = m.idMOVIMIENTO WHERE pm.idPERSONAJE  = "+t+";");
			ResultSetMetaData res1 = res.getMetaData();
			
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			int cols = res1.getColumnCount();
			String[] colN = new String [cols];
			for(int i = 0; i < cols; i++) {
				colN[i] = res1.getColumnName(i+1);
			}
			
			
			
			m.setColumnIdentifiers(colN);
			
			while(res.next()) {
				ids[counter] = res.getInt("idMOVIMIENTO");
				counter++;
				String[] fila = {String.valueOf(res.getInt("idMOVIMIENTO")), res.getString("NombreMov"), res.getString("TipoMov") ,String.valueOf(res.getInt("Coste"))      };
				m.addRow(fila);
			}
			
			res.close();
			s.close();
			
			if(temp.ListaMovimientos.size() > 0) {
				for(int i = 0; i < temp.ListaMovimientos.size(); i++) {
					temp.quitarMovimiento(ids[i]);
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
					
					temp.asignarMovimiento(mov);
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		lblNombre.setText("Nombre: " + temp.getNombre());
		lblClase.setText("Clase: " + temp.getClase());
		lblHabilidad.setText("Hab: "+ temp.getTipoH());
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
			
				
				System.out.println(temp);
				
				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	
	
}
