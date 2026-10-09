package com.fromero.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fromero.interfaces.CategoriaInterface;
import com.fromero.model.Categoria;

@Service
public class CategoriaService implements CategoriaInterface {
	
	// === ATRIBUTOS A NIVEL DE CLASE ===
	private List<Categoria> listaCategorias = null;
	
	public CategoriaService() {
		listaCategorias = new LinkedList<>();
		
	    Categoria categoria1 = new Categoria();
	    categoria1.setId(1);
	    categoria1.setNombre("Contabilidad");
	    categoria1.setDescripcion("Descripcion de la categoria Contabilidad");
	    categoria1.setEstado("A");

	    Categoria categoria2 = new Categoria();
	    categoria2.setId(2);
	    categoria2.setNombre("Ventas");
	    categoria2.setDescripcion("Trabajos relacionados con Ventas");
	    categoria2.setEstado("A");

	    Categoria categoria3 = new Categoria();
	    categoria3.setId(3);
	    categoria3.setNombre("Finanzas");
	    categoria3.setDescripcion("Trabajos relacionados con Finanzas");
	    categoria3.setEstado("A");

	    Categoria categoria4 = new Categoria();
	    categoria4.setId(4);
	    categoria4.setNombre("Mantenimiento");
	    categoria4.setDescripcion("Trabajos de mantenimiento");
	    categoria4.setEstado("A");

	    Categoria categoria5 = new Categoria();
	    categoria5.setId(5);
	    categoria5.setNombre("Transporte");
	    categoria5.setDescripcion("Trabajos relacionados con Transporte y Choferes");
	    categoria5.setEstado("A");
	    
	    Categoria categoria6 = new Categoria();
	    categoria6.setId(5);
	    categoria6.setNombre("Informatica");
	    categoria6.setDescripcion("Trabajos relacionados con Computación e Informatica");
	    categoria6.setEstado("A");	    

	    listaCategorias.add(categoria1);
	    listaCategorias.add(categoria2);
	    listaCategorias.add(categoria3);
	    listaCategorias.add(categoria4);
	    listaCategorias.add(categoria5);
	    listaCategorias.add(categoria6);
	}

	@Override
	public void guardar(Categoria categoria) {
		listaCategorias.add(categoria);
        System.out.println("Categoría guardada correctamente!");
	}

	@Override
	public List<Categoria> buscarTodas() {
		return listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria cat : listaCategorias) {
			if(cat.getId() == idCategoria) {
				return cat;
			}
		}
		return null;
	}
}
