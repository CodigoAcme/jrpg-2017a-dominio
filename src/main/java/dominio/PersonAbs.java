package dominio;

import java.util.ArrayList;

public abstract class PersonAbs {
  protected String nombre;
  protected int salud;
  protected int fuerza;
  protected int nivel;
  protected int defensa;
  protected ArrayList<Item> inventario;

  protected RandomGenerator myRandom;

  public PersonAbs(String nombre) {
    this.nombre = nombre;
    inventario = new ArrayList<Item>();
  }

  public void setRandomGenerator(final RandomGenerator randomG) {
    this.myRandom = randomG;
  }

  public RandomGenerator getMyRandom() {
    return this.myRandom;
  }
  
  public void modificarDefenza(int defenza) {
    this.defensa += defenza;
  }
  
  public void modificarFuerza(int fuerza) {
    this.fuerza += fuerza;
  }
   
  
  public void modificarSalud(int salud) {
    this.salud += salud;
  }
  
  
  

}
