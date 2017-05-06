package dominio;

import java.io.Serializable;

/**
 * Clase abstracta que define que habilidades tendran, los valores de da�o critico 
 * y probabilidad de critico segun la vocacion de los personajes
 */

public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	public Casta(double prob_crit, double evasion, double daño_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = daño_crit;
	}
	/**
     * Funcion abstarcta que serán definidas en cada especialización de Casta.
     * @param caster caster.
     * @param atacado caster.
     * @return true o false.
     */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);
	/**
     * Funcion abstarcta que serán definidas en cada especialización de Casta.
     * @param caster caster.
     * @param atacado caster.
     * @return true o false.
     */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);
	/**
     * Funcion abstarcta que serán definidas en cada especialización de Casta.
     * @param caster caster.
     * @param atacado caster.
     * @return true o false.
     */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);
	/**
	 * Devuelve el nombre de la casta
	 * @return nombreCasta
	 */
	public String getNombreCasta() {
		return this.nombreCasta;
	}
	/**
	 * Devuelve la habilidades de la casta 
	 * @return habilidadesCasta
	 */
	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}
	/**
	 * Devuelve la probabilidad de golpe critico
	 * @returnprobabilidadGolpeCritico
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}
	/**
	 * Setea la probabilidad de golpe critico
	 * @param probabilidadGolpeCritico probabilidad de golpe critico
 	 */
	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}
	/**
	 * Devuelve la probabilidad de evitar daño
	 * @return probabilidadEvitarDaño
	 */
	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}
	/**
	 * Setea la probabilidad de evitar daño
	 * @param probabilidadEvitarDaño probabilidad de evitar daño
	 */
	public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}
	/**
	 * Devuelve el daño critico
	 * @return dañoCritico
	 */
	public double getDañoCritico() {
		return dañoCritico;
	}
	/**
	 * Setea el daño critico
	 * @param dañoCritico daño critico
	 */
	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}


}
