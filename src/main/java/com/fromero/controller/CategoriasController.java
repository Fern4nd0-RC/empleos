package com.fromero.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fromero.interfaces.CategoriaInterface;
import com.fromero.model.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	// === INYECCION DE LA INTERFAZ "CATEGORIA" ===
	private final CategoriaInterface categoriaService;

	public CategoriasController(CategoriaInterface categoriaService) {
	    this.categoriaService = categoriaService;
	}
	
	
	// === INDICE DE CATEGORIAS ===
	@GetMapping("/index")
	public String mostrarIndex(Model modelo) {
		List<Categoria> listCategorias = categoriaService.buscarTodas();
		modelo.addAttribute("categorias", listCategorias);
		
		return "categorias/listCategorias";
	}
	
	
	// === CREAR CATEGORIA ===
	@GetMapping("/create")
	public String crearCategoria(Categoria categoria) {
		return "categorias/formCategorias";
	}
	
	
	// === GUARDAR CATEGORIA ===
	@PostMapping("/save")
	public String guardarCategoria(Categoria categoria, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            return "categorias/formCategoria";
        }
        
        categoriaService.guardar(categoria);
        redirectAttributes.addFlashAttribute("msg", "Categoria guardada correctamente!!");
		
		return "redirect:/categorias/index";
	}
} 