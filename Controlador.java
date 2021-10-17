import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.util.Arrays;

/**
 * Comunica a la Vista con el Modelo y viceversa.
 * 
 * @author Isaac Solórzano Q.
 * @version 17/10/2021
 */

public class Controlador{
	
	private Vista v;
	private ArrayList<String> UltimasTresAcciones;
	
	/**
	 * Instancia un objeto de tipo Controlador.
	 * @version 17/10/2021
	 */
	public Controlador(){
		v = new Vista();
		UltimasTresAcciones = new ArrayList<String>();
	}
	
	/**
	 * Es uno de los métodos principales. Crea al Raid Boss, sus acompañantes y alos jugadores. Además, manda a ejecutar el metodo "CicloGeneral"
	 * @version 17/10/2021
	 */
	public void ciclo(){
		
		ArrayList<Acompanante> Clones = new ArrayList<Acompanante>();
		ArrayList<Acompanante> AcompanantesDelRaidBoss = new ArrayList<Acompanante>();
		ArrayList<Acompanante> MascotasDeLosCazadores = new ArrayList<Acompanante>();
		ArrayList<Jugador> Jugadores = new ArrayList<Jugador>();
		
		v.MensajeBienvenida();	
		
		//Generar Raid Boss
		
		String mensaje = "GENERANDO RAID BOSS...";
		v.MostrarMensaje(mensaje);
		
		String nombre = "Poseidon: Guardian de los siete mares";
		RaidBoss SuperJefe = new RaidBoss(nombre);
		
		mensaje = "\nLos datos del Raid Boss son:";
		v.MostrarMensaje(mensaje);
		
		mensaje = SuperJefe.toString();
		v.MostrarMensaje(mensaje);
		
		//Generar Acompañantes del Raid Boss
		
		mensaje = "\nGENERANDO ACOMPANANTES DE POSEIDON...";
		v.MostrarMensaje(mensaje);
		
		ArrayList<String> NombresAcompanantes = new ArrayList<>(Arrays.asList("Bulbasaur","Ivysaur"));
		
		int Aleatorio = (int)(Math.random()*(3));
		
		for (int i=0; i<Aleatorio; i++){
			Acompanante Ene = new Enemigo("Enemigo", NombresAcompanantes.get(i));
			AcompanantesDelRaidBoss.add(Ene);
		}
		
		if(Aleatorio>=1){
			mensaje = "\nSe han generado " + Aleatorio + " acompanantes, estos son:";
			v.MostrarMensaje(mensaje);
			
			for (int i=0; i<AcompanantesDelRaidBoss.size(); i++){
				Acompanante Ene = AcompanantesDelRaidBoss.get(i);
				mensaje = Ene.toString();
				v.MostrarMensaje(mensaje);
			}
		}else{
			mensaje = "\nNo se ha generado ningun acompanante para Poseidon.";
			v.MostrarMensaje(mensaje);
		}
		
		
		//Generar Jugadores
		
		ArrayList<String> NombresJugadores = new ArrayList<>(Arrays.asList("Squirtle","Wartortle","Charmeleon"));
		ArrayList<String> NombresMascotas = new ArrayList<>(Arrays.asList("Voltorb", "Electrode","Exeggcute", "Exeggutor", "Exeggutor de Alola", "Cubone", "Marowak", "Marowak de Alola", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Weezing de Galar", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Mr. Mime de Galar", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeo", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Articuno de Galar", "Zapdos", "Zapdos de Galar", "Moltres", "Moltres de Galar", "Dratin2","Dragonair","Dragonite", "Mewtwo","Mew", "Pikachu","Nidoran","Zubat"));
		ArrayList<String> MensajesInicio = new ArrayList<>(Arrays.asList("Hagamos esto!","Que empieze la accion!","A pelear!"));
		ArrayList<String> MensajesVictoria = new ArrayList<>(Arrays.asList("A eso le llamo ganar!","Nunca pense que un Dios griego fuese tan debil","Que dulce es el sabor de la victoria"));
		ArrayList<String> MensajesDerrota = new ArrayList<>(Arrays.asList("Nooo, no puede ser!","Hoy estabas de suerte, Poseidon","A la proxima no escaparas"));
		
		mensaje = "\nHA LLEGADO LA HORA DE GENERAR LOS JUGADORES...";
		v.MostrarMensaje(mensaje);
		
		int numJugadores = v.PedirNumJugadores();
		
		mensaje = "\nGENERANDO JUGADORES...";
		
		for(int i=0; i<numJugadores; i++){
			
			int TipoJugador = v.PedirTipoJugador(i+1);
			
			String MensajeInicio;
			String MensajeVictoria;
			String MensajeDerrota;
			
			if(TipoJugador==1){
				//Crear un guerrero
				nombre = NombresJugadores.get(i);
				
				MensajeInicio = MensajesInicio.get(0);
				MensajesInicio.remove(0);
				
				MensajeVictoria = MensajesVictoria.get(0);
				MensajesVictoria.remove(0);
				
				MensajeDerrota = MensajesDerrota.get(0);
				MensajesDerrota.remove(0);
				
				Jugador Juga = new Guerrero(1, nombre, MensajeInicio, MensajeVictoria, MensajeDerrota);
				Jugadores.add(Juga);
			}else if (TipoJugador==2){
				//Crear un explorador
				nombre = NombresJugadores.get(i);
				
				MensajeInicio = MensajesInicio.get(0);
				MensajesInicio.remove(0);
				
				MensajeVictoria = MensajesVictoria.get(0);
				MensajesVictoria.remove(0);
				
				MensajeDerrota = MensajesDerrota.get(0);
				MensajesDerrota.remove(0);
				
				Jugador Juga = new Explorador(2, nombre, MensajeInicio, MensajeVictoria, MensajeDerrota);
				Jugadores.add(Juga);
			}else if (TipoJugador==3){
				//Crear un cazador
				nombre = NombresJugadores.get(i);
				
				MensajeInicio = MensajesInicio.get(0);
				MensajesInicio.remove(0);
				
				MensajeVictoria = MensajesVictoria.get(0);
				MensajesVictoria.remove(0);
				
				MensajeDerrota = MensajesDerrota.get(0);
				MensajesDerrota.remove(0);
				
				String nombreMascota = NombresMascotas.get(0);
				NombresMascotas.remove(0);
				Jugador Juga = new Cazador("Cazador", nombre, nombreMascota, MensajeInicio, MensajeVictoria, MensajeDerrota);
				
				Cazador Cazad = (Cazador) Juga;
				
				Mascota Mascot = Cazad.getMas();
				MascotasDeLosCazadores.add(Mascot);
				
				Jugadores.add(Juga);
			}
			
		}
		
		mensaje = "\nSe han generado " + numJugadores + " jugadores, estos son:";
		v.MostrarMensaje(mensaje);
			
		for (int i=0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			mensaje = Juga.toString();
			v.MostrarMensaje(mensaje);
		}
		
		//Mostrar mensajes de los jugadores al iniciar la batalla
		mensaje = ("\n-----------------------------------------------------------------------------------------------------------------------------------");
		v.MostrarMensaje(mensaje);
		
		for(int i=0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			mensaje = Juga.MensajeInicio();
			v.MostrarMensaje(mensaje);
		}
		
		mensaje = SuperJefe.MensajeInicio();
		v.MostrarMensaje(mensaje);
		
		mensaje = ("-----------------------------------------------------------------------------------------------------------------------------------");
		
		//Mostrar mensaje de bienvenida a la batalla
		mensaje = ("-----------------------------------------------------------------------------------------------------------------------------------\n\nQUE COMIENZE LA BATALLA!!");
		v.MostrarMensaje(mensaje);
		
		CicloGeneral(SuperJefe, Clones, AcompanantesDelRaidBoss, Jugadores, NombresMascotas, MascotasDeLosCazadores);
	}
	
