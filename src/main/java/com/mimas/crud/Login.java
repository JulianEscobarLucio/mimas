package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mimas.model.Usuario;
import com.mimas.util.conexionDB;

public class Login implements CrudInterface {
    Connection con;
    
    
    @Override
    public int insertar(Object request) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
        Usuario usuario = (Usuario) consultar;
        boolean respuesta = false;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "select nombre1, nombre2, apellido1, apellido2, telefonofijo, telefonomovil, email, pregunta, respuesta, contraseña"
                + " from usuario where email = ? and contraseña = ? ";
        preparedStatement  = con.prepareStatement(sql);
        preparedStatement.setString(1, usuario.getEmail());
        preparedStatement.setString(2, usuario.getContrasena());
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
              respuesta = true;
              break;
        }        
        preparedStatement.close();
        con.close();        
        // TODO Auto-generated method stub
        return respuesta;
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
