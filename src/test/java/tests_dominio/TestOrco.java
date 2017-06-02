package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestOrco {

  @Test
  public void testGolpeDefensivo() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Orco o = new Orco("Hernan", new Guerrero(), 1);

    h.setRandomGenerator(new MyRandomStub(0.49));
    o.setRandomGenerator(new MyRandomStub(0.49));

    Assert.assertTrue(h.getSalud() == 105);
    if (o.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() == 95);
    } else {
      Assert.assertTrue(o.getSalud() == 105);
    }
  }



  @Test
  public void puedeSerCurado() {
    Orco o = new Orco("Hernan", new Guerrero(), 1);
    Assert.assertTrue(o.puedeSerCurado());
  }

  @Test
  public void puedeSerAtacado() {
    Orco o = new Orco("Hernan", new Guerrero(), 1);
    Assert.assertTrue(o.serAtacado());
  }
}
