package Session1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import Session1.pojo.User;


import static org.hamcrest.Matchers.equalTo;

public class HelloWorldRestAssuredSession1 {

    // ----  First Http request using Rest-Assured ------
    //We are sending a GET request to the https://api.escuelajs.co/api/v1/users/1
    //and then validating that status code is 200 and that the response body contains a name field with the Jhon value
    @Test
    public void readUser(){
        RestAssured.baseURI = "https://api.escuelajs.co/api/v1";
        RestAssured
                .given()
                .when()
                    .get("/users/1")
                .then()
                    .statusCode(200)
                    .body("name", equalTo("Jhon"))
                    .log().all();
    }

    //----  Second Http request using Rest-Assured ------
    // We are sending a POST  request to the https://api.escuelajs.co/api/v1/users/
    // and then validating that status code is 201 (Created) and that the response body contains a name field with the Angelica value
    @Test
    public void createUser(){

        RestAssured.baseURI = "https://api.escuelajs.co/api/v1";

        //First approach: Sending a plain text String as a Json
        String jsonString = "{"
                + "\"email\":\"Alejo@test.com\","
                + "\"password\":\"password\","
                + "\"avatar\":\"https://picsum.photos/800\","
                + "\"name\":\"Alejo\""
                + "}";

        //Second approach: Serializing the User java object into a Json --- Best practice -----
        User angelica = new User("Angelica","angelica@test.com", "password", "https://i.imgur.com/yhW6Yw1.jpg");

        RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(angelica) // Or JsonString in case you want to use the first approach
                .when()
                .post("/users/")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo("Angelica"));
    }

}
