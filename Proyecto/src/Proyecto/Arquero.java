package Proyecto;

public class Arquero extends Personaje implements SPEED, VOID{

	
	public Arquero(int hp, Clases cl, HabilidadesEnum h, String nom) {
		super(hp, cl, h, nom);
		
		if(validHPArquero(hp)) {
		setNOMBRE(nom);
		setCLASE(cl);
		asignarHabilidad(h);
		
		construirArquero(hp);
		}else {
			System.out.println("Se ingresó un valor no válido para Arquero");
		}	
		
		
	}
	
	public void construirArquero(int hp) {
		
		if(validHPArquero(hp)) {
			if(hp <= 190 && hp >=175) {
				setHP(hp);
				setMP((int)(Math.random() * ((65 - 60) + 1)) + 60);
				setDEF((int)(Math.random() * ((4 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((4 - 3) + 1)) + 3);
				setSPE((int)(Math.random() * ((6 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.7 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.1 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.4 - 1.3)) + 1.3) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.1 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.9 - 1.7)) + 1.7) * 10.0 ) / 10.0));
				

			}else if(hp <= 174 && hp >=160) {
				setHP(hp);
				setMP((int)(Math.random() * ((70 - 66) + 1)) + 6);
				setDEF((int)(Math.random() * ((4 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((5 - 3) + 1)) + 3);
				setSPE((int)(Math.random() * ((8 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (2.0 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.1 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.6 - 1.3)) + 1.3) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.2 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (2.3 - 1.7)) + 1.7) * 10.0 ) / 10.0));

			}
		}
		
		
		
	}
	
	public static boolean validHPArquero(int hp) {
		if(hp <= 190 && hp >=160) return true;
		return false;
	}
	
	public Arquero(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		super(id, hp, mp, atk, defm, voim, spem, mag, def, voi, spe, cl, h, n);
	}
	
	
	
	
	
	@Override
	public void activateSpeed() {
		// TODO Auto-generated method stub
		if(this.EstadoHabilidad == SLIMIT) {
			//Se cancela
			this.SpeM -= 0.9;
			this.VoidM += 0.2;
			this.HabilidadUsada = true;
			
		}else if(this.EstadoHabilidad == 0){
			this.SpeM += 1.0;
			this.VoidM -= 0.2;
			System.out.println("Se ha usado SPEED!!!!!!!");
			this.EstadoHabilidad ++;
		}else {
			this.EstadoHabilidad ++;
		}
	}

	
	@Override
	public void activateVoid() {
		if(this.EstadoHabilidad == VLIMIT) {
			//Se cancela
			this.Mag -= 0.5;
			this.VoidM -= 0.6;
			this.Atk += 0.2;
			this.HabilidadUsada = true;
			
		}else if(this.EstadoHabilidad == 0){
			this.Mag += 0.5;
			this.VoidM += 0.6;
			this.Atk -= 0.3;
			System.out.println("Se ha usado VOID!!!!!!!");
			this.EstadoHabilidad ++;
		}else {
			this.EstadoHabilidad ++;
		}
	}
	
	
	@Override
	public boolean usarHabilidad() {
		if(this.HabilidadUsada == false) {
			if(this.UsandoHabilidad == false) this.UsandoHabilidad = true;
			
			if(this.TipoHabilidad == HabilidadesEnum.SPEED) {
				
				activateSpeed();
				return true;
			}else if(this.TipoHabilidad == HabilidadesEnum.VOID) {
				activateVoid();
				return true;
			}
		}else {
			System.out.println("Habilidad usada!!!!!!");
			return false;
		}
		return false;
	}

	@Override
	public Personaje Clone() {
		Arquero temp = new Arquero(IDPersonaje,   HP    ,MP, Atk, DefM, VoidM, SpeM, Mag, Def, Void, Spe, Clase, TipoHabilidad, nombre);
		for(int i = 0; i < this.ListaMovimientos.size(); i++) {
			temp.asignarMovimiento(this.ListaMovimientos.get(i));
		}
		return temp;
	}


	

}
