
/**
 * Modela una acompañante del raid boss, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Enemigo extends Acompanante{
	
	/**
     * Poder de vida del enemigo
     */
	private int PuntosVida;
	
	/**
	 * Instancia un enemigo
	 * @version 17/10/2021
	 * @param tipoCombatiente que indica el tipo de jugador de acompañante del que se trata (en este caso, un enemigo)
	 * @param nom Nombre del enemigo
	 */
	public Enemigo(String tipoCombatiente, String nom){
		nombre = nom;
		PuntosVida = 5;
		PoderAtaque = 2;
		tipo = "Enemigo";
	}
	
	/**
	 * Ataca a un jugador
	 * @version 17/10/2021
	 * @param Atacado Jugador al que se atacará
	 * @param PoderAtaque Puntos de vida que se le restarán al jugador.
	 */
	public void AtacarJugador(Jugador Atacado, int PoderAtaque){
		//Se reduce la vida del jugador  atacado
		int nuevosPuntosDeVida = Atacado.getPuntosVida() - PoderAtaque;
		Atacado.setPuntosVida(nuevosPuntosDeVida);
	}
	
	/**
	 * Devuelve un String que contiente el estatus del Enemigo
	 * @version 17/10/2021
	 * @return Devuelve un String con el estatus del Enemigo
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +"\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque;
		return mensaje;
	}
}