
/**
 * Modela una mascota, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Mascota extends Acompanante{
	
	/**
     * Poder de la mordida de la mascota
     */
	private int PoderMordida;
	
	/**
	 * Instancia una mascota
	 * @version 17/10/2021
	 * @param nom Nombre de la mascota
	 */
	public Mascota(String nom){
		nombre = nom;
		PoderMordida = 1;
		PoderAtaque = 1;
		tipo = "mascota";
	}
	
	/**
	 * Ataca a un jugador cuando actúa como clon del raid boss
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
	 * Devuelve el contenido del atributo "PoderMordida"
	 * @version 17/10/2021
	 * @return Devuelve el poder de la mordida de la mascota
	 */
	public int getPoderMordida(){
		return PoderMordida;
	}
	
}