package com.fromero.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fromero.model.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping("/index")
	public String mostrarIndex(Model modelo) {
		return "categorias/listCategorias";
	}
	
	@GetMapping("/create")
	public String crearCategoria() {
		return "categorias/formCategorias";
	}
	
	@PostMapping("/save")
	public String guardarCategoria(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, Model modelo) {
		
		List<Categoria> listaCategoria = new LinkedList<>();
		
		Categoria categoria = new Categoria();
		
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		categoria.setEstado(true);
		
		listaCategoria.add(categoria);
		
		modelo.addAttribute("catNueva", listaCategoria);
		
		return "categorias/listCategorias";
	}
} 