package dominio;
/**Clase Guerrero. La clase  Guerrero se encarga de crear un personaje con
 * un nombre tipo 'Guerrero' con sus respectivas habilidades especiales(que son 3) 
 */
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daÃ±o_crit) {
		super(prob_crit, evasion, daÃ±o_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}
	/**Método habilidad1.
	 * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede hacerse con un ataque doble 
	 * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si es atacado con un ataque doble 
	 */
	// Ataque Doble
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	// Aumentar Defensa
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}
	/**Método habilidad2.
	 * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede aumentar su defensa
	 * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si se puede influir un aumento de su defensa 
	 */
	// Ignorar Defensa
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
