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
import com.mimas.crud.RolCrud;
import com.mimas.crud.UsuarioCrud;
import com.mimas.model.Rol;
import com.mimas.model.Usuario;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/rolServices")
public class RolServices {

    private Gson gson ;
    private CrudInterface crud;   
    
    
    @POST
    @Path("/registrarRol") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarRol(Rol rol) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
                        
            crud = new RolCrud();
            int respueata = crud.insertar(rol);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Rol registrado");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Rol no registrado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Rol no registrado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 
    
    
    
    @POST
    @Path("/actualizarRol") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarRol(Rol rol) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
                        
            crud = new RolCrud();
            int respueata = (int) crud.actualizar(rol);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Rol acutalizado");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Rol no actualizado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Rol no actualizado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 
    
    @POST
    @Path("/consultarRol") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarRol(Rol rol) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
            Rol respuestaRol = new Rol();            
            crud = new RolCrud();
            respuestaRol = (Rol) crud.consultar(rol);
            if(respuestaRol.getIdRol() != null){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Rol consultado");
               jo.put("idRol", respuestaRol.getIdRol());
               jo.put("nombre", respuestaRol.getNombre());
               jo.put("descripcion", respuestaRol.getDescripcion());
               jo.put("formularios", respuestaRol.getFormularios());
               jo.put("funcionalidades", respuestaRol.getFuncionalidades());
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Rol no encontrado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Rol no registrado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }
    
    
    @POST
    @Path("/eliminarRol") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarRol(Rol rol) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try {    
                        
            crud = new RolCrud();
            int respueata = (int) crud.eliminar(rol);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Rol eliminado");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Rol no eliminado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Rol no eliminado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 
     
}
