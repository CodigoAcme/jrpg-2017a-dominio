package dominio;

import java.util.Random;

public class MyRandom extends RandomGenerator {

  @Override
  public double nextDouble() {
    return new Random().nextDouble();
  }

  @Override
  public  int nextInt(final int val) {
    return new Random().nextInt(val);

  }

}
