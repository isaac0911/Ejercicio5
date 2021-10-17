
/**
 * Clase abstracta que modela un acompañante (Mascotas y Enemigos)
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public abstract class Acompanante implements Cloneable{
	
	/**
     * Nombre del acompañante
     */
	protected String nombre;
	
	/**
     * Poder de ataque del acompañante
     */
	protected int PoderAtaque;
	
	/**
     * Tipo al que pertenece el acompañante (Enemigo o Mascota)
     */
	protected String tipo;
	
	/**
	 * Ataca al jugador que recibe como parámetro
	 * @version 17/10/2021
	 * @param Atacado Jugador al que se atacará
	 * @param PoderAtaque Puntos de vida que se le restarán al jugador que está siendo atacado.
	 */
	public abstract void AtacarJugador(Jugador Atacado, int PoderAtaque);
	
	/**
	 * Devuelve el contenido del atributo "PoderAtaque"
	 * @version 17/10/2021
	 * @return Devuelve el poder de ataque del Acompañante
	 */
	public int getPoderAtaque(){
		return PoderAtaque;
	}
	
	/**
	 * Devuelve el contenido del atributo "Nombre"
	 * @version 17/10/2021
	 * @return Devuelve el nombre del acompañante
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve un clon del acompañante pero de tipo Object
	 * @version 17/10/2021
	 * @return Devuelve un clon del acompañante
	 */
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}