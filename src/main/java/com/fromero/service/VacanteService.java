package com.fromero.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fromero.interfaces.VacanteInterface;
import com.fromero.model.Vacante;

@Service
public class VacanteService implements VacanteInterface{
	
	// === ATRIBUTOS A NIVEL DE LA CLASE ===
	private List<Vacante> listaVacantes = null;
	
	// ===== CONSTRUCTOR QUE GENERA UNA LISTA DE OBJETOS DE TIPO VACANTE =====
	public VacanteService() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		listaVacantes = new LinkedList<>();
		
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero en Sistemas");
			vacante1.setDescripcion("Se solicita Ingeniero en Sistemas para desarrollo de aplicaciones en Java Spring Boot.");
			vacante1.setFecha(sdf.parse("11-04-2026"));
			vacante1.setSalario(12800.0);
			vacante1.setEstatus(true);			
			vacante1.setDestacada(1);
			vacante1.setImagen("empresa1.webp");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Se solicita contador con 5 años de experiencia y que cuente con titulo.");
			vacante2.setFecha(sdf.parse("09-06-2026"));
			vacante2.setSalario(14600.0);
			vacante2.setEstatus(true);	
			vacante2.setDestacada(0);
			vacante2.setImagen("empresa2.webp");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Empresa solicita ingeniero electrico titulado para mantenimiento de la instalacion electrica.");
			vacante3.setFecha(sdf.parse("11-04-2026"));
			vacante3.setSalario(10500.0);
			vacante3.setEstatus(false);	
			vacante3.setDestacada(0);
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Grafico");
			vacante4.setDescripcion("Solicitamos diseñador grafico titulado para diseñar estrategias publicitarias de la empresa.");
			vacante4.setFecha(sdf.parse("11-04-2026"));
			vacante4.setSalario(7500.0);
			vacante4.setEstatus(true);
			vacante4.setDestacada(1);
			vacante4.setImagen("empresa3.webp");
			
			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante4);
			
		} catch (ParseException e){
			System.out.println("Error: " + e.getMessage());
		}		
	}
	

	public List<Vacante> buscarTodas() {	
		return listaVacantes;
	}


	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		for(Vacante v : listaVacantes) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		
		return null;
	}

}
