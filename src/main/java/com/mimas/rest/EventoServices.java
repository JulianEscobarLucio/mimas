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
import com.mimas.crud.AdopcionCrud;
import com.mimas.crud.CrudInterface;
import com.mimas.crud.EventoCrud;
import com.mimas.crud.FundacionCrud;
import com.mimas.crud.MascotaCrud;
import com.mimas.model.Adopcion;
import com.mimas.model.Evento;
import com.mimas.model.Mascota;
//
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/eventoservices")
public class EventoServices {
	
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
    @Path("/evento")   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarEvento(Evento evento) throws JSONException  {
        JSONObject jo = new JSONObject();    
        try {                      
            crud = new EventoCrud ();
            int respueata = crud.insertar(evento);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Evento registrado");
            }else{
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Evento no registrado");   
            };           
            
            JSONArray ja = new JSONArray();
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Evento no registrado¡, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
     

}
    

    @POST
    @Path("/actualizarEvento") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEvento(Evento evento) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
                        
            crud = new EventoCrud();
            int respueata = (int) crud.actualizar(evento);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Evento acutalizado");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Evento no acutalizado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Evento no actualizado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }
    
    
    @POST
    @Path("/consultarEvento") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarEvento(Evento evento) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
            Evento respuestaEvento = new Evento();            
            crud = new EventoCrud();
            respuestaEvento = (Evento) crud.consultar(evento);
            if(respuestaEvento.getNombre() != null){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Evento Consultado");              
               jo.put("nombre", respuestaEvento.getNombre());
               jo.put("usuario", respuestaEvento.getUsuario());
               jo.put("fechai", respuestaEvento.getFechai());
               jo.put("fechaf", respuestaEvento.getFechaf());
               jo.put("lugar", respuestaEvento.getLugar());
               jo.put("descripcion", respuestaEvento.getDescripcion());
               jo.put("imagen", respuestaEvento.getImagen());
       
               
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Evento no encontrado");   
            };               
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Evento no encontrado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }
    
    
}
