package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mimas.model.Mascota;
import com.mimas.model.Rol;
import com.mimas.util.conexionDB;

public class MascotaCrud implements CrudInterface {
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Mascota mascota = (Mascota) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into mascota (Id, Nombre, IdResponsable, Especie, Raza, Genero, Edad, Tamaño, "
                + "Estado, Caracteristicas, FechaN, Señales, Color, Colorojos, Personalidad, EstadoSalud)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, mascota.getId());
        preparedStatement.setString(2, mascota.getNombre());
        preparedStatement.setString(3, mascota.getIdResponsable());
        preparedStatement.setString(4, mascota.getEspecie());
        preparedStatement.setString(5, mascota.getRaza());
        preparedStatement.setString(6, mascota.getGenero());
        preparedStatement.setString(7, mascota.getEdad());
        preparedStatement.setString(8, mascota.getTamano());
        preparedStatement.setString(9, mascota.getEstado());
        preparedStatement.setString(10, mascota.getCaracteristicas());
        preparedStatement.setString(11, mascota.getFechaN());
        preparedStatement.setString(12, mascota.getSenales());
        preparedStatement.setString(13, mascota.getColor());
        preparedStatement.setString(14, mascota.getColorojos());
        preparedStatement.setString(15, mascota.getPersonalidad());
        preparedStatement.setString(16, mascota.getEstadoSalud());
        respuesta = preparedStatement .executeUpdate();
        // TODO Auto-generated method stub
        return respuesta;
    }

    @Override
    public Object consultar(Object consultar) throws Exception {
        ResultSet respuesta;
        Mascota mascota = (Mascota) consultar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "Select  Nombre, IdResponsable, Especie, Raza, Genero, Edad, Tamaño, "
                + "Estado, Caracteristicas, FechaN, Señales, Color, Colorojos, Personalidad, EstadoSalud from Mascota where Id = ?";       
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, mascota.getId());        
        respuesta = preparedStatement.executeQuery();
        Mascota mascotaRespuesta = new Mascota(); 
        while(respuesta.next()){
            mascotaRespuesta.setNombre(respuesta.getString("Nombre"));
            mascotaRespuesta.setIdResponsable(respuesta.getString("IdResponsable"));
            mascotaRespuesta.setEspecie(respuesta.getString("Especie"));
            mascotaRespuesta.setRaza(respuesta.getString("Raza"));
            mascotaRespuesta.setGenero(respuesta.getString("Genero"));
            mascotaRespuesta.setEdad(respuesta.getString("Edad"));
            mascotaRespuesta.setTamano(respuesta.getString("Tamaño"));
            mascotaRespuesta.setEstado(respuesta.getString("Estado"));
            mascotaRespuesta.setCaracteristicas(respuesta.getString("Caracteristicas"));            
            mascotaRespuesta.setFechaN(respuesta.getString("FechaN"));
            mascotaRespuesta.setSenales(respuesta.getString("Señales"));
            mascotaRespuesta.setColor(respuesta.getString("Color"));
            mascotaRespuesta.setColorojos(respuesta.getString("Colorojos"));
            mascotaRespuesta.setPersonalidad(respuesta.getString("Personalidad"));
            mascotaRespuesta.setEstadoSalud(respuesta.getString("EstadoSalud"));
        }
        preparedStatement.close();
        con.close();        
        // TODO Auto-generated method stub
        return mascotaRespuesta;
    }

    @Override
    public Object actualizar(Object actualizar) throws Exception {
        int respuesta = 0;
        Mascota mascota = (Mascota) actualizar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "update mascota set  Nombre = ?, IdResponsable = ? , Especie = ?, Raza = ?, Genero = ?, Edad= ?, Tamaño= ?, "
                + "Estado = ?, Caracteristicas = ?, FechaN = ?, Señales = ?, Color = ?, Colorojos = ?, Personalidad = ?, EstadoSalud = ? where Id = ?";             
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, mascota.getNombre());
        preparedStatement.setString(2, mascota.getIdResponsable());
        preparedStatement.setString(3, mascota.getEspecie());
        preparedStatement.setString(4, mascota.getRaza());
        preparedStatement.setString(5, mascota.getGenero());
        preparedStatement.setString(6, mascota.getEdad());
        preparedStatement.setString(7, mascota.getTamano());
        preparedStatement.setString(8, mascota.getEstado());
        preparedStatement.setString(9, mascota.getCaracteristicas());
        preparedStatement.setString(10, mascota.getFechaN());
        preparedStatement.setString(11, mascota.getSenales());
        preparedStatement.setString(12, mascota.getColor());
        preparedStatement.setString(13, mascota.getColorojos());
        preparedStatement.setString(14, mascota.getPersonalidad());
        preparedStatement.setString(15, mascota.getEstadoSalud());
        preparedStatement.setString(16, mascota.getId());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        // TODO Auto-generated method stub
        return respuesta;
    }

    @Override
    public Object eliminar(Object eliminar) throws Exception {
        int respuesta = 0;
        Mascota mascota = (Mascota)  eliminar;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "delete from Mascota  where Id = ?";        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);      
        preparedStatement.setString(1, mascota.getId());
        respuesta = preparedStatement.executeUpdate();  
        preparedStatement.close();
        con.close();        
        // TODO Auto-generated method stub
        return respuesta;
    }

}
