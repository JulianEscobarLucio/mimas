package com.mimas.model;

public class Rol {
    
    private String idRol;
    private String nombre;
    private String descripcion;
    private String formularios;
    private String funcionalidades;
    
    
    
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
    public String getFormularios() {
        return formularios;
    }
    public void setFormularios(String formularios) {
        this.formularios = formularios;
    }
    public String getFuncionalidades() {
        return funcionalidades;
    }
    public void setFuncionalidades(String funcionalidades) {
        this.funcionalidades = funcionalidades;
    }
    public String getIdRol() {
        return idRol;
    }
    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }


}
