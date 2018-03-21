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
import com.mimas.crud.Login;
import com.mimas.crud.UsuarioCrud;
import com.mimas.model.Usuario;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/securityServices")
public class SecurityServices {

    private Gson gson;
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
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuario) throws JSONException {
        JSONObject jo = new JSONObject();
        try {
            crud = new Login();
            boolean respuesta = (boolean) crud.consultar(usuario);
            Usuario miUsuario;
            if (respuesta) {
                crud = new UsuarioCrud();
                miUsuario = (Usuario) crud.consultar(usuario);
                jo.put("codRespuesta", "200");
                jo.put("respuesta", "Usuario valido");
                jo.put("nombre1", miUsuario.getNombre1());
                jo.put("apellido1", miUsuario.getApellido1());
            } else {
                jo.put("codRespuesta", "201");
                jo.put("respuesta", "Usuario no valido");
            }
            JSONArray ja = new JSONArray();
            ja.put(jo);
            return Response.status(200).entity(ja).build();
        } catch (Exception e) {
            jo.put("codRespuesta", "500");
            jo.put("respuesta", "Eroro interno");
            e.printStackTrace();
            return Response.serverError().entity(jo).build();
        }
    }
}
