package dominio;

public abstract class PersonAbs {
	protected String nombre;
	protected int salud;
	protected int fuerza;
	protected int nivel;
	protected int defensa;
	
	public PersonAbs(String nombre ) {
		this.nombre = nombre;
	}

}
