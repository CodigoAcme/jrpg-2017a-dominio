package dominio;

/**Clase Hechicero. La clase  Hechicero se encarga de crear un personaje con
 * un nombre tipo 'Hechicero' con sus respectivas habilidades especiales(que son 3) 
 */

public class Hechicero extends Casta {

  public Hechicero(double proCrit, double evasion, double danioCritico) {
    super(proCrit, evasion, danioCritico);
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

  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0) {
        return true;
      }
    }
    return false;
  }

  /**Método habilidad2.
  * @param caster es el personaje que será evaluado por la habilidad del Hechicero para ver si puede curar a un alidado
  * @param aliado es el personaje que sera evaluado por la habilidad del Hechicero para ver si es posible ser curado por el Hechicero
  */

  public boolean habilidad2(Personaje caster, Peleable aliado) {
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (aliado.puedeSerCurado()) {
        ((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
        return true;
      }
    }
    return false;
  }


  /**Método habilidad3.
  * @param caster es el personaje que robará la energía y salud del personaje atacado
  * @param atacado es el personaje que sera evaluado por la habilidad del Hechicero para ver si el Hechicero puede robar su energía y salud 
  */

  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.modificarEnergia(-10);
      if (atacado.serAtacado()) {
        int energiaRobada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
        int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
        caster.serEnergizado(energiaRobada);
        caster.serCurado(saludRobada);
        return true;
      }

    }
    return false;
  }


  /**
  * Devuelve la fuerza dependiendo de la raza.
  */

  @Override
  public int getFueraza() {
    return 0;
  }

  /**
  * Devuelve la inteligencia dependiendo de la raza.
  */

  @Override
  public int getInteligencia() {
    return 5;
  }

  /**
  * devuelve la destreza dependiendo de la raza.
  */

  @Override
  public int getDestreza() {
    return 0;
  }
}
