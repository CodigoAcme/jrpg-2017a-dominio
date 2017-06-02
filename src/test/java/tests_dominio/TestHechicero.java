package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestHechicero {


  @Test
  public void testBolaDeFuego() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    h.setRandomGenerator(new MyRandomStub(0.49));
    e.setRandomGenerator(new MyRandomStub(0.49));
 
    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadCasta1(e)) {
      Assert.assertTrue(e.getSalud() < 100);
    } else {
      Assert.assertTrue(e.getSalud() == 100);
    }
  }
}
