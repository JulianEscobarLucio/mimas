package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mimas.model.Fundacion;
import com.mimas.util.conexionDB;

public class FundacionCrud implements CrudInterface {
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Fundacion fundacion = (Fundacion) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into fundacion (identificacion, razonSocial, telefonofijo, telefonomovil, email, direccion, usuario, tipoEntidad)"
                + " values (?,?,?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, fundacion.getIdentificacion());
        preparedStatement.setString(2, fundacion.getRazonSocial());
        preparedStatement.setString(3, fundacion.getTelefonoFijo());
        preparedStatement.setString(4, fundacion.getTelefonomovil());
        preparedStatement.setString(5, fundacion.getEmail());
        preparedStatement.setString(6, fundacion.getDireccion());
        preparedStatement.setString(7, fundacion.getUsuario());
        preparedStatement.setString(8, fundacion.getTipoEntidad());
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
