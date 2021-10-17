import java.util.Objects;

/**
 * Modela un Cazador, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */


public class Cazador extends Jugador{
	
	/**
	* Indica si el cazador tiene o no una mascota
	*/
	private boolean tieneMascota;
	
	/**
	* Número de turnos que debe esperar el cazador para poder regenerar su mascota
	*/
	private int TurnosParaTenerMascota;
	
	/**
	* Mascota del cazador
	*/
	private Mascota Mas;
	
	/**
	* Numero de veces que el cazador puede lanzar un ataque de flechas
	*/
	private int numAtaqueFlechas;
	
	/**
	 * Instancia un Cazador
	 * @version 17/10/2021
	 * @param tipoCombatiente entero que indica el tipo de jugador del que se trata, (en este caso Cazador)
	 * @param nom Nombre del Cazador
	 * @param nomMascota Nombre de la mascota del Cazador
	 * @param MenInicio Mensaje que dice el Cazador al iniciar la batalla
	 * @param MenVic Mensaje que dice el Cazador al ganar la batalla
	 * @param MenDerr Mensaje que dice el Cazador al perder la batalla
	 */
	public Cazador(String tipoCombatiente, String nom, String nomMascota, String MenInicio, String MenVic, String MenDerr){
		
		nombre = nom;
		tipo = tipoCombatiente;
		PuntosVida = 5;
		PoderAtaque = 1;
		tieneMascota = true;
		TurnosParaTenerMascota = 0;
		Mas = new Mascota(nomMascota);
		MensajeInicio = MenInicio;
		MensajeVictoria = MenVic;
		MensajeDerrota = MenDerr;
		numAtaqueFlechas = 2;
		
	}
	
	/**
	 * Ataca al raid boss
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarRaidBoss(RaidBoss Atacado, int PoderAtaque){
		
		//Ataca el cazador
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Ataca la mascota del cazador
		String mensaje = "";
		
		if(Objects.isNull(Mas)){
			mensaje = "\n" + nombre + " ataco a Poseidon. Al no disponer de una mascota, el ataque solo lo realizo " + nombre;
		}else{
			nuevosPuntosDeVida = Atacado.getPuntosVida() - Mas.getPoderAtaque();
			Atacado.setPuntosVida(nuevosPuntosDeVida);
			mensaje = "\n" + nombre + " ataco a Poseidon. Su mascota hizo lo mismo";
		}
		
		return mensaje;
	}
	
	/**
	 * Devuelve un String que contiente el estatus del Cazador
	 * @version 17/10/2021
	 * @return Devuelve un String con el estatus del Cazador
	 */
	public String toString(){
		
		String mensaje = "";
		String PoseeMascota;
		
		if(tieneMascota){
			
			String NombreMascota = Mas.getNombre();
			
			PoseeMascota = "Si";
			mensaje = "\nNombre: " + nombre +  "\n\tTipo: " + tipo  + "\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tAtaques de flechas disponibles: " + numAtaqueFlechas + "\n\tPosee una mascota: " + PoseeMascota + "\n\tNombre de la mascota: " + NombreMascota;
		}else{
			PoseeMascota = "No";
			int turnosQueFaltan = 3-TurnosParaTenerMascota;
			mensaje = "\nNombre: " + nombre +  "\n\tTipo: " + tipo  + "\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tAtaques de flechas disponibles: " + numAtaqueFlechas + "\n\tPosee una mascota: " + PoseeMascota + "\n\tTurnos que deben pasar para que pueda tener una mascota: " + turnosQueFaltan;
		}
		return mensaje;
	}
	
	/**
	 * Devuelve un String que contiene todos los items de los que dispone un Cazador
	 * @version 17/10/2021
	 * @return Devuelve un String con todos los items de un Cazador
	 */
	public String MensajePedirItem(){
		
		String m = "\nQue item desea ejecutar: \n1.\tLanzar mascota\n2.\tLanzar ataque de flechas";
		return m;
	}
	
	/**
	 * Devuelve el contenido del atributo "numAtaqueFlechas"
	 * @version 17/10/2021
	 * @return Devuelve el número de veces que el cazador puede lanzar un ataque de flechas
	 */
	public int getnumAtaqueFlechas(){
		return numAtaqueFlechas;
	}
	
	/**
	 * Devuelve el contenido del atributo "Mas"
	 * @version 17/10/2021
	 * @return Devuelve a la mascota del cazador
	 */
	public Mascota getMas(){
		return Mas;
	}
	
	/**
	 * Asigna una nueva mascota al cazador
	 * @version 17/10/2021
	 * @param Masc Nueva mascota del cazador
	 */
	public void setMas(Mascota Masc){
		Mas = Masc;
	}
	
	/**
	 * Lanza un ataque de flechas
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @param PoderAtaque Puntos de vida que se le restarán al raid boss. 
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String LanzarAtaqueFlechas(RaidBoss Atacado, int PoderAtaque){
		
		//El cazador lanza el ataque de flechas
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//La mascota lanza ataque de flechas, si es que esta existe
		String mensaje = "";
		
		if(Objects.isNull(Mas)){
			mensaje = "\n" + nombre + " lanzo un ataque de flechas en contra de Poseidon. Al no disponer de una mascota, el ataque solo lo realizo " + nombre;
		}else{
			nuevosPuntosDeVida = Atacado.getPuntosVida() - 1;
			Atacado.setPuntosVida(nuevosPuntosDeVida);
			mensaje = "\n" + nombre + " lanzo un ataque de flechas en contra de Poseidon. Su mascota hizo lo mismo";
		}
		
		return mensaje;
		
	}
	
	/**
	 * Lanza a la mascota del cazador
	 * @version 17/10/2021
	 * @param Atacado Es el raid boss
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String LanzarMascota(RaidBoss Atacado){
		
		//Se le quita la mascota al cazador
		tieneMascota = false;
		TurnosParaTenerMascota=0;
		
		//Se obtiene el poder de la mordida de la mascota
		int PoderAtaque = Mas.getPoderMordida();
		
		//Eliminar a la mascota
		Mas = null;
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + nombre + " lanzo a su mascota, y esta mordio a Poseidon. Lamentablemente, la mascota murio";
		
		return mensaje;
		
	}
	
	/**
	 * Devuelve el contenido del atributo "tieneMascota"
	 * @version 17/10/2021
	 * @return Devuelve true si el cazador tiene una mascota, de lo contrario, devuelve false
	 */
	public boolean getTieneMascota(){
		return tieneMascota;
	}
	
	/**
	 * Cambia el valor del atributo "TurnosParaTenerMascota"
	 * @version 17/10/2021
	 * @param num entero que indica si se debe aumentar en uno el valor del atributo "TurnosParaTenerMascota", o si se debe inicializar el mismo a 0
	 */
	public void setTurnosParaTenerMascota(int num){
		if (num==0){
			TurnosParaTenerMascota = 0;
		}else{
			TurnosParaTenerMascota++;
		}
	}
	
	/**
	 * Devuelve el contenido del atributo "TurnosParaTenerMascota"
	 * @version 17/10/2021
	 * @return Devuelve el número de turnos que faltan para que el cazador pueda regenerar su mascota
	 */
	public int getTurnosParaTenerMascota(){
		return TurnosParaTenerMascota;
	}
	
	/**
	 * Cambia el valor del atributo "tieneMascota"
	 * @version 17/10/2021
	 * @param num entero que indica si se debe establecer el valor del atributo "tieneMascota" como false o true
	 */
	public void setTieneMascota(int num){
		if(num==1){
			tieneMascota=true;
		}else if(num==0){
			tieneMascota=false;
		}
	}
	
}