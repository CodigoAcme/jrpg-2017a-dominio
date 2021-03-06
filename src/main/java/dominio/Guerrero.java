package dominio;

/**
 * Clase Guerrero. La clase  Guerrero se encarga de crear un personaje con
 * un nombre tipo 'Guerrero' con sus respectivas habilidades especiales(que son 3) 
 */

public class Guerrero extends Casta {

  public Guerrero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
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

  /**
  * Método habilidad1.
  * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede hacerse con un ataque doble 
  * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si es atacado con un ataque doble 
  */

  public boolean habilidad1(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (atacado.serAtacado(caster.ataque * 2) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
  * Método habilidad2.
  * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede aumentar su defensa
  * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si se puede influir un aumento de su defensa 
  */

  public boolean habilidad2(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      caster.modificarDefenza(caster.magia);
      return true;
    }
    return false;
  }

  /**
  * Método habilidad.
  * @param caster es el personaje que será evaluado por la habilidad del Guerrero para ver si puede ignorar su defensa
  * @param atacado es el personaje que sera evaluado por la habilidad del Guerrero para ver si se puede ignorar su defensa 
  */

  public boolean habilidad3(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (atacado.estaVivo()) {
        int defensaOriginal = ((Personaje) atacado).getDefensa();
        ((Personaje) atacado).modificarDefenza(0);
        if (atacado.serAtacado(caster.ataque) > 0) {
          ((Personaje) atacado).modificarDefenza(defensaOriginal);
          return true;
        }
      }

    }
    return false;
  }

  /**
  * Devuelve la fuerza dependiendo de la raza.
  */

  @Override
  public int getFueraza() {
    return 5;
  }
  
  /**
  * Devuelve la inteligencia dependiendo de la raza.
  */
  
  @Override
  public int getInteligencia() {
    return 0;
  }

  /**
  * Devuelve la destreza dependiendo de la raza.
  */

  @Override
  public int getDestreza() {
    return 0;
  }
}
