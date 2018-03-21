package com.mimas.crud;

public interface CrudInterface {
    
    int insertar(Object request) throws Exception;
    
    Object consultar(Object consultar) throws Exception;
    
    Object actualizar(Object consultar) throws Exception;
    
    Object eliminar(Object consultar) throws Exception;

}
