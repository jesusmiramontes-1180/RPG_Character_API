package Proyecto;
import java.util.ArrayList;


public abstract class Personaje{
	protected int HP = 0,HPL = 0, MP = 0, Def, Void, Spe;
	protected float Atk, DefM, Mag, VoidM, SpeM;
	protected String nombre = " ";
	protected String ruta;
	
	protected float AtkC, DefC, MagC, VoidC, SpeC;
	
	protected int IDPersonaje;
	protected Clases Clase;
	protected HabilidadesEnum TipoHabilidad;
	protected ArrayList<Movimiento> ListaMovimientos = new ArrayList <>();
	
	protected int EstadoHabilidad = 0;
	protected boolean HabilidadUsada = false, UsandoHabilidad  = false;
	
	protected static final int LIMITEBUFF = 4, LIMITDEBUFF = 6;
	protected int estadobuff = 0, estadodebuff = 0;
	
	public Personaje(int hp, Clases cl, HabilidadesEnum h, String nom) {
	}
	
	public Personaje(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		setNOMBRE(n);
		setHP(hp);
		setMP(mp);
		setATK(atk);
		setDEF(def);
		setVOID(voi);
		setMAG(mag);
		setSPE(spe);
		setDEFM(defm);
		setVOIDM(voim);
		setSPEM(spem);
		setCLASE(cl);
		setID(id);
		asignarHabilidad(h);
	}
	
	
	
	public void asignarHabilidad(HabilidadesEnum h) {
		if(this.Clase == Clases.ESPADACHIN) {
			if(h == HabilidadesEnum.RAGE ||  h == HabilidadesEnum.TANK) {
				this.TipoHabilidad = h;
			}else {
				System.out.println("La habilidad no es válida para esta clase!!");
			}
		}else if(this.Clase == Clases.ARQUERO) {
			if(h == HabilidadesEnum.SPEED ||  h == HabilidadesEnum.VOID) {
				this.TipoHabilidad = h;
			}else {
				System.out.println("La habilidad no es válida para esta clase!!");
			}
		}else if(this.Clase == Clases.ASESINO) {
			if(h == HabilidadesEnum.SPEED ||  h == HabilidadesEnum.SPECS) {
				this.TipoHabilidad = h;
			}else {
				System.out.println("La habilidad no es válida para esta clase!!");
			}
		}else if(this.Clase == Clases.INVOCADOR) {
			if(h == HabilidadesEnum.VOID ||  h == HabilidadesEnum.SPECS) {
				this.TipoHabilidad = h;
			}else {
				System.out.println("La habilidad no es válida para esta clase!!");
			}
		}else if(this.Clase == Clases.TANQUE) {
			if(h == HabilidadesEnum.VOID ||  h == HabilidadesEnum.TANK) {
				this.TipoHabilidad = h;
			}else {
				System.out.println("La habilidad no es válida para esta clase!!");
			}
		}
		
	}
	
	
	//Setters
	public void setHP(int hp) {
		HP = hp;
		HPL = hp;
	}
	public void setMP(int mp) {
		MP = mp;
	}
	public void setATK(float atk) {
		Atk = atk;
		AtkC = atk;
	}
	public void setDEF(int def) {
		Def = def;
	}
	public void setVOID(int v) {
		Void = v;
	}
	public void setSPE(int spe) {
		Spe= spe;
	}
	public void setDEFM(float def) {
		DefM = def;
		DefC = def;
	}
	public void setMAG(float mag) {
		Mag = mag;
		MagC = mag;
	}
	public void setVOIDM(float v) {
		VoidM = v;
		VoidC = v;
	}
	public void setSPEM(float spe) {
		SpeM = spe;
		SpeC = spe;
	}
	public void setID(int id) {
		IDPersonaje = id;
	}
	public void setNOMBRE(String n) {
		nombre = n;
	}
	public void setCLASE(Clases cl) {
		Clase = cl;
	}
	public void setRuta(String r) {
		ruta = r;
	}
	
	
	//Getters
	public int getHP() {
		return this.HP;
	}
	public int getMP(){
		return this.MP;
	}
	public float getAtk() {
		return this.Atk;
	}
	public float getMag() {
		return this.Mag;
	}
	public int getDef() {
		return this.Def;
	}
	public float getDefM() {
		return this.DefM;
	}
	public int getVoid() {
		return this.Void;
	}
	public float getVoidM() {
		return this.VoidM;
	}
	public int getSpe() {
		return this.Spe;
	}
	public float getSpeM() {
		return this.SpeM;
	}
	public int getID() {
		return this.IDPersonaje;
	}
	public String getNombre() {
		return this.nombre;
	}
	public Clases getClase() {
		return this.Clase;
	}
	public HabilidadesEnum getTipoH() {
		return this.TipoHabilidad;
	}
	public String getRuta() {
		return this.ruta;
	}
	
	//A partir de aqui son generales sin importar la clase
	public void printM() {
		if(ListaMovimientos.size() == 0) {
			System.out.println("Ningun movimiento asignado!!!");
		}else {
			for(Movimiento t : ListaMovimientos) {
				System.out.println(t);
			}
		}		
	}
		
	
	
	public boolean estadoMovs() {
		if(ListaMovimientos.size() == 4) return true;
		return false;
	}
	
