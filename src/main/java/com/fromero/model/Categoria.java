package com.fromero.model;

public class Categoria {
	
	private String nombre;
	private String descripcion;
	private Boolean estado;
	 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "CategoriaModel [nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
}
