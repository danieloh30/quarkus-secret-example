package org.acme;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "username")
    String username;

    @ConfigProperty(name = "password")
    String password;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/security")
    public Map securty() {
        HashMap<String, String> map = new HashMap<>();
        map.put("db.username", username);
        map.put("db.password", password);
        return map;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}