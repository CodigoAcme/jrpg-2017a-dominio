package dominio;

public abstract class PersonAbs {
	protected String nombre;
	protected int salud;
	protected int fuerza;
	protected int nivel;
	protected int defensa;

	protected RandomGenerator myRandom;

	public PersonAbs(String nombre) {
		this.nombre = nombre;
	}

	public void setRandomGenerator(MyRandomStub myRandomStub) {
		this.myRandom = myRandomStub;
	}

	public RandomGenerator getMyRandom() {
		return this.myRandom;
	}

}
