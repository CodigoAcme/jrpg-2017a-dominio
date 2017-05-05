package dominio;

import java.util.LinkedList;
/**Clase Alianza. Se ocupa de formar un lista de aliados y 
 * se le asigna un nombre representavo
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}
	/**Método getAliados
	 * Devuelve los aliados que forman parte de la alizana
	 * */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}
	/**Método setAliados
	 * @param aliados es la lista de aliados que formarán parte de la alianza
	 **/
	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}
	/**M�todo obtenerNombre.
	 *Retorna el nombre de nuestra alianza
	 */
	public String obtenerNombre(){
		return nombre;
	}
	/**M�todo eliminarPersonaje.
	 * @param pj es el personaje que eliminaremos de nuestra Alianza.
	 */
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	/**M�todo a�adirPersonaje.
	 * @param pj es el personaje que se unir� a una Alianza.
	 */
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
