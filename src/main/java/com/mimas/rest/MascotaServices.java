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
import com.mimas.crud.MascotaCrud;
import com.mimas.crud.RolCrud;
import com.mimas.model.Mascota;
import com.mimas.model.Rol;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/Mascotaservices")
public class MascotaServices {
    
    

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
                crud = new MascotaCrud ();
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
        
    
        @POST
        @Path("/actualizarMascota") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response actualizarRol(Mascota mascota) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                            
                crud = new MascotaCrud();
                int respueata = (int) crud.actualizar(mascota);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Mascota acutalizadoa");
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Mascota no actualizada");   
                };          
                
               
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            } catch (Exception e) {
                jo.put("codRespuesta", "500");
                jo.put("respuesta", "Mascota no actualizada, error interno");
                e.printStackTrace();
                return Response.serverError()
                        .entity(jo).build();
            }
        }
        
        
        @POST
        @Path("/consultarMascota") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response consultarMascota(Mascota mascota) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                Mascota respuestaMascota = new Mascota();            
                crud = new MascotaCrud();
                respuestaMascota = (Mascota) crud.consultar(mascota);
                if(respuestaMascota.getIdResponsable() != null){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Mascota consultada");              
                   jo.put("nombre", respuestaMascota.getNombre());
                   jo.put("idResponsable", respuestaMascota.getIdResponsable());
                   jo.put("especie", respuestaMascota.getEspecie());
                   jo.put("raza", respuestaMascota.getRaza());
                   jo.put("genero", respuestaMascota.getGenero());
                   jo.put("edad", respuestaMascota.getEdad());
                   jo.put("tamano", respuestaMascota.getTamano());
                   jo.put("estado", respuestaMascota.getEstado());
                   jo.put("caracteristicas", respuestaMascota.getCaracteristicas());
                   jo.put("fechaN", respuestaMascota.getFechaN());
                   jo.put("senales", respuestaMascota.getSenales());
                   jo.put("color", respuestaMascota.getColor());
                   jo.put("colorOjos", respuestaMascota.getPersonalidad());
                   jo.put("personalidad", respuestaMascota.getEstadoSalud());
                   jo.put("estadoSalud", respuestaMascota.getEstadoSalud());
                   jo.put("imagen", respuestaMascota.getImagen());
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Mascota no encontrada");   
                };               
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            } catch (Exception e) {
                jo.put("codRespuesta", "500");
                jo.put("respuesta", "Mascota no encontrada, error interno");
                e.printStackTrace();
                return Response.serverError()
                        .entity(jo).build();
            }
        }
        
        @POST
        @Path("/eliminarMascota") 
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response eliminarMascota(Mascota mascota) throws JSONException  {
            JSONObject jo = new JSONObject();    
            JSONArray ja = new JSONArray();
            try {    
                            
                crud = new MascotaCrud();
                int respueata = (int) crud.eliminar(mascota);
                if(respueata==1){  
                   jo.put("codRespuesta", "200");
                   jo.put("respuesta", "Mascota eliminada");
                }else{
                   jo.put("codRespuesta", "201");
                   jo.put("respuesta", "Mascota no eliminada");   
                };          
                
               
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            } catch (Exception e) {
                jo.put("codRespuesta", "500");
                jo.put("respuesta", "Mascota no eliminada, error interno");
                e.printStackTrace();
                return Response.serverError()
                        .entity(jo).build();
            }
        } 

}
