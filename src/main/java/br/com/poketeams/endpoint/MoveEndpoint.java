package br.com.poketeams.endpoint;

import br.com.poketeams.model.entity.Creature;
import br.com.poketeams.model.entity.Move;
import br.com.poketeams.model.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("move")
public class MoveEndpoint {

    @Autowired
    private MoveService moveService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Move> all = moveService.findAll();
        return Response.ok(all).status(Response.Status.OK.getStatusCode()).build();
    }
}
