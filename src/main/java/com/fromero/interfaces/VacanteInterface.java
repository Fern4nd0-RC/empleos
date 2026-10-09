package com.fromero.interfaces;

import java.util.List;

import com.fromero.model.Vacante;

public interface VacanteInterface {
	List<Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);

    void guardar(Vacante vacante);
}
