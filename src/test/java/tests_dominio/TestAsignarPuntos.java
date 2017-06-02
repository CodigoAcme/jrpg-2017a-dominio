package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAsignarPuntos {

  @Test
  public void testAumentarSalud_tope(){
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Assert.assertTrue(h.getSaludTope()==105); 
    h.ganarExperiencia(50);
    Assert.assertTrue(h.getSaludTope()==130);
  }

  @Test
  public void testAumentarEnergia_tope(){
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Assert.assertTrue(h.getEnergiaTope()==105);
    h.ganarExperiencia(50);
    Assert.assertTrue(h.getEnergiaTope()==125);
  }

}
