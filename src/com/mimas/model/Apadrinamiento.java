package com.mimas.model;

public class Apadrinamiento {
    private String IdSol;
    private String IdSolicitante;
    private String IdMascota;
    private String Fecha;
    private String NombreAdj;
    private String EstadoSol;
  
    
    //GETTER Y SETTER

   

  
    public String getIdSol() {
		return IdSol;
	}

	public void setIdSol(String idSol) {
		IdSol = idSol;
	}

	public String getIdSolicitante() {
		return IdSolicitante;
	}

	public void setIdSolicitante(String idSolicitante) {
		IdSolicitante = idSolicitante;
	}

	public String getIdMascota() {
		return IdMascota;
	}

	public void setIdMascota(String idMascota) {
		IdMascota = idMascota;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getNombreAdj() {
		return NombreAdj;
	}

	public void setNombreAdj(String nombreAdj) {
		NombreAdj = nombreAdj;
	}
	
	  /**
     * @return the estadoEntidad
     */
    public String getEstadoSol() {
        return EstadoSol;
    }


	/**
     * @param estadoEntidad the estadoEntidad to set
     */
    public void setEstadoSOl(String EstadoSol) {
        this.EstadoSol = EstadoSol;
    }



    

}
