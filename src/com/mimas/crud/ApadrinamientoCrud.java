package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mimas.model.Apadrinamiento;
import com.mimas.util.conexionDB;

public class ApadrinamientoCrud implements CrudInterface {
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Apadrinamiento apadrinamiento = (Apadrinamiento) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into apadrinamiento (IdSol, IdSolicitante, IdMascota, Fecha, NombreAdj, EstadoSol )"
                + " values (?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, apadrinamiento.getIdSol());
        preparedStatement.setString(2, apadrinamiento.getIdSolicitante());
        preparedStatement.setString(3, apadrinamiento.getIdMascota());
        preparedStatement.setString(4, apadrinamiento.getFecha());
        preparedStatement.setString(5, apadrinamiento.getNombreAdj());
        preparedStatement.setString(6, apadrinamiento.getEstadoSol());
        respuesta = preparedStatement .executeUpdate();
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
    	
        ResultSet respuesta;
        Apadrinamiento apadrinamiento = (Apadrinamiento) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select IdSol, IdSolicitante, IdMascota, Fecha, NombreAdj, EstadoSol from apadrinamiento where IdSol = ?";  
        
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, apadrinamiento.getIdSol());        
        respuesta = preparedStatement.executeQuery();
        
        Apadrinamiento apadrinamientoRespuesta = new Apadrinamiento(); 
        while(respuesta.next()){
        	apadrinamientoRespuesta.setIdSol(respuesta.getString("IdSol"));
        	apadrinamientoRespuesta.setIdSolicitante(respuesta.getString("IdSolicitante"));
        	apadrinamientoRespuesta.setIdMascota(respuesta.getString("IdMascota"));
        	apadrinamientoRespuesta.setFecha(respuesta.getString("Fechal"));
        	apadrinamientoRespuesta.setNombreAdj(respuesta.getString("NombreAdj"));
        	apadrinamientoRespuesta.setEstadoSol(respuesta.getString("EstadoSol"));
        	
        }
        preparedStatement.close();
        con.close();        

        return apadrinamientoRespuesta;
    }

    @Override
    public Object actualizar(Object actualizar) throws Exception {
    	
        int respuesta = 0;
        Apadrinamiento apadrinamiento = (Apadrinamiento) actualizar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        
        String sql = "Update apadrinamiento set  IdSol =?, IdSolicitante =?, IdMascota =?, "
        		+ "Fecha =?, NombreAdj =?, EstadoSol =?  where IdSol = ?";    
        
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, apadrinamiento.getIdSol());
        preparedStatement.setString(2, apadrinamiento.getIdSolicitante());
        preparedStatement.setString(3, apadrinamiento.getIdMascota());
        preparedStatement.setString(4, apadrinamiento.getIdFecha());
        preparedStatement.setString(5, apadrinamiento.getNombreAdj());
        preparedStatement.setString(6, apadrinamiento.getEstadoSol());       
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        

        return respuesta;
    }

    @Override
    public Object eliminar(Object eliminar) throws Exception {
    	
        int respuesta = 0;
        Apadrinamiento apadrinamiento = (Apadrinamiento) eliminar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        
        String sql = "delete from apadrinamiento  where IdSol = ?";  
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, apadrinamiento.getIdSol());
        
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        

        return respuesta;
    }
    
    

}
