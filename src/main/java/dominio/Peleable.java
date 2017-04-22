package dominio;

/*
 * Interfaz con todas las funciones y situaciones las cuales utilizan los personajes que pueden combatir
 */

public interface Peleable {
	public int serAtacado(int daño);
	public int getSalud();
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
