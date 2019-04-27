package com.param.dropbookmarks.resources;

import com.param.dropbookmarks.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {

    @GET
    public String getGreetings(){
        return "Hello Dropwizard";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/secure")
    public String helloSecuredGreetings(@Auth User user){
        return "Hello Secured Dropwizard";
    }
}
