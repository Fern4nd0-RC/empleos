package com.fromero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fromero.interfaces.VacanteInterface;
import com.fromero.model.Vacante;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/vacantes")
public class VacanteController {
	
	private VacanteInterface IVacante;
	
    public VacanteController(VacanteInterface IVacante) {
        this.IVacante = IVacante;
    }

	@GetMapping("/create")
	public String crer() {
		return "vacantes/formVacante";
	}
	
	@PostMapping("/save")
	public String guardar(
		@RequestParam("nombre") String nombre, 
		@RequestParam("descripcion") String descripcion, 
		@RequestParam("estatus") String estatus, 
		@RequestParam("fecha") String fecha, 
		@RequestParam("destacado") String destacado, 
		@RequestParam("salario") double salario, 
		@RequestParam("detalles") String detalles) {

		System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(estatus);
		System.out.println(fecha);
		System.out.println(destacado);
		System.out.println(salario);
		System.out.println(detalles);
		
		return "vacantes/listVacante";
	}
	
	
	// === ANOTACIÓN PathVariable === //
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model modelo){
		
		Vacante vacante = IVacante.buscarPorId(idVacante);
		modelo.addAttribute("vacante", vacante);
		
		return "vacantes/detalleVacante";
	}
	
	// === ANOTACIÓN RequestParam === //
	@GetMapping("/delete")
	public String eliminarVacante(@RequestParam("id") int idVacante, Model modelo){
		System.out.println("Vacante con ID: " + idVacante + " borrada correctamente...");
		
		modelo.addAttribute("idMensaje", idVacante);
		
		return "vacantes/mensaje";
	}
	
}
