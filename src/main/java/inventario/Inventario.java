package inventario;
import java.util.HashMap;



public class Inventario {
	private int idInv;
	private HashMap<Integer,Item> inventario;

	public Inventario() {
		this.idInv = 0;
		this.inventario = new HashMap<Integer,Item>();
	}
	
	
	public Inventario(int idInv, HashMap<Integer,Item> items) {
		this.idInv = idInv;
		this.inventario = items;
	}
	
	public int getIdInv() {
		return idInv;
	}
	
	public void setIdInv(int idInv) {
		this.idInv = idInv;
	}

	public HashMap<Integer,Item> getItems() {
		return inventario;
	}
	
	public boolean agregaItem(Item item) {
		if (inventario.size() < 20) {
			inventario.put(item.getIdItem(), item);
			return true;
		}
		return false;
	}
	
	public Item obtenerItem(int idItem) {
		return this.getItems().get(idItem);
	}
	

}