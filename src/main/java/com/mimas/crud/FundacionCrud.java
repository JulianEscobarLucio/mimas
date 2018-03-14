package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "insert into fundacion (identificacion, razonSocial, telefonoFijo, telefonoMovil, email, direccion, usuario, tipoEntidad, estadoEntidad)"
                + " values (?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, fundacion.getIdentificacion());
        preparedStatement.setString(2, fundacion.getRazonSocial());
        preparedStatement.setString(3, fundacion.getTelefonoFijo());
        preparedStatement.setString(4, fundacion.getTelefonoMovil());
        preparedStatement.setString(5, fundacion.getEmail());
        preparedStatement.setString(6, fundacion.getDireccion());
        preparedStatement.setString(7, fundacion.getUsuario());
        preparedStatement.setString(8, fundacion.getTipoEntidad());
        preparedStatement.setString(9, fundacion.getEstadoEntidad());
        respuesta = preparedStatement .executeUpdate();
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
    	
        ResultSet respuesta;
        Fundacion fundacion = (Fundacion) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select identificacion, razonSocial, telefonoFijo, "
        		+ "telefonoMovil, email, direccion, usuario, estadoEntidad, tipoEntidad from fundacion where identificacion = ?";  
        
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, fundacion.getIdentificacion());        
        respuesta = preparedStatement.executeQuery();
        
        Fundacion fundacionRespuesta = new Fundacion(); 
        while(respuesta.next()){
        	fundacionRespuesta.setIdentificacion(respuesta.getString("identificacion"));
        	fundacionRespuesta.setRazonSocial(respuesta.getString("razonSocial"));
        	fundacionRespuesta.setTelefonoFijo(respuesta.getString("telefonoFijo"));
        	fundacionRespuesta.setTelefonoMovil(respuesta.getString("telefonoMovil"));
        	fundacionRespuesta.setEmail(respuesta.getString("email"));
        	fundacionRespuesta.setDireccion(respuesta.getString("direccion"));
        	fundacionRespuesta.setUsuario(respuesta.getString("usuario"));
        	fundacionRespuesta.setTipoEntidad(respuesta.getString("tipoEntidad"));
        	fundacionRespuesta.setEstadoEntidad(respuesta.getString("estadoEntidad"));
        }
        preparedStatement.close();
        con.close();        

        return fundacionRespuesta;
    }

    @Override
    public Object actualizar(Object actualizar) throws Exception {
    	
        int respuesta = 0;
        Fundacion fundacion = (Fundacion) actualizar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        
        String sql = "Update fundacion set  identificacion =?, razonSocial =?, telefonoFijo =?, "
        		+ "telefonoMovil =?, email =?, direccion =?, usuario =?, tipoEntidad =?, estadoEntidad=?  where identificacion = ?";    
        
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, fundacion.getIdentificacion());
        preparedStatement.setString(2, fundacion.getRazonSocial());
        preparedStatement.setString(3, fundacion.getTelefonoFijo());
        preparedStatement.setString(4, fundacion.getTelefonoMovil());
        preparedStatement.setString(5, fundacion.getEmail());
        preparedStatement.setString(6, fundacion.getDireccion());
        preparedStatement.setString(7, fundacion.getUsuario());
        preparedStatement.setString(8, fundacion.getTipoEntidad());
        preparedStatement.setString(9, fundacion.getEstadoEntidad());
        preparedStatement.setString(10, fundacion.getIdentificacion());
        
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        

        return respuesta;
    }

    @Override
    public Object eliminar(Object eliminar) throws Exception {
    	
        int respuesta = 0;
        Fundacion fundacion = (Fundacion) eliminar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        
        String sql = "delete from fundacion  where identificacion = ?";  
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, fundacion.getIdentificacion());
        
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        

        return respuesta;
    }
    
    

}
