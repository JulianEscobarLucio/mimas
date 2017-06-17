package com.mimas.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.mimas.crud.CrudInterface;
import com.mimas.crud.FundacionCrud;
import com.mimas.model.Fundacion;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/fundacionServices")

public class fundacionServices {
    
    private Gson gson ;
    private CrudInterface crud;
    
    
    @POST
    @Path("/registrarFundacion") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response regisrtrarfundacion(Fundacion fundacion) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try { 
            
            
            if(fundacion.getTelefonoFijo() == null || fundacion.getTelefonoFijo().equals("") && 
                    (fundacion.getTelefonomovil() == null || fundacion.getTelefonomovil().equals("") )){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
              
            crud = new FundacionCrud();
            int respueata = crud.insertar(fundacion);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Fundación registrada");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Fundación no registrado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Fundación no registrado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 

}
