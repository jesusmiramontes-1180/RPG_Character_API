package Proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public abstract class Usuario {
	protected String Clave;
	protected String Nombre; 
	protected Date Fecha; 
	
	
	
	public Usuario(String Cl, String Nom) {
		this.Clave = Cl;
		this.Nombre = Nom;
	}
	
	
	
	
//public abstract boolean ingresar(String Cl, int ID);
		
		
		
	
	
	
	
}
