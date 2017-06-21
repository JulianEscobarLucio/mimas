package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mimas.model.Usuario;
import com.mimas.util.conexionDB;

public class UsuarioCrud implements CrudInterface {
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Usuario usuario = (Usuario) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into usuario (nombre1, nombre2, apellido1, apellido2, telefonofijo, telefonomovil, email, pregunta, respuesta, contraseña, confirmarcontraseña)"
                + " values (?,?,?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, usuario.getNombre1());
        preparedStatement.setString(2, usuario.getNombre2());
        preparedStatement.setString(3, usuario.getApellido1());
        preparedStatement.setString(4, usuario.getApellido2());
        preparedStatement.setString(5, usuario.getTelefonoFijo());
        preparedStatement.setString(6, usuario.getTelefonomovil());
        preparedStatement.setString(7, usuario.getEmail());
        preparedStatement.setString(8, usuario.getPregunta());
        preparedStatement.setString(9, usuario.getRespuesta());
        preparedStatement.setString(10, usuario.getContraseña());
        preparedStatement.setString(11, usuario.getConfirmarContraseña());
        respuesta = preparedStatement .executeUpdate();
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
