package Proyecto;

public class Arena {
	private boolean Batalla = true;
	private float Turno = 0;
	
	public Arena(){
		
	}
	
	public boolean determinarOrden(Personaje p1, Personaje p2) {
		if((p1.Spe * p1.SpeM)  >= (p2.Spe * p2 .SpeM)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void listaOrdenes(int orden, Personaje p1, Personaje p2, Movimiento m) {
		if(!(p1.HabilidadUsada))revisarHabilidad(p1);
		
		
		switch(orden) {
		case 0:
			Personaje.ataqueDefecto(p1, p2);
		break;
		case 1:
			Personaje.accion(p1, p2, m);
		break;
		case 2:
			if(!(p1.UsandoHabilidad)) {
				p1.usarHabilidad();
			}
		break;
		}
		
		if(Personaje.revisarHP(p2) == false) {
			Batalla= false;
		}else {
			Turno += 0.5;
		}
	}
	
	
	
	private void revisarHabilidad(Personaje p) {
		if(p.UsandoHabilidad == true) p.usarHabilidad();
	}
	
	
	public int getTurno() {
		return (int) Turno;
	}
	
	public boolean getEstadoBatalla() {
		return Batalla;
	}
	

	
	
	
	
	
	

}
