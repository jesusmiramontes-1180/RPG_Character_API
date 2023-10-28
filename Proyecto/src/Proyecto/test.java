package Proyecto;

import javax.swing.JOptionPane;

public class test {
	public static void main(String[] args) {
		Movimiento m1 = new Movimiento("Zio", 10, 5, 0, Clases.ESPADACHIN, TiposMovimientos.ATAQUE_ESPECIAL, " ", 1, 2);
		Movimiento m2 = new Movimiento("Tarukaja", 0, 5, 0.3f, Clases.ESPADACHIN, TiposMovimientos.BUFF, "Ataque", 2, 2);
		Movimiento m3 = new Movimiento("Tarunda", 0, 5, 0.3f, Clases.ESPADACHIN, TiposMovimientos.DEBUFF, "Ataque", 3, 4);
		Movimiento m4 = new Movimiento("Nut Berserk", 60, 3, 0, Clases.ESPADACHIN, TiposMovimientos.ATAQUE_FISICO, " ", 4, 10);
		
		System.out.println("======================================================");
		Personaje p1 = new Espadachin(180, Clases.ESPADACHIN, HabilidadesEnum.RAGE ,"Okita");
		System.out.println("======================================================");
		
		p1.asignarMovimiento(m1);
		p1.asignarMovimiento(m2);
		p1.asignarMovimiento(m3);
		p1.asignarMovimiento(m4);
		
		
		System.out.println("======================================================");
		System.out.println("======================================================");
		
		
		Personaje p2 = p1.Clone();
		System.out.println(p1);
		
		System.out.println("======================================================");
		System.out.println(p2);
		
		
		
		//Crear segundo personaje
		Personaje p3 =  new Espadachin(190, Clases.ESPADACHIN, HabilidadesEnum.RAGE ,"Artoria");
		p3.asignarMovimiento(m1);
		p3.asignarMovimiento(m2);
		p3.asignarMovimiento(m3);
		p3.asignarMovimiento(m4);
		
		Personaje p4 = p3.Clone();
		
		System.out.println("======================================================");
		System.out.println("======================================================");
		System.out.println("======================================================");
		
		
		
		
		//Pruebas de gameplay
		//Usar p2 y p4
		for(int i = 0; i < 10; i++) System.out.println((int)(Math.random() * ((5 - 1) + 1)+1 ));
		
		
		System.out.printf("%s VS. %s\n", p2.nombre, p4.nombre);
		
		boolean battleON = true;
		String input, message = " ";
		boolean used = false;
		
		boolean p2S = false, p4S = false, p2SU = false, p4SU = false;
		
		
		
		while(battleON) {
			message = String.format("%s\nVS.\n%s", p2.toString(), p4.toString());
			JOptionPane.showMessageDialog(null, message);
			
			
			if((p2.Spe*p2.SpeM ) >= (p4.Spe * p4.SpeM) ) {
				
				//a de attack, m1 al m4
				input = JOptionPane.showInputDialog("Que hará " + p2.nombre + " ?\n");
				switch(input) {
				case "a":
					Personaje.ataqueDefecto(p2, p4);
					message = String.format("Movimiento por defecto usado!!!");
				break;
				case "m1":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(0));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(0).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(0).Nombre);
					
					break;
				case "m2":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(1));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(1).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(1).Nombre);
					break;
				case "m3":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(2));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(2).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(2).Nombre);
					break;
				case "m4":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(3));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(3).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(3).Nombre);
					break;
				case "h":
					if(p2S == false && p2SU == false) {//Habilidad sin activar ni usar
						p2S = true;
						message = String.format("%s usó %s", p2.nombre, p2.TipoHabilidad);
					}else {
						message = String.format("%s ya activó la habilidad!", p2.nombre);
					}
					
				break;
				}
				
				if(p2SU && p2S) {
					p2S = false;
					System.out.println("Habilidad de " + p2.nombre + " desactivada");
				}
				if(p2S) {
					p2SU = !(p2.usarHabilidad());
				}
				
				
				
				
				JOptionPane.showMessageDialog(null, message);
				
				if(Personaje.revisarHP(p4) == false) {
					battleON = false;
					break;
				}
				
				
				input = JOptionPane.showInputDialog("Que hará " + p4.nombre + " ?\n");
				switch(input) {
				case "a":
					Personaje.ataqueDefecto(p4, p2);
					message = String.format("Movimiento por defecto usado!!!");
				break;
				case "m1":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(0));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(0).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(0).Nombre);
					break;
				case "m2":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(1));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(1).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(1).Nombre);
					break;
				case "m3":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(2));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(2).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(2).Nombre);
					break;
				case "m4":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(3));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(3).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(3).Nombre);
					break;
				case "h":
					if(p4S == false && p4SU == false) {//Habilidad sin activar ni usar
						p4S = true;
						message = String.format("%s usó %s", p4.nombre, p4.TipoHabilidad);
					}else {
						message = String.format("%s ya activó la habilidad!", p4.nombre);
					}
					
				break;
				}
				
				if(p4SU && p4S) {
					p4S = false;
					System.out.println("Habilidad de " + p4.nombre + " desactivada");
				}
				if(p4S) {
					p4SU = !(p4.usarHabilidad());
				}
				
				
				JOptionPane.showMessageDialog(null, message);
				if(Personaje.revisarHP(p2) == false) {
					battleON = false;
					break;
				}
				
				
				
			}else {
				input = JOptionPane.showInputDialog("Que hará " + p4.nombre + " ?\n");
				switch(input) {
				case "a":
					Personaje.ataqueDefecto(p4, p2);
					message = String.format("Movimiento por defecto usado!!!");
				break;
				case "m1":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(0));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(0).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(0).Nombre);
					break;
				case "m2":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(1));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(1).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(1).Nombre);
					break;
				case "m3":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(2));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(2).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(2).Nombre);
					break;
				case "m4":
					used = Personaje.accion(p4, p2, p4.ListaMovimientos.get(3));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(3).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(3).Nombre);
					break;
				case "h":
					if(p4S == false && p4SU == false) {//Habilidad sin activar ni usar
						p4S = true;
						message = String.format("%s usó %s", p4.nombre, p4.TipoHabilidad);
					}else {
						message = String.format("%s ya activó la habilidad!", p4.nombre);
					}
					
				break;
				}
				
				if(p4SU && p4S) {
					p4S = false;
					System.out.println("Habilidad de " + p4.nombre + " desactivada");
				}
				if(p4S) {
					p4SU = !(p4.usarHabilidad());
				}
				
				JOptionPane.showMessageDialog(null, message);
				if(Personaje.revisarHP(p2) == false) {
					battleON = false;
					break;
				}
				
				
				input = JOptionPane.showInputDialog("Que hará " + p2.nombre + " ?\n");
				switch(input) {
				case "a":
					Personaje.ataqueDefecto(p2, p4);
					message = String.format("Movimiento por defecto usado!!!");
				break;
				case "m1":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(0));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(0).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(0).Nombre);
					
					break;
				case "m2":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(1));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(1).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(1).Nombre);
					break;
				case "m3":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(2));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(2).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(2).Nombre);
					break;
				case "m4":
					used = Personaje.accion(p2, p4, p2.ListaMovimientos.get(3));
					if(used) message = String.format("Se usó %s!!!", p2.ListaMovimientos.get(3).Nombre);
					else message = String.format("El ataque %s falló!!!", p2.ListaMovimientos.get(3).Nombre);
					break;
				case "h":
					if(p2S == false && p2SU == false) {//Habilidad sin activar ni usar
						p2S = true;
						message = String.format("%s usó %s", p2.nombre, p2.TipoHabilidad);
					}else {
						message = String.format("%s ya activó la habilidad!", p2.nombre);
					}
					
				break;
				}
				
				if(p2SU && p2S) {
					p2S = false;
					System.out.println("Habilidad de " + p2.nombre + " desactivada");
				}
				if(p2S) {
					p2SU = !(p2.usarHabilidad());
				}
				
				JOptionPane.showMessageDialog(null, message);
				
				if(Personaje.revisarHP(p4) == false) {
					battleON = false;
					break;
				}
				
				
				
			}
		}//Fin while
		
		if(Personaje.revisarHP(p2)) {
			//Gana p2
			message = String.format("Gana %s!!!!!!", p2.nombre);
			System.out.println(p2);
			System.out.println(p4);
		}else {
			message = String.format("Gana %s!!!!!!", p4.nombre);
			System.out.println(p4);
			System.out.println(p2);
		}
		
		JOptionPane.showMessageDialog(null, message);
		
		
		
		
	}

}
