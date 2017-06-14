package dominio;

import java.util.ArrayList;

import inventario.Inventario;
import inventario.Item;

public abstract class PersonAbs {
  protected String nombre;
  protected int salud;
  protected int fuerza;
  protected int nivel;
  protected int defensa;
  protected Inventario inventario;
  

  protected RandomGenerator myRandom;

  
  //personaje nuevo
  public PersonAbs (final String nombre, final int salud, final int fuerza, final int nivel) {

  	this.nombre = nombre;
  	this.salud = salud;
  	this.fuerza = fuerza;
  	this.nivel = nivel;
  	this.inventario = new Inventario();
  	this.myRandom = new MyRandom();
   }
  
  //personaje ya existente
  public PersonAbs (final String nombre, final int salud, final int fuerza, final int nivel, final Inventario inventario) {

	  	this.nombre = nombre;
	  	this.salud = salud;
	  	this.fuerza = fuerza;
	  	this.nivel = nivel;
	  	this.inventario = inventario;
	  	this.myRandom = new MyRandom();
	   }
  
 
  //personaje NPC
  public PersonAbs (final String nombre, final int nivel) {

	  	this.nombre = nombre;
	  	this.nivel = nivel;
	  	this.myRandom = new MyRandom();
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
  
  public Inventario getInventario() {
		return inventario;
	}
  

}
