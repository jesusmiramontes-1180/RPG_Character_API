package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String controlador  = "com.mysql.jdbc.Driver";
	private static final String url  = "jdbc:mysql://localhost:3306/proyecto";
	private static final String user  = "root";
	private static final String password  = "123456";
	
	
	static {
		try {
			Class.forName(controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(url, user, password);
			
			System.out.println("Base de Datos alcanzada");
			
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
		}
		return c;
	}
	
	
	public static void desconectar(Connection c) {
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				
			}
		}
	}
}
