package tests_inventario;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import inventario.Item;

public class TestItem {

	@Test
	public void TestCrearItem() {
		Item item = new Item();
		Assert.assertEquals("null", item.getEstado());
		Assert.assertEquals("null", item.getNombre());
		Assert.assertEquals(0, item.getBonoAtaque());
		
		Item item2 = new Item(1,2,0,0,0,1,"item","desequipado");
		Assert.assertEquals("item", item2.getNombre());
		item2.serEquipado();
		Assert.assertEquals("equipado", item2.getEstado());
		
		
		
	}
}
