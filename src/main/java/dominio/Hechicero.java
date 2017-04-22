package dominio;
/**Clase Hechicero. La clase  Hechicero se encarga de crear un personaje con
 * un nombre tipo 'Hechicero' con sus respectivas habilidades especiales(que son 3) 
 */
public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double daÃ±o_crit) {
		super(prob_crit, evasion, daÃ±o_crit);
		this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}
	/**Método habilidad1.
	 * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede hacerse con una bola de fuego 
	 * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si es inflingido con una bola de fuego
	 */
	// Bola de Fuego
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}
	/**Método habilidad2
	 * @param caster es el personaje que será evaluado por la habilidad del Hechicero para ver si puede curar a un alidado
	 * @param aliado es el personaje que sera evaluado por la habilidad del Hechicero para ver si es posible ser curado por el Hechicero
	 */
	// Curar Aliado
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	// Robar Energia y Salud
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
