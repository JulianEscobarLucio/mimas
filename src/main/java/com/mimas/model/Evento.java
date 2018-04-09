package com.mimas.model;

import java.util.Date;

public class Evento {
	
	private String idEvento;
	private String nombre;
	private String usuario;
	private String fechai;
	private String fechaf;
	private String lugar;
	private String descripcion;
	private String estado;
	private String imagen;

	
	





	public String getIdEvento() {
		return idEvento;
	}








	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
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








	public String getEstado() {
		return estado;
	}








	public void setEstado(String estado) {
		this.estado = estado;
	}

	//






	public String getImagen() {
		return imagen;
	}








	public void setImagen(String imagen) {
		this.imagen = imagen;
	}








	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", usuario=" + usuario + ",  fechai="
				+ fechai + ", fechaf=" + fechaf + ", lugar=" + lugar + ", descripcion="
				+ descripcion + ", estado=" + estado + ", imagen=" + imagen + "]";
	}
	
	
	

}
