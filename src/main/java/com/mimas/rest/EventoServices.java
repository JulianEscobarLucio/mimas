package com.mimas.rest;

import java.util.Date;
import java.util.List;

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
import com.mimas.crud.EventoCrud;
import com.mimas.crud.EventoCrudInterface;
import com.mimas.model.Evento;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/Mascotaservices")
public class EventoServices {
    
    

        private EventoCrudInterface eventoCrudInterface = new EventoCrud();;
        
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getStartingPage()
        {
            String output = "<h1>Hello World!<h1>" +
                    "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p><br>";
            return Response.status(200).entity(output).build();
        }
        
        
        
        @POST
        @Path("/registrarEvento")   
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response registrarMascota(Evento evento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            try {                      
                int respueata = eventoCrudInterface.insertar(evento);
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
        public Response actualizarRol(Evento evento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                int respueata = eventoCrudInterface.actualizar(evento);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Evento acutalizado");
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Evento no actualizado");   
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
        public Response consultarMascota(Evento evento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                Evento respuestaEvento = eventoCrudInterface.consultar(evento);           
                if(respuestaEvento.getId() != null){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Evento consultada");              
                   jo.put("nombre", respuestaEvento.getNombre());
                   jo.put("usuario", respuestaEvento.getUsuario());
                   jo.put("fechai", respuestaEvento.getFechai());
                   jo.put("fechaf", respuestaEvento.getFechaf());
                   jo.put("lugar", respuestaEvento.getLugar());
                   jo.put("descripcion", respuestaEvento.getDescripcion());                
                   jo.put("estado", respuestaEvento.getEstado());                 
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
        
        @POST
        @Path("/eliminarEvento") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response eliminarMascota(Evento evento) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                int respueata = eventoCrudInterface.eliminar(evento);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Evento eliminado");
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Evento no eliminado");   
                };          
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            } catch (Exception e) {
                jo.put("codRespuesta", "500");
                jo.put("respuesta", "Evento no eliminado, error interno");
                e.printStackTrace();
                return Response.serverError()
                        .entity(jo).build();
            }
        } 
        
        
        @GET
        @Path("/listaMascota") 
        @Produces(MediaType.APPLICATION_JSON)
        public List<Evento> listaMascota(){
			try {
				return eventoCrudInterface.listar();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
        }

}
