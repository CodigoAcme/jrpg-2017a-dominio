package dominio;
/**Clase Asesino. La clase  Asesino se encarga de crear un personaje con
 * un nombre tipo asesino que tendr� sus respectivas habilidades(que son 3) 
 */
public class Asesino extends Casta {

	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}
	/**M�todo habilidad1.
	 * @param caster es el personaje que ser� evaluado por la habilidad del asesino para ver si puede hacerse con un golpe cr�tico 
	 * @param atacado es el personaje que sera atacado por el asesino con un golpe cr�tico 
	 */
	// Golpe Crítico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}
	/**M�todo habilidad1.
	 * @param caster es el personaje que ser� evaluado por la habilidad del asesino para ver si puede hacerse con un aumento de evasion
	 * @param atacado es el personaje que sera atacado por el asesino con un la habilidad de evasion 
	 */
	// Aumentar Evasion
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
