package br.com.poketeams.endpoint;

import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.entity.Creature;
import br.com.poketeams.model.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("creature")
public class CreatureEndpoint {

    @Autowired
    private CreatureService creatureService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Creature> all = creatureService.findAll();
        return Response.ok(all).status(Response.Status.OK.getStatusCode()).build();
    }
}
