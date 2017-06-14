package dominio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import inventario.Inventario;
import inventario.Item;

/**
 * Clase que define los atributos que tienen en comun todas las clases de
 * personajes, todo lo que los define ya sea posicion, alianza, estadisticas,
 * nombre del personaje o de la raza, experiencia, nivel, etc. y sus funciones
 * para manejar los ataques, salud, curaciones, aumentos de experiencia, etc.
 * Estos personajes son manejados unicamente por jugadores
 */

public abstract class Personaje extends PersonAbs implements Peleable, Serializable {

  protected int energia;

  protected int ataque;
  protected int magia;

  protected String nombreRaza;

  protected int saludTope;
  protected int energiaTope;

  protected int destreza;
  protected int inteligencia;
  protected Casta casta;

  protected int x;
  protected int y;

  protected int experiencia;

  protected int idPersonaje;

  protected Alianza clan = null;
  public static int tablaDeNiveles[];

  protected String[] habilidadesRaza;

  public String[] getHabilidadesRaza() {
    return habilidadesRaza;
  }

  /**
   * Metodo que devuelve las habilidades de la Casta.
   */
  
  public String[] getHabilidadesCasta() {
    return casta.getHabilidadesCasta();
  }

  /**
   * Metodo que carga el nivel del personaje segun la tabla de niveles.
   */

  public static void cargarTablaNivel() {
    Personaje.tablaDeNiveles = new int[101];
    Personaje.tablaDeNiveles[0] = 0;
    Personaje.tablaDeNiveles[1] = 0;
    for (int i = 2; i < 101; i++) {
      Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
    }
  }

  //personaje nuevo
  public Personaje(String nombre, Casta casta, int id) {
    super(nombre, 100, 10, 1);
    this.casta = casta;
    this.idPersonaje = id;
    experiencia = 0;
    inteligencia = 10;
    destreza = 10;

    fuerza += casta.getFueraza();

    inteligencia += casta.getInteligencia();

    destreza += casta.getDestreza();

    x = 0;
    y = 0;
    saludTope = 100;
    energiaTope = 100;

    ataque = this.calcularPuntosDeAtaque();
    defensa = this.calcularPuntosDeDefensa();
    magia = this.calcularPuntosDeMagia();

  }

