package dominio;

/**Clase Asesino. La clase  Asesino se encarga de crear un personaje con
 * un nombre tipo asesino que tendrá sus respectivas habilidades(que son 3) 
 */

public class Asesino extends Casta {

  public Asesino(double probCrit,double evasion,double danioCrit) {
    super(probCrit, evasion, danioCrit);
    this.nombreCasta = "Asesino";
  }
  
  /**
   * Constructor por defecto.
   */

  public Asesino() {
    super();
    this.nombreCasta = "Asesino";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }
  
  /**Método habilidad1.
   * @param caster es el personaje que será evaluado por la habilidad del asesino.
   * @param atacado es el personaje que sera atacado por el asesino con un golpe crítico.
   */

  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanioCritico())) > 0) {
        return true;
      }
    }
    return false;
  }
  /**Método habilidad1.
   * @param caster es el personaje que será evaluado por la habilidad del asesino para ver si puede hacerse con un aumento de evasion
   * @param atacado es el personaje que sera atacado por el asesino con un la habilidad de evasion 
   */

  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (this.getProbabilidadEvitarDanio() + 0.15 < 0.5) {
        this.probabilidadEvitarDanio += 0.15;
      } else {
        this.probabilidadEvitarDanio = 0.5;
      }
      return true;
    }
    return false;
  }

  /**Método habilidad3.
   * @param caster es el personaje que será evaluado por la habilidad del asesino para ver si puede robarlo
   * @param atacado es el personaje que sera atacado por el asesino con un la habilidad de robar 
   */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    return false;
  }

  /**Devuelve la fuerza dependiendo de la raza.
   * 
   */
  
  @Override
  public int getFueraza() {
    return 0;
  }
  
  /**Devuelve la inteligencia dependiendo de la raza.
   * 
   */
  
  @Override
  public int getInteligencia() {
    return 0;
  }
  
  /**devuelve la Destreza dependiendo de la raza.
   * 
   */
  
  @Override
  public int getDestreza() {
    return 5;
  }


}
