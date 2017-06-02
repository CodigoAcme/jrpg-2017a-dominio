package dominio;

public abstract class  RandomGenerator {

  /**
   * Retorna un valor fraccionario random entre  0 y 1.
   * @return double random
   */

  public abstract double nextDouble();

  /**
  * Retorna un valor entero random mayor igual a 0 y menor al parámetro.
  * @param val valor maximo del random
  * @return entero random
  */

  public abstract int nextInt(final int val);

}
