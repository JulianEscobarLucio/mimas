package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mimas.model.Rol;
import com.mimas.model.Usuario;
import com.mimas.util.conexionDB;

public class RolCrud implements CrudInterface{
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Rol rol = (Rol) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into rol (idRol, nombre, descripcion, formularios, funcionalidades)"
                + " values (?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, rol.getIdRol());
        preparedStatement.setString(2, rol.getNombre());
        preparedStatement.setString(3, rol.getDescripcion());
        preparedStatement.setString(4, rol.getFormularios());
        preparedStatement.setString(5, rol.getFuncionalidades());        
        respuesta = preparedStatement .executeUpdate();
        preparedStatement.close();
        con.close();        
        // TODO Auto-generated method stub
        return respuesta;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object actualizar(Object consultar) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object eliminar(Object consultar) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
    

}
