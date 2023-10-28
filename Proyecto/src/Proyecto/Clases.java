package Proyecto;

public enum Clases {
	ESPADACHIN("ESPADACHIN"), ARQUERO("ARQUERO"), ASESINO("ASESINO"), INVOCADOR("INVOCADOR"), TANQUE("TANQUE");
	
	private final String nombreClase;
	
	Clases(String str){
		nombreClase = str;
	}
	
	public String toString()
	{
		return nombreClase;
	}
	
}
