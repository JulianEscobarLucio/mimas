package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
        respuesta = preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
        ResultSet respuesta;
        Rol rol = (Rol) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select idRol, nombre, descripcion, formularios, funcionalidades from rol where idRol = ?";       
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, rol.getIdRol());        
        respuesta = preparedStatement.executeQuery();
        Rol rolRespuesta = new Rol(); 
        while(respuesta.next()){
            rolRespuesta.setIdRol(respuesta.getString("idRol"));
            rolRespuesta.setNombre(respuesta.getString("nombre"));
            rolRespuesta.setDescripcion(respuesta.getString("descripcion"));
            rolRespuesta.setFormularios(respuesta.getString("formularios"));
            rolRespuesta.setFuncionalidades(respuesta.getString("funcionalidades"));
        }
        preparedStatement.close();
        con.close();        
        return rolRespuesta;
    }

    @Override
    public Object actualizar(Object actualizar) throws Exception {
        int respuesta = 0;
        Rol rol = (Rol) actualizar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Update rol set  nombre = ?, descripcion = ?, formularios = ?, funcionalidades = ? where idRol = ?";        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, rol.getNombre());
        preparedStatement.setString(2, rol.getDescripcion());
        preparedStatement.setString(3, rol.getFormularios());
        preparedStatement.setString(4, rol.getFuncionalidades()); 
        preparedStatement.setString(5, rol.getIdRol());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

    @Override
    public Object eliminar(Object eliminar) throws Exception {
        int respuesta = 0;
        Rol rol = (Rol) eliminar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "delete from rol  where idRol = ?";        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, rol.getIdRol());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

	@Override
	public List<Object> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}