  //persoanje existente
  public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,int experiencia, int nivel, int idPersonaje, final Inventario inventario) {

    super(nombre, salud, fuerza, nivel, inventario);
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
   * Devuelve la Raza de un personaje.
   * @return nombre de la raza.
   */

  public String getNombreRaza() {
    return nombreRaza;
  }

  /**
   * Setea la raza de un personaje.
   * @param nombreRaza el el nombre de la raza del personaje.
   */
  
  public void setNombreRaza(String nombreRaza) {
    this.nombreRaza = nombreRaza;
  }

  /**
   * Devuelde el nombre de un personaje.
   * @return nombre del personaje.
   */
  
  public String getNombre() {
    return nombre;
  }

  /**
   * Setea el nombre de un personaje.
   * @param nombre es el nombre del personaje.
   */
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Devuelve el ataque de un personaje.
   * @return ataque de un peronaje.
   */
  
  public int getAtaque() {
    return ataque;
  }

  /**
   * Setea el ataque de un personaje.
   * @param ataque son los puntos de ataque a setear.
   */

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  /**
   * Devuelve la magia de un personaje.
   * @return la magia de un personaje.
   */

  public int getMagia() {
    return magia;
  }

  /**
   * Setea la magia de un personaje.
   * @param magia son los puntos de magia a setear.
   */

  public void setMagia(int magia) {
    this.magia = magia;
  }

  /**
   * Devuelve el clan a que pertenece el personaje.
   * @return el clan de un personaje.
   */

  public Alianza getClan() {
    return clan;
  }

  /**
   * Setea el clan al cual pertenece el personaje.
   * @param clan es el clan a cual pertenece el personaje.
   */
  
  public void setClan(Alianza clan) {
    this.clan = clan;
    clan.aniadirPersonaje(this);
  }

  /**
   * Devuelve la salud de un personaje.
   * @return la salud de un peronaje.
   */

  public int getSalud() {
    return salud;
  }


  /**
   * Devuelve la energia de un personaje.
   */
  
  public int getEnergia() {
    return energia;
  }

  /**
   * Devuelve la fuerza de un personaje.
   * @return fuerza.
   */

  public int getFuerza() {
    return fuerza;
  }

  /**
   * Devuelve la destreza de un personaje.
   * @return destreza.
   */
  public int getDestreza() {
    return destreza;
  }

  /**
   * devuelve la inteligencia de un personaje.
   * @return inteligencia.
   */
  
  public int getInteligencia() {
    return inteligencia;
  }

  /**
   * Cevuelve la casta a la que pertenece un personaje.
   * @return casta.
   */

  public Casta getCasta() {
    return casta;
  }


  /**
   * Devuelve la experiencia de un personaje.
   * @return experiencia.
   */
  
  public int getExperiencia() {
    return experiencia;
  }

  /**
   * Devuelve el nivel de un personaje.
   * 
   * @return nivel
   */

  public int getNivel() {
    return nivel;
  }

  /**
   * Devuelve el identificador de un personaje.
   * @return id de personaje.
   */

  public int getIdPersonaje() {
    return idPersonaje;
  }

  /**
   * Devuelve la defensa de un personaje. 
   * @return defensa.
   */
  
  public int getDefensa() {
    return defensa;
  }

  /**
   * Devuelve el tope de salud de un personaje. 
   * @return el tope de salud.
   */

  public int getSaludTope() {
    return saludTope;
  }

  /**
   * Devuelve el tope de energia de un personaje.
   * 
   * @return tope de energia.
   */
  
  public int getEnergiaTope() {
    return energiaTope;
  }


  /**
   * Funcion que determina como ataca un personaje si el personaje tiene salud
   * puede atacar si el personaje que quiere atacar tiene salud puede ser
   * atacado en caso que se cumplan esas condiciones el personaje que recibe
   * el ataque sera atacado con un valor que depende de que se cumplan las
   * condiciones de golpe critico o no De no cumplirse la condicion de critico
   * el ataque sera del mismo valor de ataque que posee el personaje.
   * @param atacado es el enemigo que recibira el ataque.
   */

  public int atacar(Peleable atacado) {
    if (salud == 0) {
      return 0;
    }
    if (atacado.getSalud() > 0) {
      if (this.myRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
        return atacado.serAtacado(this.golpe_critico());
      } else {
        return atacado.serAtacado(this.ataque);
      }
    }
    return 0;
  }

  /**
   * Calcula el daño crítico basado en la casta del personaje.
   * @return (int) (this.ataque * this.getCasta().getDañoCritico()) -> Valor del daño crítico realizado por el golpe
   */

  public int golpe_critico() {
    return (int) (this.ataque * this.getCasta().getDanioCritico());
  }

  public void despuesDeTurno() {}

  /**
   * Determina si el personaje puede realizar un ataque si tiene la cantidad
   * necesaria de energia.
   * @return energia > 10 -> Valor para determinar si posee la energia para realizar un ataque
   */
  
  public boolean puedeAtacar() {
    return energia > 10;
  }

  /**
   * Determina la cantidad de puntos de ataque del personaje basando en la
   * cantidad de fuerza del mismo. 
   * @return (int) (this.getFuerza() * 1.5) -> Valor de ataque del personaje
   */
  
  public int calcularPuntosDeAtaque() {
    return (int) (this.getFuerza() * 1.5);
  }

  /**
   * Calcula la cantidad de puntos de defensa del personaje basando en la
   * cantidad de destreza del mismo.
   * 
   * @return (int) (this.getDestreza()) -> Valor de defensa del personaje
   */
  
  public int calcularPuntosDeDefensa() {
    return (int) (this.getDestreza());
  }

  /**
   * Calcula la cantidad de puntos de magia del personaje basando en la
   * cantidad de inteligencia del mismo.
   * 
   * @return (int) (this.getInteligencia() * 1.5) -> Valor de magia del
   *         personaje
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
   * Determina si el personaje se encuentra vivo. 
   * @return salud > 0 -> Establece si el personaje esta vivo
   */
  
  public boolean estaVivo() {
    return salud > 0;
  }

  /**
   * Funcion para que el personaje interprete cuando es atacado si el da�o es
   * menor a la cantidad de puntos de defensa o su defiende usando sus puntos
   * de evitar da�o este personaje no recibirra da�o, en caso contrario al
   * da�o se le resta los puntos de defensa del personaje y el resultado se le
   * resta a la salud, en caso de que la cantidad de da�o supere a la salud la
   * salud es reducida a 0 y el da�o es igual a la cantidad de salud del
   * enemigo.
   * @param danio es la cantidad de puntos de da�os que el ataque le inflingio al personaje
   */
  
  public int serAtacado(int danio) {
	  
//    if (this.myRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDanio()) {
      danio -= this.defensa;
      if (danio > 0) {
        if (salud <= danio) {
          danio = salud;
          salud = 0;
        } else {
          salud -= danio;
        }
        return danio;
      }
      return 0;
//    }
//    return 0;
  }
  


  /**
   * Define el estado del personaje, luego de que le roban salud. El nivel de
   * salud robada decrementa en función del nivel de defensa que posea el personaje.
   * @param danio Cantidad recibida de daño por el personaje al cual se le roba salud
   * @return daño Daño generado.
   */
  
  public int serRobadoSalud(int danio) {
    danio -= this.defensa;
    if (danio <= 0) {
      return 0;
    }
    if ((salud - danio) >= 0) {
      salud -= danio;
    } else {
      danio = salud;// le queda menos salud que el daño inflingido
      salud = 0;
    }
    return danio;
  }

  /**
   * Define el estado del personaje, luego de que le roban energía. El nivel
   * de energía robada decrementa en función del nivel de defensa que posea el
   * personaje.
   * @param danio Cantidad recibida de daño por el personaje al cual se le roba energía
   * @return daño -> Daño generado
   */
  
  public int serDesernegizado(int danio) {
    danio -= this.defensa;
    if (danio <= 0) {
      return 0;
    }
    if ((energia - danio) >= 0) {
      energia -= danio;
    } else {
      danio = energia;
      energia = 0;
    }
    return danio;
  }

  /**
   * Permite curar al personaje por una determinada cantidad de salud.
   * @param salud Cantidad de salud por la cual el personaje es curado
   */
  
  public void serCurado(int salud) {
    if ((this.salud + salud) <= this.saludTope) {
      this.salud += salud;
    } else {
      this.salud = this.saludTope;
    }
  }

  /**
   * Permitee energizar al personaje por una determinada cantidad de energía.
   * @param energia energia que recupera Cantidad de energía por la cual el personaje es energizado
   */

  public void serEnergizado(int energia) {
    if ((this.energia + energia) <= this.energiaTope) {
      this.energia += energia;
    } else {
      this.energia = this.energiaTope;
    }
  }

  /**
   * Permite la creación de una alianza por parte del personaje.
   * @param nombreAlianza nombre de la alianza
   */
 

  public void crearAlianza(String nombreAlianza) {
    this.clan = new Alianza(nombreAlianza);
    this.clan.aniadirPersonaje(this);
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
  
  public boolean aliar(Personaje nuevoAliado) {
    if (this.clan == null) {
      Alianza a = new Alianza("Alianza 1");
      this.clan = a;
      a.aniadirPersonaje(this);
    }

    if (nuevoAliado.clan == null) {
      nuevoAliado.clan = this.clan;
      this.clan.aniadirPersonaje(nuevoAliado);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Determina la asignacion de los atributos principales del personaje
   * (fuerza/destreza/inteligencia) y luego calcula los que se basan en ellos
   * (defensa/magia/ataque).
   * @param fuerza fuerza
   * @param destreza  destreza
   * @param inteligencia inteligencia
   */
  
  public void asignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
    if (this.fuerza + fuerza <= 200) {
      this.fuerza += fuerza;
    }
    if (this.destreza + destreza <= 200) {
      this.destreza += destreza;
    }
    if (this.inteligencia + inteligencia <= 200) {
      this.inteligencia += inteligencia;
    }
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
    while (this.nivel != 100 && (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
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
   * @return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y,2))Cantidad de tildes de distancia con respecto al otro personaje
   */

  public double distanciaCon(Personaje p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }

  /**
   * Permite al personaje usar su primera habilidad de casta.
   * @param atacado peleable a atacar
   * @return this.getCasta().habilidad1(this, atacado) Determina si se puede o no realizar la habilidad
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

  protected void asignarHabilidadInicial(String nombre) {
    switch (nombreRaza) {
      case "Elfo":
        energiaTope += 10;
        salud = saludTope;
        energia = energiaTope;
        habilidadesRaza = new String[2];
        habilidadesRaza[0] = "Golpe Level";
        habilidadesRaza[1] = "Ataque Bosque"; 
        break;
      case "Orco":
        saludTope += 10;
        salud = saludTope;
        energia = energiaTope;
        habilidadesRaza = new String[2];
        habilidadesRaza[0] = "Golpe Defensa";
        habilidadesRaza[1] = "Mordisco de Vida";
        break;
      case "Humano":
        energiaTope += 5;
        saludTope += 5;
        salud = saludTope;
        energia = energiaTope;
        break;
      default:
        break;
    }
  }

  public void actualizarValores(HashMap<String, Integer> atributos) { 
    this.salud = atributos.get("salud");
    this.energia = atributos.get("energia");
  }

  public void modificarEnergia(int energia) {
    this.energia += energia;
  }

  public void modificarMagia(int magia) {
    this.magia += magia;
  }

  public void modificarAtaque(int ataque) {
    this.ataque += ataque;
  }

  public void modificarDestreza(int magia) {
    this.destreza += destreza;
  }
  
  public void aplicarBonusItem(Item item) {
		this.ataque += item.getBonoAtaque();
		this.defensa += item.getBonoDefensa();
		this.magia += item.getBonoMagia();
		this.saludTope += item.getBonoSalud();
		this.salud += item.getBonoSalud();
		this.energiaTope += item.getBonoEnergia();
		this.energia += item.getBonoEnergia();
	}
	
	public void quitarBonusItem(Item item) {
		this.ataque -= item.getBonoAtaque();
		this.defensa -= item.getBonoDefensa();
		this.magia -= item.getBonoMagia();
		this.saludTope -= item.getBonoSalud();
		this.salud -= item.getBonoSalud();
		this.energiaTope -= item.getBonoEnergia();
		this.energia -= item.getBonoEnergia();
	}
	
	public void equiparItemEnInventario(int idItem) {
		Item item = this.inventario.obtenerItem(idItem);
		item.serEquipado();
		this.aplicarBonusItem(item);
	}
	
	public void desequiparItemDeInventario(Item itemEquipado) {		
		
		itemEquipado.serDesequipado();
		this.quitarBonusItem(itemEquipado);
	}

  
}