	public void asignarMovimiento(Movimiento m) {
		
		if(m.ClaseMov == this.Clase) {
			if(estadoMovs()) {
				System.out.println("Limite de movimientos alcanzado!");
			}else {
				boolean sw = false;
				for(Movimiento t : ListaMovimientos) {
					if(m.IDMovimiento == t.IDMovimiento) sw = true;
				}
				
				if(sw) {
					System.out.println("El movimiento ya ha sido añadido!!!");
				}else {
					ListaMovimientos.add(m);
					System.out.println("Movimiento añadido correctamente");
				}	
			}			
		}else {
			System.out.println("El movimiento ingresado no puede ser añadido a esta clase!!!!");
		}
	}

	public boolean quitarMovimiento(int id) {
		int pos = 0;
		for(Movimiento t : ListaMovimientos) {
			if(id == t.IDMovimiento) break;
			else pos ++;
		}
		
		if(pos >= ListaMovimientos.size()) {
			System.out.println("El movimiento a elimnar no existe en la lista!!!");
			return false;
		}else {
			ListaMovimientos.remove(pos);
			System.out.println("movimiento eliminado");
			return true;
		}
		
		
	}
	
	public abstract boolean usarHabilidad();
	
	public static boolean revisarHP(Personaje p){
		if(p.HP > 0) return true;
		else return false;
	}
	
	public static boolean revisarMagia(Personaje p, Movimiento m) {
		if(p.MP >= m.Coste) return true;
		else return false;
	}
	
	public static boolean accion(Personaje p1, Personaje p2, Movimiento m) {
		boolean use = false;
		
		if(revisarMagia(p1, m)) {
			int r = (int)(Math.random() * ((5 - 1) + 1)+1 );
			if(r <= m.Precision) {
				
				if(m.TipoMov == TiposMovimientos.ATAQUE_FISICO || m.TipoMov == TiposMovimientos.ATAQUE_ESPECIAL ) {
					//Usar el daño de ese movimiento y bajarselo al objetivo p2
					atacar(p1, p2, m);
					use = true;
				}else if(m.TipoMov == TiposMovimientos.BUFF && p1.estadobuff < Personaje.LIMITEBUFF ) {
					buff(p1, m);
					p1.estadobuff ++;
					use = true;
				}else if(m.TipoMov == TiposMovimientos.DEBUFF && p2.estadodebuff < Personaje.LIMITDEBUFF){
					debuff(p2, m);
					p2.estadodebuff ++;
					use = true;
				}
				if(use) {
					p1.MP -= m.Coste;
					return true;
				}else {
					System.out.println("Limite BUFF/DEBUF alcanzado");
					return false;
				}
			}else {
				System.out.println("El ataque no acertó!!!");
			}
			}else {
				System.out.println("No hay suficientes MP!!!!!!");
				return false;
			}
		return false;
			
		
	}
	
	private static void atacar(Personaje p1, Personaje p2, Movimiento m) {
		int damage = 0;
		
		if(m.TipoMov == TiposMovimientos.ATAQUE_FISICO) {
			damage = (int) ((p1.Atk * m.Dano)  - (p2.Def * p2.DefM));
		}else {
			damage = (int) ((p1.Mag * m.Dano) - (p2.Void * p2.VoidM));
		}
		
		p2.HP -= damage;
	}
	
	private static void buff(Personaje p1, Movimiento m) {
		switch(m.EfectoStat) {
		case "Ataque":
			p1.Atk += m.Efecto;
		break;
		case "Defensa":
			p1.DefM += m.Efecto;
			break;
		case "Magia":
			p1.Mag += m.Efecto;
			break;
		case "Void":
			p1.VoidM += m.Efecto;
			break;
		case "Velocidad":
			p1.SpeM += m.Efecto;
			break;
		case "Salud":
			p1.HP += m.Efecto;
			if(p1.HP > p1.HPL) p1.HP = p1.HPL;
			break;
		}	
	}
	
	private static void debuff(Personaje p1, Movimiento m) {
		switch(m.EfectoStat) {
		case "Ataque":
			p1.Atk -= m.Efecto;
		break;
		case "Defensa":
			p1.DefM -= m.Efecto;
			break;
		case "Magia":
			p1.Mag -= m.Efecto;
			break;
		case "Void":
			p1.VoidM -= m.Efecto;
			break;
		case "Velocidad":
			p1.SpeM -= m.Efecto;
			break;
		}	
	}
	
	//Por si no hay suficientes MP en el personaje
	public static void ataqueDefecto(Personaje p1, Personaje p2) {
		p2.HP -= p1.Atk * 5;
	}
	
	public String toString() {
		return String.format("%s ID[%d]\nClase [%s]  Habilidad [%s]\nHP[%d] MP[%d]\nATK[%.1f] "
				+ "MAG[%.1f] DEF[%d] VOID[%d] SPE[%d]\nMultiplicadores\nDEF[%.1f] VOID[%.1f] SPEED[%.1f]\n", 
				nombre, IDPersonaje,Clase , TipoHabilidad  , HP, MP, Atk,Mag,Def,Void,Spe, DefM,  VoidM, SpeM);
	}


	public abstract Personaje Clone();

	
	
}
