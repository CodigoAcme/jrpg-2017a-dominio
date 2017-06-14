package inventario;

public class Item {
	protected int idItem;
	protected int bonoAtaque;
	protected int bonoDefensa;
	protected int bonoMagia;
	protected int bonoSalud;
	protected int bonoEnergia;
	protected String nombre;
	protected String estado;
	
	
	
	public Item() {
	this.nombre = "null";
	this.estado = "null";
	}
	
	public Item(int idItem, int bonoAtaque, int bonoDefensa, int bonoMagia, int bonoSalud, int bonoEnergia, String nombre, String estado) {
	this.idItem = idItem;
	this.bonoAtaque = bonoAtaque;
	this.bonoDefensa = bonoDefensa;
	this.bonoMagia = bonoMagia;
	this.bonoSalud = bonoSalud;
	this.bonoEnergia = bonoEnergia;
	this.nombre = nombre;
	this.estado = estado;
	}


	public int getIdItem() {
		return idItem;
	}


	public int getBonoAtaque() {
		return bonoAtaque;
	}


	public int getBonoDefensa() {
		return bonoDefensa;
	}


	public int getBonoMagia() {
		return bonoMagia;
	}


	public int getBonoSalud() {
		return bonoSalud;
	}


	public int getBonoEnergia() {
		return bonoEnergia;
	}


	public String getNombre() {
		return nombre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void serEquipado() {
		this.estado="equipado";
	}
	
	public void serDesequipado() {
		this.estado="desequipado";
	}
	
}