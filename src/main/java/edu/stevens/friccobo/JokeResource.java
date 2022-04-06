package edu.stevens.friccobo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/j")
public class JokeResource {
    static List<DadJoke> jokes = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DadJoke getJoke(@QueryParam("name") String name){
        return new DadJoke("some_id", "To be Frank, I would have to change my name");
    }

    @GET
    @Path("/{jokeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public DadJoke getJokeById(@PathParam("jokeId") String name){
        return new DadJoke("some_id", "To be Frank, I would have to change my name");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DadJoke> putJoke(@FormParam("message2") String message2, DadJoke newJoke){
        System.out.println(newJoke);
        jokes.add(newJoke);
        return jokes;
    }

}
