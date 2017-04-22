package dominio;

/*
 * Devuelve valores al azar del tipo double y enteros
 */

public class MyRandom {
	
	

	/*
	 * devuelve valores al azar entre 0 y 1 del tipo double
	 */
	public static double nextDouble() {
		return 0.49;
	}
	
	/*
	 * devuelve valores al azar entre 0 y 2 del tipo entero
	 */
	public static int nextInt(int val) {
		return val - 1;
	}
	
}
