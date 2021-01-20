package es.insa.proyecto.mus.contratos;

import es.insa.proyecto.dominio.cartas.Jugador;

/**
 * Interface que incluye la comprobaci�n del ganador de un lance
 * 
 * @author Cristina y Javier
 *
 */
public interface IGanadorLance {
	
	/**
	 *  Este m�todo permite saber que jugador, de un array de jugadores, ha ganado un lance
	 */
	public Jugador ganador(Jugador... jugadores);

}
