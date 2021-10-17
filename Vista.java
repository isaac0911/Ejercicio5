import java.util.Scanner;
import java.util.ArrayList;

/**
 * Muestra mensajes en pantalla y recibe datos a través del teclado.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Vista{
	
	/**
	 * Muestra el mensaje de Bienvenida.
	 * @version 17/10/2021
	 */
	public void MensajeBienvenida(){
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nBIENVENIDO AL SISTEMA DE BATALLAS RAID\n-----------------------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Muestra el mensaje de Despedida.
	 * @version 17/10/2021
	 */
	public void MensajeDespedida(){
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nGraciar por jugar. Feliz dia.\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * Muestra el String que recibe como parámetro.
	 * @version 17/10/2021
	 * @param mensaje Conjunto de caracteres que se deseea mostrar en pantalla.
	 */
	public void MostrarMensaje (String mensaje){
		System.out.println(mensaje);
	}
	
	/**
	 * Pide al usuario que ingrese el número de jugadores que desea crear
	 * @version 17/10/2021
	 * @return Devuelve el número de jugadores que el usuario desea crear
	 */
	public int PedirNumJugadores(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nCuantos jugadores desea crear para luchar contra Poseidon?");
		System.out.println("1. Uno");
		System.out.println("2. Dos");
		System.out.println("3. Tres");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
	}
	
	/**
	 * Pide al usuario el tipo de jugador a crear
	 * @version 17/10/2021
	 * @param numJugador Correlativo del jugador que se esta creando
	 * @return Devuelve un número que indica el tipo de jugador que desea crear el usuario
	 */
	public int PedirTipoJugador(int numJugador){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		if (numJugador==1){
			System.out.println("\nQue tipo de jugador sera el primero?");
		}else if(numJugador==2){
			System.out.println("\nQue tipo de jugador sera el segundo?");
		}else if(numJugador==3){
			System.out.println("\nQue tipo de jugador sera el tercero?");
		}
		System.out.println("1. Guerrero");
		System.out.println("2. Explorador");
		System.out.println("3. Cazador");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra las opciones que puede realizar el jugador y se pregunta al usuario cuál desea ejecutar.
	 * @version 17/10/2021
	 * @param nombre Nombre del combatiente cuyo turno está en curso.
	 * @return Devuelve el número que corresponde con la opción ingresada por el usuario.
	 */
	public int MostrarOpciones(String nombre){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nTURNO DE " + nombre.toUpperCase() + "\n\nQue desea hacer?");
		System.out.println("1. Atacar");
		System.out.println("2. Usar un item");
		System.out.println("3. Pasar turno");
		System.out.println("4. Salir");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
	}
	
	/**
	 * Muestra las opciones que puede realizar el raid boss y se pregunta al usuario cuál desea ejecutar.
	 * @version 17/10/2021
	 * @param nombre Nombre del Raid boss.
	 * @param opciones String que indica las acciones que puede hacer el raid boss
	 * @return Devuelve el número que corresponde con la opción ingresada por el usuario.
	 */
	public int MostrarOpcionesRaidBoss(String nombre, String opciones){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println(opciones);
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>7){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 7.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra las posibles víctimas del ataque y se le pregunta al raid boss a cuál desea atacar.
	 * @version 17/10/2021
	 * @param Jugadores ArrayList que contiente a todos los jugadores que estan en la batalla
	 * @return Devuelve el número que corresponde con la posicion que ocupa el jugador elegido dentro del ArrayList de Jugadores
	 */
	public int PedirJugadorAAtacar (ArrayList<Jugador> Jugadores){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue jugador desea atacar?");
		for (int i = 0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			System.out.println(i+1 + "\t" + Juga.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Jugadores.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Jugadores.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
	}
	
	/**
	 * Muestra las posibles víctimas del ataque y se le pregunta al raid boss a cuál le desea lanzar un rayo electrico.
	 * @version 17/10/2021
	 * @param Jugadores ArrayList que contiente a todos los jugadores que estan en la batalla
	 * @return Devuelve el número que corresponde con la posicion que ocupa el jugador elegido dentro del ArrayList de Jugadores
	 */
	public int PedirJugadorALanzarRayoElectrico (ArrayList<Jugador> Jugadores){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nA que jugador desea lanzarle el rayo electrico?");
		for (int i = 0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			System.out.println(i+1 + "\t" + Juga.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Jugadores.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Jugadores.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
	}
	
	/**
	 * Muestra las posibles víctimas del ataque y se le pregunta al raid boss a cuál le desea realizar un super ataque
	 * @version 17/10/2021
	 * @param Jugadores ArrayList que contiente a todos los jugadores que estan en la batalla
	 * @return Devuelve el número que corresponde con la posicion que ocupa el jugador elegido dentro del ArrayList de Jugadores
	 */
	public int PedirJugadorARealizarSuperAtaque (ArrayList<Jugador> Jugadores){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nA que jugador desea lanzarle un super ataque?");
		for (int i = 0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			System.out.println(i+1 + "\t" + Juga.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Jugadores.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Jugadores.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
	}
	
	/**
	 * Muestra todos los items o habilidades especiales con los que cuenta el partipante y se le pide al usaurio que ingrese el que desea aplicar.
	 * @version 17/10/2021
	 * @param mensaje String que contiene todas los items o hablidades especiales con los que cuenta el combatiente.
	 * @param numOpciones Numero de items o habilidades especiales de los que dispone el combatiente
	 * @return Devuelve el número que corresponde con el item o habilidad especial ingresada por el usuario.
	 */
	public int PedirItem(String mensaje, int numOpciones){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println(mensaje);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>numOpciones){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + numOpciones + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra todos los acompañantes que están en batalla y se le pide al raid boss a cual desea clonar.
	 * @version 17/10/2021
	 * @param AcompanantesDelRaidBoss ArrayList que contiene a los acompanantes del RaidBoss.
	 * @param MascotasDeLosCazadores ArrayList que contiene a las mascotas de los cazadores.
	 * @return Devuelve un arrayList en el que la primera posicion contiene un entero que indica si se clonará una mascota o un acompañante, y la segunda contiene un entero que indica cual de ellos es.
	 */
	public ArrayList<Integer> PedirAcompananteAClonar(ArrayList<Acompanante> AcompanantesDelRaidBoss, ArrayList<Acompanante> MascotasDeLosCazadores){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nA quien desea clonar?");
		
		if (AcompanantesDelRaidBoss.size()>0){
			System.out.println("\tAcompanantes:");
			for (int i=0; i<AcompanantesDelRaidBoss.size(); i++){
				Acompanante Acom = AcompanantesDelRaidBoss.get(i);
				int num = i+1;
				System.out.println("\t" + num + ".\t" + Acom.getNombre());
			}
		}
		
		if (MascotasDeLosCazadores.size()>0){
			System.out.println("\tMascotas:");
			for (int i=0; i<MascotasDeLosCazadores.size(); i++){
				Acompanante Acom = MascotasDeLosCazadores.get(i);
				int num = AcompanantesDelRaidBoss.size()+i+1;
				System.out.println("\t" + num + ".\t" + Acom.getNombre());
			}
		}
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>(AcompanantesDelRaidBoss.size()+MascotasDeLosCazadores.size())){
			int num = AcompanantesDelRaidBoss.size() + MascotasDeLosCazadores.size();
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + num + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		int tipo = -1;
		int posicion = -1;
		int num = AcompanantesDelRaidBoss.size() + MascotasDeLosCazadores.size();
		
		if (numero<=AcompanantesDelRaidBoss.size()){
			
			tipo = 1;
			posicion = numero-1;
			
		}else if(numero>AcompanantesDelRaidBoss.size()){
			
			tipo = 2;
			
			posicion = numero-AcompanantesDelRaidBoss.size()-1;
			
		}
		
		ArrayList<Integer> Datos = new ArrayList<Integer>();
		Datos.add(tipo);
		Datos.add(posicion);
		
		return Datos;
		
	}
	
	/**
	 * Muestra todas las habilidades especiales con que cuenta el raid boss y se le pide que ingrese cual de ellas desea que tengan sus clones.
	 * @version 17/10/2021
	 * @param mensaje String que contiene todas las habilidades especiales del raid boss
	 * @return Devuelve un entero que indica la habilidad especial que se escogió.
	 */
	public int PedirHabilidadEspecialAClonar(String mensaje){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println(mensaje);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Verifica si el valor que recibe como parámetro es un entero.
	 * @version 17/10/2021
	 * @param conjuntoCaracteres Valor del cual se verificará si es un entero o no.
	 * @return Devuelve true si el valor recibido como parámetro es un entero, de lo contrario, devuelve false
	 */
	private static boolean comprobarNumero(String conjuntoCaracteres){
		try{
			//Se trata de convertir el objeto de tipo String a tipo int
			Integer.parseInt(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
}