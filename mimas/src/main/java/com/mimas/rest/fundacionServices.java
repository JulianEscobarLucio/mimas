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
            
        	 /* 
        	 * Validation  
        	 */
        	if(fundacion.getIdentificacion() == null || fundacion.getIdentificacion().equals("") && 
                    (fundacion.getRazonSocial() == null || fundacion.getRazonSocial().equals("") )){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
        	
            if((fundacion.getTelefonoFijo() == null || fundacion.getTelefonoFijo().equals("")) && 
                    (fundacion.getTelefonoMovil() == null || fundacion.getTelefonoMovil().equals("") )){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(fundacion.getEmail() == null || fundacion.getEmail().equals("") && 
                    (fundacion.getDireccion() == null || fundacion.getDireccion().equals("") )){
                jo.put("codRespuesta", "202");
                jo.put("respuesta", "Faltan datos obligatorios"); 
                ja.put(jo);
                return Response.status(200).entity(ja).build();
            }
            
            if(fundacion.getUsuario() == null || fundacion.getUsuario().equals("")){
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
               jo.put("respuesta", "Fundación no registrada");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
            
            
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Fundación no registrada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }
    
    
    
    
    @POST
    @Path("/actualizarFundacion") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarFundacion(Fundacion fundacion) throws JSONException  {
    	
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        
        try {    
                        
            crud = new FundacionCrud();
            int respuesta = (int) crud.actualizar(fundacion);
            if(respuesta==1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Fundacion acutalizada");
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Fundacion no actualizada");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
            
            
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Fundacion no actualizada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 
    
    
    
    
    @POST
    @Path("/consultarFundacion") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarFundacion(Fundacion fundacion) throws JSONException  {
    	
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        
        try {    
        	
            Fundacion respuesta = new Fundacion();            
            crud = new FundacionCrud();
            respuesta = (Fundacion) crud.consultar(fundacion);
            
            if(respuesta.getIdentificacion() != null){  
            	
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Fundacion consultada");
               jo.put("identificacion", respuesta.getIdentificacion());
               jo.put("razonSocial", respuesta.getRazonSocial());
               jo.put("telefonoFijo", respuesta.getTelefonoFijo());
               jo.put("telefonoMovil", respuesta.getTelefonoMovil());
               jo.put("email", respuesta.getEmail());
               jo.put("direccion", respuesta.getDireccion());
               jo.put("usuario", respuesta.getUsuario());
               jo.put("tipoEntidad", respuesta.getTipoEntidad());
               
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Fundacion no encontrada");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
            
            
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    }
    
    
    
    
    @POST
    @Path("/eliminarFundacion") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarFundacion(Fundacion fundacion) throws JSONException  {
    	
        JSONObject jo = new JSONObject();    
        JSONArray ja = new JSONArray();
        
        try {    
                        
            crud = new FundacionCrud();
            int respuesta = (int) crud.eliminar(fundacion);
            
            if(respuesta == 1){  
               jo.put("codRespuesta", "200");
               jo.put("respuesta", "Fundación eliminada");
               
            }else{
               jo.put("codRespuesta", "201");
               jo.put("respuesta", "Fundación no eliminada");   
            };          
            
           
            ja.put(jo);
            return Response.status(200).entity(ja).build();
            
        } catch (Exception e) {
        	
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Fundación no eliminada, error interno");
            e.printStackTrace();
            return Response.serverError()
                    .entity(jo).build();
        }
    } 

}
