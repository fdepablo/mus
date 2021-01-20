package es.insa.proyecto.mus.contratos;

import es.insa.proyecto.dominio.cartas.Carta;
import es.insa.proyecto.dominio.cartas.Jugador;

/**
 * Interface que se encarga de realizar de las
 * operaciones del mazo de reparto y del mazo de
 * descartes. 
 * @author Jos� Antonio y Cristina
 *
 */
public interface ICrupier {

	/**
	 *  Este m�todo permite mezclar las cartas de forma aleatoria
	 */
	void barajar();
	
	/**
	 *  Este m�todo permite cargar el mazo de reparto con la baraja completa
	 *  e inicializar el mazo de descartes
	 */
	void inicializarMazo();
	
	/**
	 * Este m�todo permite repartir del mazo un n�mero de cartas concreto al
	 * jugador
	 * @param numCartas
	 * @param j
	 */
	void repartirCartas(int numCartas, Jugador j);
	
	/**
	 * Este m�todo permite recoger unas cartas concretas de la mano de jugador
	 * y ponerlas en el mazo de descartes 
	 * @param cartasADescartar
	 * @param j
	 */
	void descartarCartas(Jugador j, Carta...cartasADescartar);
	
	/**
	 * Este m�todo permite recoger las cartas del mazo de descartes y ponerlas
	 * en el mazo de reparto (cambia uno por otro) y barajar el mazo
	 */
	void recogerDescartes();
	
}
