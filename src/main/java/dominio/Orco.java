package dominio;

/*
 * Define la raza Orco la cual tiene un aumento de salud de 10 puntos por ensima del personaje por defecto
 * Sus habilidades son "Golpe Defensa" y "Modisco de Vida"
 */

public class Orco extends Personaje {

	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	// Golpe Defensa
	/*
	 * Esta habilidad cuesta 10 de energia, en caso de tener suficiente energia para realizar la habilidad
	 * el enemigo es atacado utilizando el valor de los puntos de defensa del personaje multiplicado por 2
	 * El ataque solo puede realizarse si el personaje tiene puntos de defensa mayores a 0
	 *  @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}

	// Mordisco de Vida
	/*
	 * Esta habilidad cuesta 10 puntos de energia
	 * El personaje atacado recibe un daño igual a los puntos de fuerza del orco atacante
	 * La cantidad de daño realizado le es sumado a la vida del orco en caso de no superar el maximo de vida
	 * de lo contrario simplemente su vida sera restablecida al maximo posible
	 * @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daÃ±o_causado = atacado.serAtacado(this.getFuerza());
			if (daÃ±o_causado > 0) {
				this.serCurado(daÃ±o_causado);
				return true;
			}
		}
		return false;
	}
}
