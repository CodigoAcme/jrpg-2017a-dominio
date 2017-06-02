package dominio;


public class MyRandomStub extends RandomGenerator {

  private double valor;

  public MyRandomStub(double valorFijo) {
    this.valor = valorFijo;
  }
  
  @Override
  public double nextDouble() {
    return this.valor;
  }


  @Override
  public int nextInt(final int val) {
    return (int)this.valor;
  }

}

