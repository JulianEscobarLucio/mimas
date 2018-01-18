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
import com.mimas.crud.ApadrinamientoCrud;
import com.mimas.crud.RolCrud;
import com.mimas.model.Apadrinamiento;
import com.mimas.model.Rol;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/Apadrinamientoservices")
public class apadrinamientoServices {
    
    

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
        public Response registrarApadrinamiento(Apadrinamiento apadrinamiento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            try {                      
                crud = new ApadrinamientoCrud ();
                int respueata = crud.insertar(apadrinamiento);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Solicitud registrada");
                }else{
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Solicitud no registrada");   
                };           
                
                JSONArray ja = new JSONArray();
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
        
    
        @POST
        @Path("/actualizarMascota") 
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
                   jo.put("respuesta", "Solicitud acutalizadoa");
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
        
        
        @POST
        @Path("/consultarApadrinamiento") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response consultarApadrinamiento(Apadrinamiento apadrinamiento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                Apadrinamiento respuestaApadrinamiento = new Apadrinamiento();            
                crud = new ApadrinamientoCrud();
                respuestaApadrinamiento = (Apadrinamiento) crud.consultar(apadrinamiento);
                if(respuestaApadrinamiento.getIdResponsable() != null){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Solicitud consultado");              
                   jo.put("IdSol", respuestaApadrinamiento.getIdSol());
                   jo.put("IdSolicitante", respuestaApadrinamiento.getIdSolicitante());
                   jo.put("IdMascota", respuestaApadrinamiento.getIdMascota());
                   jo.put("Fecha", respuestaApadrinamiento.getFecha());
                   jo.put("NombreAdj", respuestaApadrinamiento.getNombreAdj());
                   jo.put("EstadoSol", respuestaApadrinamiento.getEstadoSol());
                   
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
        
        @POST
        @Path("/eliminarApadrinamiento") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response eliminarApadrinamiento(Apadrinamiento apadrinamiento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                            
                crud = new ApadrinamientoCrud();
                int respueata = (int) crud.eliminar(apadrinamiento);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Solicitud eliminada");
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Solicitud no eliminada");   
                };          
                
               
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            } catch (Exception e) {
                jo.put("codRespuesta", "500");
                jo.put("respuesta", "Solicitud no eliminada, error interno");
                e.printStackTrace();
                return Response.serverError()
                        .entity(jo).build();
            }
        } 

}
