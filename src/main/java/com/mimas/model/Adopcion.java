package com.mimas.model;

import java.util.Date;

public class Adopcion {
	//hola laura
	private String idAdopcion;
	private String usuario;
	private Date fecha;
	private String idMascota;
	private String nombreAdjunto;
	private String adjunto;
	private String estadoSolicitud;
	
	public String getIdAdopcion() {
		return idAdopcion;
	}
	public void setIdAdopcion(String idAdopcion) {
		this.idAdopcion = idAdopcion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}
	public String getNombreAdjunto() {
		return nombreAdjunto;
	}
	public void setNombreAdjunto(String nombreAdjunto) {
		this.nombreAdjunto = nombreAdjunto;
	}
	public String getAdjunto() {
		return adjunto;
	}
	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
	@Override
	public String toString() {
		return "Adopcion [idAdopcion=" + idAdopcion + ", usuario=" + usuario + ", fecha=" + fecha + ", idMascota="
				+ idMascota + ", nombreAdjunto=" + nombreAdjunto + ", adjunto=" + adjunto + ", estadoSolicitud="
				+ estadoSolicitud + "]";
	}
	
	
	

}
