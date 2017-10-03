package br.com.poketeams.model.task;

import br.com.poketeams.model.entity.Creature;
import br.com.poketeams.model.entity.Move;
import br.com.poketeams.model.entity.ResponseCreatureList;
import br.com.poketeams.model.entity.ResponseMoveList;
import br.com.poketeams.model.service.CreatureService;
import br.com.poketeams.model.service.MoveService;
import br.com.poketeams.model.util.LoggerUtil;
import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SetupTask {

    private LoggerUtil<SetupTask> loggerUtil = new LoggerUtil<SetupTask>(SetupTask.class);

    @Inject
    private CreatureService creatureService;
    @Inject
    private MoveService moveService;

    private Integer numberOfCreatures = 15;
    private Integer numberOfMoves = 20;
    private String baseUrl = "https://pokeapi.co/api/v2/";

    public void loadMoves() {
        ResponseMoveList responseMoveList = null;
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(baseUrl.concat("move?limit=").concat(numberOfMoves.toString()));

        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        Response response = request.get();

        String message;
        Level levelLog;
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            message = "Success getting pokemon moves";
            levelLog = Level.INFO;

            String strResponse = response.readEntity(String.class);
            responseMoveList = new Gson().fromJson(strResponse, ResponseMoveList.class);

        } else {
            message = "Error getting pokemon moves";
            levelLog = Level.ERROR;

            responseMoveList = new ResponseMoveList();
            responseMoveList.setResults(new ArrayList<Move>());
        }

        HashMap<String, String> details = new HashMap<String, String>();
        details.put("Status code", String.valueOf(response.getStatusInfo().getStatusCode()));
        details.put("Reason", response.getStatusInfo().getReasonPhrase());
        loggerUtil.log(message, levelLog, details);

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

        String message;
        Level levelLog;
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            message = "Success getting pokemon creatures";
            levelLog = Level.INFO;

            String strResponse = response.readEntity(String.class);
            Gson gson = new Gson();
            responseCreatureList = gson.fromJson(strResponse, ResponseCreatureList.class);

        } else {
            message = "Error getting pokemon creatures";
            levelLog = Level.ERROR;

            responseCreatureList = new ResponseCreatureList();
            responseCreatureList.setResults(new ArrayList<Creature>());
        }

        HashMap<String, String> details = new HashMap<String, String>();
        details.put("Status code", String.valueOf(response.getStatusInfo().getStatusCode()));
        details.put("Reason", response.getStatusInfo().getReasonPhrase());
        loggerUtil.log(message, levelLog, details);

        List<Creature> results = responseCreatureList.getResults();
        for (Creature creature : results) {
            creatureService.create(creature);
        }
    }
}
