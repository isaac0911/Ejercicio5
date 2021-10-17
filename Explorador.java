
/**
 * Modela un Explorador, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Explorador extends Guerrero{
	
	/**
	* Numero de veces que se puede aplicar el item de "Lanzar bola de fuego"
	*/
	private int numBolaDeFuego;
	
	/**
	* Numero de veces que se puede aplicar el item de "Envenenar"
	*/
	private int numEnvenenar;
	
	/**
	 * Instancia un Explorador
	 * @version 17/10/2021
	 * @param tipoCombatiente entero que indica el tipo de jugador del que se trata, (en este caso Explorador)
	 * @param nom Nombre del Explorador
	 * @param MenInicio Mensaje que dice el Explorador al iniciar la batalla
	 * @param MenVic Mensaje que dice el Explorador al ganar la batalla
	 * @param MenDerr Mensaje que dice el Explorador al perder la batalla
	 */
	public Explorador(int tipoCombatiente, String nom, String MenInicio, String MenVic, String MenDerr){
		
		super (tipoCombatiente, nom, MenInicio, MenVic, MenDerr);
		numBolaDeFuego = 2;
		numEnvenenar= 3;
	}
	
	/**
	 * Ataca al raid boss
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarRaidBoss(RaidBoss Atacado, int PoderAtaque){
		
		//Se reduce la vida del Raid Boss
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + nombre + " ataco a Poseidon";
		
		return mensaje;
	}
	
	/**
	 * Devuelve un String que contiente el estatus del Explorador
	 * @version 17/10/2021
	 * @return Devuelve un String con el estatus del Explorador
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +  "\n\tTipo: " + tipo  + "\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tHongos para recuperar vidas disponibles: " + numRecuperarPuntosDeVida  + "\n\tDuplicadores de ataque disponibles: " + numUsarDobleAtaque + "\n\tBolas de fuego disponibles: " + numBolaDeFuego + "\n\tVenenos disponibles para utilizar: " + numEnvenenar;
		return mensaje;
	}
	
	/**
	 * Devuelve un String que contiene todos los items de los que dispone un explorador
	 * @version 17/10/2021
	 * @return Devuelve un String con todos los items de un explorador
	 */
	public String MensajePedirItem(){
		
		String m = "\nQue item desea ejecutar: \n1.\tInerir hongo para recuperar puntos de vida\n2.\tUsar doble ataque\n3.\tUsar bola de fuego\n4.\tEnvenenar";
		return m;
	}
	
	/**
	 * Devuelve el contenido del atributo "numBolaDeFuego"
	 * @version 17/10/2021
	 * @return Devuelve el número de veces que el explorador puede lanzar una bola de fuego
	 */
	public int getnumBolaDeFuego(){
		return numBolaDeFuego;
	}
	
	/**
	 * Devuelve el contenido del atributo "numEnvenenar"
	 * @version 17/10/2021
	 * @return Devuelve el número de veces que el explorador puede envenenar
	 */
	public int getnumEnvenenar(){
		return numEnvenenar;
	}
	
	/**
	 * Ataca con una bola de fuego
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss. 
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarConBolaDeFuego(RaidBoss Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se disminuye en uno el número de veces que puede usar un doble ataque
		numBolaDeFuego--;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + nombre + " lanzo una bola de fuego en contra de Poseidon";
		
		return mensaje;
	}
	
	/**
	 * Envenena al raid boss
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss. 
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String Envenenar(RaidBoss Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se disminuye en uno el número de veces que puede usar un doble ataque
		numEnvenenar--;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + nombre + " enveneno a Poseidon, pero, sigue vivo!";
		
		return mensaje;
	}
	
}