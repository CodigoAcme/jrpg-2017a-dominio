package tests_inventario;

import org.junit.Assert;
import org.junit.Test;

import inventario.Inventario;
import inventario.Item;

public class TetsInventario {

	@Test
	public void testCrearInventario() {
		Item item1 = new Item(1,2,0,0,0,0,"item1","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,"item2","desequipado");
		
		Inventario inventario = new Inventario();
		
		inventario.agregaItem(item1);
		inventario.agregaItem(item2);
		
		Assert.assertEquals("item1", inventario.obtenerItem(1).getNombre());
		Assert.assertEquals("item2", inventario.obtenerItem(2).getNombre());
	}

}
