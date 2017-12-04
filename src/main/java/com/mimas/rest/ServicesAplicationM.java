package com.mimas.rest;

import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.mimas.crud.MascotasCrud1;
import com.mimas.model.Mascota;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/services")
public class ServicesAplicationM {
    private Gson gson ;
    private CrudInterface crud;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStartingPage()
    {
        String output = "<h1>Hello World!<h1>" +
                "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p><br>";
        return Response.status(200).entity(output).build();
    }
    
    
    
    @POST
    @Path("/registrarMacota") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarMascota(Mascota mascota) throws JSONException  {
        JSONObject jo = new JSONObject();    
        try {
                  
            crud = new MascotasCrud1();
            int respueata = crud.insertar(mascota);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Mascota registrada");
            }else{
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Mascota no registrada");   
            };           
            
            JSONArray ja = new JSONArray();
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Mascota no registrada¡, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }  

}
