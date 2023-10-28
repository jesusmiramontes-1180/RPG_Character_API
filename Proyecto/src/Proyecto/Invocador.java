package Proyecto;

public class Invocador extends Personaje implements SPECS, VOID {

	public Invocador(int hp, Clases cl, HabilidadesEnum h, String nom) {
		super(hp, cl, h, nom);
		
		if(validHPInvocador(hp)) {
		setNOMBRE(nom);
		setCLASE(cl);
		asignarHabilidad(h);
		
		construirInvocador(hp);
		}else {
			System.out.println("Se ingresó un valor no válido para Arquero");
		}	
		
		
	}
	
	public void construirInvocador(int hp) {
		
		if(validHPInvocador(hp)) {
			if(hp <= 185 && hp >=174) {
				setHP(hp);
				setMP((int)(Math.random() * ((76 - 73) + 1)) + 73);
				setDEF((int)(Math.random() * ((4 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((6 - 5) + 1)) + 5);
				setSPE((int)(Math.random() * ((6 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.1 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.3 -1.0)) + 1.0) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.9 - 1.6)) + 1.6) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.5 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.5 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				

			}else if(hp <= 173 && hp >=160) {
				setHP(hp);
				setMP((int)(Math.random() * ((80 - 76) + 1)) + 76);
				setDEF((int)(Math.random() * ((4 - 3) + 1)) + 3);
				setVOID((int)(Math.random() * ((6 - 5) + 1)) + 5);
				setSPE((int)(Math.random() * ((6 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.2 - 1.0)) + 1.0) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.3 -1.1)) + 1.1) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (2.0 - 1.6)) + 1.6) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.6 - 1.4)) + 1.4) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.5 - 1.2)) + 1.2) * 10.0 ) / 10.0));

			}
		}
	}
	
	public static boolean validHPInvocador(int hp) {
		if(hp <= 185 && hp >=160) return true;
		return false;
	}
	
	
	public Invocador(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		super(id, hp, mp, atk, defm, voim, spem, mag, def, voi, spe, cl, h, n);
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
	public void activateSpecs() {
		if(this.EstadoHabilidad == SPLIMIT) {
			//Se cancela
			this.Atk -= 0.7;
			this.Mag -= 0.7;
			this.DefM += 0.3;
			this.HabilidadUsada = true;
			
		}else if(this.EstadoHabilidad == 0){
			this.Atk += 0.7;
			this.Mag += 0.7;
			this.DefM -= 0.3;
			
			System.out.println("Se ha usado SPEED!!!!!!!");
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
			}else if(this.TipoHabilidad == HabilidadesEnum.SPECS) {
				activateSpecs();
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
		Invocador temp = new Invocador(IDPersonaje,   HP    ,MP, Atk, DefM, VoidM, SpeM, Mag, Def, Void, Spe, Clase, TipoHabilidad, nombre);
		for(int i = 0; i < this.ListaMovimientos.size(); i++) {
			temp.asignarMovimiento(this.ListaMovimientos.get(i));
		}
		return temp;
	}

}
