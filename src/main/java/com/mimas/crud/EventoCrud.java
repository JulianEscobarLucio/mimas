package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mimas.model.Evento;
import com.mimas.model.Mascota;
import com.mimas.model.Rol;
import com.mimas.util.conexionDB;

public class EventoCrud implements CrudInterface {

	private Connection con = null;
	
	@Override
	public int insertar(Object request) throws Exception {
		int respuesta = 0;
		Evento evento = (Evento) request;
		con = conexionDB.getConexion();
		PreparedStatement preparedStatement = null ;
		String sql = "Insert Into evento(nombre,usuario,fechai,fechaf,lugar,descripcion,estado,imagen)values(?,?,?,?,?,?,?,?)";
		preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, evento.getNombre());
		preparedStatement.setString(2, evento.getUsuario());
		preparedStatement.setString(3, evento.getFechai());
		preparedStatement.setString(4, evento.getFechaf());
		preparedStatement.setString(5, evento.getLugar());
		preparedStatement.setString(6, evento.getDescripcion());
		preparedStatement.setString(7, evento.getEstado());
		preparedStatement.setString(8, evento.getImagen());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();
		return respuesta;
	}

    @Override
    public Object consultar(Object consultar) throws Exception {
        ResultSet respuesta;
        Evento evento = (Evento) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select  nombre,usuario,fechai,fechaf,lugar,descripcion,estado,imagen from Evento where nombre= ?";       
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, evento.getIdEvento());        
        respuesta = preparedStatement.executeQuery();
        Evento eventoRespuesta = new Evento(); 
        while(respuesta.next()){
        	
        	eventoRespuesta.setNombre(respuesta.getString("nombre"));
        	eventoRespuesta.setUsuario(respuesta.getString("usuario"));
        	eventoRespuesta.setFechai(respuesta.getString("fechai"));
        	eventoRespuesta.setFechaf(respuesta.getString("fechaf"));  
        	eventoRespuesta.setLugar(respuesta.getString("lugar"));
        	eventoRespuesta.setDescripcion(respuesta.getString("descripcion"));
        	eventoRespuesta.setEstado(respuesta.getString("estado"));            
        	eventoRespuesta.setImagen(respuesta.getString("imagen"));
   
           
        }
        preparedStatement.close();
        con.close();        
        return eventoRespuesta;
    }

    @Override
    public Object actualizar(Object actualizar) throws Exception {
        int respuesta = 0;
        Evento evento = (Evento) actualizar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "update evento set  nombre = ?, usuario = ? , fecha = ?, fechai = ?, fechaf = ?, lugar= ?, descripcion= ?, "
                + "estado = ?, imagen = ? where nombre = ?";             
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, evento.getNombre());
        preparedStatement.setString(2, evento.getUsuario());
        preparedStatement.setString(3, evento.getFechai());
        preparedStatement.setString(4, evento.getFechaf());
        preparedStatement.setString(5, evento.getLugar());
        preparedStatement.setString(6, evento.getDescripcion());
        preparedStatement.setString(7, evento.getEstado());
        preparedStatement.setString(8, evento.getImagen());
        preparedStatement.setString(16, evento.getIdEvento());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
    }
    
    public Object eliminar(Object eliminar) throws Exception {
    	return null;
    }

}