	/**
	 * Contiene el ciclo en el que se mantendrá el flujo del programa hasta que el usuario decida salir.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Clones ArrayList que contiene a todos los clones con los que cuenta el Raid Boss.
	 * @param AcompanantesDelRaidBoss ArrayList que contiene a los acompanantes del RaidBoss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @param NombresMascotas ArrayList que contiene lo nombres de todas las mascotas.
	 * @param MascotasDeLosCazadores ArrayList que contiene a las mascotas de los cazadores.
	 */
	private void CicloGeneral(RaidBoss SuperJefe, ArrayList<Acompanante> Clones, ArrayList<Acompanante> AcompanantesDelRaidBoss, ArrayList<Jugador> Jugadores, ArrayList<String> NombresMascotas, ArrayList<Acompanante> MascotasDeLosCazadores){
		
		int numParticipantes = Jugadores.size()+1;
		
		boolean validacion = true;
		String s = "NO";
		
		int posicion = -1;
		
		ArrayList<Jugador> JugadoresIniciales = new ArrayList<Jugador>();
		
		for(int i=0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			JugadoresIniciales.add(Juga);
		}
		
		while (validacion && s != "Salir"){
			
			posicion++;
			
			if(posicion>=numParticipantes){
				posicion = 0;
			}
			
			if (posicion<numParticipantes-1){
				
				TurnoJugador(SuperJefe, Jugadores.get(posicion), MascotasDeLosCazadores, NombresMascotas);
				
			}else if (posicion == numParticipantes-1){
				TurnoRaidBoss(SuperJefe, Clones, AcompanantesDelRaidBoss, Jugadores, MascotasDeLosCazadores);
			}
			
			s = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			UltimasTresAcciones.remove(UltimasTresAcciones.size()-1);
			
			if (s != "Salir"){
				MandarAMostrarEstadoParticipantes(Jugadores, SuperJefe);
				if(UltimasTresAcciones.size()>0){
					MandarAMostrarUltimasTresAcciones(UltimasTresAcciones);
				}
				
			}
			
			validacion = validarSuperJefeEstaVivoYHayUnJugadorVivo(SuperJefe, Jugadores);
			
			boolean HayUnMuerto = ComprobarSiHayUnJugadorMuerto(Jugadores);
			if(HayUnMuerto){
				
				int posicionJugaMuerto = -1;
				
				for (int i=0; i<Jugadores.size(); i++){
					Jugador Juga = Jugadores.get(i);
					if(!Juga.ComprobarVivo()){
						posicionJugaMuerto = i;
					}
				}
				
				Jugador JugaMuerto = Jugadores.get(posicionJugaMuerto);
				Jugadores.remove(posicionJugaMuerto);
				
				String mensaje = "\n*****************************************************\n\n" + JugaMuerto.getNombre() + " ha muerto.";
				v.MostrarMensaje(mensaje);
				numParticipantes--;
			}
			
		}
		
		if(s == "Salir"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nGraciar por jugar. Feliz dia.\n-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}else{
			MostrarAlGanador(SuperJefe, JugadoresIniciales);
		}
		
	}
	
