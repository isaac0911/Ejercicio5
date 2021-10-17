import java.util.ArrayList;

/**
 * Modela al raid boss, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class RaidBoss{
	
	/**
     * Nombre del raid boss
     */
	private String nombre;
	
	/**
     * Puntos de vida del raid boss
     */
	private int PuntosVida;
	
	/**
     * Poder de ataque del raid boss
     */
	private int PoderAtaque;
	
	/**
     * Número de clones con los que cuenta raid boss
     */
	private int numClones;
	
	/**
     * Habilidad especial que heredará el raid boss a sus clones
     */
	private String TipoHabilidadAclonar;
	
	/**
	 * Instancia un Raid Boss
	 * @version 17/10/2021
	 * @param nom Nombre del enemigo
	 */
	public RaidBoss(String nom){
		nombre = nom;
		PuntosVida = 20;
		PoderAtaque = 4;
		numClones = 0;
		TipoHabilidadAclonar = "Aun no definida";
	}
	
	/**
	 * Devuelve un String que contiente el estatus del raid boss
	 * @version 17/10/2021
	 * @return Devuelve un String con el estatus del raid boss
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +"\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tClones: " + numClones + "\n\tHabilidad a clonar: " + TipoHabilidadAclonar;
		return mensaje;
	}
	
	/**
	 * Cambia el valor del atributo "PuntosVida"
	 * @version 17/10/2021
	 * @param nuevosPuntosDeVida Son los nuevos puntos de vida del raid boss
	 */
	public void setPuntosVida(int nuevosPuntosDeVida){
		PuntosVida = nuevosPuntosDeVida;
	}
	
	/**
	 * Cambia el valor del atributo "TipoHabilidadAclonar"
	 * @version 17/10/2021
	 * @param HabilidadAClonar Nueva habilidad que heredará el raid boss cuando cree clones
	 */
	public void setTipoHabilidadAclonar(String HabilidadAClonar){
		TipoHabilidadAclonar = HabilidadAClonar;
	}
	
	/**
	 * Devuelve el contenido del atributo "PuntosVida"
	 * @version 17/10/2021
	 * @return Devuelve los puntos de vida que tiene el raid boss
	 */
	public int getPuntosVida(){
		return PuntosVida;
	}
	
	/**
	 * Aumenta en 1 el valor del atributo "numClones"
	 * @version 17/10/2021
	 */
	public void setNumClones(){
		numClones++;
	}
	
	/**
	 * Asigna al atributo "numClones" un valor de 0
	 * @version 17/10/2021
	 */
	public void ReiniciarNumClones(){
		numClones=0;
	}
	
	/**
	 * Devuelve el contenido del atributo "TipoHabilidadAclonar"
	 * @version 17/10/2021
	 * @return Devuelve un String que indica la habilidad especial que se hereda cuando el raid boss crea un clon
	 */
	public String getTipoHabilidadAclonar(){
		return TipoHabilidadAclonar;
	}
	
	/**
	 * Devuelve el contenido del atributo "nombre"
	 * @version 17/10/2021
	 * @return Devuelve el nombre del raid boss
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve el contenido del atributo "PoderAtaque"
	 * @version 17/10/2021
	 * @return Devuelve el poder de ataque del raid boss
	 */
	public int getPoderAtaque(){
		return PoderAtaque;
	}
	
	/**
	 * Devuelve el mensaje que dice el raid boss cuando inicia el juego
	 * @version 17/10/2021
	 * @return Devuelve el mensaje que dice el raid boss cuando inicia la batalla
	 */
	public String MensajeInicio(){
		return "- Poseidon: Hahaha, esto sera pan comido";
	}
	
	/**
	 * Devuelve el mensaje que dice el raid boss cuando gana el juego
	 * @version 17/10/2021
	 * @return Devuelve el mensaje que dice el raid boss cuando gana la batalla
	 */
	public String MensajeVictoria(){
		return "- Poseidon: Ja!, a eso le llamo ganar";
	}
	
	/**
	 * Devuelve el mensaje que dice el raid boss cuando pierde el juego
	 * @version 17/10/2021
	 * @return Devuelve el mensaje que dice el raid boss cuando pierde la batalla
	 */
	public String MensajeDerrota(){
		return "- Poseidon: No puede ser!, me vengare la proxima vez que nos veamos";
	}
	
	/**
	 * Devuelve un String con todas las acciones que puede ejecutar el raid boss
	 * @version 17/10/2021
	 * @return Devuelve un String con todas las acciones que puede ejecutar el raid boss
	 */
	public String MensajePedirOpcion(){
		String opcion = "\n-----------------------------------------------------------------------------------------------------------------------------------\nTURNO DE " + nombre.toUpperCase() + "\n\nQue desea hacer?\n1. Atacar\n2. Usar una habilidad especial\n3. Clonar\n4. Variar\n5. Liberar\n6. Pasar turno\n7. Salir";
		return opcion;
	}
	
	/**
	 * Devuelve un String con todas las habilidades especiales que puede ejecutar el raid boss
	 * @version 17/10/2021
	 * @return Devuelve un String con todas las habilidades especiales que puede ejecutar el raid boss
	 */
	public String MensajePedirHabEspecial(){
		
		String m = "\nQue habilidad especial desea ejecutar: \n1.\tTirar un rayo electrico\n2.\tRegenerar heridas\n3.\tRealizar un super ataque";
		return m;
	}
	
	/**
	 * Devuelve un String con todas las habilidades especiales que puede heredar el raid boss al momento de crear un clon
	 * @version 17/10/2021
	 * @return Devuelve un String con todas las habilidades especiales que puede heredar el raid boss al momento de crear un clon
	 */
	public String MensajePedirHabEspecialAClonar(){
		
		String m = "\nQue habilidad especial desea que tengan los clones que cree partir de ahora: \n1.\tTirar un rayo electrico\n2.\tRegenerar heridas\n3.\tRealizar un super ataque";
		return m;
		
	}
	
	/**
	 * Ataca a un jugador
	 * @version 17/10/2021
	 * @param Atacado Jugador que esta siendo atacado
	 * @param PoderDeAtaque Puntos de vida que se le restarán al jugador.
	 */
	public void Atacar(Jugador Atacado, int PoderDeAtaque){
		
		//Se reduce la vida del Raid Boss
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
	}
	
	/**
	 * Lanza un rayo electrico a un jugador
	 * @version 17/10/2021
	 * @param Atacado Jugador que esta siendo atacado
	 * @param PoderDeAtaque Puntos de vida que se le restarán al jugador.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String LanzarRayoElectrico(Jugador Atacado, int PoderDeAtaque){
		
		//Se reduce la vida del jugador atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\nPoseidon realizo lanzo un rayo electrico en contra de " + Atacado.getNombre();
		
		return mensaje;
		
	}
	
	/**
	 * Regenera heridas del raid boss
	 * @version 17/10/2021
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String RegenerarHeridas(){
		
		//Se aumenta la vida del combatiente
		PuntosVida = PuntosVida+5;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\nPoseidon regenero sus heridas y obtuvo un +5 en su vida";
		
		return mensaje;
		
	}
	
	/**
	 * Lanza un super ataque a un jugador
	 * @version 17/10/2021
	 * @param Atacado Jugador que esta siendo atacado
	 * @param PoderDeAtaque Puntos de vida que se le restarán al jugador.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String LanzarSuperAtaque(Jugador Atacado, int PoderDeAtaque){
		
		//Se reduce la vida del jugador atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\nPoseidon realizo lanzo un super ataque en contra de " + Atacado.getNombre();
		
		return mensaje;
		
	}
	
	/**
	 * Comprueba si el rais boss esta vivo
	 * @version 17/10/2021
	 * @return Devuelve true si el raid boss tiene una vida mayor a 0, de lo contrario devuelve false.
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