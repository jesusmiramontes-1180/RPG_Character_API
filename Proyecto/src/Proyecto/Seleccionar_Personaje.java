package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Seleccionar_Personaje extends JFrame {

	private JPanel contentPane;
	private JTextField tfBuscar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccionar_Personaje frame = new Seleccionar_Personaje();
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
	
	int t;
	JLabel lblIDJ;
	
	public Seleccionar_Personaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes_Menu menu = new Personajes_Menu();
				menu.lblIDJugador.setText(lblIDJ.getText());
				menu.setVisible(true);
				Seleccionar_Personaje.this.dispose();
			}
		});
		btnVolver.setBounds(10, 553, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				try {
					s = n.createStatement();
					res = s.executeQuery("SELECT p.idPERSONAJE as 'ID', p.Nombre, p.Clase, p.TipoHabilidad as 'Hab', p.HP, p.MP, p.Atk, p.Mag, p.Def, "
							+ "p.Void, p.Spe as 'Vel', p.DefM, p.VoidM, p.SpeM as 'VelM' "
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
		btnMostrar.setBounds(10, 33, 89, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblBuscar = new JLabel();
		lblBuscar.setText("<html>Ingrese el ID<br/>del personaje<br/>a editar!</html>");
		lblBuscar.setBounds(10, 123, 100, 49);
		contentPane.add(lblBuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(10, 192, 86, 20);
		contentPane.add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JButton btnEditar = new JButton("Ir a Edición!");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(tfBuscar.getText().equals("")) {
					
				}else {
					try {
						t = Integer.parseInt(tfBuscar.getText());
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
							JOptionPane.showMessageDialog(null, "No se encontró el ID ingresado para este Jugador");
						}else {
							Editar_Personaje t2 = new Editar_Personaje();
							t2.lblID.setText(String.valueOf(t));
							t2.lblIDJ.setText(lblIDJ.getText());
							
							t2.setVisible(true);
							Seleccionar_Personaje.this.dispose();
							
						}
						
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
				}
				}
				
				
				
				
				
				
					
				
				
				
				
				
				
				
			}
		});
		btnEditar.setBounds(10, 236, 100, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 28, 867, 548);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Movimientos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	if(tfBuscar.getText().equals("")) {
					
				}else {
					try {
						t = Integer.parseInt(tfBuscar.getText());
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
							JOptionPane.showMessageDialog(null, "No se encontró el ID ingresado para este Jugador");
						}else {
							Agregar_movimientos t2 = new Agregar_movimientos();
							t2.lblID.setText(String.valueOf(t));
							t2.lblIDJ.setText(lblIDJ.getText());
							
							t2.setVisible(true);
							Seleccionar_Personaje.this.dispose();
							
						}
						
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					
					
				}
				
			
				
				}
				
				
					
				
				
				
				
			}
		});
		btnNewButton.setBounds(0, 284, 121, 23);
		contentPane.add(btnNewButton);
		
		lblIDJ = new JLabel("...");
		lblIDJ.setBounds(53, 490, 46, 14);
		contentPane.add(lblIDJ);
		lblIDJ.setVisible(false);
	}
}
