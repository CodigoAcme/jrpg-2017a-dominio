package dominio;

import java.util.Iterator;

/**
 * Esta clase define a los NPC(personajes controlados por el programa) del juego, seteando segun su nivel de 
 * dificultad y nivel valores base a sus puntos de fuerza, salud y defensa.
 */

public class NonPlayableCharacter extends PersonAbs implements Peleable {


  private static final int dificultadAleatoria = -1;


  public NonPlayableCharacter(String nombre, int nivel, int dificultadNpc) {
    super(nombre,nivel);
    int dificultad;
    if (dificultadNpc == dificultadAleatoria) {
      dificultad = this.myRandom.nextInt(3);
    } else {
      dificultad = dificultadNpc;
    }
    switch (dificultad) {
      case 0:
        this.fuerza = 10 + (nivel - 1) * 3;
        this.salud = 30 + (nivel - 1) * 15;
        this.defensa = 2 + (nivel - 1) * 1;
        break;
      case 1:
        this.fuerza = 20 + (nivel - 1) * 6;
        this.salud = 40 + (nivel - 1) * 20;
        this.defensa = 5 + (nivel - 1) * 2;
        break;
      case 2:
        this.fuerza = 30 + (nivel - 1) * 10;
        this.salud = 50 + (nivel - 1) * 25;
        this.defensa = 4 + (nivel - 1) * 4;
        break;

    }
  }
  
  /**
  * Incrementa los puntos de nivel.
  * @return nivel * 30.
  */
  
  public int otorgarExp() {
    return this.nivel * 30;
  }
  
  /**
   * Devuelve la fuerza personaje.
   * @return fuerza.
   */
  
  public int getFuerza() {
    return fuerza;
  }

  /**
   * Setea la fuerza del personaje.
   * @param fuerza del personaje.
   */

  public void setFuerza(int fuerza) {
    this.fuerza = fuerza; 
  }

  /**
   * Devuelve el nombre de personaje.
   * @return nombre.
   */

  public String getNombre() {
    return nombre;
  }

  /**
   * Setea el nombre del personaje.
   * @param nombre nombre del personaje.
   */

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Devuelve el nivel del personaje.
   * @return nivel.
   */

  public int getNivel() {
    return nivel;
  }

  /**
   * Setea el nivel del personaje.
   * @param nivel nivel del personaje.
   */

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  /**
   * @return false/true si esta vivo o no.
   */

  public boolean estaVivo() {
    return salud > 0;
  }

  /**
   * Devuelve la defensa de un personaje.
   * @return defensa .
   */

  public int getDefensa() {
    return defensa;
  }

  /**Setea la defensa de un personaje.
   * @param defensa defensa de un personaje.
   */

  public void setDefensa(int defensa) {
    this.defensa = defensa;
  }

  /**
   * Devuelve la salud de un personaje .
   * @return salud.
   */

  public int getSalud() {
    return salud;
  }

  /**
   * Setea la salud de un personaje.
   * @param salud salu de un personaje.
   */

  public void setSalud(int salud) {
    this.salud = salud;
  }

  /**
   * Funcion que define como el NPC ataca.
   * 15 de cada 100 ataques son criticos lo cual hace que su ataque reste un 50% mas de vida al rival de lo
   * que lo haria en caso de no ser critico el ataque
   *  @param atacado es el personaje elegido para que sea atacado en caso de que sea posible .
   */

  public int atacar(Peleable atacado) {
    if (myRandom.nextDouble() <= 0.15) {
      return atacado.serAtacado((int) (this.getAtaque() * 1.5));
    } else {
      return atacado.serAtacado(this.getAtaque());
    }
  }

  /**
   * Funcion que determina como recibe los ataques el NPC.
   * 15 de cada 100 ataques recibidos logra defenderlos con exito sin necesidad de usar sus puntos de defensa
   * En caso de que su probabilidad de defensa falle al da�o recibido se le restan la mitad de los puntos
   * de defensa del NPC, si el da�o resultante es menor a 0 el personaje logro defenderse con exito y por lo
   * tanto no pierde puntos de salud, en caso contrario se le resta el da�o a la salud del NPC
   * @param danio es la cantidad de puntos de da�o que el atacante envia
   */

  public int serAtacado(int danio) {
    if (myRandom.nextDouble() >= 0.15) {
      danio -= this.getDefensa() / 2;
      if (danio > 0) {
        salud -= danio;
        return danio;
      }
      return 0;
    }
    return 0;
  }
  
  
  /**
   * Metodo que devuelve si el personaje puede ser atacado o no.
   */

  @Override
  public boolean serAtacado() {
    return false;
  }

  /**
   * Implementada en Intefaz.
   */

  public void despuesDeTurno() { }

  /** 
   * @param exp implementada en interfaz.
   */
  public void ganarExperiencia(int exp) { }

  @Override
  public int getAtaque() {
    return fuerza;
  }
   
  @Override
  public void setAtaque(int ataque) {
    this.fuerza = ataque;
  }

  /**
   * Metodo que devuelve si el personaje puede ser curado o no.
   */

  @Override
  public boolean puedeSerCurado() {
    return false;
  }

  
}
