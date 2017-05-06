package dominio;

import java.io.Serializable;

/**
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
	
	/**
	 * Metodo que devuelve las habilidades de la Casta
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}
	
	/**
	 * Metodo que carga el nivel del personaje segun la tabla de niveles
	 */

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
	
	/**
	 * Devuelve la Raza de un personaje
	 * @return nombre de la raza
	 */

	public String getNombreRaza() {
		return nombreRaza;
	}
	/**
	 * Setea la raza de un personaje
	 * @param nombreRaza el el nombre de la raza del personaje
	 */
	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}
	/**
	 * Devuelde el nombre de un personaje
	 * @return nombre del personaje
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setea el nombre de un personaje
	 * @param nombre es el nombre del personaje
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve el ataque de un personaje
	 * @return ataque de un peronaje
	 */
	public int getAtaque() {
		return ataque;
	}
	/**
	 * Setea el ataque de un personaje
	 * @param ataque son los puntos de ataque a setear
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	/**
	 * Devuelve la magia de un personaje
	 * @return la magia de un personaje
	 */
	public int getMagia() {
		return magia;
	}
	/**
	 * Setea la magia de un personaje
	 * @param magia son los puntos de magia a setear
	 */
	public void setMagia(int magia) {
		this.magia = magia;
	}
	/**
	 *Devuelve el clan a que pertenece el personaje
	 *@return el clan de un personaje
	 */
	public Alianza getClan() {
		return clan;
	}
	/**
	 * Setea el clan al cual pertenece el personaje
	 * @param clan es el clan a cual pertenece el personaje
	 */
	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}
	/**
	 * Devuelve la salud de un personaje
	 * @return la salud de un peronaje
	 */
	public int getSalud() {
		return salud;
	}
	/**
	 * setea la salud del personaje
	 * @param salud son los puntos salud a setear
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}
	/**
	 * Devuelve la energia de un personaje
	 */
	public int getEnergia() {
		return energia;
	}
	/**
	 * Setea la energia de un personaje
	 * @param energia son los puntos de energia a setear
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	/**
	 * Devuelve la fuerza de un personaje 
	 * @return fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}
	/**
	 * Setea la fuerza de un personaje
	 * @param fuerza son los puntos de fuerza a setear
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	/**
	 * Devuelve la destreza de un personaje
	 * @return destreza
	 */
	public int getDestreza() {
		return destreza;
	}
	/**
	 * Setea la destreza de un personaje
	 * @param destreza son los puntos de destreza a setear
	 */
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	/**
	 * devuelve la inteligencia de un personaje
	 * @return inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}
	/**
	 * Setea la inteligencia de un personaje 
	 * @param inteligencia son los punto de inteligencia a setear
	 */
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	/**
	 * Cevuelve la casta a la que pertenece un personaje 
	 * @return casta
	 */
	public Casta getCasta() {
		return casta;
	}
	/**
	 * Setea la casta de un personaje
	 * @param casta es la casta a la que pertenece un personaje
	 */
	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	/**
	 * Devuelve la experiencia de un personaje
	 * @return experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}
	/**
	 * Setea la experiencia de un perosnaje
	 * @param experiencia son los puntos de experiencia de un personaje
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	/**
	 * Devuelve el nivel de un personaje
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Setea el nivel de un personaje
	 * @param nivel son los puntos de nivel de un personaje
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * Devuelve el identificador de un personaje
	 * @return id de personaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}
	/**
	 * Setea el identificador de un personaje
	 * @param idPersonaje es el identificador de un personaje
	 */
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	/**
	 * Devuelve la defensa de un personaje
	 * @return defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * Setea la defensa de un personaje
	 * @param defensa son los puntos de defensa de un personaje
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	/**
	 * Devuelve el tope de salud de un personaje
	 * @return el tope de salud
	 */
	public int getSaludTope() {
		return saludTope;
	}
	/**
	 * Setea el tope de salud de un personaje
	 * @param saludTope es el tope de salud de un personaje
	 */
	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}
	/**
	 * Devuelve el tope de energia de un personaje
	 * @return tope de energia
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}
	/**
	 * Setea el tope de energia de un personaje
	 * @param energiaTope es el tope de energia de un personaje
	 */
	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	
	/**
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
	/**
     * Calcula el daño crítico basado en la casta del
     * personaje.
     * @return (int) (this.ataque * this.getCasta().getDañoCritico()) -> Valor
     *         del daño crítico realizado por el golpe
     */
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}
	/**
     * Determina si el personaje puede realizar un ataque
     * si tiene la cantidad necesaria de energia.
     * @return energia > 10 -> Valor para determinar si posee la energia para realizar un ataque
     */
	public boolean puedeAtacar() {
		return energia > 10;
	}
	/**
     * Determina la cantidad de puntos de ataque del
     * personaje basando en la cantidad de fuerza del mismo.
     * @return (int) (this.getFuerza() * 1.5) -> Valor de ataque del personaje
     */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}
	 /**
     * Calcula la cantidad de puntos de defensa del
     * personaje basando en la cantidad de destreza del mismo.
     * @return (int) (this.getDestreza()) -> Valor de defensa del personaje
     */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}
	 /**
     * Calcula la cantidad de puntos de magia del
     * personaje basando en la cantidad de inteligencia del mismo.
     * @return (int) (this.getInteligencia() * 1.5) -> Valor de magia del personaje
     */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}
	/**
     * Reestablece la salud a su valor máximo.
     */
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}
	/**
     * Reestablece la energia a su valor máximo.
     */

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}
	/**
     * Permite Modificar los atributos del personaje.
     */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}
	 /**
		 * Determina si el personaje se encuentra vivo 
		 * @return salud > 0 -> Establece si el personaje esta vivo 
		 */ 
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
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
	 /**
     * Define el estado del personaje, luego de que le roban salud. El nivel de salud
     *  robada decrementa en función del nivel de defensa que posea el personaje.
     * @param daño  Cantidad recibida de daño por el personaje al cual se le roba salud
     * @return daño Daño generado.
     */
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

	/**
     * Define el estado del personaje, luego de que le roban energía. El nivel de energía 
     * robada decrementa en función del nivel de defensa que posea el personaje.
     * @param daño Cantidad recibida de daño por el personaje al cual se le  roba energía
     * @return daño -> Daño generado
     */
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
	 /**
     * Permite curar al personaje por una determinada cantidad de salud.
     * @param salud Cantidad de salud por la cual el personaje es curado
     */
	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}
	/**
     * Permitee energizar al personaje por una determinada cantidad de energía.
     * @param energia energia que recupera Cantidad de energía por la cual el personaje es energizado
     */
	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}
    /**
     * Permite la creación de una alianza por parte del personaje.
     * @param nombreAlianza nombre de la alianza
     */
	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}
	/**
     * Este método permite al personaje salir de su actual alianza.
     */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}
	/**
     * Permite la alianza con otro personaje.
     * @param nuevoAliado aliado que se incorpora
     * @return true/false ->determina si se pudo realizar la alianza
     */
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
	/**
     * Determina la asignacion de los atributos principales del personaje (fuerza/destreza/inteligencia) 
     * y luego calcula los que se basan en ellos (defensa/magia/ataque).
     * @param fuerza fuerza
     * @param destreza destreza
     * @param inteligencia inteligencia
     */
	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}
	/**
     * Sube de nivel al personaje hasta un máximo de 100.
     */
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
	  /**
     * Suma una determinada cantidad de experiencia al personaje y determinar si sube de nivel.
     * @param exp esperiencia
     * @return true/false Determina si subió o no de nivel como resultado de la suma de experiencia
     */
	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}
    /**
     * Otorga experiencia basada en el nivel del personaje.
     * @return this.nivel * 40 Cantidad de experiencia entregada.
     */
	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/**
     * Permite calcular los tildes de distancia que hay entre este personaje y otro.
     * @param p personaje respecto al cual quiero saber la distancia
     * @return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2))Cantidad de tildes de distancia con respecto al otro personaje
     */
	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
    /**
     * Permite al personaje usar su primera habilidad de casta.
     * @param atacado  peleable a atacar
     * @return this.getCasta().habilidad1(this, atacado) Determina si se  puede o no realizar la habilidad
     */
	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}
	/**
     * Permite al personaje usar su segunda habilidad de casta.
     * @param atacado peleable a atacar
     * @return this.getCasta().habilidad2(this, atacado) -> Determina si se puede o no realizar la habilidad
     */
	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}
     /**
     * Permite al personaje usar su tercera habilidad de casta.
     * @param atacado peleable a atacar
     * @return this.getCasta().habilidad3(this, atacado) -> Determina si se puede o no realizar la habilidad
     */
	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}
	/**
     * Permite al personaje usar su primera habilidad de raza.
     * @param atacado peleable a atacar
     * @return boolean.
     */
	public abstract boolean habilidadRaza1(Peleable atacado);
	/**
     * Permite al personaje usar su segunda habilidad de raza.
     * @param atacado peleable a atacar
     * @return boolean.
     */
	public abstract boolean habilidadRaza2(Peleable atacado);
}