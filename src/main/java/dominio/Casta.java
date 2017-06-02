package dominio;

import java.io.Serializable;

/**
* Clase abstracta que define que habilidades tendran, los valores de da�o critico. 
* y probabilidad de critico segun la vocacion de los personajes.
*/

public abstract class Casta implements Serializable {
  protected double probabilidadGolpeCritico;
  protected double probabilidadEvitarDanio;
  protected double danioCritico;
  protected String nombreCasta;

  protected String[] habilidadesCasta;

  public Casta() {
    this.probabilidadGolpeCritico = 0.2;
    this.probabilidadEvitarDanio = 0.2;
    this.danioCritico = 1.5;
  }

  public Casta(double probCrit, double evasion, double dañoCrit) {
    this.probabilidadGolpeCritico = probCrit;
    this.probabilidadEvitarDanio = evasion;
    this.danioCritico = dañoCrit;
  }
  
  /**
  * Funcion abstracta que serán definidas en cada especialización de Casta.
  * @param caster caster.
  * @param atacado caster.
  * @return true o false.
  */
  
  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  /**
  * Funcion abstracta que serán definidas en cada especialización de Casta.
  * @param caster caster.
  * @param atacado caster.
  * @return true o false.
  */
  
  public abstract boolean habilidad2(Personaje caster, Peleable atacado);

  /**
  * Funcion abstracta que serán definidas en cada especialización de Casta.
  * @param caster caster.
  * @param atacado caster.
  * @return true o false.
  */
  
  public abstract boolean habilidad3(Personaje caster, Peleable atacado);

  /**
  * Devuelve el nombre de la casta.
  * @return nombreCasta
  */
  
  public String getNombreCasta() {
    return this.nombreCasta;
  }
  
  /**
  * Devuelve la habilidades de la casta .
  * @return habilidadesCasta
  */
  
  public String[] getHabilidadesCasta() {
    return habilidadesCasta;
  }
  
  /**
  * Devuelve la probabilidad de golpe critico.
  * @returnprobabilidadGolpeCritico
  */
  
  public double getProbabilidadGolpeCritico() {
    return probabilidadGolpeCritico;
  }
  
  /**
  * Setea la probabilidad de golpe critico.
  * @param probabilidadGolpeCritico probabilidad de golpe critico
  */
  
  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }
  
  /**
  * Devuelve la probabilidad de evitar daño.
  * @return probabilidadEvitarDaño
  */
  
  public double getProbabilidadEvitarDanio() {
    return probabilidadEvitarDanio;
  }
  
  /**
  * Setea la probabilidad de evitar daño.
  * @param probabilidadEvitarDaño probabilidad de evitar daño
  */
  
  public void setProbabilidadEvitarDanio(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDanio = probabilidadEvitarDaño;
  }
  
  /** Devuelve el daño critico.
  * @return dañoCritico
  */ 
  
  public double getDanioCritico() {
    return danioCritico;
  }
  
  /**Setea el daño critico.
  * @param dañoCritico daño critico
  */
  
  public void setDanioCritico(double dañoCritico) {
    this.danioCritico = dañoCritico;
  }

  public abstract int getFueraza();

  public abstract int getDestreza();

  public abstract int getInteligencia();

}
