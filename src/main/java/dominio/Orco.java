package dominio;

import inventario.Inventario;

/**
 * Define la raza Orco la cual tiene un aumento de salud de 10 puntos por ensima del personaje por defecto.
 * Sus habilidades son "Golpe Defensa" y "Modisco de Vida"
 */

public class Orco extends Personaje {

	  public Orco(String nombre, Casta casta , int id) {
	    super(nombre, casta, id);
	    nombreRaza = "Orco";
	    this.asignarHabilidadInicial("Orco");
	  }

	  public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,int experiencia, int nivel, int idPersonaje, final Inventario inventario) {
	    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje, inventario);
	   
	    nombreRaza = "Orco";
	    habilidadesRaza = new String[2];
	    habilidadesRaza[0] = "Golpe Defensa";
	    habilidadesRaza[1] = "Mordisco de Vida";
	  }

  /**
  * Esta habilidad cuesta 10 de energia, en caso de tener suficiente energia para realizar la habilidad
  * el enemigo es atacado utilizando el valor de los puntos de defensa del personaje multiplicado por 2.
  * El ataque solo puede realizarse si el personaje tiene puntos de defensa mayores a 0.
  *  @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
  */

  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.modificarEnergia(-10);
      if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
        return true;
      }
    }
    return false;
  }


  /**
  * Esta habilidad cuesta 10 puntos de energia
  * El personaje atacado recibe un da�o igual a los puntos de fuerza del orco atacante
  * La cantidad de da�o realizado le es sumado a la vida del orco en caso de no superar el maximo de vida
  * de lo contrario simplemente su vida sera restablecida al maximo posible.
  * @param atacado es el personaje que sera afectado por la habilidad en caso de que sea posible realizarla 
  */

  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.modificarEnergia(-10);
      int danioCausado = atacado.serAtacado(this.getFuerza());
      if (danioCausado > 0) {
        this.serCurado(danioCausado);
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
