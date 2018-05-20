package com.mimas.crud;

import java.util.List;

import com.mimas.model.Mascota;

public interface MascotaCrudInterface {
    
    int insertar(Mascota mascota) throws Exception;
    
    Mascota consultar(Mascota mascota) throws Exception;
    
    int actualizar(Mascota mascota) throws Exception;
    
    int eliminar(Mascota mascota) throws Exception;
    
    List<Mascota> listar() throws Exception;
}
