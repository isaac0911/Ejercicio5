
/**
 * Modela un Guerrero, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Guerrero extends Jugador{
	
	/**
	* Numero de veces que se puede aplicar el item de "recuperar puntos de vida"
	*/
	protected int numRecuperarPuntosDeVida;
	
	/**
	* Numero de veces que se puede aplicar el item "doble ataque"
	*/
	protected int numUsarDobleAtaque;
	
	/**
	 * Instancia un Guerrero
	 * @version 17/10/2021
	 * @param tipoCombatiente entero que indica el tipo de jugador del que se trata, (en este caso Guerrero)
	 * @param nom Nombre del Guerrero
	 * @param MenInicio Mensaje que dice el guerrero al iniciar la batalla
	 * @param MenVic Mensaje que dice el guerrero al ganar la batalla
	 * @param MenDerr Mensaje que dice el guerrero al perder la batalla
	 */
	public Guerrero(int tipoCombatiente, String nom, String MenInicio, String MenVic, String MenDerr){
		
		nombre = nom;
		numRecuperarPuntosDeVida = 2;
		numUsarDobleAtaque = 3;
		MensajeInicio = MenInicio;
		MensajeVictoria = MenVic;
		MensajeDerrota = MenDerr;
		
		if(tipoCombatiente == 1){
			tipo = "Guerrero";
			PuntosVida = 10;
			PoderAtaque = 2;
		}else if(tipoCombatiente == 2){
			tipo = "Explorador";
			PuntosVida = 5;
			PoderAtaque = 1;
		}
		
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
	 * Devuelve un String que contiente el estatus del Guerrero
	 * @version 28/09/2021
	 * @return Devuelve un String con el estatus del Guerrero
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +  "\n\tTipo: " + tipo  + "\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tHongos para recuparar vidas disponibles: " + numRecuperarPuntosDeVida  + "\n\tDuplicadores de ataque disponibles: " + numUsarDobleAtaque;
		return mensaje;
	}
	
	/**
	 * Devuelve un String con un mensaje que contiene todos los items de los que dispone un guerrero
	 * @version 17/10/2021
	 * @return Devuelve un String con todos los items de un guerrero
	 */
	public String MensajePedirItem(){
		
		String m = "\nQue item desea ejecutar: \n1.\tInerir hongo para recuperar puntos de vida\n2.\tUsar doble ataque";
		return m;
	}
	
	/**
	 * Devuelve el contenido del atributo "numRecuperarPuntosDeVida"
	 * @version 17/10/2021
	 * @return Devuelve el número de veces que puede recuperar puntos de vida el guerrero
	 */
	public int getnumRecuperarPuntosDeVida(){
		return numRecuperarPuntosDeVida;
	}
	
	/**
	 * Devuelve el contenido del atributo "numUsarDobleAtaque"
	 * @version 17/10/2021
	 * @return Devuelve el número de veces que el guerrero puede realizar un doble ataque
	 */
	public int getnumUsarDobleAtaque(){
		return numUsarDobleAtaque;
	}
	
	/**
	 * Recupera puntos de vida
	 * @version 17/10/2021
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String RecuperarPuntosDeVida(){
		
		//Se aumenta la vida del Guerrero
		int VidaNueva = PuntosVida + 3;
		PuntosVida = VidaNueva;
		
		//Se disminuye en uno el número de hongos para recuperar vida que le quedan
		numRecuperarPuntosDeVida--;
		
		//Se arma el String que indica la acción realizada
		String m = "\n" + nombre + " recupero 3 puntos de vida";
		return m;
	}
	
	/**
	 * Realiza un doble ataque
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarDoble (RaidBoss Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se disminuye en uno el número de veces que puede usar un doble ataque
		numUsarDobleAtaque--;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + nombre + " realizo un doble ataque en contra de Poseidon";
		
		return mensaje;
	}
	
}