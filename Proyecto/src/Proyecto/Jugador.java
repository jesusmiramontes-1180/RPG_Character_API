package Proyecto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Jugador extends Usuario{

	Connection c = Conexion.conectar();
    
    Statement s = null; //Sirve para crear un sitio para guardar la consulta (te sirve para crear la consulta)
    
    ResultSet res = null; // Aqui se guarda la consulta
    
    CallableStatement cl = null; //Para llamar storeprocedures 
    
    
    
	
	public Jugador( String Cl, String Nom, int IDJ) {
	
		super(Cl, Nom);
		this.IDJugador = IDJ;
		
		}
	
	private int IDJugador;
	private int Victorias;
	private int Derrotas;
	
	/*
	public void CrearPersonajes() {
		
	}
	public void EliminarPersonajes() {
		
	}
	*/	
	public void EliminarJugador(int ID, String Cl) {
		if(ingresar(Cl, ID)) {
			try {
				s= c.createStatement();
				s.executeUpdate("DELETE FROM JUGADOR_PERSONAJES WHERE idJUGADOR = "+ID+";");
				s.close();
				
				s = c.createStatement();
				
				s.executeUpdate("DELETE FROM jugador.jugador WHERE IDJugador ="+ ID +";");
				 
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	
	public static boolean ingresar(String Cl, int ID) {
		try {
			Connection c = Conexion.conectar();
			Statement s = c.createStatement();
			ResultSet res = s.executeQuery("SELECT Clave FROM JUGADOR where idJUGADOR = "+ ID +";");
			String tempoClave= "";
			while(res.next()) {
				tempoClave = res.getString("Clave");
			}
			res.close();
			s.close();
			return tempoClave.equals(Cl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean registrarJugadores(String Cl, String Nom) {
		Connection c = Conexion.conectar();
	    
	    try {
			Statement s = c.createStatement();
			ResultSet res = s.executeQuery("SELECT MAX(idJUGADOR) + 1 as 'maxi' FROM JUGADOR;");
			int tempo = 0;
			
			while(res.next()){
				tempo = res.getInt("maxi");
			}
			
			res.close();
			s.close();
			
			if(tempo == 0) {
				return false;
			}else {
				s = c.createStatement();
				s.executeUpdate("INSERT INTO JUGADOR VALUES ("+tempo+", '"+Cl+"', '"+Nom+"', 0, 0, now());");
				
				s.close();
				JOptionPane.showMessageDialog(null, "Se ha registrado el nuevo jugador con el ID " + tempo);
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return false;	
	}
	
	
	
}