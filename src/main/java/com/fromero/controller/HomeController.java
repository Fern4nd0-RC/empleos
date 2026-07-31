package com.fromero.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fromero.interfaces.VacanteInterface;
import com.fromero.model.Vacante;

@Controller
public class HomeController {
	
	private final VacanteInterface IVacante;
	
    public HomeController(VacanteInterface IVacante) {
        this.IVacante = IVacante;
    }

	// === AÑADIR UN TIPO DE DATO "LISTA" AL MODELO Y DESPLEGARLO EN LA LISTA. DICHA LISTA SE OBTIENE MEDIANTE EL METODO "buscarTodas()"  === //	
	@GetMapping("/tablaEmpleos")
	public String mostrarTablaEmpleos(Model modelo) {
		List<Vacante> listaVacantes = IVacante.buscarTodas();
		
		modelo.addAttribute("vacantes", listaVacantes);
		
		return "tablaVacantes";
	}
	
	
	// ===  AÑADIR UN TIPO DE DATO "VACANTE" AL MODELO Y DESPLEGARLO EN LA VISTA === //
	@GetMapping("/detalle")
	public String mostrarDetalleEmpleo(Model modelo) {
		Vacante vacante = new Vacante();
		
		vacante.setNombre("Ingeniero electrico");
		vacante.setDescripcion("Se solicita para chambear.");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);

		modelo.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	// === AGREGAR TIPO DE DATO "LISTA" AL MODELO Y DESPLEGARLO EN LA VISTA === //
	@GetMapping("/lista")
	public String mostrarLista(Model modelo){
		
		List<String> lista = new LinkedList<String>();
		
		lista.add("Ingeniero de Software");
		lista.add("Ingeniero electrico");
		lista.add("Auxiliar de contabilidad");
		lista.add("Ingeniero mecanico");
		
		modelo.addAttribute("listadoEmpleos", lista);
		
		return "listadoEmpleos";
	}

	// === AGREGAR TIPOS DE DATOS "SIMPLES" AL MODELO Y DESPLEGARLOS EN LA VISTA === //
	@GetMapping("/")
	public String home(Model modelo) {
		
		List<Vacante> listaVacantes = IVacante.buscarTodas();
		modelo.addAttribute("vacantes", listaVacantes);		
		
		return "home";
	}
	
}
