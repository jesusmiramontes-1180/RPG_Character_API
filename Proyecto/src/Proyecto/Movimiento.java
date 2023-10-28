package Proyecto;

public class Movimiento {
	protected int IDMovimiento;
	protected String Nombre;
	protected int Dano, Precision, Coste;
	protected float Efecto;
	protected String EfectoStat;
	protected Clases ClaseMov;
	protected TiposMovimientos TipoMov;
	
	
	public Movimiento(String n, int d, int p, float e, Clases cl, TiposMovimientos tm, String es, int id, int cost) {
		IDMovimiento = id;
		
		setNombre(n);
		setPrecision(p);		
		setClase(cl);
		setTipo(tm);
		setEfecto(e);
		setStat(es);
		setCoste(cost);
		
		if(this.TipoMov == TiposMovimientos.ATAQUE_FISICO || this.TipoMov == TiposMovimientos.ATAQUE_ESPECIAL ) {
			setDano(d);
		}
	
		
	}
	
	//Setters
	protected void setDano(int d) {
		Dano = d;
	}
	protected void setPrecision(int p) {
		Precision = p;
	}
	protected void setEfecto(float e) {
		Efecto = e;
	}
	protected void setClase(Clases cl) {
		ClaseMov = cl;
	}
	protected void setTipo(TiposMovimientos tm) {
		TipoMov = tm;
	}
	protected void setNombre(String n) {
		Nombre =  n;
	}
	protected void setStat(String s) {
		EfectoStat = s;
	}
	protected void setCoste(int c) {
		Coste = c;
	}
	
	
	//Getters
	public int getDano() {
		return Dano;
	}
	public int getPrecision() {
		return Precision;
	}
	public float getEfecto() {
		return Efecto;
	}
	public Clases getClase() {
		return ClaseMov;
	}
	public TiposMovimientos getTipo() {
		return TipoMov;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getStat() {
		return EfectoStat;
	}
	public int getCoste() {
		return Coste;
	}
	
	
	public String toString() {
		if(this.TipoMov == TiposMovimientos.ATAQUE_FISICO || this.TipoMov == TiposMovimientos.ATAQUE_ESPECIAL  ) {
			return String.format("NOMBRE [%s] TIPO [%s] DAÑO [%d] PRECISION [%d] CLASE [%s]", Nombre, TipoMov, Dano, Precision, ClaseMov);
		}else if( this.TipoMov == TiposMovimientos.BUFF     ){
			return String.format("NOMBRE [%s] TIPO [%s] BUFF [%.2f] STAT AFECTADO [%s] PRECISION [%d] CLASE [%s]", Nombre, TipoMov, Efecto, EfectoStat, Precision, ClaseMov);
		}else {
			return String.format("NOMBRE [%s] TIPO [%s] DEBUFF NEGATIVO [%.2f] STAT AFECTADO [%s] PRECISION [%d] CLASE [%s]", Nombre, TipoMov, Efecto,EfectoStat, Precision, ClaseMov);
		}
	}
	
	
	
}
