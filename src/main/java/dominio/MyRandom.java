package dominio;

import java.util.Random;

public class MyRandom extends RandomGenerator {
  private Random random;
  
  public MyRandom() {
		this.random = new Random();
  }
  
  @Override
  public double nextDouble() {
    return random.nextDouble();
  }

  @Override
  public  int nextInt(final int val) {
    return random.nextInt(val);

  }

}
