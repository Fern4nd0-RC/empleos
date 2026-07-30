package com.fromero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fromero.interfaces.VacanteInterface;
import com.fromero.model.Vacante;

@Controller
@RequestMapping("/vacantes")
public class VacanteController {
	
	private VacanteInterface IVacante;
	
    public VacanteController(VacanteInterface IVacante) {
        this.IVacante = IVacante;
    }
	
	// === ANOTACIÓN PathVariable === //
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model modelo){
		Vacante vacante = IVacante.buscarPorId(idVacante);
		
		System.out.println("Los datos de la vacante encontrada son: \n" + vacante);
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
