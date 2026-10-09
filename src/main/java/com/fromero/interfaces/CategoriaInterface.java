package com.fromero.interfaces;

import java.util.List;

import com.fromero.model.Categoria;

public interface CategoriaInterface {
	void guardar(Categoria categoria);	
	
	List<Categoria> buscarTodas();
	
	Categoria buscarPorId(Integer idCategoria);
}
