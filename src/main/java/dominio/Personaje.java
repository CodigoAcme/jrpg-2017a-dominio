package dominio;

import java.io.Serializable;

/*
 * Clase que define los atributos que tienen en comun todas las clases de personajes, todo lo que los define
 * ya sea posicion, alianza, estadisticas, nombre del personaje o de la raza, experiencia, nivel, etc.
 * y sus funciones para manejar los ataques, salud, curaciones, aumentos de experiencia, etc.
 * Estos personajes son manejados unicamente por jugadores
 */

public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;
	
	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	
	/*
	 * Funcion que determina como ataca un personaje
	 *  si el personaje tiene salud puede atacar
	 *  si el personaje que quiere atacar tiene salud puede ser atacado
	 *  en caso que se cumplan esas condiciones el personaje que recibe el ataque sera atacado con un valor
	 *  que depende de que se cumplan las condiciones de golpe critico o no
	 *  De no cumplirse la condicion de critico el ataque sera del mismo valor de ataque que posee el personaje 
	 * @param atacado es el enemigo que recibira el ataque
	 */
	public int atacar(Peleable atacado) {
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return energia > 10;
	}

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	/*
	 * Funcion para que el personaje interprete cuando es atacado
	 * si el da�o es menor a la cantidad de puntos de defensa o su defiende usando sus puntos de evitar
	 * da�o este personaje no recibirra da�o, en caso contrario al da�o se le resta los puntos de defensa
	 * del personaje y el resultado se le resta a la salud, en caso de que la cantidad de da�o supere a la
	 * salud la salud es reducida a 0 y el da�o es igual a la cantidad de salud del enemigo
	 * @param da�o es la cantidad de puntos de da�os que el ataque le inflingio al personaje
	 */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
				}
				return daño;
			}
			return 0;
		}
		return 0;
	}

	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((salud - daño) >= 0)
			salud -= daño;
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			return false;
	}

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}