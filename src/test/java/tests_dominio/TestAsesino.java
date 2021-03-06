package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import inventario.Inventario;

public class TestAsesino {

  @Test
  public void testRobar() { }
  
  @Test
  public void testCritico() {
    Humano h = new Humano("Nicolas",new Asesino(),1);
    Humano h2 = new Humano("Lautaro",new Hechicero(),2);
    h.setRandomGenerator(new MyRandomStub(0.49));
    h2.setRandomGenerator(new MyRandomStub(0.49));
    Assert.assertEquals(105, h2.getSalud());
    if (h.habilidadCasta1(h2)) {
      Assert.assertTrue(93 == h2.getSalud());
    } else {
      Assert.assertEquals(105, h2.getSalud());
    }
  }

  @Test
  public void testProbEvasion() {
    Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
    Assert.assertTrue(0.3 == h.getCasta().getProbabilidadEvitarDanio());
    h.habilidadCasta2(null);
    Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDanio(), 0.01);
    h.habilidadCasta2(null);
    Assert.assertEquals(0.5, h.getCasta().getProbabilidadEvitarDanio(), 0.1);
  }
}
