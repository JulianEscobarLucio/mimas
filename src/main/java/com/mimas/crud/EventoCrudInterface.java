package com.mimas.crud;

import java.util.List;

import com.mimas.model.Evento;

public interface EventoCrudInterface {
    
    int insertar(Evento evento) throws Exception;
    
    Evento consultar(Evento evento) throws Exception;
    
    int actualizar(Evento evento) throws Exception;
    
    int eliminar(Evento evento) throws Exception;
    
    List<Evento> listar() throws Exception;
}
