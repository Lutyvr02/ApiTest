import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApi {
    @Test
    public void createUpdateReadDeleteProject() {
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "EynarJSON");
        bodyProject.put("Icon", 2);

        // create
        Response response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .post("https://todo.ly/api/projects.json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Icon", equalTo(2));

        int idProject = response.then().extract().path("Id");
        // update
        bodyProject.put("Content", "JSON Update");
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .put("https://todo.ly/api/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Icon", equalTo(2));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .log()
                .all().
                when()
                .get("https://todo.ly/api/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Icon", equalTo(2));


        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .log()
                .all().
                when()
                .delete("https://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Deleted", equalTo(true))
                .body("Icon", equalTo(2));


    }

    @Test
    public void createUpdateReadDeleteItem() {
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content", "LucianoJson");

        // create
        Response response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .post("https://todo.ly/api/items.json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")));

        int idProject = response.then().extract().path("Id");
        // update
        bodyProject.put("Content", "LucianoJsonUpdate");
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .body(bodyProject.toString())
                .log()
                .all().
                when()
                .put("https://todo.ly/api/items/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .log()
                .all().
                when()
                .get("https://todo.ly/api/items/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")));


        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("lutyvr02@gmail.com", "hola1234")
                .log()
                .all().
                when()
                .delete("https://todo.ly/api/items/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(bodyProject.get("Content")))
                .body("Deleted", equalTo(true));


    }
}