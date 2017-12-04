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
import com.mimas.crud.UsuarioCrud;
import com.mimas.model.Usuario;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/usuarioServices")
public class usuarioServices {
    
    private Gson gson ;
    private CrudInterface crud;
    
    
    @POST
    @Path("/registrarUsuario") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response regisrtrarUsuario(Usuario usuario) throws JSONException  {
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        try { 
            
            
            if(usuario.getNombre1() == null || usuario.getNombre1().equals("")){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
       
            
            if(usuario.getApellido1() == null || usuario.getApellido1().equals("")){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(usuario.getTelefonoFijo() == null || usuario.getTelefonoFijo().equals("") && 
                    (usuario.getTelefonomovil() == null || usuario.getTelefonomovil().equals("") )){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(usuario.getPregunta() == null || usuario.getPregunta().equals("")){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(usuario.getRespuesta() == null || usuario.getRespuesta().equals("")){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(usuario.getContrasena() == null || usuario.getContrasena().equals("")){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            
            if(!usuario.getContrasena().equals(usuario.getConfirmarContrasena())){
                jo.put("codRespuesta", "203");
                jo.put("respuesta", "Contraseña y confirmación no coinciden"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
               
                        
            crud = new UsuarioCrud();
            int respueata = crud.insertar(usuario);
            if(respueata==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Usuario registrado");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Usuario no registrado");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Usuario no registrado, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 

}
