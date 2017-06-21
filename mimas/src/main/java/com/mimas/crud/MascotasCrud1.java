package com.mimas.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mimas.model.Mascota;
import com.mimas.util.conexionDB;

public class MascotasCrud1 implements CrudInterface {
    Connection con;

    @Override
    public int insertar(Object request) throws Exception {
        int respuesta = 0;
        Mascota mascota = (Mascota) request;         
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "insert into mascota (Id, Nombre, IdResponsable, Especie, Raza, Genero, Edad, Tamaño, "
                + "Estado, Caracteristicas, Vacunas, FechaN, Señales, Color, Colorojos, Personalidad, EstadoSalud)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, mascota.getId());
        preparedStatement.setString(2, mascota.getNombre());
        preparedStatement.setString(3, mascota.getIdResponsable());
        preparedStatement.setString(4, mascota.getEspecie());
        preparedStatement.setString(5, mascota.getRaza());
        preparedStatement.setString(6, mascota.getGenero());
        preparedStatement.setString(7, mascota.getEdad());
        preparedStatement.setString(8, mascota.getTamaño());
        preparedStatement.setString(9, mascota.getEstado());
        preparedStatement.setString(10, mascota.getCaractetisticas());
        preparedStatement.setString(11, mascota.getVacunas());
        preparedStatement.setString(12, mascota.getFechaN());
        preparedStatement.setString(13, mascota.getSeñales());
        preparedStatement.setString(14, mascota.getColor());
        preparedStatement.setString(15, mascota.getColorojos());
        preparedStatement.setString(16, mascota.getPersonalidad());
        preparedStatement.setString(17, mascota.getEstadoSalud());
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
