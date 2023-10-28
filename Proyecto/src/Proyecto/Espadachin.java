package Proyecto;

public class Espadachin extends Personaje implements RAGE, TANK{

	public Espadachin(int hp, Clases cl, HabilidadesEnum h, String nom) {
		super(hp, cl, h, nom);
		
		if(validHPEspadachin(hp)) {
		setNOMBRE(nom);
		setCLASE(cl);
		asignarHabilidad(h);
		
		construirEspadachin(hp);
		}else {
			System.out.println("Se ingresó un valor no válido para Espadachin");
		}	
	}
	
	
	public void construirEspadachin(int hp) {
		if(validHPEspadachin(hp)) {
			if(hp <= 210 && hp >=190) {
				setHP(hp);
				setMP((int)(Math.random() * ((64 - 60) + 1)) + 60);
				setDEF((int)(Math.random() * ((6 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((5 - 2) + 1)) + 2);
				setSPE((int)(Math.random() * ((4 - 2) + 1)) + 2);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.7 - 1.1)) + 1.1) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.4 - 0.9)) + 1.0) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.3 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.2 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.4 - 1.1)) + 1.1) * 10.0 ) / 10.0));
				
				
			}else if(hp <= 189 && hp >=170) {
				setHP(hp);
				setMP((int)(Math.random() * ((69 - 63) + 1)) +  63);
				setDEF((int)(Math.random() * ((6 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((4 - 2) + 1)) + 2);
				setSPE((int)(Math.random() * ((6 - 3) + 1)) + 3);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.9 - 1.1)) + 1.1) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.4 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.3 - 1.1)) + 1.1) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.3 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.6 - 1.1)) + 1.1) * 10.0 ) / 10.0));
				
			
			}
		}
		
		
		
	}
	
	public static boolean validHPEspadachin(int hp) {
		if(hp <= 210 && hp >=170) return true;
		return false;
	}
	
	//Constructor super cuando no se crea el personaje 
	public Espadachin(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		super(id, hp, mp, atk, defm, voim, spem, mag, def, voi, spe, cl, h, n);
	}
	
	
	
	@Override
	public void activateRage() {
		// TODO Auto-generated method stub
		if(this.EstadoHabilidad == RLIMIT) {
			//Se cancela
			this.Atk -= 0.7;
			this.SpeM -= 0.3;
			this.DefM += 0.3;
			this.HabilidadUsada = true;
			
		}else if(this.EstadoHabilidad == 0){
			this.Atk += 0.7;
			this.SpeM += 0.3;
			this.DefM -= 0.3;
			System.out.println("Se ha usado RAGE!!!!!!!");
			this.EstadoHabilidad ++;
		}else {
			this.EstadoHabilidad ++;
		}
	}

	@Override
	public void activateTank() {
		// TODO Auto-generated method stub
		if(this.EstadoHabilidad == TLIMIT) {
			//Se cancela
			this.DefM -= 0.7;
			this.VoidM -= 0.6;
			this.SpeM += 0.4;
			this.HabilidadUsada = true;
			
		}else if(this.EstadoHabilidad == 0){
			this.DefM += 0.7;
			this.VoidM += 0.6;
			this.SpeM -= 0.4;
			System.out.println("Se ha usado TANK!!!!!!!");
			this.EstadoHabilidad ++;
		}else {
			this.EstadoHabilidad ++;
		}
	}
	
	@Override
	public boolean usarHabilidad() {
		if(this.HabilidadUsada == false) {
			if(this.UsandoHabilidad == false) this.UsandoHabilidad = true;
			
			if(this.TipoHabilidad == HabilidadesEnum.RAGE) {
				activateRage();
				return true;
			}else if(this.TipoHabilidad == HabilidadesEnum.TANK) {
				activateTank();
				return true;
			}
		}else {
			System.out.println("Habilidad usada!!!!!!");
			return false;
		}
		return false;
	}
	
	
	public Espadachin Clone() {
		Espadachin temp = new Espadachin(IDPersonaje,   HP    ,MP, Atk, DefM, VoidM, SpeM, Mag, Def, Void, Spe, Clase, TipoHabilidad, nombre);
		for(int i = 0; i < this.ListaMovimientos.size(); i++) {
			temp.asignarMovimiento(this.ListaMovimientos.get(i));
		}
		return temp;
	}

	

}
