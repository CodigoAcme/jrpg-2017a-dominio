package tests_inventario;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.MyRandomStub;
import inventario.Inventario;
import inventario.Item;

public class TestPersonaje {

	@Test
	public void testCrearInventario() {
		Item item1 = new Item(1,2,0,0,0,0,"item1","desequipado");
		Item item2 = new Item(2,0,2,0,0,0,"item2","desequipado");
		
		Inventario inventario = new Inventario();
		
		inventario.agregaItem(item1);
		inventario.agregaItem(item2);
		
		Assert.assertEquals("item1", inventario.obtenerItem(1).getNombre());
		Assert.assertEquals("item2", inventario.obtenerItem(2).getNombre());
		
		
		Elfo e = new Elfo("pepe", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, inventario);
		e.setRandomGenerator(new MyRandomStub(0.49));
		
		// Estado inicial de los atributos
		Assert.assertEquals(37, e.getAtaque());
		Assert.assertEquals(20, e.getDefensa());
		
		//Equipo el item 1
		e.equiparItemEnInventario(1);
		Assert.assertEquals(39, e.getAtaque());
		
		//Equipo el item 2
		e.equiparItemEnInventario(2);
		Assert.assertEquals(22, e.getDefensa());
		
		//Desequipo los items
		e.desequiparItemDeInventario(e.getInventario().obtenerItem(1));
		e.desequiparItemDeInventario(e.getInventario().obtenerItem(2));
		
		// quito los bonus luego de desequipar
		Assert.assertEquals(37, e.getAtaque());
		Assert.assertEquals(20, e.getDefensa());
	}
}


