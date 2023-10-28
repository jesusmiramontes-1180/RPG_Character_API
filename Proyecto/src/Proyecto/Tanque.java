package Proyecto;

public class Tanque extends Personaje implements VOID, TANK {

	public Tanque(int hp, Clases cl, HabilidadesEnum h, String nom) {
		super(hp, cl, h, nom);
		
		if(validHPTanque(hp)) {
		setNOMBRE(nom);
		setCLASE(cl);
		asignarHabilidad(h);
		
		construirTanque(hp);
		}else {
			System.out.println("Se ingresó un valor no válido para Arquero");
		}	
		
		
	}
	
public void construirTanque(int hp) {
		
		if(validHPTanque(hp)) {
			if(hp <= 250 && hp >=226) {
				setHP(hp);
				setMP((int)(Math.random() * ((50 - 46) + 1)) + 46);
				setDEF((int)(Math.random() * ((7 - 4) + 1)) + 4);
				setVOID((int)(Math.random() * ((7 - 4) + 1)) + 4);
				setSPE((int)(Math.random() * ((2 - 1) + 1)) + 1);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.4 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.8 -1.4)) + 1.4) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.1 - 0.9)) + 0.9) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.6 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.1 - 0.9)) + 0.9) * 10.0 ) / 10.0));
				

			}else if(hp <= 225 && hp >=200) {
				setHP(hp);
				setMP((int)(Math.random() * ((55 - 51) + 1)) + 51);
				setDEF((int)(Math.random() * ((7 - 5) + 1)) + 5);
				setVOID((int)(Math.random() * ((7 - 4) + 1)) + 4);
				setSPE((int)(Math.random() * ((3 - 2) + 1)) + 2);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.4 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.9 -1.4)) + 1.4) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.2 - 0.9)) + 0.9) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.7 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.1 - 0.9)) + 0.9) * 10.0 ) / 10.0));

			}
		}
	}
	
	public static boolean validHPTanque(int hp) {
		if(hp <= 250 && hp >=200) return true;
		return false;
	}
	
	public Tanque(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		super(id, hp, mp, atk, defm, voim, spem, mag, def, voi, spe, cl, h, n);
	}
	
	@Override
	public void activateTank() {
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
			if(this.TipoHabilidad == HabilidadesEnum.VOID) {
				activateVoid();
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

	@Override
	public Personaje Clone() {
		Tanque temp = new Tanque(IDPersonaje,   HP    ,MP, Atk, DefM, VoidM, SpeM, Mag, Def, Void, Spe, Clase, TipoHabilidad, nombre);
		for(int i = 0; i < this.ListaMovimientos.size(); i++) {
			temp.asignarMovimiento(this.ListaMovimientos.get(i));
		}
		return temp;
	}

}
