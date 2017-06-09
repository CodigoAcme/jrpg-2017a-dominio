package dominio;

import java.util.HashMap;

public class Item {
  private String nombre;
  private HashMap<String,Integer> valor; // HashMap<atributo que modifica , cantidad que modfica>
 
  
  public Item(String nombre, HashMap<String, Integer> valor) {
    this.nombre = nombre;
    this.valor = valor;
  }
  
  
  public void agregarValor(String atributo, Integer cant) {
    if(valor.containsKey(atributo)) {	  
      valor.put(atributo, cant); 
    }
  }


  public HashMap<String, Integer> getValor() {
    return valor;
  }
  
  
  
}
