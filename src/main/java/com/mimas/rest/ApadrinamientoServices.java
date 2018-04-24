package com.mimas.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.mimas.crud.ApadrinamientoCrud;
import com.mimas.crud.CrudInterface;
import com.mimas.crud.FundacionCrud;
import com.mimas.crud.MascotaCrud;
import com.mimas.model.Apadrinamiento;
import com.mimas.model.Mascota;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/apadrinamientoservices")
public class ApadrinamientoServices {
	
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
    @Path("/apadrinamiento")   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarSolicitud(Apadrinamiento apadrinamiento) throws JSONException  {
        JSONObject jo = new JSONObject(); 
        JSONArray ja = new JSONArray();
        try {               
        	crud = new MascotaCrud();
        	Mascota mascota = new Mascota();
        	mascota.setId(apadrinamiento.getIdMascota());
        	mascota = (Mascota) crud.consultar(mascota);
        	if (mascota.getId() == null) {
        	  jo.put("codRespuesta", "501");
        	  ja.put(jo);
        	  return Response.status(501).entity(ja).build();		
        	}        	
            crud = new ApadrinamientoCrud();
            int respueata = crud.insertar(apadrinamiento);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
            }else{
               jo.put("codRespuesta", "200");
            };          
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Solicitud no registrada¡, error interno");
            e.printStackTrace();
             return Response.serverError()
                    .entity(jo).build();
        }     

   }
    
    @GET
    @Path("/list-apadrinamiento") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitud() throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {  
            crud = new ApadrinamientoCrud();
            List<Apadrinamiento> listaSolicitud = new ArrayList<>();
            listaSolicitud = (List<Apadrinamiento>)(List<?>) crud.listar();
//            jo.put("codRespuesta", "200");
//            jo.put("listaSolicitud", listaSolicitud);                             
//            ja.put(jo);
            return Response.status(200).entity(listaSolicitud).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Solicitud no encontrada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
            
        }
    } 
    
    @GET
    @Path("/apadrinamiento") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarSolicitud(@QueryParam("id") String id) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {  
        	Apadrinamiento apadrinamiento = new Apadrinamiento();
        	apadrinamiento.setIdApadrinamiento(id);
        	Apadrinamiento respuestaApadrinamiento = new Apadrinamiento();            
            crud = new ApadrinamientoCrud();
            respuestaApadrinamiento = (Apadrinamiento) crud.consultar(apadrinamiento);
            if(respuestaApadrinamiento.getIdMascota() != null){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Solicitud consultada");              
               jo.put("usuario", respuestaApadrinamiento.getUsuario());
               jo.put("idMascota", respuestaApadrinamiento.getIdMascota());
               jo.put("nombreAdjunto", respuestaApadrinamiento.getNombreAdjunto());
               jo.put("adjunto", respuestaApadrinamiento.getAdjunto());
               jo.put("estado", respuestaApadrinamiento.getEstadoSolicitud());
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Solicitud no encontrada");   
            };               
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Solicitud no encontrada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 
    
    @PUT
    @Path("/apadrinamiento") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarRol(Apadrinamiento apadrinamiento) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
                        
            crud = new ApadrinamientoCrud();
            int respueata = (int) crud.actualizar(apadrinamiento);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Solicitud actualizadoa");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Solicitud no actualizada");   
            };          
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Solicitud no actualizada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }

}
