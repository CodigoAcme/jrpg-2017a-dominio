package dominio;

public abstract class PersonAbs {
	protected String nombre;// hay que agregarlo a todos los constructores
	protected int salud;
	protected int fuerza;
	protected int nivel;
	protected int defensa;// depende de la destreza
	
	public PersonAbs(String nombre ) {
		this.nombre = nombre;
	}

}
