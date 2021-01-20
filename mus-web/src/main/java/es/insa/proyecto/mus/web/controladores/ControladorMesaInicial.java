package es.insa.proyecto.mus.web.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.insa.proyecto.dominio.cartas.Jugador;
import es.insa.proyecto.mus.contratos.IGestorFaseDescartes;
import es.insa.proyecto.mus.modelo.Partida;

@Controller
public class ControladorMesaInicial {

	//Partida partida = new Partida();
	@Autowired(required=true)
	private Partida partida;
	@Autowired(required=true)
	private IGestorFaseDescartes gestorDescartes;
	
	
	@RequestMapping("/buscarMesa.html")
	public String buscarMesa(String nombre, Model m) {
		Jugador[] miMesa = partida.getMesa();
		m.addAttribute("mesa", miMesa);
		m.addAttribute("jugador", nombre);
		return "mesaInicial";
	}

	@RequestMapping("/sentarJugador.html")
	public String sentarJugador(String nombre, int silla, Model m, HttpSession sesion) {
		Jugador j = new Jugador(nombre);
		if (partida.sentarJugador(j, silla)) {
			sesion.setAttribute("jugadorActual", nombre);
			return refrescarMesa(m);
		}
		return "mesaInicial";
	}

	@RequestMapping("/refrescarMesa.html")
	private String refrescarMesa(Model m) {
		Jugador[] miMesa = partida.getMesa();
		m.addAttribute("mesa", miMesa);
		boolean lleno = true;
		for (int x=0; x<=3; x++){
			if(miMesa[x]== null) lleno=false;
		}
		if(lleno){
			if(!partida.isEmpezada()){
				iniciarPartida(m, miMesa);
			}
			return "iniciar";
		}else{
			return "mesaInicial";
		}
	}

	private void iniciarPartida(Model m, Jugador[] miMesa) {
		// iniciar la partida
		partida.empezarPartida();
		// llamar al gestor inicializarMazo, barajar, repartirCartas
		gestorDescartes.inicializar();
		
		m.addAttribute("mesa", miMesa);
	}

}
