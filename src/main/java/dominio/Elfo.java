package dominio;

import inventario.Inventario;

/**Clase Elfo. El objetivo de la clase es crear.
 * un personaje de raza Elfo con sus respectivas habilidades
 */

public class Elfo extends Personaje {

  public Elfo(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    nombreRaza = "Elfo";
    this.asignarHabilidadInicial("Elfo");
  }


 public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,int experiencia,int nivel,int idPersonaje, final Inventario inventario) {
	    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
	    experiencia, nivel, idPersonaje, inventario);
	    nombreRaza = "Elfo";

	    habilidadesRaza = new String[2];
	    habilidadesRaza[0] = "Golpe Level";
	    habilidadesRaza[1] = "Ataque Bosque";
  }



  /**Metodo habilidadRaza1.
  * @param atacado es el personaje que se utilizar� con la habilidad especial de 'golpe level' del Elfo
  */

  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.modificarEnergia(-10);
      if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
        return true;
      }
    }
    return false;
  }

  /**Metodo habilidadRaza2.
  * @param atacado es el personaje que se utilizar� con la habilidad especial 'ataque bosque' del Elfo
  */

  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.modificarEnergia(-10);
      if (atacado.serAtacado((int) (this.magia)) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
  * Metodo que devuelve si el personaje puede ser atacado o no.
  */

  @Override
  public boolean serAtacado() {
    return true;
  }

  /**
  * Metodo que devuelve si el personaje puede ser curado o no.
  */

  @Override
  public boolean puedeSerCurado() {
    return true;
  }
}
