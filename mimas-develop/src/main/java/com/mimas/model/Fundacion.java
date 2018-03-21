package com.mimas.model;

public class Fundacion {
    private String identificacion;
    private String razonSocial;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    private String direccion;
    private String usuario;
    private String tipoEntidad;
    private String estadoEntidad;

    
    //GETTER Y SETTER
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    /**
     * @return the estadoEntidad
     */
    public String getEstadoEntidad() {
        return estadoEntidad;
    }

    /**
     * @param estadoEntidad the estadoEntidad to set
     */
    public void setEstadoEntidad(String estadoEntidad) {
        this.estadoEntidad = estadoEntidad;
    }



    

}
