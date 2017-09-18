package br.com.poketeams.endpoint;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CoachEndpointIT {

    private Map<String, String> coachMap;

    @Before
    public void setup() {
        coachMap = new HashMap<String, String>();
        coachMap.put("name", "Coach from team T");
    }

    @Test
    public void create() {
        given().contentType("application/json")
                .body(coachMap)
                .when().post("/api/coach")
                .then()
                .body("name", equalTo("Coach from team T"))
                .statusCode(201);
    }

    @Test
    public void findAll() {
        given().when().get("api/coach").then().statusCode(200);
    }

    @Test
    public void findOne() {
        given().when().get("api/coach/1").then().statusCode(200);
    }

    @Test
    public void update() {
        coachMap.put("id", "1");
        coachMap.put("name", "New Coach");

        given().contentType("application/json")
                .body(coachMap)
                .when().put("api/coach")
                .then()
                .body("name", equalTo("New Coach"))
                .statusCode(200);
    }

    @Test
    @Ignore
    public void delete() {
        given().when().delete("api/coach/" + 1)
                .then()
                .statusCode(200);
    }
}
