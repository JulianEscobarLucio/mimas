package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mimas.model.Evento;
import com.mimas.model.Rol;
import com.mimas.util.conexionDB;

public class EventoCrud implements EventoCrudInterface {
    Connection con;

    @Override
    public int insertar(Evento evento) throws Exception {
        int respuesta = 0;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into evento (Id, Nombre, Usuario, Fechai, Fechaf, lugar, Descripcion, Estado,imagen)"
                + " values (?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, evento.getId());
        preparedStatement.setString(2, evento.getNombre());
        preparedStatement.setString(3, evento.getUsuario());
        preparedStatement.setString(11, evento.getFechai());
        preparedStatement.setString(11, evento.getFechaf());
        preparedStatement.setString(3, evento.getLugar());
        preparedStatement.setString(3, evento.getDescripcion());
        preparedStatement.setString(9, evento.getEstado());
        preparedStatement.setString(7, evento.getImagen());
        
          
        
        
        respuesta = preparedStatement .executeUpdate();
        return respuesta;
    }

    @Override
    public Evento consultar(Evento evento) throws Exception {
        ResultSet respuesta;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select   Nombre, Usuario, Fechai, Fechaf, lugar, Descripcion, Estado,imagen from Evento where Id = ?";       
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, evento.getId());        
        respuesta = preparedStatement.executeQuery();
        Evento eventoRespuesta = new Evento(); 
        while(respuesta.next()){
        	eventoRespuesta.setId(evento.getId());
        	eventoRespuesta.setNombre(respuesta.getString("Nombre"));
        	eventoRespuesta.setUsuario(respuesta.getString("Usuario"));
        	eventoRespuesta.setFechai(respuesta.getString("Fechai"));
        	eventoRespuesta.setFechaf(respuesta.getString("Fechaf"));
        	eventoRespuesta.setLugar(respuesta.getString("Lugar"));  
        	eventoRespuesta.setDescripcion(respuesta.getString("Descripcion"));
        	eventoRespuesta.setEstado(respuesta.getString("Estado"));
            eventoRespuesta.setImagen(respuesta.getString("Imagen"));
        }
        preparedStatement.close();
        con.close();        
        return eventoRespuesta;
    }

    @Override
    public int actualizar(Evento evento) throws Exception {
        int respuesta = 0;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "update evento set  Nombre = ?, Usuario = ? , Fechai = ?, Fechaf = ?, Lugar = ?, Descripcion= ?, Estado= ?, "
                + "Imagen = ? where Id = ?";             
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, evento.getNombre());
        preparedStatement.setString(2, evento.getUsuario());
        preparedStatement.setString(3, evento.getFechai());
        preparedStatement.setString(4, evento.getFechaf());
        preparedStatement.setString(5, evento.getLugar());
        preparedStatement.setString(5, evento.getDescripcion());
        preparedStatement.setString(5, evento.getEstado());
        preparedStatement.setString(6, evento.getImagen());
        preparedStatement.setString(16, evento.getId());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

    @Override
    public int eliminar(Evento evento) throws Exception {
        int respuesta = 0;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "delete from Evento  where Id = ?";        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, evento.getId());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
    }

	@Override
	public List<Evento> listar() throws Exception {
		List<Evento> listEvento = new ArrayList<Evento>();
		Evento evento= null;
		con = conexionDB.getConexion();
		PreparedStatement preparedStatement = con.prepareStatement("select  id, nombre, usuario, fechai, fechaf, lugar, descripcion, estado, imagen from evento", Statement.RETURN_GENERATED_KEYS);  
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			evento = new Evento();
			evento.setId(resultSet.getString("id"));
			evento.setNombre(resultSet.getString("nombre"));
			evento.setUsuario(resultSet.getString("usuario"));
			evento.setFechai(resultSet.getString("fechai"));
			evento.setFechaf(resultSet.getString("fechaf"));
			evento.setLugar(resultSet.getString("lugar"));
			evento.setDescripcion(resultSet.getString("descripcion"));
			evento.setEstado(resultSet.getString("estado"));
			evento.setImagen(resultSet.getString("imagen"));
			
			listEvento.add(evento);
		}
		return listEvento;
	}

}
