package dominio;

/*
 * Define la Raza Humano la cual tiene un aumento de salud y energia balanzeado( = 5) por ensima de la que viene
 * por defecto, sus habilidades son "Incentivar" y "Golpe Fatal"
 */

public class Humano extends Personaje {

	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	// Incentivar
	/*
	 * Activa la habilidad llamada "Incentivar" la cual cuesta 10 de energia, en caso de no tener la suficiente 
	 * energia la funcion devuelve "false", si tiene suficiente se la resta al personaje y al personaje
	 * afectado por la habilidad recibe un aumento en sus puntos de ataque en relacion a la cantidad de magia
	 * del humano
	 * @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	// Golpe Fatal
	/*
	 * Activa la habilidad llamada "Golpe Fatal" se necesita minimo 10 puntos de energia, esta habilidad ataca 
	 * al enemigo con un daño igual a la mitad de los puntos de salud que este posea y le resta al jugador
	 * la mitad de sus puntos de energia
	 * @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
