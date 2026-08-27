package com.fromero.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // === INDICE DE VACANTES ===
    @GetMapping("/index")
    public String mostrarIndex(Model modelo) {

        List<Vacante> vacante = IVacante.buscarTodas(); 
        modelo.addAttribute("vacante", vacante); 

        return "vacantes/listVacante";
    }
    
    // === CREAR ===
    @GetMapping("/create")
    public String crear() {
        return "vacantes/formVacante";
    }

    // === GUARDAR ===
    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result) {
        if (result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println("OCURRIÓ UN ERROR: \n" + error.getDefaultMessage());
            }

            return "vacantes/formVacante";
        }

        IVacante.guardar(vacante);

        return "vacantes/listVacante";
    }

    // === ANOTACIÓN PathVariable === //
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model modelo) {

        Vacante vacante = IVacante.buscarPorId(idVacante);
        modelo.addAttribute("vacante", vacante);

        return "vacantes/detalleVacante";
    }

    // === ANOTACIÓN RequestParam === //
    @GetMapping("/delete")
    public String eliminarVacante(@RequestParam("id") int idVacante, Model modelo) {
        System.out.println("Vacante con ID: " + idVacante + " borrada correctamente...");
        modelo.addAttribute("idMensaje", idVacante);

        return "vacantes/mensaje";
    }


    // === ANOTACIÓN InitBinder ===
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
