package dominio;


public class MyRandomStub extends RandomGenerator {

	private double valor = 0.49;

	
	@Override
	public double nextDouble() {
		return this.valor;
	}

	
	@Override
	public int nextInt(final int val) {
		return val - 1;
	}

}
