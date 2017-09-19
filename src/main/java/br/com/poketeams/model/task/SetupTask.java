package br.com.poketeams.model.task;

import br.com.poketeams.model.entity.Creature;
import br.com.poketeams.model.entity.Move;
import br.com.poketeams.model.entity.ResponseCreatureList;
import br.com.poketeams.model.entity.ResponseMoveList;
import br.com.poketeams.model.service.CreatureService;
import br.com.poketeams.model.service.MoveService;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Component
public class SetupTask {

    @Inject
    private CreatureService creatureService;
    @Inject
    private MoveService moveService;

    private Integer numberOfCreatures = 15;
    private Integer numberOfMoves = 20;
    private String baseUrl = "http://pokeapi.co/api/v2/";

    public void loadMoves() {
        ResponseMoveList responseMoveList = null;
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(baseUrl.concat("move?limit=").concat(numberOfMoves.toString()));

        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        Response response = request.get();

        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            System.out.println("Success getting moves: " + response.getStatus());
            String strResponse = response.readEntity(String.class);
            Gson gson = new Gson();
            responseMoveList = gson.fromJson(strResponse, ResponseMoveList.class);

        } else {
            System.out.println("Error getting moves: " + response.getStatus());
            responseMoveList = new ResponseMoveList();
            responseMoveList.setResults(new ArrayList<Move>());
        }

        List<Move> results = responseMoveList.getResults();
        for (Move move : results) {
            moveService.create(move);
        }
    }

    public void loadCreatures() {
        ResponseCreatureList responseCreatureList = null;
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(baseUrl.concat("pokemon?limit=").concat(numberOfCreatures.toString()));

        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        Response response = request.get();

        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            System.out.println("Success getting creatures: " + response.getStatus());
            String strResponse = response.readEntity(String.class);
            Gson gson = new Gson();
            responseCreatureList = gson.fromJson(strResponse, ResponseCreatureList.class);

        } else {
            System.out.println("Error getting creatures: " + response.getStatus());
            responseCreatureList = new ResponseCreatureList();
            responseCreatureList.setResults(new ArrayList<Creature>());
        }

        List<Creature> results = responseCreatureList.getResults();
        for (Creature creature : results) {
            creatureService.create(creature);
        }
    }
}
