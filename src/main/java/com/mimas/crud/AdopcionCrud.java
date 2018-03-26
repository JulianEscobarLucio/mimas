package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.mimas.model.Adopcion;
import com.mimas.model.Mascota;
import com.mimas.util.conexionDB;

public class AdopcionCrud implements CrudInterface {

	private Connection con = null;
	private PreparedStatement preparedStatement;

	@Override
	public int insertar(Object request) throws Exception {
		int respuesta = 0;
		Adopcion adopcion = (Adopcion) request;
		adopcion.setFecha(new Date());
		con = conexionDB.getConexion();
		preparedStatement = null;
		String sql = "Insert Into adopcion(usuario,mascota,fecha,nombreadjunto,adjunto,estado)values(?,?,?,?,?,?)";
		preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, adopcion.getUsuario());
		preparedStatement.setString(2, adopcion.getIdMascota());
		preparedStatement.setDate(3, new java.sql.Date(0L));
		preparedStatement.setString(4, adopcion.getNombreAdjunto());
		preparedStatement.setString(5, adopcion.getAdjunto());
		preparedStatement.setString(6, "En proceso");
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();
		return respuesta;
	}

	@Override
	public Object consultar(Object consultar) throws Exception {
        ResultSet respuesta;
        Adopcion adopcion = (Adopcion) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select   usuario, mascota,fecha, nombreadjunto, adjunto, estado from adopcion where idSolicitud = ?";       
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, adopcion.getIdAdopcion());        
        respuesta = preparedStatement.executeQuery();
        Adopcion adopcionRespuesta = new Adopcion(); 
        while(respuesta.next()){
        	adopcionRespuesta.setUsuario(respuesta.getString("usuario"));
        	adopcionRespuesta.setIdMascota(respuesta.getString("mascota"));
        	adopcionRespuesta.setFecha(respuesta.getDate("fecha"));
        	adopcionRespuesta.setNombreAdjunto(respuesta.getString("nombreadjunto"));
        	adopcionRespuesta.setAdjunto(respuesta.getString("adjunto"));
        	adopcionRespuesta.setEstadoSolicitud(respuesta.getString("estado"));
        }
        preparedStatement.close();
        con.close();        
        return adopcionRespuesta;
	}
	
	@Override
	public Object actualizar(Object actualizar) throws Exception {
		int respuesta = 0;
		Adopcion adopcion = (Adopcion) actualizar;        
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "update adopcion set  mascota = ?, fecha = ? , nombreadjunto = ?, adjunto = ?, estado = ? where idSolicitud = ?";             
		preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, adopcion.getIdMascota());
		preparedStatement.setDate(2, new java.sql.Date(0L));
		preparedStatement.setString(3, adopcion.getNombreAdjunto());
		preparedStatement.setString(4, adopcion.getAdjunto());
		preparedStatement.setString(5, adopcion.getEstadoSolicitud());
		preparedStatement.setString(6, adopcion.getIdAdopcion());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        return respuesta;
	}

	@Override
	public Object eliminar(Object consultar) throws Exception {
		return null;
	}

}
