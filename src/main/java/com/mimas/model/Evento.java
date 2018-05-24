package com.mimas.model;

import java.util.Date;

public class Evento {
	
	private String id;
	private String nombre;
	private String usuario;
	private String fechai;
	private String fechaf;
	private String lugar;
	private String descripcion;
	private String imagen;
	private String estado;

	
	










	public String getId() {
		return id;
	}













	public void setId(String id) {
		this.id = id;
	}













	public String getNombre() {
		return nombre;
	}













	public void setNombre(String nombre) {
		this.nombre = nombre;
	}













	public String getUsuario() {
		return usuario;
	}













	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}













	public String getFechai() {
		return fechai;
	}













	public void setFechai(String fechai) {
		this.fechai = fechai;
	}













	public String getFechaf() {
		return fechaf;
	}













	public void setFechaf(String fechaf) {
		this.fechaf = fechaf;
	}













	public String getLugar() {
		return lugar;
	}













	public void setLugar(String lugar) {
		this.lugar = lugar;
	}













	public String getDescripcion() {
		return descripcion;
	}













	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}













	public String getImagen() {
		return imagen;
	}













	public void setImagen(String imagen) {
		this.imagen = imagen;
	}













	public String getEstado() {
		return estado;
	}













	public void setEstado(String estado) {
		this.estado = estado;
	}













	@Override
	public String toString() {
		return "Evento [Id=" + id + ", usuario=" + usuario + ",  fechai="
				+ fechai + ", fechaf=" + fechaf + ", lugar=" + lugar + ", descripcion="
				+ descripcion + ", estado=" + estado + ", imagen=" + imagen + "]";
	}
	
	
	

}
