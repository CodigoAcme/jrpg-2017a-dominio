package inventario;
import java.util.HashMap;

public class Inventario {
	private int idInv;
	private HashMap<Integer,Item> items;

	public Inventario() {
		this.idInv = 0;
		this.items = new HashMap<Integer,Item>();
	}
	
	
	public Inventario(int idInv, HashMap<Integer,Item> items) {
		super();
		this.idInv = idInv;
		this.items = items;
	}
	
	public int getIdInv() {
		return idInv;
	}
	
	public void setIdInv(int idInv) {
		this.idInv = idInv;
	}

	public HashMap<Integer,Item> getItems() {
		return items;
	}
	
	public boolean agregaItem(Item item) {
		if (items.size() < 20) {
			items.put(item.getIdItem(), item);
			return true;
		}
		return false;
	}
	
	public Item obtenerItem(int idItem) {
		return this.getItems().get(idItem);
	}
	
	
	

}