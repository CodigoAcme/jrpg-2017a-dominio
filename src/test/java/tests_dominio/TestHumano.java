package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import inventario.Inventario;

public class TestHumano {

  @Test
  public void testIncentivar() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());

    Assert.assertTrue(e.getAtaque() == 37);
    h.habilidadRaza1(e);
    Assert.assertTrue(e.getAtaque() > 37);
  }

  @Test
  public void testGolpeFatal() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());

    h.setRandomGenerator(new MyRandomStub(0.49));
    e.setRandomGenerator(new MyRandomStub(0.49));

    Assert.assertTrue(h.getEnergia() == 100);
    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadRaza2(e)) {
      Assert.assertTrue(e.getSalud() == 70);
      Assert.assertEquals(h.getEnergia(),50,0);
    } else {
      Assert.assertTrue(h.getEnergia() == 90);
      Assert.assertTrue(e.getSalud() == 100);
    }
  }

  @Test
  public void puedeSerCurado() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());  
    Assert.assertTrue(h.puedeSerCurado());
  }

  @Test
  public void puedeSerAtacado() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
    Assert.assertTrue(h.serAtacado());
  }
}
