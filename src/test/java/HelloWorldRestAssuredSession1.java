import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import pojo.User;


import static org.hamcrest.Matchers.equalTo;

public class HelloWorldRestAssuredSession1 {

    @Test
    public void getUser(){
        RestAssured.baseURI = "https://api.escuelajs.co/api/v1";

                RestAssured.given()
                .when()
                .get("/users/86")
                .then()
                .statusCode(200)
                        .body("name", equalTo("Angelica"))
                        .log().all();
    }

    @Test
    public void createUser(){
        RestAssured.baseURI = "https://api.escuelajs.co/api/v1";

        User angelica = new User("Angelica","angelica@test.com", "password", "https://i.imgur.com/yhW6Yw1.jpg");

        RestAssured.given()
                    .log().all()
                    .contentType("application/json")
                    .body(angelica)
                .when()
                    .post("/users/")
                .then()
                    .log().all()
                    .statusCode(201)
                    .body("name", equalTo("Angelica"));

    }

}
