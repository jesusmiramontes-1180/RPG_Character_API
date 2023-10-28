package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class Ver_Personajes extends JFrame {

	private JPanel contentPane;
	private JTable tblDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Personajes frame = new Ver_Personajes();
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
	private JTextField rfBuscar;
	public Personaje temp;
	JLabel lblNewLabel;
	int t;
	JLabel lblIDJ;
	
	public Ver_Personajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblDatos.setModel(new DefaultTableModel());
				try {
					s = n.createStatement();
					res = s.executeQuery("SELECT p.idPERSONAJE as 'ID', p.Nombre, p.Clase, p.TipoHabilidad as 'Hab', p.HP, p.MP, p.Atk, p.Mag, p.Def, "
							+ "p.Void, p.Spe as 'Vel', p.DefM, p.VoidM, p.SpeM as 'VelM' "
							+ "FROM PERSONAJE p JOIN JUGADOR_PERSONAJES jp ON jp.idPERSONAJE = p.idPERSONAJE WHERE jp.idJUGADOR = "+lblIDJ.getText()+"; ");
					ResultSetMetaData res1 = res.getMetaData();
					
					DefaultTableModel m = (DefaultTableModel) tblDatos.getModel();
					int cols = res1.getColumnCount();
					String[] colN = new String [cols];
					for(int i = 0; i < cols; i++) {
						colN[i] = res1.getColumnName(i+1);
					}
					
					m.setColumnIdentifiers(colN);
					
					while(res.next()) {
						String[] fila = { String.valueOf(res.getInt("ID")),res.getString("Nombre") ,res.getString("Clase"),  res.getString("Hab") ,String.valueOf(res.getInt("HP")),
								String.valueOf(res.getInt("MP")) , String.valueOf(res.getFloat("Atk")),
								String.valueOf(res.getBigDecimal("Mag")), String.valueOf(res.getBigDecimal("DefM")), 
								String.valueOf(res.getBigDecimal("VoidM")),String.valueOf(res.getFloat("VelM")),
								String.valueOf(res.getInt("Def")),  String.valueOf(res.getInt("Void")), String.valueOf(res.getInt("Vel"))};
						m.addRow(fila);
						

					}
					
					res.close();
					s.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnMostrar.setBounds(7, 60, 135, 52);
		contentPane.add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 63, 818, 465);
		contentPane.add(scrollPane);
		
		tblDatos = new JTable();
		scrollPane.setViewportView(tblDatos);
		
		JLabel lblBuscar = new JLabel("Ingresa el ID a buscar:");
		lblBuscar.setBounds(10, 187, 132, 39);
		contentPane.add(lblBuscar);
		
		rfBuscar = new JTextField();
		rfBuscar.setBounds(10, 237, 116, 20);
		contentPane.add(rfBuscar);
		rfBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rfBuscar.getText().equals("")) {
					
				}else {
					try {
						t = Integer.parseInt(rfBuscar.getText());
					}catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Se debe ingresar un numero válido!!!");
					}
					
					try {
						s = n.createStatement();
						res = s.executeQuery("SELECT *\r\n"
								+ "FROM PERSONAJE p\r\n"
								+ "JOIN JUGADOR_PERSONAJES jp ON jp.idPERSONAJE = p.idPERSONAJE \r\n"
								+ "WHERE p.idPERSONAJE = "+t+" and  jp.idJUGADOR = "+lblIDJ.getText()+";");
						
						
						if(res.next() == false) {
							
						res.close();
						s.close();
							JOptionPane.showMessageDialog(null, "No se encontró el ID ingresado para este Jugador");
						}else {
							Mostrar_Personaje_Ingresado t2 = new Mostrar_Personaje_Ingresado();
							t2.lblIDJ.setText(lblIDJ.getText());
							t2.lblID.setText(String.valueOf(t));
							
							t2.setVisible(true);
							Ver_Personajes.this.dispose();
							
						}
						
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					
					
				}
				
			
				
				}
				
			}
		});
		btnBuscar.setBounds(10, 268, 116, 28);
		contentPane.add(btnBuscar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 342, 150, 150);
		contentPane.add(lblNewLabel);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes_Menu menu = new Personajes_Menu();
				menu.lblIDJugador.setText(lblIDJ.getText());
				menu.setVisible(true);
				Ver_Personajes.this.dispose();
			}
		});
		btnCancelar.setBounds(7, 526, 89, 23);
		contentPane.add(btnCancelar);
		
		lblIDJ = new JLabel("...");
		lblIDJ.setForeground(Color.RED);
		lblIDJ.setBounds(124, 11, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
	}
}
