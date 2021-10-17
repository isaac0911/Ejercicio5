
/**
 * Clase abstracta que modela un Jugador
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public abstract class Jugador{
	
	/**
     * Nombre del jugador
     */
	protected String nombre;
	
	/**
     * Tipo al que pertenece el jugador (guerrero, explorador, cazador)
     */
	protected String tipo;
	
	/**
     * Puntos de vida del jugador
     */
	protected int PuntosVida;
	
	/**
     * Poder de ataque del jugador
     */
	protected int PoderAtaque;
	
	/**
     * Mensaje que dice el jugador al inicio de la batalla
     */
	protected String MensajeInicio;
	
	/**
     * Mensaje que dice el jugador al ganar la batalla
     */
	protected String MensajeVictoria;
	
	/**
     * Mensaje que dice el jugador al perder la batalla
     */
	protected String MensajeDerrota;
	
	/**
	 * Ataca al raid boss
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public abstract String AtacarRaidBoss(RaidBoss Atacado, int PoderAtaque);
	
	/**
	 * Extrae el mensaje que contiene todos los items con los que cuenta el jugador
	 * @version 17/10/2021
	 * @return Devuelve un String que indica todos los items que tiene el jugador
	 */
	public abstract String MensajePedirItem();
	
	/**
	 * Devuelve el contenido del atributo "PuntosVida"
	 * @version 17/10/2021
	 * @return Devuelve los puntos de vida que tiene el jugador
	 */
	public int getPuntosVida(){
		return PuntosVida;
	}
	
	/**
	 * Cambia el valor del atributo "PuntosVida"
	 * @version 17/10/2021
	 * @param nuevosPuntosDeVida Son los nuevos puntos de vida del jugador
	 */
	public void setPuntosVida(int nuevosPuntosDeVida){
		PuntosVida = nuevosPuntosDeVida;
	}
	
	/**
	 * Devuelve el contenido del atributo "Nombre"
	 * @version 17/10/2021
	 * @return Devuelve el nombre del jugador
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve el contenido del atributo "Tipo"
	 * @version 17/10/2021
	 * @return Devuelve el tipo del jugador
	 */
	public String getTipo(){
		return tipo;
	}
	
	/**
	 * Devuelve el contenido del atributo "PoderAtaque"
	 * @version 17/10/2021
	 * @return Devuelve el poder de ataque del jugador
	 */
	public int getPoderAtaque(){
		return PoderAtaque;
	}
	
	/**
	 * Devuelve el mensaje de inicio
	 * @version 17/10/2021
	 * @return Devuelve un String con el mensaje que muestra el jugador al iniciar la batalla
	 */
	public String MensajeInicio(){
		String mensaje = "- " + nombre + ": " + MensajeInicio;
		return mensaje;
	}
	
	/**
	 * Devuelve el mensaje de victoria
	 * @version 17/10/2021
	 * @return Devuelve un String con el mensaje que muestra el jugador al ganar la batalla
	 */
	public String MensajeVictoria(){
		String mensaje = "- " + nombre + ": " + MensajeVictoria;
		return mensaje;
	}
	
	/**
	 * Devuelve el mensaje de derrota
	 * @version 17/10/2021
	 * @return Devuelve un String con el mensaje que muestra el jugador al perder la batalla
	 */
	public String MensajeDerrota(){
		String mensaje = "- " + nombre + ": " + MensajeDerrota;
		return mensaje;
	}
	
	/**
	 * Comprueba si el jugador esta vivo
	 * @version 17/10/2021
	 * @return Devuelve true si el jugador tiene una vida mayor a 0, de lo contrario devuelve false.
	 */
	public boolean ComprobarVivo(){
		
		boolean validacion = true;
		
		if(PuntosVida>0){
			validacion = true;
		}else{
			validacion = false;
		}
		
		return validacion;
	}

}