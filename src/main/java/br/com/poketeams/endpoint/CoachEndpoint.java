package br.com.poketeams.endpoint;

import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Path("coach")
public class CoachEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("{teste:1}")
                .status(Response.Status.CREATED.getStatusCode()).build();
    }
}
