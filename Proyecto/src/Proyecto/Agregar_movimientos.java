package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agregar_movimientos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_movimientos frame = new Agregar_movimientos();
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
	
	JLabel lblID;
Connection n = Conexion.conectar();
	
	Statement s = null;
	ResultSet res = null;
	Personaje temp;
	Movimiento mov;
	
	public int t= 0, idmo = 0;
	private JLabel lblImg;
	private JTextField tfAgregar;
	private JTable table_1;
	private JTextField tfBorrar;
	
	JLabel lblIDJ;
	
	public Agregar_movimientos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregando Movimientos a:");
		lblNewLabel.setBounds(29, 53, 160, 38);
		contentPane.add(lblNewLabel);
		
		lblID = new JLabel("0");
		lblID.setBounds(199, 65, 46, 14);
		contentPane.add(lblID);
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = Integer.parseInt(lblID.getText());
				
				activarP();
				lblImg.setIcon( new ImageIcon(Personajes_Menu.class.getResource(temp.getRuta())));
				String clase = temp.getClase().toString();
				btnEmpezar.setVisible(false);
				
				try {
					s = n.createStatement();
					res = s.executeQuery("SELECT * FROM MOVIMIENTO WHERE ClaseMov = '"+clase+"';");
					ResultSetMetaData res1 = res.getMetaData();
					
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					int cols = res1.getColumnCount();
					String[] colN = new String [cols];
					for(int i = 0; i < cols; i++) {
						colN[i] = res1.getColumnName(i+1);
					}
					
					m.setColumnIdentifiers(colN);
					
					while(res.next()) {
						String[] fila = {String.valueOf(res.getInt("idMOVIMIENTO")), res.getString("NombreMov"), String.valueOf(res.getInt("Dano")), String.valueOf(res.getInt("Presicion")),
								String.valueOf(res.getInt("Coste")), String.valueOf(res.getFloat("Efecto")), res.getString("EfectoStat"), res.getString("ClaseMov"), res.getString("TipoMov")          };
						m.addRow(fila);
						

					}
					
					res.close();
					s.close();
					
					mostrarMovs();
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btnEmpezar.setVisible(false);
				
				
				
				
			}
		});
		btnEmpezar.setBounds(29, 101, 89, 23);
		contentPane.add(btnEmpezar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 65, 712, 482);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblImg = new JLabel("");
		lblImg.setBounds(126, 102, 150, 150);
		contentPane.add(lblImg);
		
		JLabel lblMovs = new JLabel("Ingrese el ID del mov:");
		lblMovs.setBounds(29, 269, 113, 14);
		contentPane.add(lblMovs);
		
		tfAgregar = new JTextField();
		tfAgregar.setBounds(29, 294, 113, 23);
		contentPane.add(tfAgregar);
		tfAgregar.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idmov = Integer.parseInt(tfAgregar.getText());
				
				
				
				if(temp.estadoMovs()) {
					//Espacios llenos
					JOptionPane.showMessageDialog(null, "Este Personaje no puede tener más movimientos");
					
				}else {
					
					try {
						s = n.createStatement();
						res = s.executeQuery("SELECT * FROM MOVIMIENTO WHERE idMOVIMIENTO = "+ idmov +";");
						
						while(res.next()) {
							Clases temporalC = null;
							TiposMovimientos temporalT = null;
							
							
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
						}
						
						res.close();
						s.close();
						
						int St = temp.ListaMovimientos.size();
						temp.asignarMovimiento(mov);
						if(temp.ListaMovimientos.size() > St  ) {
							JOptionPane.showMessageDialog(null, "El movimiento se agregó correctamente!!!!");
							//Realizar el update
							s = n.createStatement();
							s.executeUpdate("INSERT INTO PERSONAJE_MOVIMIENTOS VALUES("+t+","+idmov+");");
							s.close();
							mostrarMovs();
						}else {
							JOptionPane.showMessageDialog(null, "El movimiento ingresado pertenece a otra clase!!!!");
						}
						
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
				
				
				
				
			}
		});
		btnAgregar.setBounds(29, 328, 89, 23);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 388, 247, 136);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblMovsON = new JLabel("Movimientos del Personaje");
		lblMovsON.setBounds(29, 362, 160, 15);
		contentPane.add(lblMovsON);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seleccionar_Personaje sp = new Seleccionar_Personaje();
				sp.lblIDJ.setText(lblIDJ.getText());
				sp.setVisible(true);
				Agregar_movimientos.this.dispose();
			}
		});
		btnCancelar.setBounds(10, 553, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblIdParaBorrar = new JLabel("ID para Borrar");
		lblIdParaBorrar.setBounds(171, 269, 94, 14);
		contentPane.add(lblIdParaBorrar);
		
		tfBorrar = new JTextField();
		tfBorrar.setBounds(171, 295, 86, 20);
		contentPane.add(tfBorrar);
		tfBorrar.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idmov = Integer.parseInt(tfBorrar.getText());
				
				boolean suis = temp.quitarMovimiento(idmov);
				if(suis) {
					//Se borro y toca delete
					
					try {
						s = n.createStatement();
						s.executeUpdate("DELETE FROM PERSONAJE_MOVIMIENTOS WHERE idPERSONAJE = "+t+" and idMOVIMIENTO = "+idmov+";");
						s.close();
						mostrarMovs();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el movimiendo dado!!!!");
				}
				
				
			}
		});
		btnBorrar.setBounds(176, 328, 89, 23);
		contentPane.add(btnBorrar);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Movimientos Compatibles");
		lblNewLabel_1.setBounds(286, 40, 395, 14);
		contentPane.add(lblNewLabel_1);
		
		lblIDJ = new JLabel("New label");
		lblIDJ.setBounds(29, 11, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
	}
	
	
	
	
	
	//Funciones
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

	public void mostrarMovs() {
		Clases temporalC = null;
		TiposMovimientos temporalT = null;
		Integer[] ids = new Integer[4];
		int counter = 0;
		
		table_1.setModel(new DefaultTableModel());
		
		
		
		try {
			s = n.createStatement();
			res = s.executeQuery("SELECT m.idMovimiento, m.NombreMov, m.TipoMov, m.Coste FROM MOVIMIENTO m JOIN PERSONAJE_MOVIMIENTOS pm ON pm.idMOVIMIENTO = m.idMOVIMIENTO WHERE pm.idPERSONAJE  = "+t+";");
			ResultSetMetaData res1 = res.getMetaData();
			
			DefaultTableModel m = (DefaultTableModel) table_1.getModel();
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
}
