package br.com.poketeams.endpoint;

import br.com.poketeams.model.entity.Team;
import br.com.poketeams.model.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("team")
public class TeamEndpoint {

    @Autowired
    private TeamService teamService;

    @POST
    @Path("{coachId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid Team team, @PathParam("coachId") Long coachId) {
        team = teamService.create(team, coachId);
        return Response.ok(team).status(Response.Status.CREATED.getStatusCode()).build();
    }

    @GET
    @Path("coach/{coachId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("coachId") Long coachId) {
        List<Team> all = teamService.findAll(coachId);
        return Response.ok(all).status(Response.Status.OK.getStatusCode()).build();
    }

    @GET
    @Path("{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("teamId") Long teamId) {
        Team team = teamService.findOne(teamId);
        return Response.ok(team).status(Response.Status.OK.getStatusCode()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid Team team) {
        team = teamService.update(team);
        return Response.ok(team).status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("teamId") Long teamId) {
        Team deleted = teamService.delete(teamId);
        return Response.ok(deleted).status(Response.Status.OK.getStatusCode()).build();
    }
}