	/**
	 * Manda a mostrar el status de todos participante luego de cada turno
	 * @version 17/10/2021
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @param SuperJefe Representa al Raid Boss.
	 */
	private void MandarAMostrarEstadoParticipantes(ArrayList<Jugador> Jugadores, RaidBoss SuperJefe){
		
		String mensaje = "\n*****************************************************\n\nEl nuevo estatus de cada competidor es el siguiente: ";
		v.MostrarMensaje(mensaje);
		//Se muestra el status de cada combatiente
		for(int i = 0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			mensaje = Juga.toString();
			v.MostrarMensaje(mensaje);
		}
		
		mensaje = SuperJefe.toString();
		v.MostrarMensaje(mensaje);
		
	}
	
	/**
	 * Manda a mostrar las ultimas tres acciones que han sido tomadas en el juego
	 * @version 17/10/2021
	 * @param UltimasTresAcciones ArrayList que contiene, redactadas en formato String, las tres ultimas acciones que han sido tomadas
	 */
	private void MandarAMostrarUltimasTresAcciones(ArrayList<String> UltimasTresAcciones){
		
		String mensaje = "\n*****************************************************\n\nLas ultimas acciones que han sido tomadas en el juego, desde la mas antigua a la mas reciente, son las siguientes: ";
		v.MostrarMensaje(mensaje);
		
		//Se asegura que solo se vayan a mostrar, como máximo, tres acciones
		while (UltimasTresAcciones.size()>3){
			UltimasTresAcciones.remove(0);
		}
		
		//Se muestran las últimas acciones ejecutadas
		for (int i = 0; i<UltimasTresAcciones.size();i++){
			mensaje = UltimasTresAcciones.get(i);
			mensaje = "-\t" + mensaje.substring(1, mensaje.length());
			v.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Verifica que el Raid Boss esta vivo y que por lo menos hay un jugador vivo. Esto para garantizar que el juego aun no ha terminado
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @return Devuelve true si el raid boss esta vivo y hay por lo menor un jugador vivo, de lo contrario, devuelve false.
	 */
	private boolean validarSuperJefeEstaVivoYHayUnJugadorVivo(RaidBoss SuperJefe, ArrayList<Jugador> Jugadores){
		
		boolean validacion = true;
		
		//Se comprueba que Poseidon sigue vivo
		if (!SuperJefe.ComprobarVivo()){
			validacion = false;
		}
		
		//Se comprueba que los jugadores estén vivos
		int numJugadoresMuertos = 0;
		int numJugadores = Jugadores.size();
		for (int i=0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			if(!Juga.ComprobarVivo()){
				numJugadoresMuertos++;
			}
		}
		if(numJugadoresMuertos==numJugadores){
			validacion = false;
		}
		
		return validacion;
	}
	
	/**
	 * Verifica si hay algun jugador cuya vida sea menor o igual a 0, esto para sacarlo de la partida y que este ya no tenga turno en el juego.
	 * @version 17/10/2021
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @return Devuelve true si hay un jugador cuya vida es menor o igual a 0, de lo contrario, devuelve false.
	 */
	private boolean ComprobarSiHayUnJugadorMuerto(ArrayList<Jugador> Jugadores){
		
		boolean v = false;
		int numJugadoresMuertos = 0;
		for (int i=0; i<Jugadores.size(); i++){
			Jugador Juga = Jugadores.get(i);
			if(!Juga.ComprobarVivo()){
				numJugadoresMuertos++;
			}
		}
		if(numJugadoresMuertos>0){
			v = true;
		}
		
		return v;
		
	}
	
	/**
	 * Manda a mostrar en pantalla quién ganó y los mensajes de Victoria o Derrota de cada participante, según sea el caso.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param JugadoresIniciales ArrayList que contiene a todos los jugadores que existian al inicio del juego.
	 */
	private void MostrarAlGanador (RaidBoss SuperJefe, ArrayList<Jugador> JugadoresIniciales){
		String Ganador = "Jugadores";
		
		//Comprobar si el que gano fue el jugador
		if (SuperJefe.ComprobarVivo()){
			Ganador = "Poseidon";
		}
		
		//Mandar a mostrar mensaje de quien fue el ganador
		if (Ganador == "Poseidon"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nEL GANADOR ES: POSEIDON!!!\n-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
			//Mostrar los mensajes de victoria y derrota de cada combatiente
			mensaje = SuperJefe.MensajeVictoria();
			v.MostrarMensaje(mensaje);
			for (int i=0; i<JugadoresIniciales.size(); i++){
				Jugador Juga = JugadoresIniciales.get(i);
				mensaje = Juga.MensajeDerrota();
				v.MostrarMensaje(mensaje);
			}
			mensaje = "-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}else if(Ganador == "Jugadores"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nGANARON LOS JUGADORES!!!\n-----------------------------------------------------------------------------------------------------------------------------------n";
			v.MostrarMensaje(mensaje);
			//Mostrar los mensajes de victoria y derrota de cada combatiente
			mensaje = SuperJefe.MensajeDerrota();
			v.MostrarMensaje(mensaje);
			for (int i=0; i<JugadoresIniciales.size(); i++){
				Jugador Juga = JugadoresIniciales.get(i);
				mensaje = Juga.MensajeVictoria();
				v.MostrarMensaje(mensaje);
			}
			mensaje = "-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}
	}
	
	/**
	 * Evalua el tipo de Jugador cuyo turno está en curso y manda a ejecutar el método correspondiente al turno del mismo.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Juga Jugador cuyo turno esta en curso
	 * @param MascotasDeLosCazadores ArrayList que contiene a las mascotas de los cazadores.
	 * @param NombresMascotas ArrayList que contiene lo nombres de todas las mascotas.
	 */
	private void TurnoJugador(RaidBoss SuperJefe, Jugador Juga, ArrayList<Acompanante> MascotasDeLosCazadores, ArrayList<String> NombresMascotas){
		
		String tipoJugador = Juga.getTipo();
		
		if (tipoJugador=="Guerrero"){
			TurnoGuerrero(SuperJefe, Juga);
		}else if(tipoJugador=="Explorador"){
			TurnoExplorador(SuperJefe, Juga);
		}else if(tipoJugador=="Cazador"){
			TurnoCazador(SuperJefe, Juga, MascotasDeLosCazadores, NombresMascotas);
		}
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el Guerrero y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Juga Jugador cuyo turno esta en curso
	 */
	private void TurnoGuerrero(RaidBoss SuperJefe, Jugador Juga){
		
		String nombre = Juga.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpciones(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		if (opcion == 1){
			//Si desea atacar
			
			int PoderDeAtaque = Juga.getPoderAtaque();
			String accion = Juga.AtacarRaidBoss(SuperJefe, PoderDeAtaque);
			UltimasTresAcciones.add(accion);
			String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			v.MostrarMensaje(mensaje);
			
		}else if(opcion == 2){
			//Si desea usar item
			String mensaje = Juga.MensajePedirItem();
			//Se manda a preguntar qué item desea ejecutar
			int numItem = v.PedirItem(mensaje, 2);
			
			Guerrero Guerr = (Guerrero) Juga;
			
			if (numItem == 1){
				//Si desea aumentar puntos de vida
				if (Guerr.getnumRecuperarPuntosDeVida()>0){
					String accion = Guerr.RecuperarPuntosDeVida();
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Guerr.getNombre() + " ya no cuenta con hongos para recuperar vidas.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 2){
				//Si desea realizar un doble ataque
				if (Guerr.getnumUsarDobleAtaque()>0){
					int PoderDeAtaque = 2*Guerr.getPoderAtaque();
					String accion = Guerr.AtacarDoble(SuperJefe, PoderDeAtaque);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Guerr.getNombre() + " ha realizado todos los ataques dobles con lo que contaba.";
					v.MostrarMensaje(mensaje);
				}
			}
		}
		UltimasTresAcciones.add(s);
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el explorador y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Juga Jugador cuyo turno esta en curso
	 */
	private void TurnoExplorador(RaidBoss SuperJefe, Jugador Juga){
		
		Explorador Exp = (Explorador) Juga;
		
		String nombre = Exp.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpciones(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		if (opcion == 1){
			//Si desea atacar
			
			int PoderDeAtaque = Exp.getPoderAtaque();
			String accion = Exp.AtacarRaidBoss(SuperJefe, PoderDeAtaque);
			UltimasTresAcciones.add(accion);
			String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			v.MostrarMensaje(mensaje);
			
		}else if(opcion == 2){
			//Si desea ejecutar algun item
			String mensaje = Exp.MensajePedirItem();
			int numItem = v.PedirItem(mensaje, 4);
			if (numItem == 1){
				//Si desea recuperar puntos de vida
				if (Exp.getnumRecuperarPuntosDeVida()>0){
					String accion = Exp.RecuperarPuntosDeVida();
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Exp.getNombre() + " ya no cuenta con hongos para recuperar vidas.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 2){
				//Si desea realizar un doble ataque
				if (Exp.getnumUsarDobleAtaque()>0){
					int PoderDeAtaque = 2*Exp.getPoderAtaque();
					String accion = Exp.AtacarDoble(SuperJefe, PoderDeAtaque);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Exp.getNombre() + " ha realizado todos los ataques dobles con lo que contaba.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 3){
				//Si desea lanzar una bola de fuego
				if (Exp.getnumBolaDeFuego()>0){
					int PoderDeAtaque = 3;
					String accion = Exp.AtacarConBolaDeFuego(SuperJefe, PoderDeAtaque);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Exp.getNombre() + " se ha gastado todas sus bolas de fuego.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 4){
				//Si desea usar un escudo de inmunidad
				if (Exp.getnumEnvenenar()>0){
					int PoderDeAtaque = 2;
					String accion = Exp.Envenenar(SuperJefe, PoderDeAtaque);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Exp.getNombre() + " ya ha utilizado todos los venenos de los que disponia.";
					v.MostrarMensaje(mensaje);
				}
			}
		}
		
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el cazador y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Juga Jugador cuyo turno esta en curso
	 * @param MascotasDeLosCazadores ArrayList que contiene a las mascotas de los cazadores.
	 * @param NombresMascotas ArrayList que contiene lo nombres de todas las mascotas.
	 */
	private void TurnoCazador (RaidBoss SuperJefe, Jugador Juga, ArrayList<Acompanante> MascotasDeLosCazadores, ArrayList<String> NombresMascotas){
		
		Cazador Caza = (Cazador) Juga;
		
		if (!Caza.getTieneMascota()){
			Caza.setTurnosParaTenerMascota(1);
			if(Caza.getTurnosParaTenerMascota() == 3){
				Caza.setTurnosParaTenerMascota(0);
				Caza.setTieneMascota(1);
				Mascota Masc = Caza.getMas();
				
				String nombreMascota = NombresMascotas.get(0);
				NombresMascotas.remove(0);
				
				Masc = new Mascota(nombreMascota);
				Caza.setMas(Masc);
				MascotasDeLosCazadores.add(Masc);
			}
		}
		
		String nombre = Caza.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpciones(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		if (opcion == 1){
			//Si desea atacar
			
			int PoderDeAtaque = Caza.getPoderAtaque();
			String accion = Caza.AtacarRaidBoss(SuperJefe, PoderDeAtaque);
			UltimasTresAcciones.add(accion);
			String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			v.MostrarMensaje(mensaje);
			
		}else if(opcion == 2){
			//Si desea usar item
			String mensaje = Caza.MensajePedirItem();
			//Se manda a preguntar qué item desea ejecutar
			int numItem = v.PedirItem(mensaje, 2);
			
			if (numItem == 1){
				//Si desea lanzar a su mascota
				if (Caza.getTieneMascota()){
					
					Mascota Masc = Caza.getMas();
					
					for (int i=0; i<MascotasDeLosCazadores.size(); i++){
						Acompanante Acomp = MascotasDeLosCazadores.get(i);
						Mascota Ma = (Mascota) Acomp;
						if (Masc.equals(Ma)){
							MascotasDeLosCazadores.remove(i);
						}
					}
					
					String accion = Caza.LanzarMascota(SuperJefe);
					
					
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
					
				}else{
					mensaje = "\nNo se puede realizar esta accion ya que actualmente " + Caza.getNombre() + " no dispone de una mascota. Para disponer de la misma, debe esperar " + (3-Caza.getTurnosParaTenerMascota()) + " turnos";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 2){
				//Si desea lanzar un ataque de flechas
				if (Caza.getnumAtaqueFlechas()>0){
					int PoderDeAtaque = 3;
					String accion = Caza.LanzarAtaqueFlechas(SuperJefe, PoderDeAtaque);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Caza.getNombre() + " ha realizado todos los ataques de flechas de los que disponia.";
					v.MostrarMensaje(mensaje);
				}
			}
		}
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el raid boss y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Clones ArrayList que contiene a todos los clones con los que cuenta el Raid Boss.
	 * @param AcompanantesDelRaidBoss ArrayList que contiene a los acompanantes del RaidBoss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @param MascotasDeLosCazadores ArrayList que contiene a las mascotas de los cazadores.
	 */
	private void TurnoRaidBoss(RaidBoss SuperJefe, ArrayList<Acompanante> Clones, ArrayList<Acompanante> AcompanantesDelRaidBoss, ArrayList<Jugador> Jugadores, ArrayList<Acompanante> MascotasDeLosCazadores){
		
		String nombre = SuperJefe.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		String opciones = SuperJefe.MensajePedirOpcion();
		int opcion = v.MostrarOpcionesRaidBoss(nombre, opciones);
		
		String s = "o";
		if (opcion == 7){
			s = "Salir";
		}
		
		if (opcion == 1){
		
		//Si desea atacar
			
			Jugador JugadorAAtacar = DatosDeAtaqueHaciaJugador (SuperJefe, Jugadores);
			if (Clones.size()>0){
				MandarAAtacarALosClones(JugadorAAtacar, Clones);
				MandarAAtacarALosAcompanantes(JugadorAAtacar, AcompanantesDelRaidBoss);
				String accion = "\nPoseidon ataco a " + JugadorAAtacar.getNombre() + ". Sus acompanantes y clones hicieron lo mismo";
				UltimasTresAcciones.add(accion);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}else if (Clones.size()==0){
				MandarAAtacarALosAcompanantes(JugadorAAtacar, AcompanantesDelRaidBoss);
				String accion = "\nPoseidon ataco a " + JugadorAAtacar.getNombre() + ". Al no tener clones, el ataque solo lo realizo Poseidon y sus acompanantes";
				UltimasTresAcciones.add(accion);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}
			
		}else if(opcion == 2){
			//Si desea usar una habilidad especial
			if(Clones.size()==0){
				String mensaje = SuperJefe.MensajePedirHabEspecial();
				//Se manda a preguntar qué item desea ejecutar
				int numItem = v.PedirItem(mensaje, 3);
				
				if (numItem == 1){
					//Si desea tirar un rayo eléctrico
					
					String accion = DatosLanzarRayoElectrico (SuperJefe, Jugadores);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				
				}else if(numItem == 2){
					//Si desea regenerar heridas
					
					String accion = SuperJefe.RegenerarHeridas();
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
					
				}else if(numItem == 3){
					//Si desea realizar un super ataque
				
					String accion = DatosSuperAtaque (SuperJefe, Jugadores);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}
			}else{
				String mensaje = "\nNo se puede realizar esta accion ya que Poseidon cuenta con clones. Libere a Poseidon para poder ejecutar esta accion.";
				v.MostrarMensaje(mensaje);
			}
		}else if(opcion == 3){
			
			String condicion = SuperJefe.getTipoHabilidadAclonar();
			
			if (condicion != "Aun no definida"){
				
				if (AcompanantesDelRaidBoss.size()==0 && MascotasDeLosCazadores.size()==0){
					
					String mensaje = "\nNo se puede realizar esta accion, ya que actualmente no hay ningun acompanante en la batalla para ser clonado.";
					v.MostrarMensaje(mensaje);
					
				}else if(AcompanantesDelRaidBoss.size()>0 || MascotasDeLosCazadores.size()>0){
					
					String HabilidadAClonar = SuperJefe.getTipoHabilidadAclonar();
					
					ArrayList<Integer> Datos = v.PedirAcompananteAClonar(AcompanantesDelRaidBoss, MascotasDeLosCazadores);
					int posicion = Datos.get(1);
					
					if (Datos.get(0)==1){
						//Clonar acompanante de Poseidon
						Acompanante Acomp = AcompanantesDelRaidBoss.get(posicion);
						
						Acompanante clonado = Acomp;
						
						try{
							clonado = (Acompanante) Acomp.clone();
						}catch(CloneNotSupportedException e){
							e.printStackTrace();
						}
						
						Clones.add(clonado);
						
						String mensaje = "\n" + Acomp.getNombre() + " fue clonado. El clon, al cual se le transfirio la habilidad de " + HabilidadAClonar + ", peleara al lado de Poseidon";
						v.MostrarMensaje(mensaje);
						
						String accion = "\nPoseidon clono al " + Acomp.getNombre() + ", y le transfirio la habilidad de " + HabilidadAClonar;
						UltimasTresAcciones.add(accion);
						
					}else if(Datos.get(0)==2){
						//Clonar mascota
						Acompanante Acomp = MascotasDeLosCazadores.get(posicion);
						
						Acompanante clonado = Acomp;
						
						try{
							clonado = (Acompanante) Acomp.clone();
						}catch(CloneNotSupportedException e){
							e.printStackTrace();
						}
						
						Clones.add(clonado);
						
						String mensaje = "\n" + Acomp.getNombre() + " fue clonado. El clon, al cual se le transfirio la habilidad de " + HabilidadAClonar + ", peleara al lado de Poseidon";
						v.MostrarMensaje(mensaje);
						
						String accion = "\nPoseidon clono a " + Acomp.getNombre() + ", y le transfirio la habilidad de " + HabilidadAClonar;
						UltimasTresAcciones.add(accion);
					}
					
					SuperJefe.setNumClones();
					
				}
				
			}else{
				String mensaje = "\nNo se puede realizar esta accion ya que aun no se ha definido la habilidad especial que se clonara. Defina dicha habilidad en al opcion de 'variar' para poder ejecutar esta accion";
				v.MostrarMensaje(mensaje);
			}
			
		}else if(opcion == 4){
			
			String mensaje = SuperJefe.MensajePedirHabEspecialAClonar();
			int posicion = v.PedirHabilidadEspecialAClonar(mensaje);
			
			String HabilidadAClonar = "";
			if (posicion==1){
				HabilidadAClonar = "tirar un rayo electrico";
			}else if (posicion==2){
				HabilidadAClonar = "regenerar heridas";
			}else if (posicion==3){
				HabilidadAClonar = "realizar un super ataque";
			}
			
			SuperJefe.setTipoHabilidadAclonar(HabilidadAClonar);
			
			mensaje = "\nPoseidon vario. La nueva habilidad que se clonara es '" + HabilidadAClonar + "'";
			UltimasTresAcciones.add(mensaje);
			v.MostrarMensaje(mensaje);
			
		}else if(opcion == 5){
			
			if (Clones.size()>0){
				
				Clones.clear();
				SuperJefe.ReiniciarNumClones();
				
				String mensaje = "\nPoseidon se libero de todos sus clones. Ahora puede utilizar sus habilidades especiales.";
				v.MostrarMensaje(mensaje);
			}else if(Clones.size()==0){
				String mensaje = "\nPoseidon ya estaba liberado.";
				v.MostrarMensaje(mensaje);
			}
			
		}
		
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a preguntar a qué Jugador desea atacar el raid boss y manda a ejecutar el método "Atacar" de la clase RaidBoss.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @return Devuelve la instancia de jugador a la que se desea atacar
	 */
	private Jugador DatosDeAtaqueHaciaJugador (RaidBoss SuperJefe, ArrayList<Jugador> Jugadores){
		
		//Se manda a pregunta qué jugador desea atacar
		int posEnemigoAAtacar = v.PedirJugadorAAtacar(Jugadores);
		
		//Se obtiene el jugador a atatcar
		Jugador JugadorAAtacar = Jugadores.get(posEnemigoAAtacar);
		
		//Se obtiene el poder del ataque
		int PoderDeAtaque = SuperJefe.getPoderAtaque();
		
		//Se ataca
		SuperJefe.Atacar(JugadorAAtacar, PoderDeAtaque);
		
		return JugadorAAtacar;
	}
	
	/**
	 * Manda a atacar a los clones del raid boss
	 * @version 17/10/2021
	 * @param JugadorAAtacar Jugador al que se está atacando
	 * @param Clones ArrayList que contiene a todos los clones del raid boss
	 */
	private void MandarAAtacarALosClones(Jugador JugadorAAtacar, ArrayList<Acompanante> Clones){
		
		for (int i=0; i<Clones.size(); i++){
			Acompanante Acomp = Clones.get(i);
			int PoderAtaque = Acomp.getPoderAtaque();
			Acomp.AtacarJugador(JugadorAAtacar, PoderAtaque);
		}
		
	}
	
	/**
	 * Manda a atacar a los acompañantes del raid boss
	 * @version 17/10/2021
	 * @param JugadorAAtacar Jugador al que se está atacando
	 * @param AcompanantesDelRaidBoss ArrayList que contiene a todos los acompañantes del raid boss
	 */
	private void MandarAAtacarALosAcompanantes(Jugador JugadorAAtacar, ArrayList<Acompanante> AcompanantesDelRaidBoss){
		
		for (int i=0; i<AcompanantesDelRaidBoss.size(); i++){
			Acompanante Acomp = AcompanantesDelRaidBoss.get(i);
			int PoderAtaque = Acomp.getPoderAtaque();
			Acomp.AtacarJugador(JugadorAAtacar, PoderAtaque);
		}
		
	}
	
	/**
	 * Manda a preguntar a qué Jugador le desea lanzar el raid boss un rayo electrico y manda a ejecutar el método "LanzarRayoElectrico" de la clase RaidBoss.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	private String DatosLanzarRayoElectrico (RaidBoss SuperJefe, ArrayList<Jugador> Jugadores){
		
		//Se manda a pregunta qué jugador desea atacar
		int posEnemigoAAtacar = v.PedirJugadorALanzarRayoElectrico(Jugadores);
		
		//Se obtiene el jugador a atatcar
		Jugador JugadorAAtacar = Jugadores.get(posEnemigoAAtacar);
		
		//Se obtiene el poder del ataque
		int PoderDeAtaque = 5;
		
		//Se ataca
		String mensaje = SuperJefe.LanzarRayoElectrico(JugadorAAtacar, PoderDeAtaque);
		
		return mensaje;
		
	}
	
	/**
	 * Manda a preguntar a qué Jugador le desea lanzar el raid un super ataque y manda a ejecutar el método "LanzarSuperAtaque" de la clase RaidBoss.
	 * @version 17/10/2021
	 * @param SuperJefe Representa al Raid Boss.
	 * @param Jugadores ArrayList que contiene a todos los jugadores.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	private String DatosSuperAtaque (RaidBoss SuperJefe, ArrayList<Jugador> Jugadores){
		
		//Se manda a pregunta qué jugador desea atacar
		int posEnemigoAAtacar = v.PedirJugadorARealizarSuperAtaque(Jugadores);
		
		//Se obtiene el jugador a atatcar
		Jugador JugadorAAtacar = Jugadores.get(posEnemigoAAtacar);
		
		//Se obtiene el poder del ataque
		int PoderDeAtaque = 6;
		
		//Se ataca
		String mensaje = SuperJefe.LanzarSuperAtaque(JugadorAAtacar, PoderDeAtaque);
		
		return mensaje;
		
	}
	
}