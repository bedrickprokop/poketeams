package br.com.poketeams.endpoint;

import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("coach")
public class CoachEndpoint {

    @Autowired
    private CoachService coachService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid Coach coach) {
        coach = coachService.create(coach);
        return Response.ok(coach).status(Response.Status.CREATED.getStatusCode()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Coach> all = coachService.findAll();
        return Response.ok(all).status(Response.Status.OK.getStatusCode()).build();
    }

    @GET
    @Path("{coachId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("coachId") Long coachId) {
        Coach coach = coachService.findOne(coachId);
        return Response.ok(coach).status(Response.Status.OK.getStatusCode()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid Coach coach) {
        coach = coachService.update(coach);
        return Response.ok(coach).status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("{coachId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("coachId") Long coachId) {
        Coach deleted = coachService.delete(coachId);
        return Response.ok(deleted).status(Response.Status.OK.getStatusCode()).build();
    }
}
