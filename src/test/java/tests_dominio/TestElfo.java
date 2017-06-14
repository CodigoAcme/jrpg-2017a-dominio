package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.MyRandomStub;
import inventario.Inventario;

public class TestElfo {

  @Test
  public void testGolpeLevel() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());

    Assert.assertTrue(h.getSalud() == 100);

    h.setRandomGenerator(new MyRandomStub(0.49));
    e.setRandomGenerator(new MyRandomStub(0.49));

    if (e.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() < 100);
    } else {
      Assert.assertTrue(h.getSalud() == 100);
    }
  }

  @Test
  public void testAtaqueBosque() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());


    h.setRandomGenerator(new MyRandomStub(0.49));
    e.setRandomGenerator(new MyRandomStub(0.49));
    Assert.assertTrue(h.getSalud() == 100);
    if (e.habilidadRaza2(h)) {
      Assert.assertTrue(h.getSalud() < 100);
    } else {
      Assert.assertTrue(h.getSalud() == 100);
    }
  }

  @Test
  public void puedeSerCurado() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());
    Assert.assertTrue(e.puedeSerCurado());
  }

  @Test
  public void puedeSerAtacado() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, new Inventario());
    Assert.assertTrue(e.serAtacado());
  }
}
