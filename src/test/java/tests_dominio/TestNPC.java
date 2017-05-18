package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.NonPlayableCharacter;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 2);
		Assert.assertEquals(30,npc.otorgarExp());
		Assert.assertEquals("Gigante", npc.getNombre());
		Assert.assertEquals(false,npc.puedeSerCurado());
		Assert.assertEquals(false,npc.serAtacado());
	}
		
}
