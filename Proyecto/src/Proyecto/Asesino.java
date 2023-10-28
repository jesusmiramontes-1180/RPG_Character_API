package Proyecto;

public class Asesino extends Personaje implements SPEED, SPECS {

	
	
	public Asesino(int hp, Clases cl, HabilidadesEnum h, String nom) {
		super(hp, cl, h, nom);
		
		if(validHPAsesino(hp)) {
		setNOMBRE(nom);
		setCLASE(cl);
		asignarHabilidad(h);
		
		construirAsesino(hp);
		}else {
			System.out.println("Se ingresó un valor no válido para Arquero");
		}	
		
		
	}
	
public void construirAsesino(int hp) {
		
		if(validHPAsesino(hp)) {
			if(hp <= 220 && hp >=201) {
				setHP(hp);
				setMP((int)(Math.random() * ((58 - 53) + 1)) + 53);
				setDEF((int)(Math.random() * ((4 - 2) + 1)) + 2);
				setVOID((int)(Math.random() * ((2 - 1) + 1)) + 1);
				setSPE((int)(Math.random() * ((6 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.8 - 1.6)) + 1.6) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.2 -1.1)) + 1.1) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.0 - 0.8)) + 0.8) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.0 - 0.9)) + 0.9) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (1.9 - 1.6)) + 1.6) * 10.0 ) / 10.0));
				

			}else if(hp <= 200 && hp >=170) {
				setHP(hp);
				setMP((int)(Math.random() * ((58 - 55) + 1)) + 55);
				setDEF((int)(Math.random() * ((5 - 2) + 1)) + 2);
				setVOID((int)(Math.random() * ((3 - 1) + 1)) + 1);
				setSPE((int)(Math.random() * ((6 - 4) + 1)) + 4);
				
				setATK(      (float) (Math.round(((float) (Math.random() * (1.8 - 1.6)) + 1.6) * 10.0 ) / 10.0));
				setDEFM((float) (Math.round(((float) (Math.random() * (1.3 -1.1)) + 1.1) * 10.0 ) / 10.0));
				setMAG((float) (Math.round(((float) (Math.random() * (1.1 - 0.8)) + 0.8) * 10.0 ) / 10.0));
				setVOIDM((float) (Math.round(((float) (Math.random() * (1.0 - 0.9)) + 0.9) * 10.0 ) / 10.0));
				setSPEM((float) (Math.round(((float) (Math.random() * (2.0 - 1.6)) + 1.6) * 10.0 ) / 10.0));

			}
		}
	}
	
	public static boolean validHPAsesino(int hp) {
		if(hp <= 220 && hp >=170) return true;
		return false;
	}
	
	
	public Asesino(int id,int hp, int mp, float atk, float defm, float voim, float spem, float mag, int def, int voi, int spe, Clases cl, HabilidadesEnum h, String n) {
		super(id, hp, mp, atk, defm, voim, spem, mag, def, voi, spe, cl, h, n);
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
	public void activateSpeed() {
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
	public boolean usarHabilidad() {
		if(this.HabilidadUsada == false) {
			if(this.UsandoHabilidad == false) this.UsandoHabilidad = true;
			
			if(this.TipoHabilidad == HabilidadesEnum.SPECS) {
				activateSpecs();
				return true;
			}else if(this.TipoHabilidad == HabilidadesEnum.SPEED) {
				activateSpeed();
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
		Asesino temp = new Asesino(IDPersonaje,   HP    ,MP, Atk, DefM, VoidM, SpeM, Mag, Def, Void, Spe, Clase, TipoHabilidad, nombre);
		for(int i = 0; i < this.ListaMovimientos.size(); i++) {
			temp.asignarMovimiento(this.ListaMovimientos.get(i));
		}
		return temp;
	}

}
